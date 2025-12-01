package com.moxs.gestionrepas;

/**
 * Represents an ingredient used in a recipe or stored in the fridge.
 * The object is intentionally designed as immutable: once created, its
 * attributes cannot be modified (there are no setters). This helps avoid
 * inconsistencies when manipulating ingredients in the application.
 *
 * The business identity of an ingredient is defined only by its name.
 * Two ingredients are therefore considered equal if they have the same name,
 * ignoring case. This behavior is essential to guarantee the absence of
 * duplicates in {@code Set} collections and to allow using the object as a key
 * in a {@code Map}.
 */
public class Ingredient {

    /** Name of the ingredient (business identity). */
    private String name;

    /** Quantity associated with this ingredient (e.g. 200 grams, 3 units). */
    private int quantity;

    /** Unit of measure (e.g. "g", "ml", "piece"). */
    private String unit;

    /** Best-before date as a String. */
    private String bestBeforeDate;

    /**
     * Builds a new ingredient with its name, quantity, unit
     * and best-before date.
     *
     * @param name            ingredient name (used as business identity)
     * @param quantity        associated quantity
     * @param unit            unit of measure
     * @param bestBeforeDate  best-before date
     */
    public Ingredient(String name, int quantity, String unit, String bestBeforeDate) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.bestBeforeDate = bestBeforeDate;
    }

    /** @return the name of the ingredient */
    public String getName() {
        return name;
    }

    /** @return the quantity of the ingredient */
    public int getQuantity() {
        return quantity;
    }

    /** @return the best-before date */
    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    /** @return the unit of measure */
    public String getUnit() {
        return unit;
    }

    /**
     * Determines business equality between two ingredients.
     * Two ingredients are considered equal if their names are equal,
     * ignoring case.
     *
     * @param o object to compare
     * @return true if both objects represent the same business ingredient
     */
    @Override
    public boolean equals(Object o) {

        /** Fast check: same object in memory */
        if (this == o) return true;

        /** We only compare Ingredient instances */
        if (!(o instanceof Ingredient)) return false;

        /** Cast to access the fields */
        Ingredient that = (Ingredient) o;

        /** Business rule: same name (ignore case) */
        return this.name != null && this.name.equalsIgnoreCase(that.name);
    }

    /**
     * Provides a hash code consistent with equals().
     * The name is converted to lower case so that "Tomato" and "TOMATO"
     * produce the same hash.
     *
     * @return numeric hash of the ingredient
     */
    @Override
    public int hashCode() {
        return name == null ? 0 : name.toLowerCase().hashCode();
    }

    /**
     * Provides a readable representation of the ingredient,
     * useful for console output or logs.
     *
     * @return a human-readable string representation of the ingredient
     */
    @Override
    public String toString() {
        return name + " : " + quantity + " " + unit + " (Best before: " + bestBeforeDate + ")";
    }
}
