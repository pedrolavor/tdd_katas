package me.pedrolavor.word_counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class WordCounterTest {
    
    @Test
    public void throwsException_WhenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.validateEmptyInput(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.validateEmptyInput("");
        });
    }
    
    @Test
    public void throwsException_WhenInputIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.validateBlankInput(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.validateBlankInput("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.validateBlankInput(" ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            WordCounter.validateBlankInput("    ");
        });
    }

    @Test
    public void returnCorrectCounter_WhenPassingOneDifferentWord() {
        Map<String, Integer> result1 = WordCounter.count(" ", "boom");
        Map<String, Integer> result2 = WordCounter.count(" ", "boom boom");
        Map<String, Integer> result3 = WordCounter.count(" ", "boom boom boom");

        assertEquals(1, result1.size());
        assertEquals(Integer.valueOf(1), result1.get("boom"));

        assertEquals(1, result2.size());
        assertEquals(Integer.valueOf(2), result2.get("boom"));

        assertEquals(1, result3.size());
        assertEquals(Integer.valueOf(3), result3.get("boom"));
    }

    @Test
    public void returnCorrectCounter_WhenPassingDifferentWords() {
        Map<String, Integer> result1 = WordCounter.count(",", "boom,bed,bath");
        Map<String, Integer> result2 = WordCounter.count(",", "boom,bath,boom,boom,bath,bed");
        Map<String, Integer> result3 = WordCounter.count(",", "boom,bath,bath,bed,boom,bed,boom,bed,big");

        assertEquals(3, result1.size());
        assertEquals(Integer.valueOf(1), result1.get("boom"));
        assertEquals(Integer.valueOf(1), result1.get("bed"));
        assertEquals(Integer.valueOf(1), result1.get("bath"));

        assertEquals(3, result2.size());
        assertEquals(Integer.valueOf(3), result2.get("boom"));
        assertEquals(Integer.valueOf(2), result2.get("bath"));
        assertEquals(Integer.valueOf(1), result2.get("bed"));

        assertEquals(4, result3.size());
        assertEquals(Integer.valueOf(3), result3.get("boom"));
        assertEquals(Integer.valueOf(2), result3.get("bath"));
        assertEquals(Integer.valueOf(3), result3.get("bed"));
        assertEquals(Integer.valueOf(1), result3.get("big"));
    }

}
