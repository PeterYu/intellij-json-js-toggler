package com.nexxspace.tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FromJSToJsonTest {
    @Test
    public void emptyStringConvertsToEmptyString() throws Exception {
        assertEquals("", JsonTogger.toggle(""));
    }

    @Test
    public void emptyJsObjectToEmptyJson() throws Exception {
        assertEquals("{}", JsonTogger.toggle("{}"));
    }

    @Test
    public void singleFieldJavascriptToJson() throws Exception {
        assertEquals("{\"greetings\": \"Hello\"}", JsonTogger.toggle("{greetings: \"Hello\"}"));
    }

    @Test
    public void multipleFieldsJsToJson() throws Exception {
        assertEquals("{\"greetings\": \"Hello\", \"salutation\": \"World\"}",
                JsonTogger.toggle("{greetings: \"Hello\", salutation: \"World\"}"));
    }

    @Test
    public void multilineJsToJson() throws Exception {
        assertEquals("{\n\t\"greetings\": \"Hello\",\n\t\"salutation\": \"World\"\n}",
                JsonTogger.toggle("{\n\tgreetings: \"Hello\",\n\tsalutation: \"World\"\n}"));
    }
//
//    @Test
//    public void arrayJsonToJavascript() throws Exception {
//        assertEquals("{greetings: [\"Hello\", \"World\"] }",
//                JsonTogger.toggle("{\"greetings\": [\"Hello\", \"World\"] }"));
//    }
//
//    @Test
//    public void nestedJsonToJavascript() throws Exception {
//        assertEquals("{greetings: { salutation: \"World\"} }",
//                JsonTogger.toggle("{\"greetings\": { \"salutation\": \"World\"} }"));
//    }
}
