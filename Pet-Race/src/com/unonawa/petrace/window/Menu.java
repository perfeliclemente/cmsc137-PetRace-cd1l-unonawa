package com.unonawa.petrace.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
		
	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 50, 250, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH / 2 - 50, 350, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 50, 450, 100, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt1 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("Pet Race	", Game.WIDTH / 2 - 100, 200);
		
		Font fnt2 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt2);
		g.drawString("Play", playButton.x + 19, playButton.y + 35);
		g.drawString("Help", helpButton.x + 19, helpButton.y + 35);
		g.drawString("Quit", quitButton.x + 19, quitButton.y + 35);
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(quitButton);
		
		
	}	
}
