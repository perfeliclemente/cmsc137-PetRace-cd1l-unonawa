package com.unonawa.petrace.window;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	public void mouseClicked(MouseEvent e) {
	
	}

	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		if (x >= Game.WIDTH / 2 - 50 && x <= Game.WIDTH / 2 + 50){
			if (y >= 250 && y <= 300){
				//Game.State = Game.State.GAME;
				Game.state = State.GAME;
				System.out.println("YEAH");
			}
		}
		
		if (x >= Game.WIDTH / 2 - 50 && x <= Game.WIDTH / 2 + 50){
			if (y >= 350 && y <= 400){
				//Game.State = Game.State.HELP;
				Game.state = State.HELP;
			}
		}
		
		if (x >= Game.WIDTH / 2 - 50 && x <= Game.WIDTH / 2 + 50){
			if (y >= 450 && y <= 500){
				System.exit(1);
			}
		}
		
		if (x >= Game.WIDTH / 2 + 200 && x <= Game.WIDTH / 2 + 300){
			if (y >= 450 && y <= 500){
				//Game.State = Game.State.MENU;
				Game.state = State.MENU;
			}
		}
		
		
		
		
		
		  
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
	
	}

}