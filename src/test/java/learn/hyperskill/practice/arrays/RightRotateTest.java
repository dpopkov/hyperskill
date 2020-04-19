package learn.hyperskill.practice.arrays;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class RightRotateTest {

    @Test
    public void testRightRotate() {
        int[] a = {1, 2, 3, 4, 5};
        int[] exp = {5, 1, 2, 3, 4};
        RightRotate.rightRotate(a, 1);
        Assert.assertThat(a, Matchers.is(exp));
    }
}
