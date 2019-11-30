import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class WhacAMole extends JFrame implements ActionListener {
	private static final String OFF_STRING = "   ";
	private static final String UP_STRING = ":-3";
	private static final String DOWN_STRING = "X-(";
	private static final Color OFF_COLOR = Color.LIGHT_GRAY;
	private static final Color UP_COLOR = Color.GREEN;
	private static final Color DOWN_COLOR = Color.RED;

	private static int timeLeft = 30;
	private static int score;
	private static int highscore;
	
	private JButton startButton;
	private JButton[] buttons;
	private JLabel timeLabel, scoreLabel;
	private static JLabel highScoreLabel;
	private JTextArea timeArea;
	private JTextArea scoreArea;
	private JTextArea highscoreArea;
	private static Random random = new Random();

	public WhacAMole() {
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

		JFrame frame = new JFrame("Whack-a-Mole");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 608, 720);
		
		JPanel pane = new JPanel();
		
		JLabel Title = new JLabel("Whack-A-Mole");
		Title.setForeground(new Color(53, 100, 0));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setFont(new Font("Century Gothic", Font.BOLD, 20));
        Title.setBounds(100, 50, 800, 47);
		pane.add(Title);
		
		startButton = new JButton("Start");
		pane.add(startButton);
		startButton.addActionListener(this);
		
//		resetButton = new JButton("Reset");
//		pane.add(resetButton);
		

		timeLabel = new JLabel("Timer:");
		pane.add(timeLabel);

		timeArea = new JTextArea(1, 5);
		timeArea.setEditable(false);
		pane.add(timeArea);
		timeArea.setVisible(true);

		highScoreLabel = new JLabel("High Score:");
		pane.add(highScoreLabel);

		highscoreArea = new JTextArea(1, 5);
		highscoreArea.setEditable(false);
		pane.add(highscoreArea);
		highscoreArea.setVisible(true);
		
		scoreLabel = new JLabel("Score:");
		pane.add(scoreLabel);

		scoreArea = new JTextArea(1, 5);
		scoreArea.setEditable(false);
		pane.add(scoreArea);
		scoreArea.setVisible(true);

		buttons = new JButton[100];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(OFF_STRING);
			buttons[i].setOpaque(true);
			buttons[i].setFont(font);
			buttons[i].setBackground(OFF_COLOR);
			pane.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		frame.setContentPane(pane);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new WhacAMole();
		loadHighscore();
	}

	public static class MoleThread extends Thread {
		JButton button;

		MoleThread(JButton button) {
			this.button = button;
			if (timeLeft > -1) {
				if (button.getText().equals(OFF_STRING)) {
					button.setText(UP_STRING);
					button.setBackground(UP_COLOR);

				} else {
					button.setText(OFF_STRING);
					button.setBackground(OFF_COLOR);
				}
			}
		}

		public void run() {
			while (timeLeft > -1) {
				int randomSleepTime = random.nextInt(4000);
				synchronized (button) {
					if (button.getText().equals(OFF_STRING)) {
						button.setText(UP_STRING);
						button.setBackground(UP_COLOR);

					} else {
						button.setText(OFF_STRING);
						button.setBackground(OFF_COLOR);
					}

				}
				try {
					Thread.sleep(randomSleepTime);
				} catch (InterruptedException e) {
					// Should not happen
					throw new AssertionError(e);
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				}

			}

			if (timeLeft == -1) {
				button.setText(OFF_STRING);
				button.setBackground(OFF_COLOR);
			}

		}
	}
	
	 private void saveHighscore(){
	        BufferedWriter bw = null;
	        try {
	            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/highscore.txt", false)); //append - set to false
	            bw.write("" + highscore);
	            bw.flush();
	            bw.close();
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(this, e.getMessage(), "Error while saving highscore", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	 
	 private static void loadHighscore(){
	        BufferedReader br = null;
	        String line = "";
	        try {
	            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/highscore.txt"));
	            line = br.readLine();
	            br.close();
	        } catch (IOException e) {
	            line = "";
	        }

	        if(line != ""){
	            highscore = Integer.parseInt(line);
	            highScoreLabel.setText("Highscore: " + highscore);
	        }
	    }

//	  private void clearBoard(){
//		  buttons = new JButton[100];
//			for (int i = 0; i < buttons.length; i++) {
//				buttons[i] = new JButton(OFF_STRING);
//				buttons[i].setOpaque(true);
//				buttons[i].setFont(font);
//				buttons[i].setBackground(OFF_COLOR);
//				pane.add(buttons[i]);
//				buttons[i].addActionListener(this);
//			}
//	    }


	@Override
	public void actionPerformed(ActionEvent e) {

		Thread[] moleThread = new Thread[buttons.length];

		if (e.getSource() == startButton) {
			startButton.setEnabled(false);

			// create timer, start timer, create array of mole threads, start
			Thread timerThread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (timeLeft > -1) {

						try {

							timeArea.setText("" + timeLeft);
							timeLeft--;
							Thread.sleep(1000);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					timeLeft = 30;
					score = 0;
					timeArea.setText("" + timeLeft);
					scoreArea.setText("" + score);
					startButton.setEnabled(true);
					if(score > highscore){
			            highscore = score;
			            highscoreArea.setText("Highscore: " + highscore);
			            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "You beat the high score!", JOptionPane.INFORMATION_MESSAGE);
			        }else{
			            JOptionPane.showMessageDialog(this, "Your final score is: " + score, "Game Over!", JOptionPane.INFORMATION_MESSAGE);
			        }
					saveHighscore();
				}
			});

			timerThread.start();

			for (int i = 0; i < moleThread.length; i++) {
				int randomMoleNum = random.nextInt(buttons.length);
				JButton button = buttons[randomMoleNum];
				moleThread[i] = new MoleThread(button);
				moleThread[i].start();

			}
		}
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) {
				if (timeLeft > 0) {
					if (buttons[i].getText().equals(UP_STRING)) {
						score++;
						scoreArea.setText("" + score);
						buttons[i].setText(DOWN_STRING);
						buttons[i].setBackground(DOWN_COLOR);

					}
				}
			}

		}
	}
}