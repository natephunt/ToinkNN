package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawWindow extends JPanel {
	/**
	 * 
	 */
	static Button lifeSteal;
	static Button redDot;
	static Button buckShot;
	static Button moreHealth;
	static Button homing;
	static Button machine;
	static Button bomb;
	static Button bounce;
	static Button aimless;
	static double bros;
	static double yoes;
	static double noes;
	
	public static boolean buttonTime = false;
	
	private static final long serialVersionUID = 8242558423155622593L;

	public void paintComponent(Graphics g) {
		
		
		
		
		
		if (!Game.ded) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			track0(g);
			
		}else if(Game.player.ded) {
			drawGameOver1(g);
			
		}else {
			drawGameOver2(g);
			
		}
		
		
		
		//Game.player2.hb.draw(g);
		//Game.player.hb.draw(g);
		
		Game.player.draw(g);
		Game.player2.draw(g);
		
		for (int i = 0; i < Game.player.shooties.size();i++) {
			Game.player.shooties.get(i).draw(g);
			//Game.shooties.get(i).hb.draw(g);
		}
		for (int i = 0; i < Game.player2.shooties.size();i++) {
			Game.player2.shooties.get(i).draw(g);
			//Game.shooties.get(i).hb.draw(g);
		}
		if (buttonTime) {
			if(bros<=1||yoes<=1||noes<=1) {
				machine.draw(g);
			}
			// TODO NEEDS FIXING
			
			if((bros<=2&&bros>1||yoes<=2&&yoes>1||noes<=2&&noes>1)) {
				bounce.draw(g);
			}
			
			if(bros<=3&&bros>2||yoes<=3&&yoes>2||noes<=3&&noes>2) {
				bomb.draw(g);
			}
			if((bros<=4&&bros>3||yoes<=4&&yoes>3||noes<=4&&noes>3)) {
				homing.draw(g);
			}
			if((bros<=5&&bros>4||yoes<=5&&yoes>4||noes<=5&&noes>4)) {
				moreHealth.draw(g);
			}
			if((bros<=6&&bros>5||yoes<=6&&yoes>5||noes<=6&&noes>5)) {
				redDot.draw(g);
			}
			if((bros<=7&&bros>6||yoes<=7&&yoes>6||noes<=7&&noes>6)) {
				buckShot.draw(g);
			}
			if((bros<=7&&bros>6||yoes<=7&&yoes>6||noes<=7&&noes>6)) {
				lifeSteal.draw(g);
			}
			
			if((bros<=8&&bros>7||yoes<=8&&yoes>7||noes<=8&&noes>7)) {
				aimless.draw(g);
			}
			
			
			
			
			
			
		}
		
		//g.drawImage(Loader.healthBar, -20, -60, 256, 256, null);

		
	}
	
	public static void newButtons() {

		bros = Math.random()*9;
		yoes = Math.random()*9;
		noes = Math.random()*9;
		
	}
	
	
	public void drawGameOver1(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0, this.getWidth(), this.getHeight());
		g.setColor(Color.WHITE);
		g.drawString("Game Over, player 2 (pl;') wins", this.getWidth()/2-60, this.getHeight()/2);
		g.drawString("Score: " + Game.player.score+ " to " + Game.player2.score, this.getWidth()/2-60, this.getHeight()/2+15);
;		
	}
	public void drawGameOver2(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0, this.getWidth(), this.getHeight());
		g.setColor(Color.WHITE);
		g.drawString("Game Over, player one (wasd) wins", this.getWidth()/2-60, this.getHeight()/2);
		g.drawString("Score: " + Game.player.score+ " to " + Game.player2.score, this.getWidth()/2-60, this.getHeight()/2+15);
		
		
	}
	public static void powerTime() {
		
		
		System.out.println("button ");
		lifeSteal = new Button(100, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.lifeSteal);
		redDot = new Button(200, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.redDot);
		buckShot = new Button(300, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.buckShot);
		moreHealth = new Button(400, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.moreHealth);
		bounce = new Button(500, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.bounce);
		bomb = new Button(600, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.bomb);
		machine = new Button(700, 100, Loader.lifeSteal.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.machine);
		homing = new Button(800, 100, Loader.homing.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.homing);
		aimless = new Button(900, 100, Loader.aimless.getWidth()/8, Loader.lifeSteal.getHeight()/8, Loader.aimless);
		
	}
	
	public void track0(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, Game.windowWidth, Game.windowHeight);
		
	}
	
}
