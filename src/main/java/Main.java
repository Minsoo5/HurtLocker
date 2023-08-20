import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
//        System.out.println(output);

        //Potential regex "[^a-zA-Z_0-9/.:]" split the string where it's NOT those things
        //Regex for separating by key value pairs ""??

        String cutWords = Arrays.toString(output.split("[^a-zA-Z_0-9/.:]"));    //regex
        String pairs = Parse.separateIntoPairs(output);                               //Separate into key value pairs

        GroceryList<GroceryItem> groceryList = Parse.createGroceryList(
                "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##" +
                "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##" +
                "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##" +
                "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##" +
                "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##" +
                "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##" +
                "naMe:;price:3.23;type:Food^expiration:1/04/2016##");

        groceryList.stream().forEach(item -> System.out.println(item.getName() + " " + item.getPrice() + " " + item.getType() + " " + item.getExpiration()));
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

        PrintWriter writer = new PrintWriter("Min's Output.txt");
        writer.printf(writer.printf("name:%8s\t\tseen: %d times\t\n" +
                                    "=============\t\t=============\t\n" +
                                    "Price:%7.2f\t\tseen: %d times\t\n" +
                                    "-------------\t\t-------------\t\n" +
                                    "Price:%7.2f\t\tseen: %d times\t\n\n" +
                                    "name:%8s\t\tseen: %d times\t\n" +
                                    "=============\t\t=============\t\n" +
                                    "Price:%7.2f\t\tseen: %d times\t\n" +
                                    "-------------\t\t-------------\t\n\n" +
                                    "name:%8s\t\tseen: %d times\t\n" +
                                    "=============\t\t=============\t\n" +
                                    "Price:%7.2f\t\tseen: %d times\t\n" +
                                    "-------------\t\t-------------\t\n\n" +
                                    "name:%8s\t\tseen: %d times\t\n" +
                                    "=============\t\t=============\t\n" +
                                    "Price:%7.2f\t\tseen: %d times\t\n" +
                                    "-------------\t\t-------------\t\n" +
                                    "Price:%7.2f\t\tseen: %d times\t\n\n" +
                                    "Errors\t\t\t\tseen : %d times\n\n",
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

        //groceryList.stream().forEach(item -> writer.printf("name: %s \t\n", item.getName()));

        writer.close();

        System.out.println(groceryList.getGroceryListNumber());

        System.out.println("------------");

        String nullVal = null;
        System.out.println(nullVal == null);

    }


}
