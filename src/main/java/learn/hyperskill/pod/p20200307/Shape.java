package learn.hyperskill.pod.p20200307;

enum Shape {
    TRIANGLE,
    RECTANGLE,
    CIRCLE;

    public double area(double[] a) {
        if (this == TRIANGLE) {
            double p = (a[0] + a[1] + a[2]) / 2;
            return Math.sqrt(p * (p - a[0]) * (p - a[1]) * (p - a[2]));
        } else if (this == RECTANGLE) {
            return a[0] * a[1];
        } else if (this == CIRCLE) {
            return 3.14 * a[0] * a[0];
        }
        throw new IllegalStateException("There is no calculation for this shape type: " + this);
    }

    public static Shape of(String name) {
        return Shape.valueOf(name.toUpperCase());
    }
}
