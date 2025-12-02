package com.moxs.gestionrepas.domain;


import java.util.Set;
import java.util.HashSet;

/**
 * Represents a recipe composed of a name, a set of ingredients,
 * a type (starter, main dish, dessert...), and various attributes
 * that make the application easier to manage (favorite, batch-cookable,
 * number of uses, preparation time).
 *
 * The recipe contains a Set of ingredients ({@code Set<Ingredient>})
 * to avoid duplicates. A recipe is identified by its name: two recipes
 * with the same name are considered equal (case-insensitive). This ensures
 * uniqueness in collections.
 *
 * The internal ingredients collection is never exposed directly.
 * A defensive copy is returned from {@code getIngredients()} to protect
 * the internal integrity of the object.
 */
public class Recipe {

    /** Name of the recipe (business identity). */
    private String name;

    /**
     * Set of ingredients that compose the recipe.
     * A HashSet is used to avoid duplicates (relies on Ingredient.equals/hashCode).
     */
    private Set<Ingredient> ingredients;

    /** Preparation time in minutes. */
    private int preparationTime;

    /** Number of times this recipe has been made (internal statistic). */
    private int usageCount;

    /** Recipe type (e.g. STARTER, MAIN, DESSERT). */
    private RecipeType type;

    /** Indicates whether the recipe is marked as a user favorite. */
    private boolean favorite;

    /** Indicates whether the recipe can be batch-cooked. */
    private boolean batchCookable;

    /**
     * Builds a new recipe.
     *
     * @param name             recipe name (business identity)
     * @param preparationTime  preparation time in minutes
     * @param type             recipe type (starter, main, dessert...)
     * @param batchCookable    true if the recipe can be batch-cooked
     * @param favorite         true if the recipe is marked as a favorite
     */
    public Recipe(String name, int preparationTime, RecipeType type,
                  boolean batchCookable, boolean favorite) {

        this.name = name;
        this.type = type;
        this.preparationTime = preparationTime;
        this.usageCount = 0;
        this.ingredients = new HashSet<>();
        this.favorite = favorite;
        this.batchCookable = batchCookable;
    }

    /** @return the recipe name */
    public String getName() {
        return name;
    }

    /**
     * Returns a defensive copy of the ingredients.
     *
     * @return a new Set containing the recipe's ingredients
     */
    public Set<Ingredient> getIngredients() {
        return new HashSet<>(ingredients);
    }

    /** @return preparation time in minutes */
    public int getPreparationTime() {
        return preparationTime;
    }

    /** @return number of times the recipe has been used */
    public int getUsageCount() {
        return usageCount;
    }

    /**
     * Increments the usage counter.
     *
     * @return updated usage count
     */
    public int incrementUsageCount() {
        return ++usageCount;
    }

    /** @return the recipe type as text */
    public String getType() {
        return type.toString();
    }

    /** @return the RecipeType enum value */
    public RecipeType getRecipeType() {
        return type;
    }

    /**
     * Adds an ingredient to the recipe.
     * Duplicates are automatically avoided by the HashSet.
     *
     * @param ingredient ingredient to add
     */
    public void addIngredient(Ingredient ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    /**
     * Removes an ingredient from the recipe if present.
     *
     * @param ingredient ingredient to remove
     */
    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    /** @return true if the recipe is batch-cookable */
    public boolean isBatchCookable() {
        return batchCookable;
    }

    /** @return "Yes" or "No" depending on batch-cookable status */
    public String getBatchCookableString() {
        return batchCookable ? "Yes" : "No";
    }

    /** Changes the batch-cookable status. */
    public void setBatchCookable(boolean batchCookable) {
        this.batchCookable = batchCookable;
    }

    /** @return true if the recipe is a favorite */
    public boolean isFavorite() {
        return favorite;
    }

    /** Changes the favorite status. */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /** @return "Yes" or "No" depending on favorite status */
    public String getFavoriteString() {
        return favorite ? "Yes" : "No";
    }

    /**
     * Business equality: two recipes are equal if they share the same name,
     * ignoring case.
     * 
     * @param o the object to compare with this recipe
     * @return true if both objects represent the same recipe name
     */
    @Override
    public boolean equals(Object o) {

        /* Same reference → same recipe */
        if (this == o) return true;

        /* We only compare Recipe instances */
        if (!(o instanceof Recipe)) return false;

        /* Safe cast after instanceof: allows accessing Recipe properties */
        Recipe that = (Recipe) o;

        /* Business rule: same name (ignore case) */
        return this.name != null && this.name.equalsIgnoreCase(that.name);
    }

    /**
     * Provides a hash consistent with equals(), based on the name.
     */
    @Override
    public int hashCode() {
        return name == null ? 0 : name.toLowerCase().hashCode();
    }

    /**
     * Returns a human-readable representation of the recipe:
     * name, preparation time, ingredients, favorite, batch-cookable, etc.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Recipe: ").append(name).append(" ===\n");
        sb.append("Preparation time: ").append(preparationTime).append(" min\n");
        sb.append("Batch-cookable: ").append(getBatchCookableString()).append("\n");
        sb.append("Favorite: ").append(getFavoriteString()).append("\n");
        sb.append("Ingredients:\n");

        for (Ingredient ing : ingredients) {
            sb.append(" - ").append(ing).append("\n");
        }

        sb.append("Used ").append(usageCount).append(" times\n");

        return sb.toString();
    }
}
