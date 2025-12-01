package com.moxs.gestionrepas;

import com.moxs.gestionrepas.off.OffProduct;
import com.moxs.gestionrepas.off.OpenFoodFactsClient;

public class TestOpenFoodFacts {

    public static void main(String[] args) {

        // Create the OpenFoodFacts client
        OpenFoodFactsClient client = new OpenFoodFactsClient();

        // Test barcode
        String barcode = "3017624010701"; // Nutella

        // API call and display
        try {
            OffProduct product = client.fetchProduct(barcode);

            System.out.println("=== Retrieved product ===");
            System.out.println(product); // uses toString() defined in OffProduct

        } catch (Exception e) {
            System.err.println("Error while retrieving the product: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
