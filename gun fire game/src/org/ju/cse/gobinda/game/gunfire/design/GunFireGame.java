package org.ju.cse.gobinda.game.gunfire.design;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ju.cse.gobinda.game.gunfire.real_object.GameController;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GunFireGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static CardLayout card;

	public static int FRAME_WIDTH = 281;
	public static int FRAME_HEIGHT = 436;

	private HighScorePanel highScorePanel;
	private GameBoard gameBoard;
	private JPanel optionPanel;

	public static void initialize() {
		new GunFireGame().setVisible(true);
	}

	public GunFireGame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		card = new CardLayout();
		contentPane.setLayout(card);

		optionPanel = new JPanel();
		contentPane.add(optionPanel, "optionPanel");
		optionPanel.setLayout(null);

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setThisPanelInFront("gameBoard");
				GameController.start();
			}
		});
		btnNewButton.setBounds(65, 114, 125, 31);
		optionPanel.add(btnNewButton);

		JButton btnHighScore = new JButton("High Score");
		btnHighScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				highScorePanel.refreshHighScore();
				setThisPanelInFront("highScorePanel");
			}
		});
		btnHighScore.setBounds(65, 156, 125, 31);
		optionPanel.add(btnHighScore);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(65, 198, 125, 31);
		optionPanel.add(btnExit);

		gameBoard = new GameBoard();
		gameBoard.requestFocusInWindow();
		contentPane.add(gameBoard, "gameBoard");

		highScorePanel = new HighScorePanel();
		contentPane.add(highScorePanel, "highScorePanel");

		// setThisPanelInFront("optionPanel");
		setContentPane(contentPane);

	}

	public static void setThisPanelInFront(String panelName) {
		card.show(contentPane, panelName);
	}

}
