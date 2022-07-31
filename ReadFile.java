import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {

	public ArrayList<Word> readWords(String fileName) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		List<String> lines = br.lines().collect(Collectors.toList());
		ArrayList<Word> wordList = new ArrayList<Word>();
		
		for(int i = 0; i < lines.size(); i++) {
			String[] tokens = lines.get(i).split(":");
			String hanzi = tokens[0];
			String english = tokens[2];
			String[] words = tokens[1].split(";");
			for(int a = 0; a < words.length; a++) {
				String[] attributes = words[a].split(",");
				String language = attributes[0];
				String nativeWord = attributes[1];
				String romanization = attributes[2];
				wordList.add(new Word(hanzi, language, nativeWord, romanization, english));
			}
		}
		
		br.close();
		
		for(Word w:wordList) {
			System.out.println(w);
		}
		
		return wordList;
		
	}

}
