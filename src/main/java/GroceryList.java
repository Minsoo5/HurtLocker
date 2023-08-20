import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GroceryList <GroceryThing extends GroceryItem> extends ArrayList<GroceryThing> {

    //Not really working, need to fix
    //using array list for now with <GroceryItem>
    private static int groceryListNumber = 1;
//    private GroceryList<GroceryThing> groceryList;
//
//
//    public GroceryList() {}
//
//    public GroceryList(GroceryList groceryList) {
//        this.groceryList = groceryList;
//    }

    public void writeFile() throws IOException {
        //Create a new writer
        FileWriter writer = new FileWriter("Grocery List Number " + groceryListNumber++ + ".txt");
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
