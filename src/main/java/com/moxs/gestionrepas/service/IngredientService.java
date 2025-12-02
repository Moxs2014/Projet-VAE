package com.moxs.gestionrepas.service;

import java.util.List;
import java.util.Optional;

import com.moxs.gestionrepas.catalog.IngredientsCatalog;
import com.moxs.gestionrepas.domain.Ingredient;
import com.moxs.gestionrepas.repository.IngredientRepository;

/**
 * Business service around ingredients.
 * It relies on an IngredientRepository for storage operations.
 */
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates an Ingredient from the catalog (checks that the name exists),
     * then saves it in the repository.
     */
    public Ingredient addFromCatalog(String name, int quantity, String unit, String bestBeforeDate) {
        if (!IngredientsCatalog.exists(name)) {
            throw new IllegalArgumentException("Unknown ingredient in catalog: " + name);
        }
        Ingredient ingredient = new Ingredient(name, quantity, unit, bestBeforeDate);
        return repository.save(ingredient);
    }

    /**
     * Returns all ingredients stored in the repository.
     */
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    /**
     * Searches for an ingredient by name.
     */
    public Optional<Ingredient> findByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Deletes an ingredient by name.
     */
    public boolean deleteByName(String name) {
        return repository.deleteByName(name);
    }
}
