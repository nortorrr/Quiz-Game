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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.io.FileWriter;

public class Quiz extends JFrame implements ActionListener {
	String[] questions = 	{
			"            “หมอกสามฤดู กองมูเสียดฟ้า ป่าเขียวขจี ผู้คนดี ประเพณีงาม ลือนามถิ่นบัวตอง” เป็นคำขวัญประจำจังหวัดใด ?",
			"                    แม่ฮ่องสอนอยู่ภาคใดในประเทศไทย ?",
			"                  แม่ฮ่องสอนมีอาณาเขตติดกับประเทศใด ?",
			"                      แม่ฮ่องสอน ไม่ได้ติดกับจังหวัดใด ?",
			"                   ประเพณีใดมีเฉพาะจังหวัดแม่ฮ่องสอน ?",
			"                 ข้อใดไม่ใช่ของดีประจำจังหวัดแม่ฮ่องสอน ?",
			"              ดอกไม้ประจำจังหวัดแม่ฮ่องสอน คือดอกอะไร ?",
			"                 “นอนบ้านดิน ถิ่นชิมชา ชุมชนจีนยูนนาน” จากที่กล่าวมาข้างต้นตรงกับสถานที่ใดในจังหวัดแม่ฮ่องสอน ?",
			"      สถานที่ใดได้รับสมญาว่าสวิตเซอร์แลนด์แดนสามหมอก ?",
			"            สะพานซูตองเป้ เป็นสถานที่เที่ยวยอดนิยม คำว่า      “ซูตองเป้” (Su-Tong-Pe) เป็นภาษาไทยใหญ่ที่แปลว่า อะไร ?",
			"           สถานที่ทองเที่ยวใดไม่ได้อยู่ใน จังหวัดแม่ฮ่องสอน ?",
			"                   “กองแลน” มีอีกชื่อหนึ่งเรียกว่าอะไร ?",
			" จากรูป คือสถานที่ใดในจังหวัดแม่ฮ่องสอน ?",
			" จากรูป คือสถานที่ใดในจังหวัดแม่ฮ่องสอน ?",
			"ทุ่งดอกบัวตอง ดอกไม้จะบานเต็มเขาที่สุดช่วงใด ?"
		};
	String[][] choices = 	{
			{"แม่ฮ่องสอน","เชียงราย","เชียงใหม่","เชียงคาน"},
			{"ภาคอีสาน","ภาคเหนือ","ภาคกลาง","ภาคใต้"},
			{"ประเทศกัมพูชา","ประเทศมาเลเซีย","สาธารณรัฐประชาธิปไตยประชาชนลาว","สาธารณรัฐแห่งสหภาพเมียนมา"},
			{"ไม่มีข้อใดถูก","จังหวัดเชียงใหม่","จังหวัดเชียงราย","จังหวัดตาก"},
			{"ประเพณีอุ้มพระดำน้ำ","ประเพณีฟ้อนผีปู่ย่า","ประเพณีลอยกระทงสวรรค์","ประเพณีปอยส่างลอง"},
			{"ถั่วแปยี","ชา","ขนมหม้อแกง","ผ้าทอกะเหรี่ยง"},
			{"ดอกพวงแสด","ดอกบัวตอง","ดอกทองกวาว","ดอกธรรมรักษา"},
			{"บ้านรักไทย","บ้านห้วยห้อม","ปางอุ๋ง","โป่งน้ำร้อนไทรงาม"},
			{"ปางอุ๋ง","บ้านห้วยห้อม ","จุดชมวิวหยุ่นไหล","โป่งน้ำร้อนไทรงาม"},
			{"ศรัทธา","คำอธิษฐาน","สะพานไม้แห่งศรัทธา","อธิษฐานสำเร็จ"},
			{"น้ำตกแม่สุรินทร์","จุดชมวิวหยุนไหล","น้ำตกแม่ยะ อุทยานแห่งชาติดอยอินทนนท์","ดอยกิ่วลม"},
			{"แพะเมืองผี","ถ้ำน้ำลอด","จุดชมวิวหยุ่นไหล","ปายแคนยอน"},
			{"ปางอุ๋ง","บ้านห้วยห้อม ","สะพานซูตองเป้","โป่งน้ำร้อนไทรงาม"},
			{"วัดพระธาตุแม่เย็น","วัดพระธาตุดอยกองมู","วัดศรีดอนชัย","วัดจองคำ วัดจองกลาง"},
			{"ช่วงปลายปี","ช่วงต้นปี","ช่วงกลางปี","ช่วงกลาง-ปลายปี"}
		};
	char[] answers = 		{
			'A',
			'B',
			'D',
			'C',
			'C',
			'C',
			'B',
			'A',
			'A',
			'B',
			'C',
			'D',
			'A',
			'B',
			'A'
		};
	int totalq = questions.length;
	char answer;
	int index ;
	int correct = 0;
	int seconds = 15;
	private JLabel timeLabel,secondLabel,txtLabel,freeLabel,picLabel,scoreLabel,freeLabel2;
	private JTextArea quizArea;
	private JButton aButton,bButton,cButton,dButton,closeButton;
	private JPanel answerPanel,closePanel,scorePanel,quizPanel,timePanel;
	String playername;
 	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondLabel.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
	});
	public Quiz(String name) {
		this.playername = name;
		quiz();
	}
	private void quiz() {
		setTitle("อะไรเอ่ย แม่ฮ่องสอน");
		setBounds(440, 200, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(SystemColor.control);
		
		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(1,5));
		quizPanel = new JPanel();
		answerPanel = new JPanel();
		timePanel = new JPanel();
		closePanel = new JPanel();
		scorePanel = new JPanel();
		
		quizPanel.setLayout(null);
		quizPanel.setBackground(SystemColor.control);
		
		txtLabel = new JLabel();
		txtLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 25));
		txtLabel.setBounds( 160, 0, 100, 30);
		txtLabel.setBackground(SystemColor.control);
		txtLabel.setForeground(Color.black);
		quizPanel.add(txtLabel);
		
		quizArea = new JTextArea("");
		quizArea.setFont(new Font("Angsana New", Font.BOLD, 20));
		quizArea.setBounds( 30, 35, 345, 45);
		quizArea.setLineWrap (true);
		quizArea.setWrapStyleWord (true);
		quizArea.setOpaque(true);
		quizArea.setEditable(false);
		quizArea.setBackground(SystemColor.control);
		quizArea.setSelectedTextColor(Color.black);
		quizPanel.add(quizArea);

		timePanel.setLayout(null);
		timePanel.setBackground(SystemColor.control);
	
		timeLabel = new JLabel();
		timeLabel.setText("Time : ");
		timeLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		timeLabel.setBackground(SystemColor.control);
		timeLabel.setForeground(Color.black);
		timeLabel.setBounds( 169, 220, 80, 30);
		timePanel.add(timeLabel);
		
		secondLabel = new JLabel();
		secondLabel.setOpaque(true);
		secondLabel.setText(String.valueOf(seconds));
		secondLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		secondLabel.setBackground(SystemColor.control);
		secondLabel.setForeground(Color.black);
		secondLabel.setBounds( 215, 220, 50, 30);
		timePanel.add(secondLabel);
		
		answerPanel.setLayout(null);
		answerPanel.setBackground(SystemColor.control);
		
		aButton = new JButton();
		aButton.setFont(new Font("Angsana New", Font.BOLD, 15));
		aButton.setBackground(SystemColor.controlHighlight);
		aButton.setForeground(Color.black);
		aButton.addActionListener(this);
		aButton.setBounds(75, 90, 250, 30);
		answerPanel.add(aButton);
		
		bButton = new JButton();
		bButton.setFont(new Font("Angsana New", Font.BOLD, 15));
		bButton.setBackground(SystemColor.controlHighlight);
		bButton.setForeground(Color.black);
		bButton.addActionListener(this);
		bButton.setBounds(75, 120, 250, 30);
		answerPanel.add(bButton);
		
		cButton = new JButton();
		cButton.setFont(new Font("Angsana New", Font.BOLD, 15));
		cButton.setBackground(SystemColor.controlHighlight);
		cButton.setForeground(Color.black);
		cButton.addActionListener(this);
		cButton.setBounds(75, 150, 250, 30);
		answerPanel.add(cButton);
		
		dButton = new JButton();
		dButton.setFont(new Font("Angsana New", Font.BOLD, 15));
		dButton.setBackground(SystemColor.controlHighlight);
		dButton.setForeground(Color.black);
		dButton.addActionListener(this);
		dButton.setBounds(75, 180, 250, 30);
		answerPanel.add(dButton);
		
		picLabel = new JLabel("");
		picLabel.setBackground(SystemColor.control);
		picLabel.setBounds(0,0,0,0);
		answerPanel.add(picLabel);
		
		closePanel.setLayout(null);
		closePanel.setBackground(SystemColor.control);
		
		closeButton = new JButton("CLOSE");
		closeButton.setBounds(145, 220, 110, 30);
		closeButton.setFont(new Font("Angsana New", Font.BOLD, 23));
		closeButton.setBackground(SystemColor.black);
		closeButton.setForeground(Color.WHITE);
		closeButton.addActionListener(this);
		closePanel.add(closeButton);
		
		scorePanel.setLayout(null);
		scorePanel.setBackground(SystemColor.control);
		
		scoreLabel = new JLabel("");
		scoreLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		scoreLabel.setForeground(Color.black);
		scoreLabel.setBackground(SystemColor.control);
		scoreLabel.setBounds(30, 120, 0, 0);
		scorePanel.add(scoreLabel);
		
		freeLabel = new JLabel("");
		freeLabel.setBackground(SystemColor.control);
		freeLabel.setForeground(SystemColor.black);
		freeLabel.setBounds(130, 120, 80, 50);
		freeLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		closePanel.add(freeLabel);
		
		freeLabel2 = new JLabel("");
		freeLabel2.setBackground(SystemColor.control);
		freeLabel2.setForeground(SystemColor.black);
		freeLabel2.setBounds(0, 0, 0, 0);
		freeLabel2.setFont(new Font("Angsana New", Font.BOLD, 29));
		closePanel.add(freeLabel2);
		
		contentPane.add(quizArea);
		contentPane.add(txtLabel);
		contentPane.add(timeLabel);
		contentPane.add(secondLabel);
		contentPane.add(answerPanel);
		
		nextQuestion();	
	}
	public void nextQuestion() {
		if(index>= totalq) {
			results();
		} 
		else if (index <= 11){
			freeLabel.setText("User  :  " );
			freeLabel.setBounds(100, 85, 200, 40);
			quizArea.setText(questions[index]);
			txtLabel.setText("Question "+ (index+1));
			aButton.setText("A : " + choices[index][0]);
			bButton.setText("B : " + choices[index][1]);
			cButton.setText("C : " + choices[index][2]);
			dButton.setText("D : " + choices[index][3]);
		}
		else if (index==12) {
			aButton.setBounds(43, 153, 150, 30);
			bButton.setBounds(192, 153, 150, 30);
			cButton.setBounds(43, 183, 150, 30);
			dButton.setBounds(192, 183, 150, 30);
			picLabel.setBounds( 120, 22, 238, 80);
			txtLabel.setBounds( 28, 107, 100, 30);
			quizArea.setBounds( 123, 113, 300, 30);
			txtLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 23));
			txtLabel.setText("Question "+ (index+1)+" : ");
			quizArea.setText(questions[index]);
			aButton.setText("A : " + choices[index][0]);
			bButton.setText("B : " + choices[index][1]);
			cButton.setText("C : " + choices[index][2]);
			dButton.setText("D : " + choices[index][3]);
			picLabel.setIcon(new ImageIcon(Quiz.class.getResource("13.jpg")));
			//picLabel.setIcon(new ImageIcon("13.jpg"));
		}else if (index==13) {
			aButton.setBounds(43, 153, 150, 30);
			bButton.setBounds(192, 153, 150, 30);
			cButton.setBounds(43, 183, 150, 30);
			dButton.setBounds(192, 183, 150, 30);
			picLabel.setBounds( 120, 22, 238, 80);
			txtLabel.setBounds(28, 107, 100, 30);
			quizArea.setBounds( 123, 113, 300, 30);
			txtLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 23));
			txtLabel.setText("Question "+ (index+1)+" : ");
			quizArea.setText(questions[index]);
			aButton.setText("A : " + choices[index][0]);
			bButton.setText("B : " + choices[index][1]);
			cButton.setText("C : " + choices[index][2]);
			dButton.setText("D : " + choices[index][3]);
			//picLabel.setIcon(new ImageIcon("14.jpg"));
			picLabel.setIcon(new ImageIcon(Quiz.class.getResource("14.jpg")));
			//picLabel = new JLabel(new ImageIcon("14.png"));
		}else if (index==14) {
			aButton.setBounds(43, 153, 150, 30);
			bButton.setBounds(192, 153, 150, 30);
			cButton.setBounds(43, 183, 150, 30);
			dButton.setBounds(192, 183, 150, 30);
			picLabel.setBounds( 130, 22, 238, 80);
			txtLabel.setBounds(19, 107, 100, 30);
			quizArea.setBounds( 116, 113, 300, 30);
			txtLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 23));
			txtLabel.setText("Question "+ (index+1)+ " : ");
			quizArea.setText(questions[index]);
			aButton.setText("A : " + choices[index][0]);
			bButton.setText("B : " + choices[index][1]);
			cButton.setText("C : " + choices[index][2]);
			dButton.setText("D : " + choices[index][3]);
			picLabel.setIcon(new ImageIcon(Quiz.class.getResource("15.png")));
			//picLabel = new JLabel(new ImageIcon("15.png"));
			//answerPanel.add(picLabel);
			//picLabel.setIcon(new ImageIcon("15.png"));
		} timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			aButton.setEnabled(false);
			bButton.setEnabled(false);
			cButton.setEnabled(false);
			dButton.setEnabled(false);
	
			if(e.getSource()==aButton) {
				answer= 'A';
				if(answer == answers[index]) {
					correct++;
				}
			}
			if(e.getSource()==bButton) {
				answer= 'B';
				if(answer == answers[index]) {
					correct++;
				}
			}
			if(e.getSource()==cButton) {
				answer= 'C';
				if(answer == answers[index]) {
					correct++;
				}
			}
			if(e.getSource()==dButton) {
				answer= 'D';
				if(answer == answers[index]) {
					correct++;
				}
			}displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		aButton.setEnabled(false);
		bButton.setEnabled(false);
		cButton.setEnabled(false);
		dButton.setEnabled(false);
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index <= 5 || index ==7 || index >= 9){
					 seconds=10;
				}else if (index == 6 || index == 8) {
					 seconds = 15;
				}
				answer = ' ';
				secondLabel.setText(String.valueOf(seconds));
				aButton.setEnabled(true);
				bButton.setEnabled(true);
				cButton.setEnabled(true);
				dButton.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		writescore(playername,correct);
		aButton.setEnabled(false);
		bButton.setEnabled(false);
		cButton.setEnabled(false);
		dButton.setEnabled(false);
		
		txtLabel.setText("CONGRATULATION");
		txtLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 32));
		txtLabel.setBounds(108, 20, 250, 30);
		timeLabel.setText("");
		
		freeLabel.setText("User             :   " );
		freeLabel.setBounds(100, 85, 200, 40);
		freeLabel2.setText(playername);
		freeLabel2.setBounds(190, 82, 250, 40);
		scoreLabel.setText("My Score    :    " +correct);
		scoreLabel.setBounds(100, 105, 250, 50);
		
		getContentPane().remove(quizArea);
		getContentPane().remove(answerPanel);
		getContentPane().remove(secondLabel);
		getContentPane().remove(picLabel);
		getContentPane().add(scoreLabel);
		getContentPane().add(closePanel);
		
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		rank();
	} 
	public void writescore(String pname,int pscore) {
		try {
			FileWriter file_namescore = new FileWriter("filenamescorep.txt",true);
			file_namescore.write(pname);
			file_namescore.write("\t");
			file_namescore.write(String.valueOf(pscore));
			file_namescore.write(System.getProperty("line.separator"));
			file_namescore.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void rank() {
		Rank rank = new Rank();
		rank.setVisible(false);
	}

}
