package com.moxs.gestionrepas.off;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//FONCTIONNEL - 11/11/25
public class OpenFoodFactsClient {

    private static final String BASE_URL_V0 =
            "https://world.openfoodfacts.org/api/v0/product/";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    private final ObjectMapper objectMapper = new ObjectMapper();

    // ta méthode existante
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

    // retourne un objet ProduitOff
    public ProduitOff fetchProduit(String codeBarres) throws IOException, InterruptedException {
        String json = fetchJsonProduit(codeBarres); // on réutilise ce que tu as déjà

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