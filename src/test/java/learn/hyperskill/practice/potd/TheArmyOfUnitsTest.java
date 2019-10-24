package learn.hyperskill.practice.potd;

import org.junit.Test;

import static learn.hyperskill.practice.potd.TheArmyOfUnits.classify;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TheArmyOfUnitsTest {

    @Test
    public void testClassify() {
        assertThat(classify(5), is("several"));
        assertThat(classify(303), is("swarm"));
    }
}
