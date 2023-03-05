import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> LoanwordEntries = new ArrayList<String>();

        GUI gui = new GUI();

        try {
            ReadFile rf = new ReadFile(new File("LoanwordEntries.csv"));
            LoanwordEntries = rf.getTokens();

            String longmessage = "";
            for (String s : LoanwordEntries) {
                longmessage += s;
            }

            WriteFile wf = new WriteFile("test.txt");
            wf.scribe(longmessage);

        } catch(Exception e) {
            e.printStackTrace();
        }

        /**
        try {
            WriteFile wf = new WriteFile("test.txt");
            wf.scribe("BLABLAALLBALALALLABALB");
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            ReadFile rf = new ReadFile(new File("LoanwordEntries.csv"));
            rf.print();
        } catch(Exception e) {
            e.printStackTrace();
        }
        */
    }
}