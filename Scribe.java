import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Scribe {

    public static void main(String[] args) {
        ReadFile rf = new ReadFile(new File("LoanwordEntries.csv"));

        String fileName = "test2.txt";
        List<String> lines = rf.getTokens();

        //writeUnicodeJava7(fileName, lines);
        writeUnicodeJava8(fileName, lines);
        //writeUnicodeJava11(fileName, lines);
        //writeUnicodeClassic(fileName, lines);

        System.out.println("Done");
    }

    // in the old days
    public static void writeUnicodeClassic(String fileName, List<String> lines) {

        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)
        ) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeUnicodeJava7(String fileName, List<String> lines) {

        Path path = Paths.get(fileName);
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Java 8 - Files.newBufferedWriter(path) - default UTF-8
    public static void writeUnicodeJava8(String fileName, List<String> lines) {

        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Java 11 adds Charset to FileWriter
    public static void writeUnicodeJava11(String fileName, List<String> lines) {

        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(fw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}