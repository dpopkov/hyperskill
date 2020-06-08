package learn.hyperskill.coffeemachine;

public class MessageProducer {
    public String message(int neededNumCups, int realNumCups) {
        if (neededNumCups == realNumCups) {
            return "Yes, I can make that amount of coffee";
        } else if (neededNumCups < realNumCups) {
            int diff = realNumCups - neededNumCups;
            return String.format("Yes, I can make that amount of coffee (and even %d more than that)", diff);
        } else {
            return String.format("No, I can make only %d cup(s) of coffee", realNumCups);
        }
    }
}
