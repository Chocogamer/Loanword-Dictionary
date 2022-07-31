import java.util.ArrayList;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		GUI gui = new GUI(500, 500);
		gui.setUpHomePage();
		gui.setUpButtonListeners();
		
		ReadFile rf = new ReadFile();
		try {
			ArrayList<Word> wordList = rf.readWords("src\\words.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
