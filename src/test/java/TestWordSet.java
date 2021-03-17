import org.junit.Assert;
import org.junit.Test;

public class TestWordSet {

    @Test
    public void testWordSet() {
        String text = "hello, junit 4!";
        WordSet wordSet = new WordSet(text);
        Assert.assertEquals(wordSet.toString(),
                "hello 1 50.00%\n" + "junit 1 50.00%\n"
        );
    }

}
