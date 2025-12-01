package com.moxs.gestionrepas.off;

public class ProduitCatalogue {

    private String codeBarre;
    private String nomAffiche;
    private String marque;
    private int dureeConservationJours;
    private String notePerso;
    

    // Constructeur vide
    public ProduitCatalogue() {
    }

    // constructeur pratique
    public ProduitCatalogue(String codeBarre, String nom, String marque, int dureeConservationJours) {
        this.codeBarre = codeBarre;
        this.nomAffiche = nom;
        this.marque = marque;
        this.dureeConservationJours = dureeConservationJours;
    }

    // Getters / setters
    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getNom() {
        return nomAffiche;
    }

    public void setNom(String nomAffiche) {
        this.nomAffiche = nomAffiche;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getNotePerso() {
        return notePerso;
    }

    public void setIngredientsTexte(String notePerso) {
        this.notePerso = notePerso;
    }

    public String getTempsConservation() {

        return dureeConservationJours + "Jours.";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Produit du Catalogue").append(getNom()).append(" ===\n");
        sb.append("Code Produit: ").append(getCodeBarre()).append("\n");
        sb.append("Marque : ").append(getMarque()).append("\n");
        sb.append("Temps de conservation (en J) : ").append(getTempsConservation()).append("Jours").append("\n");
        return sb.toString();
    }

}
