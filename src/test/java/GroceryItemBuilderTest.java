import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class GroceryItemBuilderTest{
    @Test
    public void groceryItemBuilderTest() {
        //Given
        GroceryItemBuilder builder = new GroceryItemBuilder();

        //When
        builder.name("Bread");
        builder.price(5.99);
        builder.type("Food");
        builder.expiration("08/26/2023");
        GroceryItem bread = builder.build();

        //Then
        Assert.assertEquals("Bread", bread.getName());
        Assert.assertEquals(5.99, bread.getPrice(), 0.01);
        Assert.assertEquals("Food", bread.getType());
        Assert.assertEquals("08/26/2023", bread.getExpiration());

    }

}