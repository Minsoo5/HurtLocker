import org.apache.commons.io.IOUtils;
import java.io.IOException;
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
        System.out.println(output);

        //Potential regex "[^a-zA-Z_0-9/.:]" split the string where it's NOT those things
        //Regex for separating by key value pairs ""??

        String cutWords = Arrays.toString(output.split("[^a-zA-Z_0-9/.:]"));    //regex
        String pairs = Parse.separateIntoPairs(output);                               //Separate into key value pairs

//        System.out.println("\n --------------- \n");
//        System.out.println(pairs);
//
//        System.out.println(0 % 5);
//        System.out.println(1 % 5);
//        System.out.println(2 % 5);
//        System.out.println(3 % 5);
//        System.out.println(4 % 5);
//        System.out.println(5 % 5);
//        System.out.println(6 % 5);
//        System.out.println(7 % 5);
//        System.out.println(8 % 5);
//        System.out.println(9 % 5);
//        System.out.println(10 % 5);
//        System.out.println(11 % 5);
//        System.out.println(12 % 5);
//        System.out.println(13 % 5);

//        GroceryList groceryList = Parse.createGroceryList(output);

        ArrayList<GroceryItem> groceryList = Parse.createGroceryList(
                "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##" +
                "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##" +
                "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##" +
                "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##" +
                "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##" +
                "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##" +
                "naMe:;price:3.23;type:Food^expiration:1/04/2016##");

        groceryList.stream().forEach(item -> System.out.println(item.getName()));

    }


}
