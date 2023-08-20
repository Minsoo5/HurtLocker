import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroceryList <GroceryThing extends GroceryItem> extends ArrayList<GroceryThing> {

    //Not really working, need to fix
    //using array list for now with <GroceryItem>
    private static int groceryListNumber = 1;
    private GroceryList<GroceryThing> groceryList;


    public GroceryList() {}
    public GroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;

    }

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

    //Takes in list of
    public int occurrenceCounter(Comparable value) {
        int counter = 0;
//        if (value.getClass().getSimpleName() == String)
//        this.groceryList.stream().filter()

        return counter;
    }

    public void setGroceryListNumber(int number) {
        this.groceryListNumber = number;
    }

    public void incrementGroceryListNumber() {
        groceryListNumber+=1;
    }


}
