import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// import java.nio.file.SecureDirectoryStream;
import java.util.ArrayList;
// import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class to read CSV-style list of Apples. Adapted from the original.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2023.02.13
 */
public class AppleReader {
    // How many fields are expected.
    private static final int NUMBER_OF_FIELDS = 5;
    // Index values for the fields in each record.
    private static final int ID = 0,
            WEIGHT = 1,
            COLOR = 2,
            SEEDS = 3,
            POISON = 4;

    /**
     * Create a AppleReader.
     */
    public AppleReader() {
    }

    /**
     * Read sightings in CSV format from the given file.
     * Return an ArrayList of Sighting objects created from
     * the information in the file.
     * 
     * @param filename The file to be read - should be in CSV format.
     * @return A list of Sightings.
     */
    public ArrayList<Apple> getApples(String filename) {
        // Create a Apple from a CSV input line.
        Function<String, Apple> createSighting = record -> {
            String[] parts = record.split(",");
            if (parts.length == NUMBER_OF_FIELDS) {
                try {
                    int id = Integer.parseInt(parts[ID].trim());
                    double weight = Double.parseDouble(parts[WEIGHT].trim());
                    String color = parts[COLOR].trim();
                    int seeds = Integer.parseInt(parts[SEEDS].trim());
                    boolean poison = Boolean.parseBoolean(parts[POISON].trim());
                    return new Apple(weight, color, seeds, poison);
                } catch (NumberFormatException e) {
                    // System.out.println("Apple record has a malformed integer: " + record);
                    return null;
                }
            } else {
                // System.out.println("Apple record has the wrong number of fields: " + record);
                return null;
            }
        };
        ArrayList<Apple> apples;
        try {
            apples = Files.lines(Paths.get(filename))
                    .filter(record -> record.length() > 0 && record.charAt(0) != '#')
                    .map(createSighting)
                    .filter(sighting -> sighting != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            // System.out.println("Unable to open " + filename);
            apples = new ArrayList<>();
        }
        return apples;
    }

}
