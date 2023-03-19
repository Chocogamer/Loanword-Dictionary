import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI implements ActionListener, ListSelectionListener {

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
    private WordPanel wordPanel;

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

        homePanel.queryList.addListSelectionListener(this);

        // word panel
        wordPanel = new WordPanel();
        wordPanel.setName("wordPanel");
        frameContainer.add(wordPanel, "wordPanel");

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

    // ListSelectionListener
    public void valueChanged(ListSelectionEvent event) {
        Object e = event.getSource();
        System.out.println(homePanel.queryList.getSelectedValue());
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

            // center panel
            centerPanel = new JPanel();
            centerPanel.setBackground(BLUETHEME);
            this.add(centerPanel, BorderLayout.CENTER);

            // organized List of tokens
            ReadFile rf = new ReadFile("LoanwordEntries.csv");
            ArrayList<String[]> organizedTokens = new ArrayList<String[]>();
            organizedTokens = rf.getTokens();

            // words
            Word[] words = new Word[organizedTokens.size()-1];

            // put into words
            for(int i = 0; i < words.length; i++) {
                String[] ot = organizedTokens.get(i+1);
                words[i] = new Word(ot[0], ot[1], ot[2], ot[3], ot[4], ot[5], ot[6], ot[7], ot[8], ot[9], ot[10], ot[11]);
            }

            // JList config
            String[] hanziStrings = new String[words.length];
            for(int i = 0; i < hanziStrings.length; i++) {
                hanziStrings[i] = words[i].getHanzi();
            }
            
            queryList = new JList<String>(hanziStrings);
            queryList.setPreferredSize(new Dimension(600, 600));

            centerPanel.add(queryList);

        }
    }

    class WordPanel extends JPanel {
        private JPanel topPanel;
        private JTextField hanziField;
        private JTextField meaningField;

        private JPanel centerPanel;
        private JTextArea descriptionArea;

        private JPanel bottomPanel;

        public WordPanel() {
            this.setLayout(new BorderLayout());

            // topPanel
            topPanel = new JPanel();
            topPanel.setLayout(new FlowLayout());

            hanziField = new JTextField();

            meaningField = new JTextField();

            topPanel.add(hanziField);
            topPanel.add(meaningField);

            // centerPanel
            centerPanel = new JPanel();

            descriptionArea = new JTextArea();

            centerPanel.add(descriptionArea);

            // bottomPanel
            bottomPanel = new JPanel();
            bottomPanel.setLayout(new FlowLayout());

            this.add(topPanel, BorderLayout.NORTH);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(bottomPanel, BorderLayout.SOUTH);
        }
    }

}