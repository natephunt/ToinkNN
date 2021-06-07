/*
 * NaThAn's Car GAmE
 * 
 * 
 * 
 * 
 */

package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JFrame;

public class Game {

	static JFrame frame;
	
	public static DrawWindow drawPanel;
	
	public static int windowHeight = 820;
	public static int windowWidth = 1200;

	public static Car player;
	public static Car player2;
	
	public static boolean ded = false;
	
	public static int fileNumber = 0;
	// 4 make an array list to hold our shoots
	
	
	//5
 
	
	// TODO public static Spawner spawn1 = new Spawner();

	
	private void prepareGUI() {
		
		//1
		frame = new JFrame("Toinks");
		//2
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//3
		drawPanel = new DrawWindow();
		//3a
		new Input(drawPanel);
		//4
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		//5
		frame.setResizable(true);
		//6
		drawPanel.setFocusable(true);
		drawPanel.requestFocusInWindow();
		//7
		frame.setSize(windowWidth, windowHeight);
		//8
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		update();
		
	//end of prepare GUI
	}
	
	
	public static void main(String[] args) {
		

		
		
		//initialize the game
		init();
		
		// TODO init and prep
		new Game().prepareGUI();
	//end of main driver
	}
	
	
	
	
	public static void init() {
	
		
		player = new Car(570, 228);
		player2= new Car(340, 500);
		player2.color=Color.magenta;
		
		ded = false;
		
		DrawWindow.newButtons();
		
		//update();
	}
	
	
	public static void update() {
		while (true) {
			
			// DONE update Car
			
			windowWidth=frame.getWidth();
			windowHeight=frame.getHeight();
			
			if (!ded) {
				
				player.checkDed(player2);
				player2.checkDed(player);
				
				player.update(player2);
				player2.update(player);
				
				//update water
				for (int i = 0; i < player.shooties.size(); i++) {
					player.shooties.get(i).update();
				}
				for (int i = 0; i < player2.shooties.size(); i++) {
					player2.shooties.get(i).update();
				}
			}
			
			
			
			
			
			
			try {
				Thread.sleep(16);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			frame.repaint();
		}
	//end of the update method
		
		
	}
	public static void readSave() throws IOException{
		
		BufferedReader f;
		
		try{
			
			f=new BufferedReader(new FileReader ("photo_editor_save.txt"));
			
			StringTokenizer st = new StringTokenizer(f.readLine());
			
			System.out.println(st.nextToken());
			
			String token =st.nextToken();
			
			System.out.println("the toeken is: "+ token);
			
			int currentExtract = Integer.parseInt(token);
			
			fileNumber = currentExtract;
					
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println(">>  FILE NOT WORKEY");
			System.out.println(">>  ...");
			savedData();
			System.out.println(">>  NEW FILE INITIALIZING");
			
			
		}
		
	}
	
	public static void savedData() {
		PrintWriter out = null;
		try {
			System.out.println("tryWrited");
			out = new PrintWriter(new BufferedWriter(new FileWriter("boom.txt")));
		}catch(IOException e){
			System.out.println("dintWork");
			e.printStackTrace();
		}
		
		out.println("Winner: " + fileNumber);
		
		out.close();
	}
	
	
	static void reset() {

		Game.player.shooties.clear();
		Game.player2.shooties.clear();
		Game.ded=false;
		Game.player.ded=false;
		Game.player2.ded=false;
		Game.player.x=100;
		Game.player2.x=700;
		Game.player.lives=Game.player.maxLives;
		Game.player2.lives=Game.player2.maxLives;
		Game.player.update(player2);
		Game.player2.update(player);
		Game.player.handleImage();
		Game.player2.handleImage();
		DrawWindow.buttonTime=false;
		DrawWindow.newButtons();
		Game.player.bullets=Game.player.maxBullets;
		Game.player2.bullets=Game.player2.maxBullets;
		
	}

	
}
