package com.moxs.gestionrepas.off;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Client used to query the OpenFoodFacts API.
 * This class is responsible for:
 *  - sending an HTTP request to the API,
 *  - retrieving the raw JSON,
 *  - parsing this JSON to build an OffProduct.
 */
public class OpenFoodFactsClient {

    /** Base URL used by the OpenFoodFacts API. */
    private static final String BASE_URL_V0 =
            "https://world.openfoodfacts.net/api/v2/product";

    /** HTTP client used to send requests. */
    private final HttpClient httpClient = HttpClient.newHttpClient();

    /** Tool used to read and parse JSON returned by the API. */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Sends an HTTP request to OpenFoodFacts to retrieve the raw JSON
     * corresponding to a barcode.
     *
     * @param barcode The product barcode to search for.
     * @return The JSON content returned by the API as a String.
     * @throws IOException If a network issue occurs.
     * @throws InterruptedException If the request is interrupted.
     */
    public String fetchProductJson(String barcode) throws IOException, InterruptedException {
        String url = BASE_URL_V0 + barcode + ".json";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Non-OK HTTP response: " + response.statusCode());
        }

        return response.body();
    }

    /**
     * Retrieves a complete product from OpenFoodFacts and maps it
     * to an OffProduct object.
     *
     * This method:
     *   1. Fetches the JSON via fetchProductJson().
     *   2. Checks that the product exists (status = 1).
     *   3. Extracts useful information (name, brand, ingredients…).
     *   4. Returns an OffProduct built from these data.
     *
     * @param barcode The product barcode to search for.
     * @return An OffProduct containing the main product information.
     * @throws IOException If a network issue occurs.
     * @throws InterruptedException If the request is interrupted.
     * @throws RuntimeException If the product is not found or JSON is invalid.
     */
    public OffProduct fetchProduct(String barcode) throws IOException, InterruptedException {
        String json = fetchProductJson(barcode); // Reuse the first method

        try {
            JsonNode root = objectMapper.readTree(json);

            int status = root.path("status").asInt(0);
            if (status != 1) {
                throw new RuntimeException("Product not found in OpenFoodFacts");
            }

            JsonNode product = root.path("product");

            String code = product.path("code").asText();
            String name = product.path("product_name_fr").asText(
                    product.path("product_name").asText()
            );
            String brand = product.path("brands").asText();
            String ingredientsText = product.path("ingredients_text_fr").asText(
                    product.path("ingredients_text").asText()
            );

            return new OffProduct(code, name, brand, ingredientsText);

        } catch (Exception e) {
            throw new RuntimeException("Error while parsing JSON", e);
        }
    }
}
