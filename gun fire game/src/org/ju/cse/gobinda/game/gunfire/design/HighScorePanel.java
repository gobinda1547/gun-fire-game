package org.ju.cse.gobinda.game.gunfire.design;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.ju.cse.gobinda.game.gunfire.database.Dao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HighScorePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int highScore = 0;

	public HighScorePanel() {
		setLayout(null);
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GunFireGame.setThisPanelInFront("optionPanel");
			}
		});
		btnNewButton.setBounds(10, 11, 41, 29);
		add(btnNewButton);
		setBounds(0, 0, 250, 420);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		showThisStringToMiddle(g, "High Score", 100);
		showThisStringToMiddle(g, "Is", 150);
		showThisStringToMiddle(g, String.valueOf(highScore), 200);
	}

	private void showThisStringToMiddle(Graphics g, String message, int height) {
		FontMetrics ff = g.getFontMetrics();
		int x = GunFireGame.FRAME_WIDTH / 2 - ff.stringWidth(message) / 2 - 10;
		g.drawString(message, x, height);
	}

	public void refreshHighScore() {
		highScore = Dao.getHighScore();
		repaint();
	}

}
