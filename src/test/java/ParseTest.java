import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParseTest {

    @Test
    public void rehydrateTextTest(){
        //Given
        String input = "Hey%How!Are;You##I%Am!Very;Good##Its%So!Nice;Out##";

        //Then
        String[] expected = {"Hey", "How", "Are", "You", "I", "Am", "Very", "Good", "Its", "So", "Nice", "Out"};
        String[] actual = Parse.cutIntoArray(Parse.separateIntoPairs(input));

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createGroceryItemListTest() {
        //Given
        String[] input = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"," ", "naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016", " "};
        List<GroceryItems> groceryList = new ArrayList<>();

        //When
        groceryList = Parse.createGroceryItemList(input);

        //Then


    }

    @Test
    public void separateIntoPairsTest(){
        //Given
        String input = "Hey%How!Are;You?";

        //When
        String actual = Parse.separateIntoPairs(input);
        String expcted = "[Hey, How, Are, You]";

        //Then
        Assert.assertEquals(expcted, actual);

    }

    @Test
    public void cutIntoArrayTest() {
        //Given
        String input = "Hey##How##Are##You";

        //When
        String[] actual = Parse.cutIntoArray(input);
        String[] expcted = {"Hey", "How", "Are", "You"};

        //Then
        Assert.assertEquals(expcted, actual);

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