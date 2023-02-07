
//Name: Chelsea Lennox
//Date: February 6, 2023
//PUrpose: Write a text analyzer program where 
// it sorts the most frequent words and show it's frequency.
//-----------------------------------------------------------------
//Imports to read files, use Map, and other utilities
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry; 
import java.util.stream.Collectors;
public class main {

	public static void main(String[] args) throws IOException {
	
	////Read Files
	URL gutenburg = null;
	try {
		gutenburg = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm?courseID=164189&assignmentID=4456667&skipModuleItemSequence=true");
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}
	BufferedReader br = new BufferedReader(new InputStreamReader(gutenburg.openStream()));
		 
	//Create HashMap 
	Map<String, Integer> wordCounts = new HashMap<>();
	
	String inputLine; //variable to store inputLines

	while ((inputLine = br.readLine()) != null) {

	String[] words = inputLine.split("[\\s.;,?:!()\"]+");

	// iterate the words
		for (String word : words) {

			word = word.trim();

			if (word.length() > 0) {

			if (wordCounts.containsKey(word)) {
			wordCounts.put(word, wordCounts.get(word) + 1);
			} else {
			wordCounts.put(word, 1);
			}
		}
	}
}

	// Sort wordCounts by it's frequency using Map
	Map<String, Integer> sortedWordCounts = wordCounts.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

	// Prints each words and its frequency number
	System.out.printf("%-20s%15s\n", "Word", "Frequency");

	System.out.printf("%-20s%15s\n", "====", "=========");

	for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {

	System.out.printf("%-20s%10s\n", entry.getKey(), entry.getValue());
			}

			br.close();
			} 
}   
