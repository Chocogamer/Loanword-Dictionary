public class Word {
    private String hanzi;
    private String meaning;
    private String cantonese, cantoneseRom;
    private String mandarin, mandarinRom;
    private String minnan, minnanRom;
    private String vietnamese, vietnameseRom;
    private String japanese, japaneseRom;

    public Word() {
        hanzi = "";
        meaning = "";
        cantonese = "";
        cantoneseRom = "";
        mandarin = "";
        mandarinRom = "";
        minnan = "";
        minnanRom = "";
        vietnamese = "";
        vietnameseRom = "";
        japanese = "";
        japaneseRom = "";
    }

    public Word(String hanzi, String meaning, String cantonese, String cantoneseRom, String mandarin, String mandarinRom, String minnan, String minnanRom, String vietnamese, String vietnameseRom, String japanese, String japaneseRom) {
        this.hanzi = hanzi;
        this.meaning = meaning;
        this.cantonese = cantonese;
        this.cantoneseRom = cantoneseRom;
        this.mandarin = mandarin;
        this.mandarinRom = mandarinRom;
        this.minnan = minnan;
        this.minnanRom = minnanRom;
        this.vietnamese = vietnamese;
        this.vietnameseRom = vietnameseRom;
        this.japanese = japanese;
        this.japaneseRom = japaneseRom;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String m) {
        hanzi = m;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String m) {
        meaning = m;
    }

    public String getCantonese() {
        return cantonese;
    }

    public void setCantonese(String m) {
        cantonese = m;
    }

    public String getCantoneseRom() {
        return cantoneseRom;
    }

    public void setCantoneseRom(String m) {
        cantoneseRom = m;
    }

    public String getMandarin() {
        return mandarin;
    }

    public void setMandarin(String m) {
        mandarin = m;
    }

    public String getMandarinRom() {
        return mandarinRom;
    }

    public void setMandarinRom(String m) {
        mandarinRom = m;
    }

    public String getMinnan() {
        return minnan;
    }

    public void setMinnan(String m) {
        minnan = m;
    }

    public String getMinnanRom() {
        return minnanRom;
    }

    public void setMinnanRom(String m) {
        minnanRom = m;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String m) {
        vietnamese = m;
    }

    public String getVietnameseRom() {
        return vietnameseRom;
    }

    public void setVietnameseRom(String m) {
        vietnameseRom = m;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String m) {
        japanese = m;
    }

    public String getJapaneseRom() {
        return japaneseRom;
    }

    public void setJapaneseRom(String m) {
        japaneseRom = m;
    }

    public String toString() {
        return "Hanzi: " + hanzi + "\nMeaning: " + meaning + "\nCantonese: " + cantonese + "\nCantonese Romanization: " + cantoneseRom + "\nMandarin: " + mandarin + "\nMandarin Romanization: " + mandarinRom + "\nMinnan: " + minnan + "\nMinnan Romanization: " + minnanRom + "\nVietnamese: " + vietnamese + "\nVietnamese Romanization: " + vietnameseRom + "\nJapanese: " + japanese + "\nJapanese Romanization: " + japaneseRom;
    }

}
