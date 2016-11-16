package com.unonawa.petrace.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import com.unonawa.petrace.framework.KeyInput;
import com.unonawa.petrace.framework.ObjectId;
import com.unonawa.petrace.objects.Block;
import com.unonawa.petrace.objects.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1429689050684822270L;
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	public static State state;
	
	private BufferedImage level = null;
	private BufferedImage background = null;
	
	private Menu menu;
	private Help help;
	
	//Object 
	Handler handler;
	Camera cam;

	private void init(){
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		state = State.MENU;
		
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level.png"); // loading level
		
		
		background = loader.loadImage("/try.jpg");
		
		menu = new Menu();
		help = new Help();
		handler = new Handler();
		
		cam = new Camera(0, 0);
		
		LoadImageLevel(level);
		 
		//handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput());
	}
	
	public synchronized void start(){
		if (running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	private void tick(){
			if (state == State.GAME){
				handler.tick();
				
				for(int i = 0; i < handler.object.size(); i++){
					if (handler.object.get(i).getId() == ObjectId.Player){
						cam.tick(handler.object.get(i));
					}
				}
			}
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		////////////
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY()); // begin of cam
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		if (state == State.GAME){
			handler.render(g);
		}
		else if (state == State.MENU){
			menu.render(g2d);
		}
		else if (state == State.HELP){
			help.render(g2d);
		}
		g2d.translate(-cam.getX(), -cam.getY()); // end of cam
		////////////
		g.dispose();
		bs.show();
	}
	
	private void LoadImageLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				int pixel = image.getRGB(i, j);
				int green = (pixel >> 16) & 0xff;
				int red = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 255 && green == 255 && blue == 255){
					handler.addObject(new Block(i*32, j*32, ObjectId.Block));
				}
				if (red == 0 && green == 0 && blue == 255){
					handler.addObject(new Player(i*32, j*32, handler, ObjectId.Player));
				}
			}
		}
	}
	
	public static void main (String [] args){
		Window window = new Window(1080, 720, "Pet Race", new Game());
	}
}
