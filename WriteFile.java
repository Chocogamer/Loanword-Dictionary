import java.io.FileWriter;
import java.io.BufferedWriter;

public class WriteFile {
    private String file;
    private FileWriter writer;
    private BufferedWriter bufferedWriter;

    public WriteFile(String f) {
        file = f;

        try {
            writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void scribe(String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}