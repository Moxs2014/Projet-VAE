package com.moxs.gestionrepas;

import java.util.List;
import java.util.Optional;

/**
 * Contrat pour accéder aux ingrédients (peu importe où ils sont stockés).
 */
public interface IngredientRepository {

    /**
     * Recherche un ingrédient par son nom.
     * Retourne un Optional qui peut être vide si rien n'est trouvé.
     */
    Optional<Ingredient> findByNom(String nom);

    /**
     * Retourne tous les ingrédients connus du repository.
     */
    List<Ingredient> findAll();

    /**
     * Sauvegarde un ingrédient (création ou mise à jour).
     * Retourne l'ingrédient sauvegardé.
     */
    Ingredient save(Ingredient ingredient);

    /**
     * Supprime un ingrédient par son nom.
     * Retourne true si quelque chose a été supprimé, false sinon.
     */
    boolean deleteByNom(String nom);
}
