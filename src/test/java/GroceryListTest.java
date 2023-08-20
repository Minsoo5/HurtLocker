import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GroceryListTest {

    @Test
    public void constructorTest() {
        //Given
        String input = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##" +
                "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##" +
                "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##";

        //When
        GroceryList<GroceryItem> list = Parse.createGroceryList(input);

        //Then
        Assert.assertEquals(list.size(), 4);
        Assert.assertEquals(list.get(0).getName(),"Milk" );
    }

    @Test
    public void addTest1() {
        //Given
        GroceryList<GroceryItem> empty = new GroceryList<>();
        GroceryList<GroceryItem> list = new GroceryList<>();
        GroceryItem muffin = new GroceryItem("Muffin", 3.99, "Food", "Tomorrow");

        //When
        list.add(muffin);

        //Then
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals(empty.size(), 0);
    }

    @Test
    public void addTest2() {
        //Given
        GroceryList list = new GroceryList();
        GroceryItem muffin = new GroceryItem("Muffin", 3.99, "Food", "Tomorrow");

        //When
        list.add(muffin);

        //Then
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void writeToFileTest() throws FileNotFoundException {
        //Given
        PrintWriter printer = new PrintWriter("TestTest123.txt");

        String input = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##" +
                "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##" +
                "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##";
        ArrayList<GroceryItem> groceryList = new ArrayList<>(Parse.createGroceryList(input));

        //When

        //Not 100% sure how to test this in a meaningful way tbh...

        //Then

    }

    @Test
    public void stringCounterTest() {
        //Given
        String input = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/11/2016##" +
                "naMe:MilK;priCe:;type:Food;expiration:1/11/2016##";

        GroceryList<GroceryItem> list = Parse.createGroceryList(input);

        //When
        int expectedMilk = 2;
        int actualMilk = GroceryList.stringCounter(list, "Milk");

        int expectedExp = 3;
        int actualExp = GroceryList.stringCounter(list, "1/11/2016");

        int expectedType = 3;
        int actualType = GroceryList.stringCounter(list, "Food");

        //Then
        Assert.assertEquals(expectedMilk, actualMilk);
        Assert.assertEquals(expectedExp, actualExp);
        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void stringCounterNullTest() {
        //Given
        String input = "naMe:MiLK;priCe:;type:Food;expiration:##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:##" +
                "naMe:;priCe:;type:;expiration:##";

        GroceryList<GroceryItem> list = Parse.createGroceryList(input);

        //When
        int expectedMilk = 1;
        int actualMilk = GroceryList.stringCounter(list, "Milk");

        int expectedExp = 0;
        int actualExp = GroceryList.stringCounter(list, "1/11/2016");

        int expectedType = 2;
        int actualType = GroceryList.stringCounter(list, "Food");


        //Then
        Assert.assertEquals(expectedMilk, actualMilk);
        Assert.assertEquals(expectedExp, actualExp);
        Assert.assertEquals(expectedType, actualType);
    }


    @Test
    public void countingNullOcurrencesTest() {
        //Given
        String input = "naMe:MiLK;priCe:;type:Food;expiration:##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:##" +
                "naMe:;priCe:;type:;expiration:##";

        GroceryList<GroceryItem> list = Parse.createGroceryList(input);

        //When
        int expectedNull = 5;
        int actualNull = GroceryList.stringCounter(list, "");

        //Then


    }


    @Test
    public void occurrenceCounterDoubleTest() {
        //Given
        String input = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##" +
                "naMe:MilK;priCe:;type:Food;expiration:4/25/2016##";

        GroceryList<GroceryItem> list = Parse.createGroceryList(input);

        //When

        int expectedPrice = 1;
        int actualPrice = GroceryList.stringCounter(list, 2.25);

        //Then
        Assert.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void getGroceryListNumberTest() {
        //Given
        GroceryList<GroceryItem> gList = new GroceryList<>();

        //When
        gList.setGroceryListNumber(1);
        int expected = 1;
        int actual = gList.getGroceryListNumber();

        //Then
        Assert.assertEquals(expected, actual);
        gList.setGroceryListNumber(1);

    }

    @Test
    public void setGroceryListNumberTest() {
        //Given
        GroceryList<GroceryItem> gList = new GroceryList<>();

        //When
        gList.setGroceryListNumber(100);
        int expected = 100;
        int actual = gList.getGroceryListNumber();

        //Then
        Assert.assertEquals(expected, actual);
        gList.setGroceryListNumber(1);
    }


    @Test
    public void incrementGroceryListNumberTest() {
        //Given
        GroceryList<GroceryItem> gList = new GroceryList<>();

        //When
        gList.setGroceryListNumber(1);
        gList.incrementGroceryListNumber();
        int expected = 2;
        int actual = gList.getGroceryListNumber();

        //Then
        Assert.assertEquals(expected, actual);
        gList.setGroceryListNumber(1);
    }


}