import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI {
    private JFrame frame;

    public GUI() {
        frame = new JFrame("Loanword Dictionary");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
