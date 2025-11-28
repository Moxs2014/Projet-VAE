package com.moxs.gestionrepas;

public class App {

public static void main(String[] args) {

        // 1. On choisit l'implémentation de stockage (en mémoire pour l'instant)
        IngredientRepository repo = new InMemoryIngredientRepository();

        // 2. On crée le service qui s'appuie sur ce repository
        IngredientService service = new IngredientService(repo);

        // 3. On crée quelques ingrédients à partir du catalogue
        service.creerDepuisCatalogue("Tomate", 3, "pièces", "2025-08-01");
        service.creerDepuisCatalogue("Poulet", 300, "g", "2025-11-12");

        // 4. On liste tout
        System.out.println("Ingrédients dans le repository :");
        service.listerTous().forEach(System.out::println);

        // 5. On en cherche un par nom
        service.chercherParNom("Tomate")
                .ifPresent(i -> System.out.println("Trouvé : " + i));

        // 6. On supprime
        boolean supprime = service.supprimerParNom("Poulet");
        System.out.println("Poulet supprimé ? " + supprime);

        System.out.println("Ingrédients dans le repository :");
        service.listerTous().forEach(System.out::println);
    }

}