package com.nexxspace.tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FromJsonToJSTest {
    @Test
    public void emptyStringConvertsToEmptyString() throws Exception {
        assertEquals("", JsonTogger.toggle(""));
    }

    @Test
    public void emptyJsonToEmptyJavascript() throws Exception {
        assertEquals("{}", JsonTogger.toggle("{}"));
    }

    @Test
    public void singleFieldJsonToJavascript() throws Exception {
        assertEquals("{greetings: \"Hello\"}", JsonTogger.toggle("{\"greetings\": \"Hello\"}"));
    }

    @Test
    public void multilineSingleFieldJsonToJavascript() throws Exception {
        assertEquals("{\ngreetings: \"Hello\"}", JsonTogger.toggle("{\n\"greetings\": \"Hello\"}"));
    }

    @Test
    public void multipleFieldsJsonToJavascript() throws Exception {
        assertEquals("{greetings: \"Hello\", salutation: \"World\"}",
                JsonTogger.toggle("{\"greetings\": \"Hello\", \"salutation\": \"World\"}"));
    }

    @Test
    public void arrayJsonToJavascript() throws Exception {
        assertEquals("{greetings: [\"Hello\", \"World\"] }",
                JsonTogger.toggle("{\"greetings\": [\"Hello\", \"World\"] }"));
    }

    @Test
    public void nestedJsonToJavascript() throws Exception {
        assertEquals("{greetings: { salutation: \"World\"} }",
                JsonTogger.toggle("{\"greetings\": { \"salutation\": \"World\"} }"));
    }

    @Test
    public void multilineJsonToJavascript() throws Exception {
        assertEquals("{\ngreetings: { salutation: \"World\"} }",
                JsonTogger.toggle("{\n\"greetings\": { \"salutation\": \"World\"} }"));
    }


}
