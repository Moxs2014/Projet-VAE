package com.moxs.gestionrepas;

import java.util.List;
import java.util.Optional;

/**
 * Service métier autour des ingrédients.
 * Il utilise un IngredientRepository pour le stockage.
 */
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    /**
     * Crée un Ingredient à partir du catalogue (contrôle que le nom existe),
     * puis le sauvegarde dans le repository.
     */
    public Ingredient creerDepuisCatalogue(String nom, int quantite, String unite, String dateLimite) {
        if (!CatalogueIngredients.existe(nom)) {
            throw new IllegalArgumentException("Ingrédient inconnu dans le catalogue : " + nom);
        }
        Ingredient ingr = new Ingredient(nom, quantite, unite, dateLimite);
        return repository.save(ingr);
    }

    /**
     * Retourne tous les ingrédients connus du repository.
     */
    public List<Ingredient> listerTous() {
        return repository.findAll();
    }

    /**
     * Cherche un ingrédient par son nom.
     */
    public Optional<Ingredient> chercherParNom(String nom) {
        return repository.findByNom(nom);
    }

    /**
     * Supprime un ingrédient par son nom.
     */
    public boolean supprimerParNom(String nom) {
        return repository.deleteByNom(nom);
    }
}
