package com.nearsoft;

import java.util.regex.Pattern;

/**
 * As a reviewer of the Nearsoft posts
 * your task is to avoid bad words into
 * the publications.
 */
public class BadWords {

    public String validateWord(String word) {
        String badWordRegex = "(^P[A-Z]*R$) | (^H[A-Z]*O[A-Z]*)";
        if(Pattern.matches(badWordRegex, word)){
            word = new String(new char[word.length()]).replace('\0', '#');
        }
        return word;
    }
}
