package learn.hyperskill.practice.arrays;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class PrettyMatrixTest {

    @Test
    public void testIsLookingPretty() {
        assertMatrixIsPretty(new String[] {
                "WWWW",
                "BBBB",
                "WWWW",
                "YYYY"
        }, true);
    }

    @Test
    public void testIsNotLookingPretty() {
        assertMatrixIsPretty(new String[]{
                "BBBB",
                "BWWB",
                "BWWB",
                "BBBB"
        }, false);
    }

    @Test
    public void testIsLookingNotPrettyDownloadedTest3() {
        assertMatrixIsPretty(new String[]{
                "BYBY",
                "YBYB",
                "BYGG",
                "YBGG"
        }, false);
    }

    private void assertMatrixIsPretty(String[] lines, boolean expected) {
        assertThat(new PrettyMatrix(2).isLookingPretty(lines), is(expected));
    }
}
