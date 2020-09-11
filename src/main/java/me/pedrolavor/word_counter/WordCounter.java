package me.pedrolavor.word_counter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    public static void validateEmptyInput(String input) {
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException("Input cannot be empty.");
    }

    public static void validateBlankInput(String input) {
        validateEmptyInput(input);
        if(input.isBlank())
            throw new IllegalArgumentException("Input cannot be blank.");
    }

	public static Map<String, Integer> count(String separator, String words) {
        validateEmptyInput(separator);
        validateBlankInput(words);

        Map<String, Integer> result = new HashMap<>();
        List<String> splittedWords = Arrays.asList(words.split(separator));
        Set<String> differentWords = Set.copyOf(splittedWords);

        differentWords.forEach(word -> {
            List<String> filteredWords = splittedWords.stream()
                .filter(splittedWord -> splittedWord.equals(word))
                .collect(Collectors.toList());
            result.put(word, filteredWords.size());
        });

		return result;
	}

}
