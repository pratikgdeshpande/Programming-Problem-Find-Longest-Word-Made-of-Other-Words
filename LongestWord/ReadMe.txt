Programming Problem ­ Find Longest Word Made of Other Words

======================

Write a program that reads a file containing a sorted list of words (one word per line, no
spaces, all lower case), then identifies the

1)1st longest word in the file that can be constructed by concatenating copies of shorter words also found in the file.
2)The program should then go on to report the 2nd longest word found.
3)Total count of how many of the words in the list can be constructed of other words in the list.

Program Design:
1)The program reads the words from the file into an Arraylist as expanding an Arraylist 
is less expensive than expanding an Array.
2)This operation takes O(n) time.
3)It then converts the Arraylist called allwords into an Array called 
array_of_words.
4)This Array is sorted on the basis of string length by overloading the inbuilt 
sort mechanism provided the Java.
5)Average running time of sorting is O(nlogn).
6)Each element from this Array is inserted into a Trie data structure.
7)Insertion,Searching and Deletion in Trie takes O(L) time where L is length of String.
8)The program then uses the Longestword() function which checks if the input
word is a concatenation of other words in file.
9)Before checking the program logically deletes the input word from Trie so that the
word does not match itself.
10)The program then outputs the 1st and 2nd longest word along with the total count of 
words in file which can be concatenation of different words in file.  
11)The Longestword funtion checks sequentially if a substring of the input word is 
present in the Trie, if yes then the function discards that substring and continues 
to check for the remaining part of word in the same manner.
12)The running time of this function can be estimated to 0(L^2) where L is the Lenght 
of  input String. 

