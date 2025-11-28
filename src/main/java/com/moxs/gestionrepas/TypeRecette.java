package com.moxs.gestionrepas;

/**
 * Représente les différents types de recettes possibles dans l'application.
 *
 * <p>Chaque type dispose d'un libellé d'affichage personnalisé
 * (par exemple "Entrée" au lieu de ENTREE) afin de permettre une
 * présentation plus lisible dans les interfaces utilisateurs
 * ou dans les méthodes {@code toString()} des autres classes.</p>
 *
 * <p>
 * L'utilisation d'une énumération garantit que les types de recettes
 * sont limités, cohérents et centralisés. Cela évite les erreurs de
 * saisie (ex : "plat", "Plat", "PLAT", "plta") et facilite les
 * comparaisons : un {@code TypeRecette} est toujours un des trois
 * types définis ici.
 * </p>
 */
public enum TypeRecette {

    ENTREE("Entrée"),
    PLAT("Plat"),
    DESSERT("Dessert");

    /** Libellé lisible correspondant au type. */
    private final String affichage;

    /**
     * Constructeur interne à l'énumération.
     *
     * @param affichage libellé lisible pour ce type de recette
     */
    TypeRecette(String affichage) {
        this.affichage = affichage;
    }

    /**
     * Retourne le libellé lisible correspondant au type de recette.
     *
     * @return une chaîne représentant le type (ex : "Entrée").
     */
    @Override
    public String toString() {
        return affichage;
    }
}
