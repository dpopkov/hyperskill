package learn.hyperskill.practice.methods;

public class CompositeNumbers {
    public static boolean isComposite(long number) {
        if (number > 2 && number % 2 == 0) {
            return true;
        }
        long limit = (long) (Math.sqrt(number)) + 1;
        for (long d = 3; d < limit; d += 2) {
            if (number % d == 0) {
                return true;
            }
        }
        return false;
    }
}
