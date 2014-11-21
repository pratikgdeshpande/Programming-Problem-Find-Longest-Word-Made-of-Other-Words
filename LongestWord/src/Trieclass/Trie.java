package Trieclass;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

class TrieNode {

	boolean is_End_of_String;// marks the end of word
	Collection<TrieNode> child;// children of root
	char character; // The character this node represents

	/* constructor for node */
	public TrieNode(char c) {
		child = new LinkedList<TrieNode>();
		is_End_of_String = false;
		character = c;

	}

	/* returns subNode with character c */

	public TrieNode subNode(char c) {
		if (child != null) {

			for (TrieNode eachChild : child) {
				if (eachChild.character == c)
					return eachChild;
			}

		}
		return null;

	}

}

public class Trie {
	private TrieNode root;

	/* constructor for root */
	public Trie() {
		root = new TrieNode('#');

	}

	/* Function to insert words into Trie: 
	 * the function starts at the root and traverses below 
	 * inserting characters of word where ever required by the function*/
	public void InsertInTrie(String word) {
		TrieNode current = root;
		if (word.length() == 0)// empty character
			current.is_End_of_String = true;
		int i;
		/* if more than one character */
		for (i = 0; i < word.length(); i++) {
			/* finding if the node already exists*/
			TrieNode child = current.subNode(word.charAt(i));
			
			/*there is already a child with this character*/
			if (child != null)
				current = child;
			
			/*creating new child and updating the current pointer*/
			else {

				current.child.add(new TrieNode(word.charAt(i)));
				current = current.subNode(word.charAt(i));
				// System.out.println(i+")"+current+" " +word.charAt(i));
			}
			/*reached the end of word*/
			if (i == word.length() - 1) {
				current.is_End_of_String = true;
				
			}

		}
		
	}
	
	/*Function to search in Trie:
	 * The function starts at the root and checks if each chracter of
	 * word is present in order*/

	public boolean SearchInTrie(String s) {

		TrieNode current = root;
		int i;
		
		while (current != null) {
             /*loop over the entire word*/
			for (i = 0; i < s.length(); i++) {
			
				/*at any time if character of word does not exist*/
				if (current.subNode(s.charAt(i)) == null)
					return false;
				else {
					/*if character exists update the current variable 
					 * to that character*/
					current = current.subNode(s.charAt(i));
					
				}

			}
			
			/*if end of word is reached the word exists in Trie*/
			if (current.is_End_of_String == true)
				return true;
			else
				return false;

		}
		return false;
	}

	/*Function to delete words from Trie:
	 * the function does not physically deletes words.
	 * It just updates the is_End_of_String variable of 
	 * word to make a logical deletion*/
	public boolean delete(String s) {

		TrieNode current = root;
		int i;
		while (current != null) {

			for (i = 0; i < s.length(); i++) {
				if (current.subNode(s.charAt(i)) == null)
					return false;
				else {
					current = current.subNode(s.charAt(i));
					// System.out.println(i+")"+current+" " +s.charAt(i));
				}

			}
			if (current.is_End_of_String == true) {
				current.is_End_of_String = false;
				return true;
			} else
				return false;

		}
		return false;
	}

	/*Function to check if input word is concatenation of
	 * other words in file:
	 * The function takes input as a String and checks sequentially if
	 * a substring of word is present in the file. If yes then
	 * it checks for the remaining part of word in the same manner
	 * recursively*/
	public boolean Longestword(String word) {
		// System.out.println(word.length());
		if (word.length() == 0)
			return true;
		for (int i = 0; i < word.length(); i++) {
			// System.out.println(word.substring(0,i+1));
			if (this.SearchInTrie(word.substring(0, i + 1))) {
				if (Longestword(word.substring(i + 1, word.length())))
					return true;

			}

		}
		return false;
	}

	/*used for debugging purpose
	 * Function that lists all the files in directory*/
	/*
	public void listfiles() {

		String path = ".";

		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				System.out.println(files);
			}
		}
	}
	*/
}
