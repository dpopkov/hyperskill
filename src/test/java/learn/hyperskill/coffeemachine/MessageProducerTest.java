package learn.hyperskill.coffeemachine;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MessageProducerTest {

    @Test
    public void testMessage() {
        MessageProducer producer = new MessageProducer();
        assertThat(producer.message(1, 1), is("Yes, I can make that amount of coffee"));
        assertThat(producer.message(0, 0), is("Yes, I can make that amount of coffee"));
        assertThat(producer.message(3, 1), is("No, I can make only 1 cup(s) of coffee"));
        assertThat(producer.message(3, 5),
                is("Yes, I can make that amount of coffee (and even 2 more than that)"));
        assertThat(producer.message(0, 3),
                is("Yes, I can make that amount of coffee (and even 3 more than that)"));
    }
}
