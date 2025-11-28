package com.moxs.gestionrepas;

import com.moxs.gestionrepas.off.OpenFoodFactsClient;
import com.moxs.gestionrepas.off.ProduitOff;

public class TestOpenFoodFacts {

    public static void main(String[] args) {

        // 1️⃣ Création du client OpenFoodFacts
        OpenFoodFactsClient client = new OpenFoodFactsClient();

        // 2️⃣ Code-barres de test
        String codeBarres = "3017624010701"; // Nutella

        // 3️⃣ Appel à l’API et affichage
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
