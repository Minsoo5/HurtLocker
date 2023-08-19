import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GroceryListTest {

    @Test
    public void addTest1() {
        //Given
        ArrayList<GroceryItem> list = new ArrayList<>();
        GroceryItem muffin = new GroceryItem("Muffin", 3.99, "Food", "Tomorrow");

        //When
        list.add(muffin);

        //Then
        Assert.assertEquals(list.size(), 1);
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
}