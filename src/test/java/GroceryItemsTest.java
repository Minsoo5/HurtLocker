import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class GroceryItemsTest {

    @Test
    public void groceryConstructorAndGetterTest() {
        //Given
        String name = "Dawn";
        double price = 12.99;
        String type = "Cleaning Supply";
        Date expiration = new Date("1/10/3030");

        //When
        GroceryItems dawnDishSoap = new GroceryItems(name, price, type, expiration);

        //Then

        Assert.assertEquals(name, dawnDishSoap.getName());
        Assert.assertEquals(price, dawnDishSoap.getPrice(), 0.01);
        Assert.assertEquals(type, dawnDishSoap.getType());
        Assert.assertEquals(expiration, dawnDishSoap.getExpiration());

    }

}