import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ParseTest {

    @Test
    public void rehydrateTextTest(){
        //Given
        String input = "Hey%How!Are;You##I%Am!Very;Good##Its%So!Nice;Out##";

        //Then
        String[] expectedArray = {"Hey%How!Are;You", "I%Am!Very;Good", "Its%So!Nice;Out"};
        String[] actualArray = Parse.cutIntoArray(input);

        //Then
        //Assert.assertEquals(expectedArray, actualArray);

    }

    @Test
    public void createGroceryItemListTest() {
        //Given
        String[] input = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"," ", "naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016", " "};
        List<GroceryItem> groceryList = new ArrayList<>();

        //When
        //groceryList = Parse.createGroceryItemList(input);

        //Then

    }



    @Test
    public void separateIntoPairsTest(){
        //Given
        String input = "Hey%How!Are;You?";

        //When
        String actual = Parse.separateIntoPairs(input);
        String expcted = "Hey, How, Are, You";

        //Then
        Assert.assertEquals(expcted, actual);

    }

    @Test
    public void cutIntoArrayTest1() {
        //Given
        String input = "naMe:Milk, price:3.23, type:Food, expiration:1/25/2016, , naME:BreaD, price:1.23, type:Food, expiration:1/02/2016,";

        //When
        String[] actual = Parse.cutIntoArray(input);
        String[] expcted = {"naMe:Milk", " price:3.23", " type:Food", " expiration:1/25/2016", " ", " naME:BreaD", " price:1.23", " type:Food", " expiration:1/02/2016"};

        //Then
        Assert.assertEquals(expcted, actual);

    }

    @Test
    public void grabValueTest() {
        //Given
        String input1 = " name:Milk";
        String input2 = " price:3.23";
        String input3 = " priCe:";

        //When
        String expected1 = "Milk";
        String expected2 = "3.23";
        String expected3 = null;


        //Then
        Assert.assertEquals(expected1, Parse.grabValue(input1));
        Assert.assertEquals(expected2, Parse.grabValue(input2));
        Assert.assertEquals(expected3, Parse.grabValue(input3));

    }

    @Test
    public void createGroceryListTest() throws IOException {
        //Given
        String input = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                       "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##" +
                       "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##" +
                       "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##";

        //When
        ArrayList<GroceryItem> groceryList = new ArrayList<>(Parse.createGroceryList(input));

        //Then
        Assert.assertEquals(4, groceryList.size());
        Assert.assertEquals("Milk", groceryList.get(0).getName());
        Assert.assertEquals(null, groceryList.get(0).getPrice());
        Assert.assertEquals(null, groceryList.get(2).getPrice());
        Assert.assertEquals("1/23/2016", groceryList.get(3).getExpiration());



    }


    @Test
    public void fixCapitalTest(){
        //Given
        String preWord1 = "tHis";
        String preWord2 = "ShOuLd";
        String preWord3 = "ALL";
        String preWord4 = "work";
        String preWord5 = "";

        //When
        String postWord1 = Parse.fixCapital(preWord1);
        String postWord2 = Parse.fixCapital(preWord2);
        String postWord3 = Parse.fixCapital(preWord3);
        String postWord4 = Parse.fixCapital(preWord4);
        String postWord5 = Parse.fixCapital(preWord5);


        //Then
        Assert.assertEquals("This", postWord1);
        Assert.assertEquals("Should", postWord2);
        Assert.assertEquals("All", postWord3);
        Assert.assertEquals("Work", postWord4);
        Assert.assertEquals("", postWord5);


    }



}