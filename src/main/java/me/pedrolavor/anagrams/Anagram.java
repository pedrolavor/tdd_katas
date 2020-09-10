package me.pedrolavor.anagrams;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static void validateInput(String input) {
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException("Anagram input is empty.");

        if(input.isBlank())
            throw new IllegalArgumentException("Anagram input is blank.");
    }

    public static int numberOfAnagrams(String input) {
        validateInput(input);

        int inputLength = input.length();
        int numberOfAnagrams = 1;

        for(int i = 1; i <= inputLength; i++) {
            numberOfAnagrams *= i;
        }

        return numberOfAnagrams;
    }

    public static List<String> generate(String input) {
        validateInput(input);
        return _generate("", input);
    }

	private static List<String> _generate(String prefix, String word) {
        List<String> anagrams = new ArrayList<>();
        int wordLength = word.length();

		if (wordLength <= 1) {
            anagrams.add(prefix + word);

		} else {
			for (int i = 0; i < wordLength; i++) {
				String currentChar = word.substring(i, i + 1);
				String allBefore = word.substring(0, i);
				String allAfter = word.substring(i + 1);
				anagrams.addAll(_generate(prefix + currentChar, allBefore + allAfter));
			}
        }
        
        return anagrams;
	}
    
}
