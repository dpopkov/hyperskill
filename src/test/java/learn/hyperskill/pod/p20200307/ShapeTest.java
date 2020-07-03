package learn.hyperskill.pod.p20200307;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void testOf() {
        assertEquals(Shape.TRIANGLE, Shape.of("triangle"));
        assertEquals(Shape.RECTANGLE, Shape.of("rectangle"));
        assertEquals(Shape.CIRCLE, Shape.of("circle"));
    }

    @Test
    public void testArea() {
        double[] sides = {3.0, 4.0, 5.0};
        double area = Shape.TRIANGLE.area(sides);
        assertEquals(6.0, area, 1e-14);
    }
}
