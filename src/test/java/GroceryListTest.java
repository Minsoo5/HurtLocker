import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GroceryListTest {

    @Test
    public void addTest1() {
        //Given
        ArrayList<GroceryItems> list = new ArrayList<>();
        GroceryItems muffin = new GroceryItems("Muffin", 3.99, "Food", "Tomorrow");

        //When
        list.add(muffin);

        //Then
        Assert.assertEquals(list.size(), 1);

    }

    @Test
    public void addTest2() {
        //Given
        GroceryList list = new GroceryList();
        GroceryItems muffin = new GroceryItems("Muffin", 3.99, "Food", "Tomorrow");

        //When
        list.add(muffin);

        //Then
        Assert.assertEquals(list.size(), 1);

    }
}