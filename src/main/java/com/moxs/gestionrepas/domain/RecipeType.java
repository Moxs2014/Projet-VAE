package com.moxs.gestionrepas.domain;


/**
 * Represents the different recipe types available in the application.
 *
 * <p>Each type has a readable display label (e.g. "Starter" instead of STARTER)
 * to provide a more user-friendly presentation in user interfaces or
 * {@code toString()} methods.</p>
 *
 * <p>
 * Using an enumeration guarantees that recipe types are limited, consistent,
 * and centralized. This avoids typing errors (e.g. "main", "Main", "MAIN", "maim")
 * and simplifies comparisons: a {@code RecipeType} is always one of the
 * defined values below.
 * </p>
 */
public enum RecipeType {

    STARTER("Starter"),
    MAIN("Main dish"),
    DESSERT("Dessert");

    /** Human-readable label corresponding to the type. */
    private final String label;

    /**
     * Internal constructor for the enumeration.
     *
     * @param label readable label for this recipe type
     */
    RecipeType(String label) {
        this.label = label;
    }

    /**
     * Returns the readable label of the recipe type.
     *
     * @return a human-readable string (e.g. "Starter")
     */
    @Override
    public String toString() {
        return label;
    }
}
