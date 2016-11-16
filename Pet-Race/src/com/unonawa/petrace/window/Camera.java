package com.unonawa.petrace.window;

import com.unonawa.petrace.framework.GameObject;

public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject player){
		//x++;
		if (player.getX() >= 543 && player.getX() <= 2975){ // to be changed per level
			x = -player.getX() + Game.WIDTH/2;
		}

		System.out.println(player.getX());
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
