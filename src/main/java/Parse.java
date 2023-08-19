import java.util.ArrayList;
import java.util.Arrays;

public class Parse {
    private String textToParse;

    // separateIntoPairs -> cutIntoArray -> grabValue -> capitalize -> build obj -> addToList

    public static String rehydrateText(String textToHydrate) {

        return null;
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

    public static ArrayList<GroceryItem> createGroceryItemList(String[] input){

        return null;
    }


    //        CapitalizeFirstLetter capitalizeFL = (w) -> {sb.append(Character.toUpperCase(w.charAt(0)))}
    public static String fixCapital(String word) {
        StringBuilder sb = new StringBuilder();
        if (word.length() > 1) {
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    sb.append(Character.toUpperCase(word.charAt(0)));
                } else {
                    sb.append(Character.toLowerCase(word.charAt(i)));
                }
            }
        }
        return sb.toString();
    }

}
