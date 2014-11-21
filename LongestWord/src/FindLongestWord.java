import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import Trieclass.*;

class Stringcomparision implements Comparator<String>
{

	@Override
	/*function to compare two string lenght:
	 * The function takes input two Strings s1 and s2 and 
	 * returns the following values
	 * if length of s1> length of s2 return -1
	 * if length of s1< length of s2 return 1
	 * else if equal length return 0*/
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		
			if(s1.length()>s2.length())
				return -1;
			else if(s1.length()<s2.length())
				return 1;
			else
			     return 0;
			
			
		
		
	}
	


}
public class FindLongestWord {

	public static void main(String[] args) {
		
		
		int total_count=0; // to count the total number of words made 
		                   //from other words in file
		String array_of_words[];//array to store words
		ArrayList<String> allwords = new ArrayList<String>();//arraylist to add words from file
		Trie trie=new Trie();
		
		try{
			BufferedReader br=null;
			boolean flag=true;
			
			while(flag) 
			{
			try{
				System.out.println("Enter file name with extension and complete path\n");
				@SuppressWarnings("resource")
				
				Scanner scanner = new Scanner(System.in);
				String file=scanner.nextLine();
		     
				 br = new BufferedReader(new FileReader(file));
				 flag=false;
			}
			catch(Exception e)
			{
				System.out.println("Please enter correct file name and path");
				
			}
			
			}
			 String each_line;

			//Read File Line By Line

				while ((each_line = br.readLine()) != null)   {
				  
				  allwords.add(each_line);//adding words into arraylists
				}


			//Closing the input stream

				br.close();
				}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		/*creating an array to store all words*/
		array_of_words=new String[allwords.size()];
		array_of_words=allwords.toArray(array_of_words);
		/*sorting based on String Length of each word*/
		Arrays.sort(array_of_words,new Stringcomparision());
		
		for(int i=0;i<array_of_words.length;i++)
		{
			/*inserting the words into trie*/
			trie.InsertInTrie(array_of_words[i]);
		}
		
		
		for(int j=0;j<array_of_words.length;j++)
		{
		if(trie.delete(array_of_words[j])&&trie.Longestword(array_of_words[j]))
		{
			total_count++;
		if(total_count==1)
			System.out.println("1st longest word in the file " +
					"that can be constructed by" +
					" \nconcatenating copies of shorter words " +
					"also found in the file:\n"+array_of_words[j]+ "\nLength:"+array_of_words[j].length());
		
		else if(total_count==2)
			System.out.println("\n2nd longest word in the file " +
					"that can be constructed by" +
					" \nconcatenating copies of shorter words " +
					"also found in the file:\n"+array_of_words[j]+ "\nLength:"+array_of_words[j].length());
		
		}
		}
		
		
		System.out.println("Total count of how many of the words in the list can be constructed\n" +
				"of other words in the list(including 1st and 2nd):"+total_count);
		

		
		
	}

}
