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

        PrintWriter writer = new PrintWriter("Min's Output.txt");

        groceryList.stream().forEach(item -> writer.printf("name: %s \t\n", item.getName()));

        writer.close();

        System.out.println(groceryList.getGroceryListNumber());

        System.out.println("------------");

        String nullVal = null;
        System.out.println(nullVal == null);

    }


}
