package com.nearsoft;

import java.util.regex.Pattern;

/**
 * As a reviewer of the Nearsoft posts
 * your task is to avoid bad words into
 * the publications.
 */
public class BadWords {

    public static String censureWord(String word) {
        String badWordRegex = "(^(P|p)[A-Za-z]*(R|r)$)|(^(H|h)[A-Za-z]*(O|o)[A-Za-z]*)";
        if(Pattern.matches(badWordRegex, word)){
            word = new String(new char[word.length()]).replace('\0', '#');
        }
        return word;
    }
}
