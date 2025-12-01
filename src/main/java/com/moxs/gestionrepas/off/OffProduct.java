package com.moxs.gestionrepas.off;

public class ProduitOff {

    private String codeBarres;
    private String nom;
    private String marque;
    private String ingredientsTexte;

    // Constructeur vide (Jackson ou toi pourront l'utiliser)
    public ProduitOff() {
    }

    // Optionnel : constructeur pratique
    public ProduitOff(String codeBarres, String nom, String marque, String ingredientsTexte) {
        this.codeBarres = codeBarres;
        this.nom = nom;
        this.marque = marque;
        this.ingredientsTexte = ingredientsTexte;
    }

    // Getters / setters
    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getIngredientsTexte() {
        return ingredientsTexte;
    }

    public void setIngredientsTexte(String ingredientsTexte) {
        this.ingredientsTexte = ingredientsTexte;
    }

    @Override
    public String toString() {
        return "ProduitOff{" +
                "codeBarres='" + codeBarres + '\'' +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", ingredientsTexte='" + ingredientsTexte + '\'' +
                '}';
    }
}
