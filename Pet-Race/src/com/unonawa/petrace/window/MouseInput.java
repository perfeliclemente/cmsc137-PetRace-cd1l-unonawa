package com.unonawa.petrace.window;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.unonawa.petrace.objects.Player;

public class MouseInput implements MouseListener{

	public void mouseClicked(MouseEvent e) {
	
	}

	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		if (Game.state == State.MENU){
			if (x >= Game.WIDTH / 2 - 50 && x <= Game.WIDTH / 2 + 50){
				if (y >= 250 && y <= 300){
					Game.state = State.CHARACTER;
				}
			}
			
			if (x >= Game.WIDTH / 2 - 50 && x <= Game.WIDTH / 2 + 50){
				if (y >= 350 && y <= 400){
					Game.state = State.HELP;
				}
			}
			
			if (x >= Game.WIDTH / 2 - 50 && x <= Game.WIDTH / 2 + 50){
				if (y >= 450 && y <= 500){
					System.exit(1);
				}
			}
			
		}
		
		if (Game.state == State.HELP){
			if (x >= Game.WIDTH / 2 + 200 && x <= Game.WIDTH / 2 + 300){
				if (y >= 450 && y <= 500){
					Game.state = State.MENU;
				}
			}	
		}
		
		if (Game.state == State.CHARACTER){
			if (x >= 170 && x <= 320){
				if (y >= Game.HEIGHT / 4 && y <= Game.HEIGHT / 4 + 150){
					Game.state = State.GAME;
					Player.player_color = new Color(255, 0, 0);
				}
			}
			
			if (x >= 370 && x <= 520){
				if (y >= Game.HEIGHT / 4 && y <= Game.HEIGHT / 4 + 150){
					Game.state = State.GAME;
					Player.player_color = new Color(0, 255, 0);
				}
			}
			
			if (x >= 570 && x <= 720){
				if (y >= Game.HEIGHT / 4 && y <= Game.HEIGHT / 4 + 150){
					Game.state = State.GAME;
					Player.player_color = new Color(0, 0, 255);
				}
			}
			
			if (x >= 770 && x <= 920){
				if (y >= Game.HEIGHT / 4 && y <= Game.HEIGHT / 4 + 150){
					Game.state = State.GAME;
					Player.player_color = new Color(0, 0, 0);
				}
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
