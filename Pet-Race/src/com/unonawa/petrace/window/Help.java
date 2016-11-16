package com.unonawa.petrace.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Help {
		
	
	public Rectangle backButton = new Rectangle(Game.WIDTH / 2 + 200, 450, 100, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt1 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("Pet Race	", Game.WIDTH / 2 - 100, 200);
		
		Font fnt2 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt2);
		g.drawString("Back", backButton.x + 19, backButton.y + 35);
		g2d.draw(backButton);
		
		
	}	
}
