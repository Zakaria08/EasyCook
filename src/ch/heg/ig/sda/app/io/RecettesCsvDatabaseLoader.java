package ch.heg.ig.sda.app.io;

import ch.heg.ig.sda.app.business.*;

import java.util.*;

import static ch.heg.ig.sda.app.io.FileDatabaseUtils.findColumnIndex;

public class RecettesCsvDatabaseLoader extends RecettesDatabaseLoader {

    public RecettesCsvDatabaseLoader(final String filepath){
        super(filepath);
    }

    public void process() {
        this.categories = loadCleanCatDatabase(filepath);
        this.recettes = loadCleanDatabase(filepath);
    }

    private Collection<Recette> loadCleanDatabase(final String filename){
        List<String[]> cleanedDatabase = ParserUtils.parseCSV(filename);
        return parseDocumentsDatabase(cleanedDatabase);
    }

    private Collection<Recette> parseDocumentsDatabase(List<String[]> cleanedDatabase){

        long elapsedTimeLoadArraylist = 0;

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
                LinkedList<Ingredient> tempCol = new LinkedList<>();
                for (String ingredient : ingredientsArray){
                        Ingredient nouvelIngredient = new Ingredient(ingredient);
                        tempCol.add(nouvelIngredient);
                }
                recette.setIngredients(tempCol);
            }
            if(categorieColumnIndex != notFoundColumnIndex) {
                recette.setCategorie(this.categories.get(cleanedDatabase.get(i)[categorieColumnIndex]));
            }
            if(stepsColumnIndex != notFoundColumnIndex) {
                String[] stepsArray = cleanedDatabase.get(i)[stepsColumnIndex].split(","); // récupère toutes les étapes dans un tableau
                LinkedList<Etape> tempCol = new LinkedList<Etape>();
                for (String etape : stepsArray){
                    Etape nouvelleEtape = new Etape(etape);
                    tempCol.add(nouvelleEtape);
                }
                recette.setEtapes(tempCol);
            }
            recettes.add(recette);
            recette.getCategorie().addRecipe(recette);
        }
        return recettes;
    }

    private Map<String,Categorie> loadCleanCatDatabase(final String filename){
        List<String[]> cleanedDatabase = ParserUtils.parseCSV(filename);
        return parseDocumentsCatDatabase(cleanedDatabase);
    }
    private Map<String,Categorie> parseDocumentsCatDatabase(List<String[]> cleanedDatabase){

        long elapsedTimeLoadArraylist = 0;

        int categorieColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.CATEGORIES.getColumnName());


        int notFoundColumnIndex = -1;

        int startIndex = 1; // Skip header

        Map<String,Categorie> categories = new HashMap<>();

        for (int i = startIndex; i < cleanedDatabase.size(); i++) {

            if(categorieColumnIndex != notFoundColumnIndex) {
                Categorie catTemp = new Categorie(cleanedDatabase.get(i)[categorieColumnIndex]);
                categories.put(catTemp.getNom(),catTemp);
            }

        }
        return categories;
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
