
public class Word {
	
	private String hanzi;
	private String language;
	private String nativeWord;
	private String romanization;
	private String english;

	public Word(String hanzi, String language, String nativeWord, String romanization, String english) {
		this.hanzi = hanzi;
		this.language = language;
		this.nativeWord = nativeWord;
		this.romanization = romanization;
		this.english = english;
	}
	
	public void setHanzi(String newHanzi) {
		hanzi = newHanzi;
	}
	
	public void setLanguage(String newLanguage) {
		language = newLanguage;
	}
	
	public void setNativeWord(String newNativeWord) {
		nativeWord = newNativeWord;
	}
	
	public void setRomanization(String newRomanization) {
		romanization = newRomanization;
	}
	
	public void setEnglish(String newEnglish) {
		english = newEnglish;
	}
	
	public String getHanzi() {
		return hanzi;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getNativeWord() {
		return nativeWord;
	}
	
	public String getRomanization() {
		return romanization;
	}
	
	public String getEnglish() {
		return english;
	}
	
	public String toString() {
		return "Hanzi: " + hanzi + ", Language: " + language + ", Native Word: " + nativeWord + ", Romanization: " + romanization + ", English: " + english;
	}

}
