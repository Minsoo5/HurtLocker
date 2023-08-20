import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class GroceryItemTest {

    @Test
    public void groceryConstructorAndGetterTest() {
        //Given
        String name = "Dawn";
        double price = 12.99;
        String type = "Cleaning Supply";
        String expiration = "1/10/3030";

        //When
        GroceryItem dawnDishSoap = new GroceryItem(name, price, type, expiration);
        GroceryItem dawnDishSoap2 = new GroceryItem(name, null, type, expiration);


        //Then
        Assert.assertEquals(name, dawnDishSoap.getName());
        Assert.assertEquals(price, dawnDishSoap.getPrice(), 0.01);
        Assert.assertEquals(type, dawnDishSoap.getType());
        Assert.assertEquals(expiration, dawnDishSoap.getExpiration());

        Assert.assertEquals(name, dawnDishSoap2.getName());
        Assert.assertEquals(null, dawnDishSoap2.getPrice());
        Assert.assertEquals(type, dawnDishSoap2.getType());
        Assert.assertEquals(expiration, dawnDishSoap2.getExpiration());
    }

    @Test
    public void grocerySetterTest() {
        //Given
        String name = "Dawn";
        double price = 12.99;
        String type = "Cleaning Supply";
        String expiration = "1/10/3030";

        //When
        GroceryItem dawnDishSoap = new GroceryItem(name, price, type, expiration);
        dawnDishSoap.setName("Pepsi");
        dawnDishSoap.setPrice(1.99);
        dawnDishSoap.setType("Soda");
        dawnDishSoap.setExpiration("Never");

        //Then

        Assert.assertEquals("Pepsi", dawnDishSoap.getName());
        Assert.assertEquals(1.99, dawnDishSoap.getPrice(), 0.01);
        Assert.assertEquals("Soda", dawnDishSoap.getType());
        Assert.assertEquals("Never", dawnDishSoap.getExpiration());

    }




}