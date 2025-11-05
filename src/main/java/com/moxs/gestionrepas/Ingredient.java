package com.moxs.gestionrepas;



public class Ingredient {
    String nom;
    int quantite;
    String unite;
    String dateLimite;

    public Ingredient( String nom, int quantite, String unite, String dateLimite)
    {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
        this.dateLimite = dateLimite;
    }

}
