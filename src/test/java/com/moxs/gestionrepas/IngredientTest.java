package com.moxs.gestionrepas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    @Test
    void testIngredientEgaliteParNom() {
        Ingredient i1 = new Ingredient("Tomate", 0, "", "");
        Ingredient i2 = new Ingredient("TOMATE", 0, "", "");

        assertEquals(i1, i2);
    }
}
