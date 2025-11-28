package com.moxs.gestionrepas.off;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Client permettant d'interroger l'API OpenFoodFacts.
 * Cette classe sert à :
 *  - envoyer une requête HTTP à l'API,
 *  - récupérer le JSON brut,
 *  - analyser ce JSON pour en extraire un ProduitOff.
 */
public class OpenFoodFactsClient {

    /** URL de base utilisée par l'API d'OpenFoodFacts. */
    private static final String BASE_URL_V0 =
            "https://world.openfoodfacts.org/api/v0/product/";

    /** Client HTTP utilisé pour envoyer les requêtes. */
    private final HttpClient httpClient = HttpClient.newHttpClient();

    /** Outil pour lire et analyser le JSON renvoyé par l'API. */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Envoie une requête HTTP à OpenFoodFacts pour récupérer le JSON brut
     * correspondant à un code-barres.
     *
     * @param codeBarres Le code-barres du produit à rechercher.
     * @return Le contenu JSON renvoyé par l'API sous forme de chaîne.
     * @throws IOException Si un problème réseau survient.
     * @throws InterruptedException Si la requête est interrompue.
     */
    public String fetchJsonProduit(String codeBarres) throws IOException, InterruptedException {
        String url = BASE_URL_V0 + codeBarres + ".json";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Réponse HTTP non OK : " + response.statusCode());
        }

        return response.body();
    }

    /**
     * Récupère un produit complet depuis OpenFoodFacts et le transforme
     * en un objet ProduitOff.
     *
     * Cette méthode :
     *   1. Récupère le JSON via fetchJsonProduit().
     *   2. Vérifie que le produit existe (status = 1).
     *   3. Extrait les informations utiles (nom, marque, ingrédients…).
     *   4. Retourne un objet ProduitOff avec ces données.
     *
     * @param codeBarres Le code-barres du produit à rechercher.
     * @return Un objet ProduitOff contenant les informations principales.
     * @throws IOException Si un problème réseau survient.
     * @throws InterruptedException Si la requête est interrompue.
     * @throws RuntimeException Si le produit est introuvable ou si le JSON est invalide.
     */
    public ProduitOff fetchProduit(String codeBarres) throws IOException, InterruptedException {
        String json = fetchJsonProduit(codeBarres); // Réutilisation de la première méthode

        try {
            JsonNode root = objectMapper.readTree(json);

            int status = root.path("status").asInt(0);
            if (status != 1) {
                throw new RuntimeException("Produit non trouvé dans Open Food Facts");
            }

            JsonNode product = root.path("product");

            String code = product.path("code").asText();
            String nom = product.path("product_name_fr").asText(
                    product.path("product_name").asText()
            );
            String marque = product.path("brands").asText();
            String ingredients = product.path("ingredients_text_fr").asText(
                    product.path("ingredients_text").asText()
            );

            return new ProduitOff(code, nom, marque, ingredients);

        } catch (Exception e) {
            throw new RuntimeException("Erreur de parsing JSON", e);
        }
    }
}