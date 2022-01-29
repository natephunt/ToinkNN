//NATHAN'S Car game


package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseMotionListener, MouseListener, KeyListener {

	
	private DrawWindow dw;
	
	
	
	public Input (DrawWindow dw) {
		this.dw = dw;
				
		this.dw.addMouseMotionListener(this);
		this.dw.addMouseListener(this);
		this.dw.addKeyListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n\nmouse");
		
		
		if(DrawWindow.buttonTime) {
			if (DrawWindow.buckShot.pointVsRect(e.getX(),e.getY(), DrawWindow.buckShot)) {
				System.out.println("buck");
				
				if(Game.player.ded) {
					Game.player.burstSpeed=0;
					Game.player.aimOff+=10;
					System.out.println("buk fur 1");
				}else {
					Game.player2.burstSpeed=0;
					Game.player2.aimOff+=10;
					System.out.println("buk fur 2");
				}
				Game.reset();
				

				
			}
			if (DrawWindow.lifeSteal.pointVsRect(e.getX(),e.getY(), DrawWindow.lifeSteal)) {
				System.out.println("steal");
				if(Game.player.ded) {
					Game.player.lifeSteal++;
					System.out.println("steal fur 1");
				}else {
					Game.player2.lifeSteal++;
					System.out.println("steal fur 2");
				}
				Game.reset();
				
			}
			if (DrawWindow.moreHealth.pointVsRect(e.getX(),e.getY(), DrawWindow.moreHealth)) {
				System.out.println("helth");
				if(Game.player.ded) {
					Game.player.maxLives+=10;
					System.out.println("helth fur 1");
				}else {
					Game.player2.maxLives+=10;
					System.out.println("helth fur 2");
				}
				Game.reset();
				
			}
			if (DrawWindow.machine.pointVsRect(e.getX(),e.getY(), DrawWindow.machine)) {
				System.out.println("steal");
				if(Game.player.ded) {
					Game.player.maxBullets+=4;
					Game.player.damage -= 3;
					System.out.println("machine fur 1");
				}else {
					Game.player2.maxBullets+=4;
					Game.player2.damage -= 3;
					System.out.println("machine fur 2");
				}
				Game.reset();
				
			}
			if (DrawWindow.redDot.pointVsRect(e.getX(),e.getY(), DrawWindow.redDot)) {
				System.out.println("Red Dot");
				
				if(Game.player.ded) {
					
					Game.player.redDot = true;
					System.out.println("red fur 1");
				}else {
					
					Game.player2.redDot = true;
					System.out.println("red fur 2");
				}
				Game.reset();
			}
			if (DrawWindow.homing.pointVsRect(e.getX(),e.getY(), DrawWindow.homing)) {
				System.out.println("HOMING");
				
				if(Game.player.ded) {
					
					Game.player.homing = true;
					Game.player.maxBullets-=1;
					System.out.println("homing fur 1");
				}else {
					
					Game.player2.homing = true;
					Game.player2.maxBullets-=1;
					System.out.println("homung fur 2");
				}
				Game.reset();
			}
			if (DrawWindow.bounce.pointVsRect(e.getX(),e.getY(), DrawWindow.bounce)) {
				System.out.println("bounce");
				
				if(Game.player.ded) {
					
					Game.player.bounces += 2;
					System.out.println("bounce fur 1");
				}else {
					
					Game.player2.bounces += 2;
					System.out.println("bounce fur 2");
				}
				Game.reset();
			}
			if (DrawWindow.bomb.pointVsRect(e.getX(),e.getY(), DrawWindow.bomb)) {
				System.out.println("bomb");
				
				if(Game.player.ded) {
					
					Game.player.damage += 5;
					System.out.println("bomb fur 1");
				}else {
					
					Game.player2.damage += 5;
					System.out.println("bomb fur 2");
				}
				Game.reset();
			}
			if (DrawWindow.aimless.pointVsRect(e.getX(),e.getY(), DrawWindow.aimless)) {
				System.out.println("aimless");
				
				if(Game.player.ded) {
					
					Game.player.doot=true;
					Game.player.maxBullets++;
					System.out.println("aimless fur 1");
				}else {
					
					Game.player2.doot=true;
					Game.player2.maxBullets++;
					System.out.println("aimless fur 2");
				}
				Game.reset();
			}
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e);
		
		if (e.getKeyCode() == 32 ) {
			
			if(Game.ded) {
				System.out.println("\n\n\n\n button time");
				DrawWindow.buttonTime = true;
				DrawWindow.powerTime();
			}
			
		}
		
		
		
		//p1
		if (e.getKeyCode() == 'W' || e.getKeyCode() == 'w') {
			Game.player.setForwardDown(true);
			System.out.println("accel");
		}
		if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
			Game.player.setRightDown(true);
			System.out.println("left");
		}
		if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
			Game.player.setLeftDown(true);
			System.out.println("right");
		}
		if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
			Game.player.setBackDown(true);
			System.out.println("bak");
		}
		if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
			Game.player.setBackDown(true);
			System.out.println("bak");
		}
		if (e.getKeyChar() == 'C' || e.getKeyChar() == 'c') {
			Game.player.setShootDown(true);
			System.out.println("shot");
		}
		if (e.getKeyChar() == 'v' || e.getKeyChar() == 'V') {
			Game.player.shoot(Game.player2);
			System.out.println("shot 2");
		}
		
		
		//p2
		if (e.getKeyCode() == 'P' || e.getKeyCode() == 'p') {
			Game.player2.setForwardDown(true);
			System.out.println("accel 2");
		}
		if (e.getKeyChar() == 'L' || e.getKeyChar() == 'l') {
			Game.player2.setRightDown(true);
			System.out.println("left 2");
		}
		if (e.getKeyChar() == '"' || e.getKeyChar() == '\'') {
			Game.player2.setLeftDown(true);
			System.out.println("right 2");
		}
		if (e.getKeyChar() == ';' || e.getKeyChar() == ':') {
			Game.player2.setBackDown(true);
			System.out.println("bak 2");
		}
		if (e.getKeyChar() == ',' || e.getKeyChar() == '<') {
			Game.player2.setShootDown(true);
			System.out.println("bshot 2");
		}
		if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
			Game.player2.shoot(Game.player);
			System.out.println("shot 2");
		}
		if (e.getKeyChar() == '\\' || e.getKeyChar() == '|') {
			Game.player2.shoot(Game.player);
			System.out.println("shot 2");
		}
		if (e.getKeyCode() == 38 ) {
			Game.speedoes--;
			System.out.println("more sped");
		}
		if (e.getKeyCode() == 40 ) {
			Game.speedoes++;
			System.out.println("LESS sped");
		}
		if (e.getKeyCode() == 'r' || e.getKeyCode() == 'R') {
			Game.random= !Game.random;
			System.out.println("rando toggled");
		}
		if (e.getKeyCode() == 'f' || e.getKeyCode() == 'F') {
			Game.displayWanted= !Game.displayWanted;
			System.out.println("display toggled");
		}
	
		if (e.getKeyCode() == 't' || e.getKeyCode() == 'T') {
			BattleGrounds.targetDummy= !BattleGrounds.targetDummy;
			System.out.println("Target Toggled");
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generatded method stub
		
		
		
		
		//p1
		if (e.getKeyCode() == 87) {
			Game.player.setForwardDown(false);
			System.out.println("stopped accel");
		}
		if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
			Game.player.setRightDown(false);
			System.out.println("stopped left");
		}
		if (e.getKeyChar() == 'D' || e.getKeyChar() == 'd') {
			Game.player.setLeftDown(false);
			System.out.println("stooped right");
		}
		if (e.getKeyChar() == 'S' || e.getKeyChar() == 's') {
			Game.player.setBackDown(false);
			System.out.println("stopped bak");
		}
		if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
			Game.player.setShootDown(false);
			System.out.println("stopped shot");
		}
		
		
		
		//p2
		if (e.getKeyCode() == 'P' || e.getKeyCode() == 'p') {
			Game.player2.setForwardDown(false);
			System.out.println("stoped accel 2");
		}
		if (e.getKeyChar() == 'L' || e.getKeyChar() == 'l') {
			Game.player2.setRightDown(false);
			System.out.println("stoped left 2");
		}
		if (e.getKeyChar() == '\'' || e.getKeyChar() == '"') {
			Game.player2.setLeftDown(false);
			System.out.println("stoped right 2");
		}
		if (e.getKeyChar() == ';' || e.getKeyChar() == ':') {
			Game.player2.setBackDown(false);
			System.out.println("stoped bak 2");
		}
		
		if (e.getKeyChar() == ',' || e.getKeyChar() == '<') {
			Game.player2.setShootDown(false);
			System.out.println("unshot 2");
		}
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
