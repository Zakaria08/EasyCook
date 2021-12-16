package ch.heg.ig.sda.app.io;

import ch.heg.ig.sda.app.business.Recette;
import ch.heg.ig.sda.app.business.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ch.heg.ig.sda.app.io.FileDatabaseUtils.findColumnIndex;
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

        int reviewColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.REVIEW.getColumnName());
        int ratingColumnIndex = findColumnIndex(cleanedDatabase.get(0), RecetteConstant.RATING.getColumnName());
        int notFoundColumnIndex = -1;

        int startIndex = 1; // Skip header

        // The size is known in advance, prevent array list unnecessary grow
        Collection<Recette> recettes = new ArrayList<>(cleanedDatabase.size() - 1);

        for (int i = startIndex; i < cleanedDatabase.size(); i++) {

            Recette comment = new Recette();

            if(reviewColumnIndex != notFoundColumnIndex) {
                recette.setReview(cleanedDatabase.get(i)[reviewColumnIndex]);
            }

            if(ratingColumnIndex != notFoundColumnIndex) {
                recette.setRating(Integer.parseInt(cleanedDatabase.get(i)[ratingColumnIndex]));
            }

            recettes.add(comment);

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
