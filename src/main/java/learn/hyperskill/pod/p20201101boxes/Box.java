package learn.hyperskill.pod.p20201101boxes;

import java.util.Arrays;

public class Box {
    private final int[] sizes = new int[3];

    public Box(int x, int y, int z) {
        sizes[0] = x;
        sizes[1] = y;
        sizes[2] = z;
    }

    /**
     * Compares sizes of this and other box.
     * This method is not semantically compatible with the method in interface {@link Comparable}.
     * @param other the other box
     * @return sum of comparing of all sizes:
     *          -3 if all sizes ot this box are less than the sizes of the other,
     *          3 if all sizes of this box are greater than the sizes of the other
     */
    public int compareTo(Box other) {
        int[] self = Arrays.copyOf(sizes, sizes.length);
        int[] target = Arrays.copyOf(other.sizes, other.sizes.length);
        Arrays.sort(self);
        Arrays.sort(target);
        int sum = 0;
        for (int i = 0; i < self.length; i++) {
            sum += Integer.compare(self[i], target[i]);
        }
        return sum;
    }

    /**
     * Checks whether this box can be put into destination box.
     * @param destination destination box
     * @return true if this box can be put into destination box,
     *         or false if the destination box can be put into this box.
     * @throws IllegalArgumentException if these two boxes can not be put
     *                                  into each other
     */
    public boolean canBePutInto(Box destination) {
        int cmp = this.compareTo(destination);
        if (cmp == 3 || cmp == -3) {
            return cmp == -3;
        }
        throw new IllegalArgumentException("Boxes are incompatible");
    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + sizes[0] +
                ", y=" + sizes[1] +
                ", z=" + sizes[2] +
                '}';
    }
}
