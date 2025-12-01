package com.moxs.gestionrepas;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a menu composed of recipes.
 * A menu can contain at most one starter, one main course and one dessert.
 *
 * This class illustrates the use of a Set to avoid duplicates
 * and enforces a few simple business rules when adding recipes.
 */
public class Menu {

    /** Name of the menu. */
    private String name;

    /** Set of recipes in the menu. */
    private Set<Recipe> recipes;

    /**
     * Constructor: a menu is created empty and identified by its name.
     *
     * @param name name of the menu
     */
    public Menu(String name) {
        this.name = name;
        this.recipes = new HashSet<>();
    }

    /** @return the name of the menu */
    public String getName() {
        return name;
    }

    /** Modifies the name of the menu. */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a copy of the Set in order to protect the internal collection.
     * This prevents callers from directly modifying the internal state.
     *
     * @return a copy of the recipes in the menu
     */
    public Set<Recipe> getRecipes() {
        return new HashSet<>(recipes);
    }

    /**
     * Adds a recipe to the menu. A business rule is applied:
     * there must not be two recipes of the same type (e.g. two starters).
     *
     * @param recipe recipe to add
     * @return true if the addition succeeded, false otherwise
     */
    public boolean addRecipe(Recipe recipe) {
        if (recipe == null) {
            System.out.println("Please provide valid information.");
            return false;
        }

        // Check if there is already a recipe of the same type
        for (Recipe r : recipes) {
            if (r.getRecipeType() == recipe.getRecipeType()) {
                System.out.println("There is already a recipe of this type.");
                return false;
            }
        }

        return recipes.add(recipe);
    }

    /**
     * Returns the recipe corresponding to the requested type.
     *
     * @param type recipe type (STARTER, MAIN, DESSERT)
     * @return the recipe if it exists, otherwise null
     */
    public Recipe getRecipeByType(RecipeType type) {
        if (type == null) return null;
        for (Recipe r : recipes) {
            if (r.getRecipeType() == type) {
                return r;
            }
        }
        return null;
    }

    /**
     * Removes the recipe associated with the requested type.
     *
     * @param type recipe type to remove
     * @return true if the removal was performed, false otherwise
     */
    public boolean removeRecipeByType(RecipeType type) {
        if (type == null) return false;

        Recipe r = getRecipeByType(type);
        if (r == null) {
            return false;
        }
        return recipes.remove(r);
    }

    /**
     * Checks whether the menu contains the three types of recipes.
     *
     * @return true if the menu is complete
     */
    public boolean isFull() {
        return getRecipeByType(RecipeType.STARTER) != null
            && getRecipeByType(RecipeType.MAIN) != null
            && getRecipeByType(RecipeType.DESSERT) != null;
    }

    /**
     * Human-readable display of the menu: starter, main and dessert.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Menu: ").append(name).append(" ===\n");

        Recipe starter = getRecipeByType(RecipeType.STARTER);
        Recipe main = getRecipeByType(RecipeType.MAIN);
        Recipe dessert = getRecipeByType(RecipeType.DESSERT);

        sb.append("Starter : ").append(starter != null ? starter.getName() : "— None —").append("\n");
        sb.append("Main    : ").append(main != null ? main.getName() : "— None —").append("\n");
        sb.append("Dessert : ").append(dessert != null ? dessert.getName() : "— None —").append("\n");

        return sb.toString();
    }
}
