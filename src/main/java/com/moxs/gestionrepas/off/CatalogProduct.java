package com.moxs.gestionrepas.off;

public class CatalogProduct {

    private String barcode;
    private String displayName;
    private String brand;
    private int shelfLifeDays;
    private String personalNote;

    /**  Empty constructor */
    public CatalogProduct() {
    }

    /** Convenient constructor */
    public CatalogProduct(String barcode, String name, String brand, int shelfLifeDays) {
        this.barcode = barcode;
        this.displayName = name;
        this.brand = brand;
        this.shelfLifeDays = shelfLifeDays;
    }

    /** Getters / Setters */
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return displayName;
    }

    public void setName(String displayName) {
        this.displayName = displayName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPersonalNote() {
        return personalNote;
    }

    public void setPersonalNote(String personalNote) {
        this.personalNote = personalNote;
    }

    public String getShelfLife() {
        return shelfLifeDays + " days";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog Product: ").append(getName()).append(" ===\n");
        sb.append("Barcode: ").append(getBarcode()).append("\n");
        sb.append("Brand: ").append(getBrand()).append("\n");
        sb.append("Shelf life (days): ").append(shelfLifeDays).append("\n");
        return sb.toString();
    }
}
