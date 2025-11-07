package com.moxs.gestionrepas;

public enum TypeRecette {
    ENTREE("Entrée"),
    PLAT("Plat"),
    DESSERT("Dessert");

    private final String affichage;

    TypeRecette(String affichage) {
        this.affichage = affichage;
    }

    @Override
    public String toString() {
        return affichage;
    }
}
