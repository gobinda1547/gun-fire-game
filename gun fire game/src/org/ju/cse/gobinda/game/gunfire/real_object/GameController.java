package org.ju.cse.gobinda.game.gunfire.real_object;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameController implements ActionListener {

	private static GameController gameController;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		
		
		
		
		
		

	}

	public static void start() {
		if (gameController == null)
			gameController = new GameController();
		Timer timer = new Timer(50, gameController);
		timer.start();
	}
}
