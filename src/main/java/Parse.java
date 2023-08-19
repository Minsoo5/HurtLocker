import java.util.ArrayList;
import java.util.Arrays;

public class Parse {
    private String textToParse;

    // separateIntoPairs -> cutIntoArray -> grabValue -> capitalize -> build obj -> addToList


    public static void rehydrateText(String textToHydrate) {

    }


    public static String separateIntoPairs(String textToSeparate) {
        String pairs = Arrays.toString(textToSeparate.split("[^a-zA-Z_0-9/.:]"));
        return pairs;
        //returns one big string that is ONE element
    }

    public static String[] cutIntoArray(String input) {

        String[] eachItem = input.split(",");
        return eachItem;
        //Each element in the array contains k:v in the form of a string
    }

    public static String grabValue(String keyValuePair) {
        String[] keyValue =  keyValuePair.split(":");
        return keyValue.length > 1 ? keyValue[1] : null;
    }

    public static GroceryList createGroceryList(String rawData) {
        GroceryList<GroceryItem> groceryList = new GroceryList();

        String stringSections = separateIntoPairs(rawData);
        String[] keyValueArray = cutIntoArray(stringSections);      //Always name, price, type, expiration
        for (int i = 0; i < keyValueArray.length; i++) {
            int groceryItemNumber = 0;
            if (i % 5 == 0) {
                GroceryItemBuilder builder = new GroceryItemBuilder();
                builder.name(Parse.fixCapital(grabValue(keyValueArray[i])));
                builder.price(keyValueArray[i+1] == null ? null : Double.parseDouble(grabValue(keyValueArray[i + 1])));
                builder.type(Parse.fixCapital(grabValue(keyValueArray[i + 2])));
                builder.expiration(grabValue(keyValueArray[i + 3]));
                groceryList.add(builder.build());
            }
        }
        return groceryList;
    }


    //        CapitalizeFirstLetter capitalizeFL = (w) -> {sb.append(Character.toUpperCase(w.charAt(0)))}
    public static String fixCapital(String word) {
        StringBuilder sb = new StringBuilder();
        if (word == null) {
            return null;
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    sb.append(Character.toUpperCase(word.charAt(0)));
                } else {
                    sb.append(Character.toLowerCase(word.charAt(i)));
                }
            }
            return sb.toString();
        }
    }


}
