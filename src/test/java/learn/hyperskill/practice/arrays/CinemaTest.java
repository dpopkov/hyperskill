package learn.hyperskill.practice.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaTest {

    @Test
    public void testSample1() {
        int[][] data = createData("0 1 0 1\n1 1 0 1\n1 0 0 1");
        int rst = Cinema.findRow(data, 2);
        assertEquals(3, rst);
    }

    @Test
    public void testSample2() {
        int[][] data = createData("0 1 0\n1 0 0\n1 1 1");
        int rst = Cinema.findRow(data, 3);
        assertEquals(0, rst);
    }

    private int[][] createData(String input) {
        String[] lines = input.split("\n");
        int[][] data = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String[] t = lines[i].split(" ");
            data[i] = new int[t.length];
            for (int j = 0; j < t.length; j++) {
                data[i][j] = Integer.parseInt(t[j]);
            }
        }
        return data;
    }
}