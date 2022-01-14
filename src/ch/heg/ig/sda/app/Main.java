/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heg.ig.sda.app;


import ch.heg.ig.sda.app.business.*;

import java.util.*;

public class Main {


    /**
     * @param args the command line arguments
     * Lanceur des méthodes contenant le code pour le projet EasyCook.
     */

    public static void main(String[] args) {

       String filepath = "C:\\DEV\\EasyCook\\data\\EasyCook.csv";

        IEasyCook app = new EasyCookMap();


        System.out.println("Chargement des recettes ... ");
        app.loadRecipes(filepath);
        System.out.println("Recettes chargées !");
        app.printRecipes();
        System.out.println("Toutes les catégories des recettes :");
        app.printCategories();

        // Test recherche par catégorie
        System.out.println("Test de recherche par catégorie");
        Collection<Recette> tempCol = app.getRecetteByCategory("Plat");
        System.out.println(tempCol.toString());

        //Test Recherche par ingrédient
        /*
        System.out.println("Test de recherche par nom ");
        Collection<Recette> tempCol = app.getRecetteByIngredient(new Ingredient("sucre"));
        System.out.println(tempCol.toString());
        */

    }
}

