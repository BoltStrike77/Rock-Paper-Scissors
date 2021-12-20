package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RPSPanel extends JPanel implements MouseListener {

	private int WIDTH = 680, HEIGHT = 500;
	private Dimension size = new Dimension(WIDTH, HEIGHT);
	private Border border;
	private ImageIcon paperImage = new ImageIcon("src/images/paper.png");
	private ImageIcon rockImage = new ImageIcon("src/images/rock.png");
	private ImageIcon scissorsImage = new ImageIcon("src/images/scissors.png");
	private ImageIcon rockEyebrow = new ImageIcon("src/images/rockEyebrow.gif");
	private ImageIcon rockAgree = new ImageIcon("src/images/rockAgree.gif");
	private ImageIcon matrix = new ImageIcon("src/images/matrix.gif");
	private ImageIcon shrug = new ImageIcon("src/images/shrug.png");
	private ImageIcon computer = new ImageIcon("src/images/computer.png");
	private JLabel paperLBL, rockLBL, scissorsLBL, resultLBL, titleLBL, responseLBL, computerLBL, computerTextLBL,
			playerChoiceLBL, instructionsLBL, winCounterLBL, computerChoiceLBL, matrixLBL;
	private int computerChoice;
	private int count = 0;

	public RPSPanel() {

		this.setLayout(null);
		this.setPreferredSize(size);

		titleLBL = new JLabel("Rock Paper Scissors");
		titleLBL.setForeground(Color.WHITE);
		titleLBL.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		titleLBL.setHorizontalAlignment(SwingConstants.CENTER);
		titleLBL.setBounds(10, 5, 680, 89);
		add(titleLBL);

		computerChoiceLBL = new JLabel("");
		computerChoiceLBL.setForeground(Color.BLACK);
		computerChoiceLBL.setFont(new Font("Franklin Gothic Medium Cond", Font.ITALIC, 25));
		computerChoiceLBL.setBounds(120, 363, 207, 62);
		add(computerChoiceLBL);

		playerChoiceLBL = new JLabel("Player chose: ");
		playerChoiceLBL.setForeground(Color.WHITE);
		playerChoiceLBL.setFont(new Font("Franklin Gothic Medium Cond", Font.ITALIC, 25));
		playerChoiceLBL.setBounds(229, 60, 229, 62);
		add(playerChoiceLBL);

		computerTextLBL = new JLabel("Computer chose: ");
		computerTextLBL.setForeground(Color.BLACK);
		computerTextLBL.setFont(new Font("Franklin Gothic Medium Cond", Font.ITALIC, 25));
		computerTextLBL.setBounds(93, 321, 207, 62);
		add(computerTextLBL);

		resultLBL = new JLabel("Winner: ");
		resultLBL.setForeground(Color.WHITE);
		resultLBL.setFont(new Font("Franklin Gothic Medium Cond", Font.ITALIC, 25));
		resultLBL.setBounds(441, 427, 229, 62);
		add(resultLBL);

		instructionsLBL = new JLabel("Click a choice to play again! ");
		instructionsLBL.setForeground(Color.WHITE);
		instructionsLBL.setFont(new Font("Dubai", Font.PLAIN, 18));
		instructionsLBL.setBounds(239, 98, 207, 41);
		add(instructionsLBL);
		instructionsLBL.setVisible(false);

		paperLBL = new JLabel(paperImage);
		paperLBL.setBounds(276, 150, 130, 130);
		paperLBL.addMouseListener(this);
		add(paperLBL);

		rockLBL = new JLabel(rockImage);
		rockLBL.setBounds(474, 150, 130, 130);
		rockLBL.addMouseListener(this);
		add(rockLBL);

		scissorsLBL = new JLabel(scissorsImage);
		scissorsLBL.setBounds(73, 150, 130, 130);
		scissorsLBL.addMouseListener(this);
		add(scissorsLBL);

		responseLBL = new JLabel(rockAgree);
		responseLBL.setBounds(457, 301, 130, 130);
		add(responseLBL);

		computerLBL = new JLabel(computer);
		computerLBL.setBounds(70, 311, 210, 194);
		add(computerLBL);

		winCounterLBL = new JLabel("Wins: " + count);
		winCounterLBL.setForeground(Color.WHITE);
		winCounterLBL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		winCounterLBL.setBounds(34, 29, 86, 54);
		add(winCounterLBL);

		matrixLBL = new JLabel(matrix);
		matrixLBL.setSize(WIDTH, HEIGHT);
		add(matrixLBL);

	}

	private void checkWinner(int id) { // ids correspond to a player selection, 0 = rock, 1 = paper, 2 = scissors
		computerChoice = (int) (3 * Math.random());
		if (computerChoice == 0) {
			computerChoiceLBL.setText("Rock");
		} else if (computerChoice == 1) {
			computerChoiceLBL.setText("Paper");
		} else if (computerChoice == 2) {
			computerChoiceLBL.setText("Scissors");
		}

		if (id == computerChoice) {
			tie();

		} else if (id == 1 && computerChoice == 0) {
			win();
		} else if (id == 2 && computerChoice == 1) {
			win();
		} else if (id == 0 && computerChoice == 2) {
			win();

		} else if (id == 1 && computerChoice == 2) {
			lose();
		} else if (id == 2 && computerChoice == 0) {
			lose();
		} else if (id == 0 && computerChoice == 1) {
			lose();
		}

	}

	private void tie() {
		resultLBL.setForeground(Color.WHITE);
		resultLBL.setBounds(500, 427, 229, 62);
		responseLBL.setIcon(shrug);
		resultLBL.setText("Tie");
	}

	private void win() {
		count++;
		winCounterLBL.setText("Wins: " + count);
		resultLBL.setBounds(475, 427, 229, 62);
		responseLBL.setIcon(rockAgree);
		resultLBL.setForeground(Color.GREEN);
		resultLBL.setText("Nice win!");
		
	}

	private void lose() {
		resultLBL.setBounds(410, 427, 260, 62);
		resultLBL.setForeground(Color.RED);
		responseLBL.setIcon(rockEyebrow);
		resultLBL.setText("The Matrix outsmarted you!");
	}

	public void mouseEntered(MouseEvent e) {
		Object src = e.getSource();
		border = BorderFactory.createLineBorder(
				new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)), 5);
		if (src == rockLBL) {
			rockLBL.setBorder(border);
		} else if (src == paperLBL) {
			paperLBL.setBorder(border);
		} else if (src == scissorsLBL) {
			scissorsLBL.setBorder(border);
		}
	}

	public void mouseExited(MouseEvent e) {
		Object src = e.getSource();
		if (src == rockLBL) {
			rockLBL.setBorder(null);
		} else if (src == paperLBL) {
			paperLBL.setBorder(null);
		} else if (src == scissorsLBL) {
			scissorsLBL.setBorder(null);
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		Object src = e.getSource();
		if (src == rockLBL) {
			checkWinner(0);
			playerChoiceLBL.setText("Player chose: Rock");
		} else if (src == paperLBL) {
			checkWinner(1);
			playerChoiceLBL.setText("Player chose: Paper");
		} else if (src == scissorsLBL) {
			checkWinner(2);
			playerChoiceLBL.setText("Player chose: Scissors");
		}
		instructionsLBL.setVisible(true);
	}

	public void mouseReleased(MouseEvent e) {
	}

}