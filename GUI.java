import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class GUI {
	
	private int width;
	private int height;
	private Color background;
	
	private JFrame homeFrame;
	private JLabel homeLabel;
	private JButton homeButton;
	
	private JFrame mainFrame;
	private JTextField mainTF;
	private JButton mainButton;
	private JTextArea mainTA;

	public GUI(int width, int height) {
		this.width = width;
		this.height = height;
		background = new Color(20, 200, 200);
		
		homeFrame = new JFrame();
		homeLabel = new JLabel("Loanword Dictionary", SwingConstants.CENTER);
		homeButton = new JButton("Start");
		
		mainFrame = new JFrame();
		mainTF = new JTextField(10);
		mainButton = new JButton("button");
		mainTA = new JTextArea();
	}
	
	public void setUpHomePage() {
		Container homeCP = homeFrame.getContentPane();
		homeCP.setLayout(null);
		homeFrame.setSize(width, height);
		homeFrame.setTitle("Home Page");
		homeCP.add(homeLabel);
		homeLabel.setBounds(100, 50, 300, 100);
		homeCP.add(homeButton);
		homeButton.setBounds(150, 300, 200, 100);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeCP.setBackground(background);
		homeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		homeFrame.setResizable(false);
		
		Border border = BorderFactory.createLineBorder(Color.black);
		homeLabel.setBorder(border);
		
		homeFrame.setVisible(true);
	}
	
	public void setUpMainPage() {
		Container mainCP = mainFrame.getContentPane();
		mainCP.setLayout(null);
		mainFrame.setSize(width, height);
		mainFrame.setTitle("Main Page");
		JScrollPane sp = new JScrollPane(mainTA);
		mainCP.add(mainTF);
		mainTF.setBounds(150, 100, 200, 100);
		mainCP.add(mainButton);
	    mainButton.setBounds(150, 200, 200, 100);
	    mainCP.add(sp);
	    sp.setBounds(150, 300, 200, 100);
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainCP.setBackground(background);
	    mainFrame.setResizable(false);	    
	    try {
      	 
        	String file = "src\\text.txt";
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] lines = br.lines().toArray(String[]::new);
            for(int i = 0; i < lines.length; i++) {
            	mainTA.append(lines[i] + "\n");
            }
            br.close();
            
          } catch(Exception e) {
        	  
        	e.printStackTrace();
            
          }
	    
	    mainFrame.setVisible(true);
	}
	
	public void setUpButtonListeners() {
		
	    ActionListener buttonListener = new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent ae) {
	        Object o = ae.getSource();
	        if(o == mainButton) {
	          String s = mainTF.getText();
	          mainTF.setText("");

	          try {
	        	  
	        	String file = "src\\text.txt";
	            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
	            bw.write(s);
	            bw.newLine();
	            bw.close();

	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String[] lines = br.lines().toArray(String[]::new);
	            mainTA.append(lines[lines.length-1] + "\n");
	            br.close();
	            
	          } catch(Exception e) {
	        	  
	        	e.printStackTrace();
	            
	          }
	        }
	        
	        if(o == homeButton) {
	        	homeFrame.setVisible(false);
	        	setUpMainPage();
	        }
	        
	      }
	    };

	    homeButton.addActionListener(buttonListener);
	    mainButton.addActionListener(buttonListener);
	    
	  }

}
