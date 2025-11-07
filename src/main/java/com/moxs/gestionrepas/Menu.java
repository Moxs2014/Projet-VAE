package com.moxs.gestionrepas;

import java.util.HashSet;
import java.util.Set;

public class Menu {

    private String nom;
    private Set<Recette> recettes;


    public Menu(String nom) {
        this.nom = nom;
        this.recettes = new HashSet<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Set<Recette> getRecettes() {
        return new HashSet<>(recettes);
    }


    public boolean ajouterRecette(Recette recette) {
        if (recette == null) {
            return false;
        }

        // Règle : max 1 entrée, 1 plat, 1 dessert
        for (Recette r : recettes) {
            if (r.getTypeRecette() == recette.getTypeRecette()) {
                // Il y a déjà une recette de ce type dans le menu
                return false;
            }
        }

        // HashSet utilise equals/hashCode de Recette (basé sur le nom chez toi)
        return recettes.add(recette);
    }

    public Recette getRecetteParType(TypeRecette type) {
        if (type == null) return null;
        for (Recette r : recettes) {
            if (r.getTypeRecette() == type) {
                return r;
            }
        }
        return null;
    }
    public boolean isComplet() {
        return getRecetteParType(TypeRecette.ENTREE) != null
            && getRecetteParType(TypeRecette.PLAT) != null
            && getRecetteParType(TypeRecette.DESSERT) != null;
    }

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