package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player extends JFrame implements ActionListener {
	private JPanel welcomePanel,buttonPanel,userPanel,iconPanel,rulePanel;
	private JMenu chooseMenu;
	private JButton buttonButton;
	private JLabel txtLabel,userLabel,scoreLabel,iconLabel,searchrankLabel;
	private JTextField userp;
	private JTextArea ruleArea;
	String name = "";
	String searchname = "";
	String searchnamep;
	String username;
	String line;
	String number;
	String score;
	int i = 0;
	int index = 0;
	
	public static void main(String[] args) {
		Player player = new Player();
		player.setVisible(true);
	}
	public Player() {
		setTitle("อะไรเอ่ย แม่ฮ่องสอน");
		setBounds(440, 200, 400, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(SystemColor.control);
		
		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(null);
		welcomePanel = new JPanel();
		buttonPanel = new JPanel();
		userPanel = new JPanel();
		iconPanel = new JPanel();
		rulePanel = new JPanel();

		welcomePanel.setLayout(null);
		welcomePanel.setBackground(SystemColor.control);
		
		txtLabel = new JLabel();
		txtLabel.setFont(new Font("Haettenschweiler", Font.ITALIC, 32));
		txtLabel.setText("Welcome to GameQuiz!!!!");
		txtLabel.setBounds(75, 10, 300, 40);
		txtLabel.setBackground(SystemColor.control);
		txtLabel.setForeground(Color.black);
		welcomePanel.add(txtLabel);
		
		searchrankLabel = new JLabel();
		searchrankLabel.setFont(new Font("Angsana New", Font.BOLD, 37));
		searchrankLabel.setText("");
		searchrankLabel.setBounds(155, 10, 300, 40);
		searchrankLabel.setBackground(SystemColor.control);
		searchrankLabel.setForeground(Color.black);
		welcomePanel.add(searchrankLabel);
		
		iconPanel.setLayout(null);
		iconLabel = new JLabel("");
		iconLabel.setBounds(108,55,250,100);
		//JLabel imgLabelw8 = new JLabel(new ImageIcon("w8.png"));
		//contentPane.add(iconLabel);
		iconLabel.setIcon(new ImageIcon(Player.class.getResource("w8.png")));
		iconPanel.add(iconLabel);
		
		rulePanel.setLayout(null);
		rulePanel.setBackground(SystemColor.control);
		ruleArea = new JTextArea("");
		ruleArea.setFont(new Font("Angsana New", Font.BOLD, 17));
		ruleArea.setBounds( 0, 0, 0, 0);
		ruleArea.setLineWrap (true);
		ruleArea.setWrapStyleWord (true);
		ruleArea.setOpaque(true);
		ruleArea.setBackground(SystemColor.control);
		ruleArea.setForeground(Color.black);
		ruleArea.setEditable(false);
		ruleArea.add(rulePanel);
		
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(SystemColor.control);
		
		buttonButton = new JButton();
		buttonButton.setText("Play game");
		buttonButton.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		buttonButton.setBackground(SystemColor.black);
		buttonButton.setForeground(Color.white);
		buttonButton.setBounds(130, 165, 125, 30);
		buttonPanel.add(buttonButton);
		buttonButton.addActionListener(this);
		
		userPanel.setLayout(null);
		userPanel.setBackground(SystemColor.control);
		userLabel = new JLabel();
		userLabel.setText("");
		userLabel.setBounds(40, 80, 100, 30);
		userLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		userLabel.setBackground(SystemColor.control);
		userLabel.setForeground(Color.black);
		userPanel.add(userLabel); 

		userp = new JTextField(null);
		userp.setFont(new Font("Cordia New", Font.BOLD, 20));
		userp.setBounds(100, 80, 0, 0);
		userp.setBackground(SystemColor.control);
		userp.setForeground(Color.black);
		userPanel.add(userp);
		
		scoreLabel = new JLabel();
		scoreLabel.setText("");
		scoreLabel.setBounds(97, 100, 90, 30);
		scoreLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 15));
		scoreLabel.setBackground(SystemColor.control);
		scoreLabel.setForeground(Color.black);
		userPanel.add(scoreLabel);
	
		contentPane.add(txtLabel);
		contentPane.add(buttonButton);
		contentPane.add(userLabel);
		contentPane.add(userp);
		contentPane.add(scoreLabel);
		contentPane.add(iconLabel);
		contentPane.add(ruleArea);
		contentPane.add(searchrankLabel,BorderLayout.NORTH);
		
		createChooseMenu();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.black);
		setJMenuBar(menuBar);
		menuBar.add(chooseMenu);	
	}
	    private void createChooseMenu() {
	        JMenuItem item;
	        
	        chooseMenu = new JMenu("Menu");
	        chooseMenu.setForeground(Color.WHITE);
			
			chooseMenu.addSeparator();
		
	        item = new JMenuItem("Search Ranking");
	        item.addActionListener(this);
	        chooseMenu.add(item);
	        
			item = new JMenuItem ("Rank");
			item.addActionListener(this);
	       	chooseMenu.add(item);
	       	
	       	chooseMenu.addSeparator();
		
	        item = new JMenuItem ("Close");
	        item.addActionListener(this);
	        chooseMenu.add(item);
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			String buttonName = ((JButton)event.getSource()).getText();
			if (buttonName== "Play game") {
				rule();
			}
			else if (buttonName==  "NEXT") {
				playgame();
			}
			else if (buttonName== "Let's Go") {
				if (userp.getText() == null || userp.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "please enter your name");
				}else {
					name = userp.getText();
					quiz();
				}
			}
			else if (buttonName== "HOME") {
				home();
			}
			else if (buttonName == "SEARCH") {
				if (userp.getText() == null || userp.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "please enter your name");
				}else {
					searchnamep = userp.getText();
					searchrank();
				}
			}
		}
		else if (event.getSource() instanceof JMenuItem) {
			String menuName;
			menuName = event.getActionCommand();
			if (menuName.equals("Rank")) {
				rank();
			} 
			else if(menuName.equals("Search Ranking")) {
				search();
			} 
			else if (menuName.equals("Close")) {
				System.exit(0);
			} 
		}	
	}
	public void quiz() {
		
		Quiz quiz = new Quiz(name);
		quiz.setVisible(true);
		
		setVisible(false);
		
	}
	public void search(){
		//iconLabel = new JLabel(new ImageIcon("c.png"));
		iconLabel.setIcon(new ImageIcon(Player.class.getResource("c.png")));
		iconLabel.setBounds(0,0,400,270);
		iconLabel.setText("");
		buttonButton.setText("SEARCH");
		txtLabel.setText("Search Ranking!!!!");
		txtLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 32));
		txtLabel.setBounds(110, 10, 300, 40);
		userLabel.setText("User    :");
		userLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		userLabel.setBounds(40, 80, 100, 30);
		scoreLabel.setText("");
		scoreLabel.setBounds(97, 100, 90, 30);
		userp.setBounds(100, 80, 200, 30);
		ruleArea.setBounds( 0, 0, 0, 0);
		searchrankLabel.setText("");
	}
	public void searchrank() {
		try (BufferedReader readfile = new BufferedReader(new FileReader ("filesearchrank.txt"))){
			readfile.readLine();
			List <ranks> rankList = new ArrayList <ranks> ();
			while ((line = readfile.readLine()) != null) {
				String [] arr = line.split("\t");
				number = arr[0];
				username = arr[1];
				score = arr[2];
				rankList.add(new ranks(number,username,score));	
			}readfile.close();
			for (int i = 0 ; i < rankList.size();i++) {
				if (rankList.get(i).username.equals(searchnamep)) {
					index++;
					getContentPane().add(searchrankLabel);
					getContentPane().add(scoreLabel);
					buttonButton.setText("HOME");
					userp.setBounds(0, 0, 0, 0);
					txtLabel.setText("");
					//iconLabel = new JLabel(new ImageIcon("c.png"));
					//iconLabel.setIcon(new ImageIcon(Player.class.getResource("c.png")));
					iconLabel.setBounds(0,0,400,270);
					searchrankLabel.setText(rankList.get(i).username);
					scoreLabel.setText("      Score          :      " + rankList.get(i).score + "   point");
					scoreLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
					scoreLabel.setBounds(97, 105, 250, 17);
					userLabel.setText("      Rank            :      " + rankList.get(i).number);
					userLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
					userLabel.setBounds(97, 80, 250, 17);
				}
			} 
			if (index <= 0) {
				JOptionPane.showMessageDialog(null,"not found");
			}
 	}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void rank() {
		
		Rank rank = new Rank();
		rank.setVisible(true);
		
		setVisible(false);
	}
	public void playgame() {
		//iconLabel = new JLabel(new ImageIcon("c.png"));
		iconLabel.setIcon(new ImageIcon(Player.class.getResource("c.png")));
		iconLabel.setBounds(108,55,250,100);
		buttonButton.setText("Let's Go");
		txtLabel.setText("Please enter your name");
		txtLabel.setBounds(70, 10, 300, 40);
		txtLabel.setFont(new Font("Haettenschweiler", Font.BOLD, 32));
		userLabel.setText("User    :");
		userLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		userLabel.setBounds(40, 80, 100, 30);
		userp.setBounds(100, 80, 200, 30);
		scoreLabel.setText("");
		scoreLabel.setBounds(97, 100, 90, 30);
		ruleArea.setBounds( 0, 0, 0, 0);
		searchrankLabel.setText("");
	}
	public void home() {
		getContentPane().add(iconLabel);
		iconLabel.setIcon(new ImageIcon(Player.class.getResource("w8.png")));
		//iconLabel = new JLabel(new ImageIcon("w8.png"));
		iconLabel.setBounds(108,55,250,100);
		buttonButton.setText("Play game");
		txtLabel.setBounds(75, 10, 300, 40);
		txtLabel.setFont(new Font("Haettenschweiler", Font.ITALIC, 32));
		userp.setBounds(0, 0, 0, 0);
		txtLabel.setText("Welcome to GameQuiz!!!!");
		scoreLabel.setText("");
		scoreLabel.setBounds(97, 100, 90, 30);
		scoreLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
		userLabel.setText("");
		ruleArea.setBounds( 0, 0, 0, 0);
		searchrankLabel.setText("");
	}
	public void rule() {
		//iconLabel = new JLabel(new ImageIcon("c.png"));
		iconLabel.setIcon(new ImageIcon(Player.class.getResource("c.png")));
		buttonButton.setText("NEXT");
		txtLabel.setText("RULE");
		txtLabel.setBounds(170, 10, 300, 40);
		txtLabel.setFont(new Font("Haettenschweiler", Font.BOLD, 32));
		userLabel.setText("");
		userLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		userLabel.setBounds(40, 80, 100, 30);
		userp.setBounds(100, 80, 200, 30);
		scoreLabel.setText("");
		scoreLabel.setBounds(97, 100, 90, 30);
		userp.setBounds(0, 0, 0, 0);
		ruleArea.setText("เกมถามตอบโดยจะมีคำถามเกี่ยวข้องกับจังหวัดแม่ฮ่องสอนทั้งหมด 15 ข้อ ข้อละ 4 ตัวเลือก ผู้เล่นจะต้องตอบคำถามให้ถูกต้องในเวลา ที่กำหนดให้ในแต่ละข้อและเมื่อ"
				+ "เลือกคำตอบแล้วจะไม่สามารถแก้ไขคำตอบได้");
		ruleArea.setBounds( 45, 60, 310, 100);
		searchrankLabel.setText("");
	}
	static class ranks {
		String number;
		String username;
		String score;
		
		public ranks(String number,String username,String score) {
			this.number = number;
			this.username = username;
			this.score = score;
		}
	}
}
