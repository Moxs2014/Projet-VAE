package com.moxs.gestionrepas;

import java.util.Set;

/**
 * Représente un ingrédient utilisé dans une recette ou stocké dans le frigo.
 * L'objet est volontairement conçu comme immuable : une fois créé, ses
 * attributs ne peuvent plus être modifiés. Cela évite les incohérences
 * lors de la manipulation des ingrédients dans l'application.
 *
 * L'identité métier d'un ingrédient est uniquement définie par son nom.
 * Deux ingrédients sont donc considérés égaux s'ils ont le même nom,
 * indépendamment de la casse. Ce comportement est indispensable
 * pour garantir l'absence de doublons dans les collections de type
 * {@code Set} et pour permettre l'utilisation de l'objet comme clé dans une {@code Map}.
 */

public class Ingredient {

    /** Nom de l'ingrédient (identité métier) */
    private String nom;

    /** Quantité associée à cet ingrédient (ex: 200 grammes, 3 unités) */
    private int quantite;

    /** Unité de mesure (ex : "g", "ml", "pièce") */
    private String unite;

    /** Date limite d'utilisation optimale (DLUO) sous forme de chaîne */
    private String dateLimite;

    /**
     * Construit un nouvel ingrédient avec son nom, sa quantité, son unité
     * et sa date limite.
     *
     * @param nom         nom de l'ingrédient (sert d'identité métier)
     * @param quantite    quantité associée
     * @param unite       unité de mesure
     * @param dateLimite  date limite d'utilisation optimale
     */
    public Ingredient(String nom, int quantite, String unite, String dateLimite) {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
        this.dateLimite = dateLimite;
    }

    /** @return le nom de l'ingrédient */
    public String getNom() {
        return nom;
    }

    /** @return la quantité de l'ingrédient */
    public int getQuantite() {
        return quantite;
    }

    /** @return la date limite d'utilisation optimale */
    public String getDateLimite() {
        return dateLimite;
    }

    /** @return l'unité de mesure */
    public String getUnite() {
        return unite;
    }

    /**
     * Détermine l'égalité métier entre deux ingrédients.
     * Deux ingrédients sont considérés égaux si leurs noms sont égaux,
     * sans tenir compte de la casse.
     *
     * @param o objet à comparer
     * @return true si les deux objets représentent le même ingrédient métier
     */
    @Override
    public boolean equals(Object o) {

        // Vérification rapide : même objet en mémoire
        if (this == o) return true;

        // On ne compare que des ingrédients
        if (!(o instanceof Ingredient)) return false;

        // On cast l'objet pour pouvoir accéder à ses attributs
        Ingredient that = (Ingredient) o;

        // Règle d'égalité métier : nom identique (ignore case)
        return this.nom != null && this.nom.equalsIgnoreCase(that.nom);
    }

    /**
     * Fournit un hash cohérent avec equals().
     * Le nom est converti en minuscules afin de garantir que
     * "Tomate" et "TOMATE" produisent le même hash.
     *
     * @return hash numérique de l'ingrédient
     */
    @Override
    public int hashCode() {
        return nom == null ? 0 : nom.toLowerCase().hashCode();
    }

    /**
     * Fournit une représentation lisible de l'ingrédient,
     * pratique lors des affichages dans la console ou les logs.
     *
     * @return une chaîne lisible représentant l'ingrédient
     */
    @Override
    public String toString() {
        return nom + " : " + quantite + " " + unite + " (DLUO : " + dateLimite + ")";
    }
}
