import org.apache.commons.io.IOUtils;
import java.io.IOException;
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

        //Potential regex "[^a-zA-Z_0-9/.]" split the string where it's NOT those things


        String cutWords = Arrays.toString(output.split("[^a-zA-Z_0-9/.]"));

        System.out.println("\n --------------- \n");

        System.out.println(cutWords);
    }


}
