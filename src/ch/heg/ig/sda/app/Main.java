/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heg.ig.sda.app;


import ch.heg.ig.sda.app.business.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {


    /**
     * @param args the command line arguments
     * Lanceur des méthodes contenant le code pour le projet EasyCook.
     */

    public static void main(String[] args) {
        String filepath = "C:\\DEV\\EasyCook\\data\\EasyCook (1).csv";

        IEasyCook app = new EasyCookList();

        app.loadRecipes(filepath);
        app.printRecipes();
        System.out.println("recette chargée");
        app.printCategories();
        System.out.println("Toutes les catégories");


        //Recherche
        System.out.println("recette par personne");
        Personne temp = new Personne("Zemmour","Eric");

        Collection<Recette> tempColByName = app.getRecetteByPerson(temp);

        System.out.println(tempColByName.toString());
        /*Set<Recette>testSet = new HashSet<Recette>();
        Collection<Recette> testColl = app.getRecette()
        Ingredient testIngr = new Ingredient("tomates");
        testCollection.contains(testIngr);*/


    }
}

