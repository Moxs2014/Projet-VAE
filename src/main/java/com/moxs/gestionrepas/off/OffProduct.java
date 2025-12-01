package com.moxs.gestionrepas.off;

public class OffProduct {

    private String barcode;
    private String name;
    private String brand;
    private String ingredientsText;

    // Empty constructor (used by Jackson or by you)
    public OffProduct() {
    }

    // Optional: convenient constructor
    public OffProduct(String barcode, String name, String brand, String ingredientsText) {
        this.barcode = barcode;
        this.name = name;
        this.brand = brand;
        this.ingredientsText = ingredientsText;
    }

    // Getters / setters
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIngredientsText() {
        return ingredientsText;
    }

    public void setIngredientsText(String ingredientsText) {
        this.ingredientsText = ingredientsText;
    }

    @Override
    public String toString() {
        return "OffProduct{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", ingredientsText='" + ingredientsText + '\'' +
                '}';
    }
}
