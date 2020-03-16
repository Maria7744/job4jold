package generator;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {

    @Test
    public void whenGeneratotGetString() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> values = Map.of("name", "Petr", "subject", "you");
        String expected = "I am a Petr, Who are you?";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }


    @Test(expected = RuntimeException.class)
    public void whenKeysExceptions() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> values = Map.of("name", "Petr");
        String expected = "I am Petr, Who are you?";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void whenMoreKeysExceptions() {
        String template = "I am a ${name}, Who are you?";
        Map<String, String> values = Map.of("name", "Petr", "subject", "you");
        String expected = "I am Petr, Who are you?";
        assertThat(SimpleGenerator.formatString(template, values), is(expected));
    }


}

