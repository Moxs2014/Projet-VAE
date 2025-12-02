package com.moxs.gestionrepas.repository;

import java.util.*;

import com.moxs.gestionrepas.domain.Ingredient;

/**
 * Simple in-memory implementation of IngredientRepository.
 * Uses a Map<String, Ingredient> indexed by the name (lowercased).
 */
public class InMemoryIngredientRepository implements IngredientRepository {

    private final Map<String, Ingredient> ingredients = new HashMap<>();

    /**
     * Searches for an ingredient by its name.
     * Returns an Optional that may be empty if nothing is found.
     */
    @Override
    public Optional<Ingredient> findByName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(ingredients.get(name.toLowerCase()));
    }

    /**
     * Returns all known ingredients from the repository.
     */
    @Override
    public List<Ingredient> findAll() {
        return new ArrayList<>(ingredients.values());
    }

    /**
     * Saves an ingredient (creation or update).
     * Returns the saved ingredient.
     */
    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient == null || ingredient.getName() == null) {
            throw new IllegalArgumentException("Ingredient and its name must not be null");
        }
        /* Key = lowercased name to avoid case sensitivity issues */
        ingredients.put(ingredient.getName().toLowerCase(), ingredient);
        return ingredient;
    }

    /**
     * Deletes an ingredient by its name.
     * Returns true if something was removed, false otherwise.
     */
    @Override
    public boolean deleteByName(String name) {
        if (name == null) return false;
        return ingredients.remove(name.toLowerCase()) != null;
    }
}
