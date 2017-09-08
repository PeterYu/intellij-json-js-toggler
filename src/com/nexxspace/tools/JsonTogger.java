package com.nexxspace.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonTogger {
    public static String toggle(String selectedText) {
        if (isJson(selectedText))
            return toJavascript(selectedText);
        else
            return toJson(selectedText);
    }

    private static String toJson(String selectedText) {
        return selectedText.replaceAll("([^ ,\"{]*):", "\"$1\":");
    }

    private static String toJavascript(String selectedText) {
        return selectedText.replaceAll("\"([^\"]*)\":", "$1:");
    }

    private static boolean isJson(String selectedText) {
        Pattern pattern = Pattern.compile(".*\"[\\s]*:.*", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(selectedText);
        return matcher.find();
    }
}
