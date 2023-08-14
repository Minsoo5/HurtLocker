import org.junit.Assert;
import org.junit.Test;

public class ParseTest {

    @Test
    public void rehydrateTextTest(){
        //Given

        //When

        //Then
    }

    @Test
    public void fixCapitalTest(){
        //Given
        String preWord = "tHis";

        //When
        String postWord = Parse.fixCapital(preWord);

        //Then
        Assert.assertEquals("This", postWord);
    }




}