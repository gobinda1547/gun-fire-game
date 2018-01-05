package org.ju.cse.gobinda.game.gunfire.real_object;

import java.awt.Graphics;

public class Box {

	public static int WIDTH_HEIGHT = 16;

	private boolean value;
	private int pos_x;
	private int pos_y;

	public Box(int pos_x, int pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void drawBox(Graphics g) {
		g.drawRect(pos_x * WIDTH_HEIGHT, pos_y * WIDTH_HEIGHT, WIDTH_HEIGHT, WIDTH_HEIGHT);
		g.fillOval(pos_x * WIDTH_HEIGHT, pos_y * WIDTH_HEIGHT, WIDTH_HEIGHT / 2, WIDTH_HEIGHT / 2);
	}

}
