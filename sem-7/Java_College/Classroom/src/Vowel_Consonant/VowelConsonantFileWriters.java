package Vowel_Consonant;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VowelConsonantFileWriters {

	public static void main(String[] args) {
		// Read a string from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String inputString = scanner.nextLine();
		scanner.close();

		// Extract vowels and consonants
		String vowels = extractVowels(inputString);
		String consonants = extractConsonants(inputString);

		// Write vowels to vowel.txt
		writeToFile("vowel.txt", vowels);

		// Write consonants to consonant.txt
		writeToFile("consonant.txt", consonants);

		System.out.println("Vowels and consonants have been written to vowel.txt and consonant.txt respectively.");
	}

	private static String extractVowels(String input) {
		return input.replaceAll("[^aeiouAEIOU]", "");
	}

	private static String extractConsonants(String input) {
		return input.replaceAll("[aeiouAEIOU]", "");
	}

	private static void writeToFile(String fileName, String content) {
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
