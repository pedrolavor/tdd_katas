package me.pedrolavor.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AnagramTest {
    
    @Test
    public void whenInputIsEmpty_ThenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Anagram.validateInput(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Anagram.validateInput("");
        });
    }

    @Test
    public void whenInputIsBlank_ThenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Anagram.validateInput(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Anagram.validateInput("  ");
        });
    }

    @Test
    public void calculateTheNumberOfAnagramsCorrectly() {
        assertEquals(1, Anagram.numberOfAnagrams("a"));
        assertEquals(2, Anagram.numberOfAnagrams("ab"));
        assertEquals(6, Anagram.numberOfAnagrams("abc"));
        assertEquals(24, Anagram.numberOfAnagrams("abcd"));
    }

    @Test
    public void generateAnagramsSizeCorrectly() {
        assertEquals(1, Anagram.generate("a").size());
        assertEquals(2, Anagram.generate("ab").size());
        assertEquals(6, Anagram.generate("abc").size());
        assertEquals(24, Anagram.generate("abcd").size());
    }

    @Test
    public void generateAnagramsCorrectly() {
        List<String> result1 = Arrays.asList("a");
        List<String> result2 = Arrays.asList("ab", "ba");
        List<String> result3 = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        List<String> result4 = Arrays.asList(
            "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
            "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
            "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
            "dabc", "dacb", "dbac", "dbca", "dcab", "dcba"
        );

        assertTrue(Anagram.generate("a").containsAll(result1));
        assertTrue(Anagram.generate("ab").containsAll(result2));
        assertTrue(Anagram.generate("abc").containsAll(result3));
        assertTrue(Anagram.generate("abcd").containsAll(result4));
    }

    @Test
    public void generateAnagramsCorrectlyEvenWithRepeatedChars() {
        List<String> result1 = Arrays.asList("aa", "aa");
        List<String> result2 = Arrays.asList("aab", "aba", "aab", "aba", "baa", "baa");

        assertTrue(Anagram.generate("aa").containsAll(result1));
        assertTrue(Anagram.generate("aab").containsAll(result2));
    }

}
