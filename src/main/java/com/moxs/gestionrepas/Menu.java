package com.moxs.gestionrepas;

import java.util.HashSet;
import java.util.Set;

/**
 * Représente un menu composé de recettes.
 * Un menu peut contenir au maximum une entrée, un plat et un dessert.
 *
 * Cette classe illustre l'utilisation d'un Set pour éviter les doublons
 * et met en place quelques règles métier simples lors de l'ajout des recettes.
 */
public class Menu {

    /** Nom du menu */
    private String nom;

    /** Ensemble des recettes du menu. */
    private Set<Recette> recettes;

    /**
     * Constructeur : un menu est créé vide et identifié par son nom.
     *
     * @param nom nom du menu
     */
    public Menu(String nom) {
        this.nom = nom;
        this.recettes = new HashSet<>();
    }

    /** @return le nom du menu */
    public String getNom() {
        return nom;
    }

    /** Modifie le nom du menu. */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne une copie du Set afin de protéger la liste interne.
     * Cela évite qu'un appelant puisse modifier directement le contenu.
     *
     * @return une copie des recettes du menu
     */
    public Set<Recette> getRecettes() {
        return new HashSet<>(recettes);
    }

    /**
     * Ajoute une recette dans le menu. On applique ici une règle métier :
     * il ne doit pas y avoir deux recettes du même type (ex : deux entrées).
     *
     * @param recette recette à ajouter
     * @return true si l'ajout a réussi, false sinon
     */
    public boolean ajouterRecette(Recette recette) {
        if (recette == null) {
            System.out.println("Veuillez saisir des informations valides");
            return false;
        }

        // Vérifie s'il existe déjà une recette du même type
        for (Recette r : recettes) {
            if (r.getTypeRecette() == recette.getTypeRecette()) {
                System.out.println("Il y'a déjà une recette de ce type.");
                return false;
            }
        }

        return recettes.add(recette);
    }

    /**
     * Retourne la recette correspondant au type demandé.
     *
     * @param type type de recette (ENTREE, PLAT, DESSERT)
     * @return la recette si elle existe, sinon null
     */
    public Recette getRecetteParType(TypeRecette type) {
        if (type == null) return null;
        for (Recette r : recettes) {
            if (r.getTypeRecette() == type) {
                return r;
            }
        }
        return null;
    }

    /**
     * Supprime la recette associée au type demandé.
     *
     * @param type type de recette à supprimer
     * @return true si la suppression a été faite, false sinon
     */
    public boolean supprimerRecetteParType(TypeRecette type) {
        if (type == null) return false;

        Recette r = getRecetteParType(type);
        if (r == null) {
            return false;
        }
        return recettes.remove(r);
    }

    /**
     * Vérifie si le menu contient bien les trois types de recettes.
     *
     * @return true si le menu est complet
     */
    public boolean isFull() {
        return getRecetteParType(TypeRecette.ENTREE) != null
            && getRecetteParType(TypeRecette.PLAT) != null
            && getRecetteParType(TypeRecette.DESSERT) != null;
    }

    /**
     * Affichage lisible du menu : entrée, plat et dessert.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Menu : ").append(nom).append(" ===\n");

        Recette entree = getRecetteParType(TypeRecette.ENTREE);
        Recette plat = getRecetteParType(TypeRecette.PLAT);
        Recette dessert = getRecetteParType(TypeRecette.DESSERT);

        sb.append("Entrée  : ").append(entree != null ? entree.getNom() : "— Aucune —").append("\n");
        sb.append("Plat    : ").append(plat != null ? plat.getNom() : "— Aucune —").append("\n");
        sb.append("Dessert : ").append(dessert != null ? dessert.getNom() : "— Aucune —").append("\n");

        return sb.toString();
    }
}
