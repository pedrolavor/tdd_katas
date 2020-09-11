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
    public void test() {
        Map<String, Integer> result1 = WordCounter.count(" ", "boom");
        Map<String, Integer> result2 = WordCounter.count(" ", "boom beg boom beg bath bath bridge");

        assertEquals(1, result1.size());
        assertEquals(Integer.valueOf(1), result1.get("boom"));

        assertEquals(4, result2.size());
        assertEquals(Integer.valueOf(2), result2.get("boom"));
        assertEquals(Integer.valueOf(2), result2.get("beg"));
        assertEquals(Integer.valueOf(2), result2.get("bath"));
        assertEquals(Integer.valueOf(1), result2.get("bridge"));
    }

}
