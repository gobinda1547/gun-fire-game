package org.ju.cse.gobinda.game.gunfire.design;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.ju.cse.gobinda.game.gunfire.real_object.Box;

public class GameBoard extends JPanel {

	private static final long serialVersionUID = 1L;

	private static int BOARD_WIDTH;
	private static int BOARD_HEIGHT;
	private static int BOARD_ROW;
	private static int BOARD_COL;

	private Box[][] boxes;

	private static boolean initializationDone;

	public GameBoard() {
		setLayout(null);
		// setBorder(new LineBorder(Color.black));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		initialize();

		drawGameBoardBorder(g);
		drawBoxs(g);
		drawMe(g);

	}

	private void drawMe(Graphics g) {

	}

	private void drawBoxs(Graphics g) {
		for (int i = 0; i < BOARD_ROW; i++) {
			for (int j = 0; j < BOARD_COL; j++) {
				if (boxes[i][j].isValue()) {
					boxes[i][j].drawBox(g);
				}
			}
		}
	}

	private void initialize() {
		if (initializationDone == false) {
			BOARD_WIDTH = getWidth() - 1;
			BOARD_HEIGHT = getHeight() - 1;
			BOARD_ROW = BOARD_HEIGHT / Box.WIDTH_HEIGHT;
			BOARD_COL = BOARD_WIDTH / Box.WIDTH_HEIGHT;
			boxes = new Box[BOARD_ROW][BOARD_COL];
			for (int i = 0; i < BOARD_ROW; i++) {
				for (int j = 0; j < BOARD_COL; j++) {
					boxes[i][j] = new Box(i, j);
				}
			}
			initializationDone = true;
		}
	}

	private void drawGameBoardBorder(Graphics g) {
		g.drawRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
	}

}
