import java.util.Arrays;

public class Parse {
    private String textToParse;


    public static String rehydrateText(String textToHydrate) {

        return null;
    }

    public static String separateIntoPairs(String textToSeparate) {
        String pairs = Arrays.toString(textToSeparate.split("[^a-zA-Z_0-9/.:]"));
        return pairs;
    }

    public static String[] cutIntoArray(String input) {

        String[] eachItem = input.split("##");
        return eachItem;
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
