import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class GUI implements ActionListener {

    // Private Fields
    private final Color BLUETHEME = new Color(25, 230, 175);
    private JFrame frame;
    private Container frameContainer;
    private CardLayout cardLayout;
    private JMenuBar menuBar;
    private JMenu menu;

    private JMenuItem startMenuItem;
    private JMenuItem homeMenuItem;

    private StartJPanel startPanel;
    private HomeJPanel homePanel;

    // Default Constructor
    public GUI() {
        frame = new JFrame("Loanword Dictionary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setResizable(false);
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);

        frameContainer = frame.getContentPane();

        // Menus
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");

        startMenuItem = new JMenuItem("Start");
        startMenuItem.addActionListener(this);

        homeMenuItem = new JMenuItem("Home");
        homeMenuItem.addActionListener(this);

        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(startMenuItem);
        menu.add(homeMenuItem);

        // start panel
        startPanel = new StartJPanel();
        startPanel.setName("startPanel");
        startPanel.button.addActionListener(this);
        frameContainer.add(startPanel, "startPanel");

        // home panel
        homePanel = new HomeJPanel();
        homePanel.setName("homePanel");
        frameContainer.add(homePanel, "homePanel");

        frame.setVisible(true);
    }

    // ActionListener
    public void actionPerformed(ActionEvent event) {
        Object e = event.getSource();
        if(e == startMenuItem) {
            cardLayout.show(frameContainer, "startPanel");
        }
        if(e == homeMenuItem) {
            cardLayout.show(frameContainer, "homePanel");
        }
        if(e == startPanel.button) {
            cardLayout.show(frameContainer, "homePanel");
        } 
    }

    // StartJPanel Class
    class StartJPanel extends JPanel {
        JPanel topPanel;
        JLabel titleLabel;

        JPanel centerPanel;
        JLabel picLabel;

        JPanel bottomPanel;
        JButton button;

        StartJPanel() {
            // panel config
            this.setLayout(new BorderLayout());
            this.setBackground(BLUETHEME);

            // north panel
            topPanel = new JPanel();
            this.add(topPanel, BorderLayout.NORTH);

            titleLabel = new JLabel("Loanword Dictionary");
            titleLabel.setSize(200, 200);
            topPanel.add(titleLabel);

            // center panel
            centerPanel = new JPanel();
            this.add(centerPanel, BorderLayout.CENTER);

            picLabel = new JLabel(new ImageIcon("Hanzi.png"));
            this.add(picLabel, BorderLayout.CENTER);

            // bottom panel
            bottomPanel = new JPanel();
            this.add(bottomPanel, BorderLayout.SOUTH);

            button = new JButton("GO");
            button.setSize(50, 50);
            bottomPanel.add(button);
        }

    }

    // HomeJPanel Class
    class HomeJPanel extends JPanel {
        JPanel topPanel;
        JTextField tf;
        JButton goButton;

        JPanel centerPanel;
        JList queryList;

        HomeJPanel() {
            this.setLayout(new BorderLayout());
            this.setBackground(BLUETHEME);

            // top panel
            topPanel = new JPanel();
            topPanel.setLayout(new FlowLayout());
            topPanel.setBackground(BLUETHEME);
            this.add(topPanel, BorderLayout.NORTH);

            tf = new JTextField();
            tf.setEditable(true);
            tf.setPreferredSize(new Dimension(200, 50));
            topPanel.add(tf, BorderLayout.NORTH);

            goButton = new JButton("GO");
            goButton.setPreferredSize(new Dimension(100, 50));
            topPanel.add(goButton);

            // bottom panel
            centerPanel = new JPanel();
            centerPanel.setBackground(BLUETHEME);
            this.add(centerPanel, BorderLayout.CENTER);

            //queryList = new JList(

            JTextArea ta = new JTextArea();
            ta.setPreferredSize(new Dimension(600, 600));
            centerPanel.add(ta);

            String message = "";
            ArrayList<String> list = new ArrayList<String>();
            ReadFile rf = new ReadFile(new File("LoanwordEntries.csv"));
            list = rf.getTokens();
            for (String str : list) {
                message += str;
            }
            ta.setText(message);

        }
    }

}