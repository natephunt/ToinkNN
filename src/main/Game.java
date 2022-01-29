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
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import com.evo.NEAT.Genome;

public class Game {

	static JFrame frame;
	
	public static DrawWindow drawPanel;
	
	public static int windowHeight = 410;
	public static int windowWidth = 600;

	public static Car player;
	public static Car player2;
	
	public static boolean ded = false;
	
	public static int fileNumber = 0;

	public static int speedoes = 4;
	public static boolean random = true;
	public static boolean display = true;
	public static boolean displayWanted = true;
	// 4 make an array list to hold our shoots
	
	
	//5
 
	
	// TODO public static Spawner spawn1 = new Spawner();

	
	private int prepareGUI() {
		if(Game.display){
			//1
			frame = new JFrame("Toinks");
			//2
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		}
		
		return update();
		
	//end of prepare GUI
	}
	
	public static int fight(Genome car0gene, Genome car1gene) {
		//initialize the game
		init(car0gene, car1gene);
		
		// TODO init and prep
		int winningCar = new Game().prepareGUI();
	//end of main driver
		return winningCar;
	}


	
	
	public static void init(Genome car0gene, Genome car1gene) {
		
		
		player = new Car(windowWidth - 100, windowHeight/2 - 5, car0gene, true);
		player2= new Car(100, windowHeight/2 + 5, car1gene, !BattleGrounds.targetDummy);
		player2.color=Color.magenta;
		
		ded = false;
		
		DrawWindow.newButtons();
		
		//update();
	}
	
	public static int update() {
		int winningCar = 2;
		int time = 0;
		//Scanner sc = new Scanner(System.in);

		while (time<2000) {
			// DONE update Car
			time++;

			

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
			}else{
				if (player.ded){
					winningCar = 1;
				}else if(player2.ded){
					
				}else{
					System.out.println("BEEBOOOBEEBOOO");
					System.out.println("BEEBOOOBEEBOOO");
					System.out.println("BEEBOOOBEEBOOO");
					System.out.println("\nSOMETHING WENT WRONG \n ");
					System.out.println("BEEBOOOBEEBOOO");
					System.out.println("BEEBOOOBEEBOOO");
					System.out.println("BEEBOOOBEEBOOO");

					boolean doots = Math.random()>0.5;
					if(doots){
						winningCar = 0;
					}else{
						winningCar = 1;
					}

				}
				break;
			}
			
			try {
				Thread.sleep(speedoes);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(Game.display){
				frame.repaint();
			}
			
		}
		//String ined = sc.nextLine();
		//if (ined.equals("F")){
		//	displayWanted = !displayWanted;
		//}

		if (Game.display){
			frame.dispose();
		}
		
		display = displayWanted;
		return winningCar;
		
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
