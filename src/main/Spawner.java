package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Spawner {
	int x, y, w, h;
	
	BufferedImage img = Loader.cloud;
	
	int maxCount = 200;
			
	int count = 0;
	
	int vx = 8;
	
	public Spawner() {
		
		this.x = 300;
		this.y = 32;
		this.h = 128;
		this.w = 200;
		
	}
	public void setVX() {
		
	}
	
	public void update() {
		
		this.x += this.vx;
		
		if (this.x > Game.windowWidth) {
			this.x = 0;
		}
		
		if (this.count >= this.maxCount) {
			new Water(this.x, this.y);
			
			this.count = 0;
			this.maxCount -= 5;
		
		}else {
			this.count++;
			boolean r = Math.random()<.5;
			if (r)count+=4;
		}
		if (this.maxCount<60) {
			maxCount=80;
		}
		
		
	}
	
	public void draw(Graphics g) {
		
		g.drawImage(this.img, this.x, this.y, this.w, this.h, null);
		
		//g.fillOval(this.x, this.y, this.w, this.w);
		
		//this.hb.draw(g);
		
	}
}
