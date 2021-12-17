package ch.heg.ig.sda.app.io;

import ch.heg.ig.sda.app.business.Recette;
import ch.heg.ig.sda.app.business.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ch.heg.ig.sda.app.io.FileDatabaseUtils.findColumnIndex;

public class RecettesCsvDatabaseLoader extends RecettesDatabaseLoader {

    public RecettesCsvDatabaseLoader(final String filepath){
        super(filepath);
    }

    public void process() {
        this.recettes = loadCleanDatabase(filepath);
    }

    private Collection<Recette> loadCleanDatabase(final String filename){
        List<String[]> cleanedDatabase = ParserUtils.parseCSV(filename);
        return parseDocumentsDatabase(cleanedDatabase);
    }

    private Collection<Recette> parseDocumentsDatabase(List<String[]> cleanedDatabase){

        int recipeNameColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.RECIPENAME.getColumnName());
        int autorFirstNameColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.AUTORFNAME.getColumnName());
        int autorLastNameColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.AUTORLNAME.getColumnName());
        int ingredientsColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.INGREDIENTS.getColumnName());
        int categorieColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.CATEGORIES.getColumnName());
        int stepsColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.STEPS.getColumnName());

        int notFoundColumnIndex = -1;

        int startIndex = 1; // Skip header

        // The size is known in advance, prevent array list unnecessary grow
        Collection<Recette> recettes = new ArrayList<>(cleanedDatabase.size() - 1);

        for (int i = startIndex; i < cleanedDatabase.size(); i++) {

            Recette recette = new Recette();

            if(recipeNameColumnIndex != notFoundColumnIndex) {
                recette.setNom(cleanedDatabase.get(i)[recipeNameColumnIndex]);
            }

            if(autorFirstNameColumnIndex != notFoundColumnIndex && autorLastNameColumnIndex != notFoundColumnIndex) {
                String tempPrenom = cleanedDatabase.get(i)[autorFirstNameColumnIndex];
                String tempNom = cleanedDatabase.get(i)[autorLastNameColumnIndex];
                recette.setAuteur(new Personne(tempNom,tempPrenom));
            }

            if(ingredientsColumnIndex != notFoundColumnIndex) {
                String[] ingredientsArray = cleanedDatabase.get(i)[ingredientsColumnIndex].split(","); // récupère tout le nom d'ingrédient dans un tableau
                Collection<Ingrédient> tempCol = new ArrayList<Ingrédient>();
                for (String ingredient : ingredientsArray){
                        Ingrédient nouvelIngredient = new Ingrédient(ingredient);
                        tempCol.add(nouvelIngredient);
                }
                recette.setIngrédients(tempCol);
            }
            if(categorieColumnIndex != notFoundColumnIndex) {
                String[] categoriesArray = cleanedDatabase.get(i)[categorieColumnIndex].split(","); // récupère tout le nom d'ingrédient dans un tableau
                Collection<Categorie> tempCol = new ArrayList<Categorie>();
                for (String categorie : categoriesArray){
                    Categorie nouvelleCategorie = new Categorie(categorie);
                    tempCol.add(nouvelleCategorie);
                }
                recette.setCatégories(tempCol);
            }
            if(stepsColumnIndex != notFoundColumnIndex) {
                String[] stepsArray = cleanedDatabase.get(i)[stepsColumnIndex].split(","); // récupère tout le nom d'ingrédient dans un tableau
                Collection<Etape> tempCol = new ArrayList<Etape>();
                for (String etape : stepsArray){
                    Etape nouvelleEtape = new Etape(etape);
                    tempCol.add(nouvelleEtape);
                }
                recette.setEtapes(tempCol);
            }


            recettes.add(recette);

        }

        return recettes;
    }

    /**
     * Parse data by a separator.
     * @param data Data to parse
     * @param separator Separator
     * @return Parsed data
     */
    private static List<String> parse(final String data, final String separator){
        List<String> elements = new ArrayList<>();
        if(data != null && data.length() > 0) {
            for(String element : data.split(separator)){
                elements.add(element.trim());
            }
        }
        return elements;
    }

}
