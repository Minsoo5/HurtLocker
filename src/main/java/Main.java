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

        String cutWords = Arrays.toString(output.split("[^a-zA-Z_0-9/.:]"));    //regex
        String pairs = Parse.separateIntoPairs(output);                               //Separate into key value pairs


        GroceryList<GroceryItem> groceryList = Parse.createGroceryList(output);
        groceryList.writeFile(groceryList);

        System.out.println(groceryList.getGroceryListNumber());

        System.out.println("------------");

        String nullVal = null;
        System.out.println(nullVal == null);

    }


}
