package com.moxs.gestionrepas;

import java.util.Set;
import java.util.HashSet;

/**
 * Représente une recette composée d'un nom, d'un ensemble d'ingrédients,
 * d'un type (entrée, plat, dessert...), et de plusieurs attributs
 * facilitant la gestion dans l'application (préférée, batchcookable,
 * nombre d'utilisations, temps de préparation).
 *
 * La recette contient un ensemble d'ingrédients ({@code Set<Ingredient>})
 * afin d'éviter les doublons. Chaque recette est identifiée
 * de manière métier par son nom : deux recettes portant le même nom
 * sont considérées comme égales, indépendamment de la casse.
 * Cela est utilisé pour garantir l'unicité dans les collections.
 *
 * La collection interne d'ingrédients n'est jamais exposée directement.
 * Une copie défensive est retournée dans {@code getIngredients()}
 * afin de protéger l'intégrité interne de l'objet et empêcher toute
 * modification non contrôlée.
 */
public class Recette {

    /** Nom de la recette (sert d'identité métier). */
    private String nom;

    /**
     * Ensemble d'ingrédients constituant la recette.
     * Utilisé pour éviter les doublons grâce à equals/hashCode.
     */
    private Set<Ingredient> ingredients;

    /** Temps nécessaire pour préparer la recette (en minutes). */
    private int tempsPreparation;

    /** Nombre de fois où la recette a été cuisinée (statistique interne). */
    private int nombreDeFoisUtilisee;

    /** Type de recette (ex : ENTREE, PLAT, DESSERT). */
    private TypeRecette type;

    /** Indique si la recette fait partie des recettes préférées par l'utilisateur. */
    private boolean preferee;

    /** Indique si la recette peut être intégrée dans un batch cooking. */
    private boolean batchCookable;


    public Recette(String nom, int tempsPreparation) {
        this.nom = nom;
        this.tempsPreparation = tempsPreparation;
        this.ingredients = new HashSet<>(); // Liste interne protégée
    }
    /**
     * Construit une nouvelle recette.
     *
     * @param nom               nom de la recette (identité métier)
     * @param tempsPreparation  temps nécessaire à la préparation (en minutes)
     * @param type              type de la recette (entrée, plat...)
     * @param batchCookable     true si la recette peut être batchcookée
     * @param preferee          true si la recette est marquée comme préférée
     */
    public Recette(String nom, int tempsPreparation, TypeRecette type,
                   boolean batchCookable, boolean preferee) {

        this.nom = nom;
        this.type = type;
        this.tempsPreparation = tempsPreparation;
        this.nombreDeFoisUtilisee = 0;
        this.ingredients = new HashSet<>(); // Liste interne protégée
        this.preferee = preferee;
        this.batchCookable = batchCookable;
    }

    /** @return nom de la recette */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne une copie défensive des ingrédients.
     * Empêche l'appelant de modifier directement la structure interne.
     *
     * @return un nouvel ensemble contenant les ingrédients de la recette
     */
    public Set<Ingredient> getIngredients() {
        return new HashSet<>(ingredients);
    }

    /** @return temps de préparation en minutes */
    public int getTempsPreparation() {
        return tempsPreparation;
    }

    /** @return nombre de fois où la recette a été utilisée */
    public int getNombreDeFoisUtilisee() {
        return nombreDeFoisUtilisee;
    }

    /**
     * Incrémente le compteur d'utilisation.
     *
     * @return nouveau nombre d'utilisations
     */
    public int addNombreDeFoisUtilisee() {
        return ++nombreDeFoisUtilisee;
    }

    /** @return type de recette sous forme de texte */
    public String getType() {
        return type.toString();
    }

    /** @return l'énumération TypeRecette brute */
    public TypeRecette getTypeRecette() {
        return type;
    }

    /**
     * Ajoute un ingrédient à la recette.
     * L'utilisation d'un HashSet évite automatiquement les doublons.
     *
     * @param ingredient ingrédient à ajouter
     */
    public void ajouterIngredient(Ingredient ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    /**
     * Supprime un ingrédient de la recette s'il est présent.
     *
     * @param ingredient ingrédient à retirer
     */
    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    /** @return true si la recette peut être préparée en batch cooking */
    public boolean isBatchCookable() {
        return batchCookable;
    }

    /** @return "Yes" ou "No" pour affichage lisible */
    public String getBatchCookableString() {
        return batchCookable ? "Yes" : "No";
    }

    /** Change l'état batchcookable de la recette. */
    public void setBatchCookable(boolean batchCookable) {
        this.batchCookable = batchCookable;
    }

    /** @return true si la recette est préférée */
    public boolean isPreferee() {
        return preferee;
    }

    /** Modifie l'état de préférence. */
    public void setPreferee(boolean preferee) {
        this.preferee = preferee;
    }

    /** @return "Yes" ou "No" selon si la recette est préférée */
    public String getPrefereeToString() {
        return preferee ? "Yes" : "No";
    }

    /**
     * Égalité métier : deux recettes sont égales si elles partagent
     * le même nom, indépendamment de la casse.
     *
     * @param o objet à comparer
     * @return true si les deux recettes ont le même nom
     */
    @Override
    public boolean equals(Object o) {

        // Même référence → même recette
        if (this == o) return true;

        // On ne compare que des Recette
        if (!(o instanceof Recette)) return false;

        Recette that = (Recette) o;

        // Règle métier d'unicité : le nom
        return this.nom != null && this.nom.equalsIgnoreCase(that.nom);
    }

    /**
     * Fournit un hash cohérent avec equals(), basé sur le nom.
     *
     * @return hash numérique de la recette
     */
    @Override
    public int hashCode() {
        return nom == null ? 0 : nom.toLowerCase().hashCode();
    }

    /**
     * Retourne une représentation textuelle complète de la recette :
     * nom, temps de préparation, ingrédients, préférences, etc.
     *
     * @return chaîne lisible représentant la recette
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Recette : ").append(nom).append(" ===\n");
        sb.append("Temps de préparation : ").append(tempsPreparation).append(" min\n");
        sb.append("Batchcookable : ").append(getBatchCookableString()).append("\n");
        sb.append("Préférée : ").append(getPrefereeToString()).append("\n");
        sb.append("Ingrédients :\n");

        for (Ingredient ing : ingredients) {
            sb.append(" - ").append(ing).append("\n");
        }

        sb.append("Utilisée ").append(nombreDeFoisUtilisee).append(" fois\n");

        return sb.toString();
    }
}
