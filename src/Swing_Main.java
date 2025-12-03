import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Swing_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(560,400);
		frame.setTitle("Flashcards");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setLayout(null);
		
		String[] questions = {
				"What is the full form of Oop?",
				"What is the capital of Bangladesh?",
				"What is the force that keeps us on the ground?",
				"What is the chemical symbol of water?",
				"Which planet is the red planet?",
				"How many colors are there in a rainbow?",
				"What has hands but can’t clap?",
				"What is the tallest mountain in the world?",
				"Who painted the Mona Lisa?",
				"What animal is known as the king of the jungle?",
				"Which country is famous for the pyramids?",
				"Which country invented ice cream?",
				"Why did the math book look sad?",
				"Whic metal can float on water?",
				"Which is the hardest natural substance on earth?"
				
		};
		
		String[] answers = {
			    "Object Oriented Programming",
			    "Dhaka",
			    "Gravity",
			    "H2O",
			    "Mars",
			    "7",
			    "Clock",
			    "Mount Everest",
			    "Leonardo da Vinci",
			    "Lion",
			    "Egypt",
			    "China",
			    "Because it had too many problems",
			    "Lithium",
			    "Diamond"
			};
	
		final int[] index= {0};
		final boolean[] showingAnswer= {false}; 

		JLabel progress = new JLabel("Card 1 of " + questions.length);
        progress.setBounds(215, 30, 200, 20);
        progress.setFont(new Font("Arial", Font.BOLD, 16));
        progress.setForeground(Color.BLACK);
        frame.add(progress);
		
		JTextPane qstn = new JTextPane();
        qstn.setBounds(120, 70, 305, 150);
        qstn.setBackground(new Color(250, 190, 220));
        qstn.setFont(new Font("Arial", Font.BOLD, 24));
        qstn.setEditable(false);

        StyledDocument doc = qstn.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        qstn.setText(questions[index[0]]);
        frame.add(qstn);
        
        JButton Btn1 = new JButton("←");
        Btn1.setBounds(90, 270, 100, 40);
        Btn1.setBackground(new Color(180, 160, 255));
        Btn1.setForeground(Color.BLACK);
        Btn1.setFont(new Font("Arial", Font.BOLD, 36));
        frame.add(Btn1);
        
        JButton Btn2 = new JButton("Show Answer");
        Btn2.setBounds(195, 270, 150, 40);
        Btn2.setBackground(new Color(0, 168, 107));
        Btn2.setForeground(Color.WHITE);
        frame.add(Btn2);
        
        JButton Btn3 = new JButton("→");
        Btn3.setBounds(350, 270, 100, 40);
        Btn3.setBackground(new Color(180, 160, 255));
        Btn3.setForeground(Color.BLACK);
        Btn3.setFont(new Font("Arial", Font.BOLD, 36));
        frame.add(Btn3);
        
        JButton Btn4 = new JButton("⟳");
        Btn4.setBounds(223, 320, 100, 38);
        Btn4.setBackground(new Color(255, 100, 100));
        Btn4.setForeground(Color.BLACK);
        Btn4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 36));
        Btn4.setEnabled(false);
        frame.add(Btn4);
        
        Runnable updateProgress= ()->{
            progress.setText("Card "+(index[0]+1)+" of "+questions.length);
        };
      
        Btn1.setEnabled(false);
        Btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {              
                if (index[0]>0) {
                	index[0]--;                
                qstn.setText(questions[index[0]]);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);               
                showingAnswer[0]=false;
                Btn2.setText("Show Answer");
                updateProgress.run();
            }
                Btn1.setEnabled(index[0]!=0); 
                Btn3.setEnabled(index[0]!=questions.length-1); 
                Btn4.setEnabled(index[0]>=2);

           }
        });  
        
            Btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!showingAnswer[0]) {
                    qstn.setText(answers[index[0]]);
                    showingAnswer[0]=true;
                    Btn2.setText("Show Question");
                    updateProgress.run();
                } else {
                    qstn.setText(questions[index[0]]);
                    showingAnswer[0]=false;
                    Btn2.setText("Show Answer"); 
                    updateProgress.run();
                }
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
            }
        });
            
            Btn3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (index[0]<questions.length-1) {
                    	index[0]++;
                    qstn.setText(questions[index[0]]);
                    doc.setParagraphAttributes(0, doc.getLength(), center, false);                
                    showingAnswer[0]=false;
                    Btn2.setText("Show Answer");
                    updateProgress.run();
                }
                    Btn1.setEnabled(index[0]!=0); 
                    Btn3.setEnabled(index[0]!=questions.length-1); 
                    Btn4.setEnabled(index[0]>=2);

               }
            });
            
            Btn4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    index[0] = 0; 
                    qstn.setText(questions[index[0]]);
                    doc.setParagraphAttributes(0, doc.getLength(), center, false);
                    Btn1.setEnabled(false);
                    Btn3.setEnabled(true);
                    Btn4.setEnabled(false);                 
                    showingAnswer[0]=false;
                    Btn2.setText("Show Answer");
                    updateProgress.run();

                }
            });
        
        frame.setVisible(true);

	}
}
