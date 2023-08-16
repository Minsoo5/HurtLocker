import org.junit.Assert;
import org.junit.Test;

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
        String preWord = "tHis";

        //When
        String postWord = Parse.fixCapital(preWord);

        //Then
        Assert.assertEquals("This", postWord);
    }




}