package com.moxs.gestionrepas;

import java.util.*;

/**
 * Implémentation simple en mémoire de IngredientRepository.
 * Utilise une Map<String, Ingredient> indexée par le nom (en lowercase).
 */
public class InMemoryIngredientRepository implements IngredientRepository {

    private final Map<String, Ingredient> ingredients = new HashMap<>();

    @Override
    public Optional<Ingredient> findByNom(String nom) {
        if (nom == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(ingredients.get(nom.toLowerCase()));
    }

    @Override
    public List<Ingredient> findAll() {
        return new ArrayList<>(ingredients.values());
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient == null || ingredient.getNom() == null) {
            throw new IllegalArgumentException("Ingredient et son nom ne doivent pas être null");
        }
        // clé = nom en lowercase pour éviter les soucis de casse
        ingredients.put(ingredient.getNom().toLowerCase(), ingredient);
        return ingredient;
    }

    @Override
    public boolean deleteByNom(String nom) {
        if (nom == null) return false;
        return ingredients.remove(nom.toLowerCase()) != null;
    }
}
