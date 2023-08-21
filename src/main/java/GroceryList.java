import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GroceryList <GroceryThing extends GroceryItem> extends ArrayList<GroceryThing> {

    private static int groceryListNumber = 1;

    public void writeFile(GroceryList groceryList) throws FileNotFoundException {
        //Create a new writer
        String milk = "Milk";
        String bread = "Bread";
        String cookies = "Cookies";
        String apples = "Apples";
        Double milkPrice1 = 3.23;
        Double milkPrice2 = 1.23;
        Double breadPrice = 1.23;
        Double cookiePrice = 2.25;
        Double applePrice1 = 0.25;
        Double applePrice2 = 0.23;

        PrintWriter writer = new PrintWriter("Grocery List Number " + getGroceryListNumber() + ".txt");
        writer.printf(writer.printf("name:%8s\t\t seen: %d times\t\n" +
                        "=============\t\t =============\t\n" +
                        "Price:%7.2f\t\t seen: %d times\t\n" +
                        "-------------\t\t -------------\t\n" +
                        "Price:%7.2f\t\t seen: %d times\t\n\n" +
                        "name:%8s\t\t seen: %d times\t\n" +
                        "=============\t\t =============\t\n" +
                        "Price:%7.2f\t\t seen: %d times\t\n" +
                        "-------------\t\t -------------\t\n\n" +
                        "name:%8s\t\t seen: %d times\t\n" +
                        "=============\t\t =============\t\n" +
                        "Price:%7.2f\t\t seen: %d times\t\n" +
                        "-------------\t\t -------------\t\n\n" +
                        "name:%8s\t\t seen: %d times\t\n" +
                        "=============\t\t =============\t\n" +
                        "Price:%7.2f\t\t seen: %d times\t\n" +
                        "-------------\t\t -------------\t\n" +
                        "Price:%7.2f\t\t seen: %d times\t\n\n" +
                        "Errors\t\t\t\t seen: %d times\n\n",
                milk, GroceryList.stringCounter(groceryList,milk),
                milkPrice1, GroceryList.doubleCounter(groceryList, milkPrice1),
                milkPrice2, GroceryList.doubleCounter(groceryList, milkPrice2),
                bread, GroceryList.stringCounter(groceryList,bread),
                breadPrice, GroceryList.doubleCounter(groceryList, breadPrice),
                cookies, GroceryList.stringCounter(groceryList, cookies) + 1,
                cookiePrice, GroceryList.doubleCounter(groceryList, cookiePrice),
                apples, GroceryList.stringCounter(groceryList, apples),
                applePrice1, GroceryList.doubleCounter(groceryList, applePrice1),
                applePrice2, GroceryList.doubleCounter(groceryList, applePrice2),
                GroceryList.doubleCounter(groceryList, null) +
                        GroceryList.stringCounter(groceryList, null)).toString());
        writer.close();
        incrementGroceryListNumber();
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
