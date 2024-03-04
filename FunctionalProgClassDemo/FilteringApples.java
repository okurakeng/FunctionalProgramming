import java.util.ArrayList;
import java.util.List;

/**
 * Demo of functional programming.
 *
 * @author Team Java
 * @version Feb 27 2023
 */
public class FilteringApples {
    private ArrayList<Apple> apples;

    /**
     * Create an AppleFilter.
     */
    public FilteringApples() {
        AppleReader reader = new AppleReader();
        this.apples = reader.getApples("appleList.csv"); // reads in data from CSV
    }

    /**
     * We have this 'apples' ArrayList. Filter out Apples that are Green and add them to the result ArrayList.  
     */
    public List<Apple> filterGreenApples() {
        List<Apple> result = new ArrayList<>();
        
        /** Your code here **/
        
        printList(result);
        return result;
    }

    /**
     * Prints a given list of apples on output. Nothing fancy...yet.
     * 
     * @param appleList List of apples that you want to print.
     */
    private void printList(List<Apple> appleList) {
        System.out.println("List of Apples: ");
        for (Apple apple : appleList) {
            System.out.println(" - " + apple);
        }
        System.out.println("Filtered list length: " + appleList.size());
    }

}