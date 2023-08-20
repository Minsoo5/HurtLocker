import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GroceryList <GroceryThing extends GroceryItem> extends ArrayList<GroceryThing> {

    private static int groceryListNumber = 1;

    public void writeFile() throws FileNotFoundException {
        //Create a new writer
        String milk = "Milk";
        String bread = "Bread";
        String cookies = "Cookies";
        String apples = "Apples";

        PrintWriter writer = new PrintWriter("Grocery List Number " + groceryListNumber++ + ".txt");
        writer.printf("name:%s\t\tseen: 2%d times\t" +
                "=============\t\t=============\t" +
                "Price:");

        //Take in the arrayList of groceryItems
        //                     8s           8s
        String example = "name:%s\t\tseen: 2%d times\t" +
                "=============\t\t=============\t" +
                "Price:";

        //Write their contents to a file with proper formatting
        //Call methods to count how many times x has appeared in the list

    }

    public int getGroceryListNumber() {
        return groceryListNumber;
    }

    //String Counter a little bugged
    public static int stringCounter(GroceryList<GroceryItem> groceryList, Comparable value) {
        int counter = 0;
        for (GroceryItem item : groceryList) {
            if (value == null) {
                if (item.getName() == null || item.getType() == null || item.getExpiration() == null) {
                    counter++;
                }
            } else if (value.getClass().getSimpleName().equals("String")) {
                try {
                    if (item.getName().equals(value) || item.getType().equals(value) || item.getExpiration().equals(value)) {
                        counter++;
                    }
                } catch (NullPointerException ignored) {}
            }
        }

        return counter;
    }


    public static int doubleCounter(GroceryList<GroceryItem> groceryList, Comparable value) {
        int counter = 0;
        for (GroceryItem item : groceryList) {
            if (value == null) {
                if (item.getPrice() == null) {
                    counter++;
                }
            } else if (value.getClass().getSimpleName().equals("Double")) {
                try {
                    if (item.getPrice().toString().equals(value.toString())) {
                        counter++;
                    }
                } catch (NullPointerException ignored) {}
            }
        }

        return counter;
    }

    //Takes in list of
    public static int occurrenceCounter(GroceryList<GroceryItem> groceryList, Comparable value) {
        int counter = 0;
        if (value.getClass().getSimpleName().equals("String")) {
            return stringCounter(groceryList, value);
        }
        else if (value.getClass().getSimpleName().equals("Double")) {
            return doubleCounter(groceryList, value);
        }
        return counter;
    }

    public void setGroceryListNumber(int number) {
        this.groceryListNumber = number;
    }

    public void incrementGroceryListNumber() {
        groceryListNumber+=1;
    }


}
