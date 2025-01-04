package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.border.BevelBorder;

import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rank extends JFrame implements ActionListener {
	int index=0;
	String username;
	int score;
	String line;
	private JPanel rankPanel,buttonPanel,tablePanel;
	private JButton buttonButton;
	private JLabel rankLabel;
	private JTable table;
	public Rank() {
		rank();
	}
	static class players {
		String username;
		int score;
		
		public players(String username,int score) {
			this.username = username;
			this.score = score;
		}
	}
	private void rank()  {
		setTitle("อะไรเอ่ย แม่ฮ่องสอน");
		setBounds(440, 200, 400, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(SystemColor.control);
		
		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(null);
		rankPanel = new JPanel();
		buttonPanel = new JPanel();
		tablePanel = new JPanel();
		
		rankPanel.setLayout(null);
		rankPanel.setBackground(SystemColor.control);
		
		rankLabel = new JLabel();
		rankLabel.setText("");
		rankLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
		rankLabel.setBounds(160, 10, 300, 40);
		rankLabel.setBackground(SystemColor.control);
		rankLabel.setForeground(Color.black);
		rankPanel.add(rankLabel);
		
		buttonPanel.setLayout(null);
		buttonPanel.setBackground(SystemColor.control);
		
		buttonButton = new JButton();
		buttonButton.setText("");
		buttonButton.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		buttonButton.setBackground(SystemColor.black);
		buttonButton.setForeground(Color.white);
		buttonButton.setBounds(130, 186, 125, 30);
		buttonPanel.add(buttonButton);
		buttonButton.addActionListener(this);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setEnabled(false);
		table.setBackground(SystemColor.control);
		table.setForeground(Color.black);
		table.setBounds(70, 55, 250, 120);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setFont(new Font("Cordia New", Font.BOLD, 18));
		table.setRowHeight (20);
		

		File delfilerank = new File("filesearchrank.txt");
		if (delfilerank.delete()) {
			System.out.print("");
		}
		
		try (BufferedReader readuserscore = new BufferedReader(new FileReader ("filenamescorep.txt"))){
			readuserscore.readLine();
			List <players> namescoreList = new ArrayList <players> ();
			while ((line = readuserscore.readLine()) != null) {
				String [] arr = line.split("\t");
				username = arr[0];
				score = Integer.parseInt(arr[1]);
				namescoreList.add(new players(username,score));	
			}readuserscore.close();
			Collections.sort(namescoreList, new Comparator<players>() {
				@Override
				public int compare(players o1, players o2) {
					return Integer.valueOf(o2.score).compareTo(o1.score);
				}
			});
			for (int i = 0 ; i < namescoreList.size();i++) {
				System.out.println((i+1) + " " + namescoreList.get(i).username + " " + namescoreList.get(i).score);
				FileWriter file_rank = new FileWriter("filesearchrank.txt",true);
				file_rank.write("Rank"+"\t"+"Name"+"\t"+"Score");
				file_rank.write(System.getProperty("line.separator"));
				file_rank.write(String.valueOf(i+1));
				file_rank.write("\t");
				file_rank.write(namescoreList.get(i).username);
				file_rank.write("\t");
				file_rank.write(String.valueOf(namescoreList.get(i).score));
				file_rank.write(System.getProperty("line.separator"));
				file_rank.close();
			}
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{"   Rank", "           User", "    Score"},
						{"      1","    " + namescoreList.get(index).username, "      " + namescoreList.get(index).score},
						{"      2","    " + namescoreList.get(index + 1).username, "      " + namescoreList.get(index+1).score},
						{"      3","    " + namescoreList.get(index + 2).username, "      " + namescoreList.get(index+2).score},
						{"      4","    " + namescoreList.get(index + 3).username, "      " + namescoreList.get(index+3).score},
						{"      5","    " + namescoreList.get(index + 4).username, "      " + namescoreList.get(index+4).score},

					},
					new String[] {
							 "RANK","USER", "SCORE"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(0).setMinWidth(20);
				table.getColumnModel().getColumn(0).setMaxWidth(60);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setMinWidth(20);
				table.getColumnModel().getColumn(1).setMaxWidth(150);
				table.getColumnModel().getColumn(2).setPreferredWidth(70);
				table.getColumnModel().getColumn(2).setMaxWidth(70);
				tablePanel.add(table);
			
			getContentPane().add(table);
			getContentPane().add(buttonButton);
			getContentPane().add(rankLabel);
			buttonButton.setText("HOME");
			rankLabel.setText("        RANK!!");
			rankLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 32));
			rankLabel.setBounds(110, 10, 300, 40);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			String buttonName = ((JButton)event.getSource()).getText();
			if  (buttonName== "HOME") {
				player();
			}
		}
	}
	public void  player() {
		Player player = new Player();
		player.setVisible(true);
		
		setVisible(false);
	}
	
}