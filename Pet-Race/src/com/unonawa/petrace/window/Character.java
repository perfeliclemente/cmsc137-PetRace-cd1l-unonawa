package com.unonawa.petrace.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Character {
	
	public Rectangle avatar1 = new Rectangle(170, Game.HEIGHT / 4, 150, 150);
	public Rectangle avatar2 = new Rectangle(370, Game.HEIGHT / 4, 150, 150);
	public Rectangle avatar3 = new Rectangle(570, Game.HEIGHT / 4, 150, 150);
	public Rectangle avatar4 = new Rectangle(770, Game.HEIGHT / 4, 150, 150);
		
		public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt1 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("Choose Your Avatar", Game.WIDTH / 2 - 240, 150);
		
		Font fnt2 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt2);
		
		g.drawString("Avatar 1", avatar1.x + 19, avatar1.y + 75);
		g2d.draw(avatar1);
		
		g.drawString("Avatar 2", avatar2.x + 19, avatar2.y + 75);
		g2d.draw(avatar2);
		
		g.drawString("Avatar 3", avatar3.x + 19, avatar3.y + 75);
		g2d.draw(avatar3);
		
		g.drawString("Avatar 4", avatar4.x + 19, avatar4.y + 75);
		g2d.draw(avatar4);
		
		
		
	}	
}
