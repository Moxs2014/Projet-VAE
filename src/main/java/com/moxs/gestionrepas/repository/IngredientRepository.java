package com.moxs.gestionrepas;

import java.util.List;
import java.util.Optional;

/**
 * Contract for accessing ingredients regardless of where they are stored.
 */
public interface IngredientRepository {

    /**
     * Searches for an ingredient by its name.
     * Returns an Optional that may be empty if no match is found.
     *
     * @param name the name of the ingredient to search for
     * @return an Optional containing the ingredient, or empty if not found
     */
    Optional<Ingredient> findByName(String name);

    /**
     * Returns all known ingredients from the repository.
     *
     * @return a list of all ingredients
     */
    List<Ingredient> findAll();

    /**
     * Saves an ingredient (creation or update).
     * Returns the saved ingredient.
     *
     * @param ingredient the ingredient to save
     * @return the saved ingredient
     */
    Ingredient save(Ingredient ingredient);

    /**
     * Deletes an ingredient by its name.
     * Returns true if something was removed, false otherwise.
     *
     * @param name the name of the ingredient to delete
     * @return true if deletion occurred, false otherwise
     */
    boolean deleteByName(String name);
}
