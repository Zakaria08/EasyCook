/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heg.ig.sda.app;


import ch.heg.ig.sda.app.business.EasyCook;
import ch.heg.ig.sda.app.business.IEasyCook;

public class Main {


    /**
     * @param args the command line arguments
     * Lanceur des méthodes contenant le code pour le projet EasyCook.
     */

    public static void main(String[] args) {
        String filepath = "C:\\DEV\\EasyCook\\data\\EasyCook (1).csv";

        IEasyCook app = new EasyCook();

        app.loadRecipes(filepath);
        app.printRecipes();

       System.out.print("Hello cte équipe");

    }
}

