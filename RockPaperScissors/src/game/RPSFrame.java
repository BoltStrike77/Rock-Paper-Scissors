package game;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

public class RPSFrame extends JFrame {

	public RPSPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPSFrame frame = new RPSFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RPSFrame() {
		this.setTitle("Rock Paper Scissors");
		ImageIcon icon = new ImageIcon("src/files/a.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(350, 75);
		this.setResizable(false);
		this.setLayout(null);
		contentPane = new RPSPanel();
		setContentPane(contentPane);
		pack();
	}
	
	

}
