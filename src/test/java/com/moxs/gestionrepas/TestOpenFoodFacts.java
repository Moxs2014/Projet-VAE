package com.moxs.gestionrepas;

import com.moxs.gestionrepas.off.OpenFoodFactsClient;
import com.moxs.gestionrepas.off.ProduitOff;

public class TestOpenFoodFacts {

    public static void main(String[] args) {

        // Création du client OpenFoodFacts
        OpenFoodFactsClient client = new OpenFoodFactsClient();

        // Code-barres de test
        String codeBarres = "3017624010701"; // Nutella

        // Appel à l’API et affichage
        try {
            ProduitOff produit = client.fetchProduit(codeBarres);

            System.out.println("=== Produit récupéré ===");
            System.out.println(produit); // utilise le toString() défini dans ProduitOff

        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du produit : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
