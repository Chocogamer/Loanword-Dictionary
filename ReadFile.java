import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private Scanner sc;
    private File file;

    public ReadFile(File f) {
        file = f;
        try {
            sc = new Scanner(file, "UTF-8");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void print() {
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            System.out.print(sc.next());
        }

        try {
            sc = new Scanner(file, "UTF-8");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTokens() {
        ArrayList<String> list = new ArrayList<String>();

        sc.useDelimiter(",");
        while(sc.hasNext()) {
            list.add(sc.next());
            System.out.println("PRINTING");
        }

        try {
            sc = new Scanner(file, "UTF-8");
        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}