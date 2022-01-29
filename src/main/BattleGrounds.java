package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.evo.NEAT.Environment;
import com.evo.NEAT.Genome;
import com.evo.NEAT.Pool;

/* 
* all code in main created by nathan h (natephunt) with help from tyler j in making the game
* implementation of ai all by nathan
*/

/** 
 * by nathan h
 */
public class BattleGrounds implements Environment {
    
    public static boolean targetDummy = false;
    public static int generation = 0;
    public static int coolness = 0;

    @Override
    public void evaluateFitness(ArrayList<Genome> population) {
        // 2d array of win/loss
        
    
        Genome[] pop = (Genome[])population.toArray(new Genome[population.size()]);
        
        
        boolean[][] wins = new boolean[pop.length][pop.length];
        
        for (boolean[] row: wins){
            Arrays.fill(row, false);
        }
          

        // targetDummy not implemented yet
        if(targetDummy){
            for (int j = 0; j < pop.length; j++) {
                    
                Genome car0gene = pop[j];
                Genome car1gene = new Genome();

                System.out.println("\n Targeting " + j);
                int winner = Game.fight(car0gene, car1gene);
                if(winner == 0){
                    wins[j][0] = true;
                    System.out.println("Round Over, they hit");
                }else{
                    
                    System.out.println("Round Over, they missed");

                    /*
                    boolean doots = Math.random()>0.5;
                    if(doots){
                        wins[i][j] = false;
                        wins[j][i] = true;
                    }else{
                        wins[i][j] = true;
                        wins[j][i] = false;
                    }
                    */
                }
            }
        
        }else{
            for (int i = 0; i < pop.length - 1; i++) {
                Genome car0gene = pop[i];
                // compete against higher numbered cars
                for (int j = i+1; j < pop.length; j++) {
                    
                    Genome car1gene = pop[j];
    
                    System.out.println("\n fighting " + i + " and " + j);
                    int winner = Game.fight(car0gene, car1gene);
                    if(winner == 0){
                        wins[i][j] = true;
                        wins[j][i] = false;
                        coolness++;
                        doLC();
                        System.out.println("#1 won...                   Generation: " + generation+ "...    roc : ");
                    }else if(winner ==1 ){
                        wins[i][j] = false;
                        wins[j][i] = true;
                        coolness++;
                        doLC();
                        System.out.println("#2 won...                   Generation: " + generation+ "...    roc : ");
                    }else{
                        coolness--;
                        doLC();
                        System.out.println("Round Over, nobody won...   Generation: " + generation + "...    roc : ");
                        wins[i][j] = false;
                        wins[j][i] = false;
    
                        /*
                        boolean doots = Math.random()>0.5;
                        if(doots){
                            wins[i][j] = false;
                            wins[j][i] = true;
                        }else{
                            wins[i][j] = true;
                            wins[j][i] = false;
                        }
                        */
                    }
                }
            }
        }
        
        
        
        int boio = 0;
        for (Genome gene: population) {
            // fitness = # of wins
            int counter = 0;
            for (int j =0; j< wins[0].length; j++){
                if(wins[boio][j]){
                    counter++;
                }
            }

            gene.setFitness(counter);
            boio++;
        }
    }
    public void doLC(){
        // coolness going up generneraly means that the ai are doing better, as coolness is a counter of the number of times on of the ais win
        System.out.println(coolness);
       }


    // terminal controls as it is hard to imput controls in the flickering window
    public static class ConsoleCommands extends Thread {
        public void run() {
            while(true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter command:");
                String instuff = sc.nextLine();
                if (instuff.equals("f") || instuff.equals("F") ){
                    Game.displayWanted = !Game.displayWanted;
                    System.out.println("Display Toggled");
                }
                if (instuff.equals("r") || instuff.equals("R") ){
                    Game.random = !Game.random;
                    System.out.println("Rando Toggled");
                }
                if (instuff.equals("8")){
                    Game.speedoes = 8;
                    System.out.println("speed 8");
                }
                if (instuff.equals("0")){
                    Game.speedoes = 0;
                    System.out.println("speed 0");
                }
                if (instuff.equals("Gen")){
                    System.out.println(generation);
                }
            }
        }
    }

    public static void main(String arg0[]){

        ConsoleCommands cc = new ConsoleCommands();
        cc.start();

        BattleGrounds battleGrounds = new BattleGrounds();
        Pool pool = new Pool(); 
        pool.initializePool();

        Genome topGenome = new Genome();
        generation = 0;
        while(true){
            // <<< One loop through is one Generation

            pool.evaluateFitness(battleGrounds);
            topGenome = pool.getTopGenome();
            System.out.println("TopFitness : " + topGenome.getPoints());

            //if(topGenome.getPoints()>15){
            //    break;
            //}
//            System.out.println("Population : " + pool.getCurrentPopulation() );
            System.out.println("Generation : " + generation );
            //           System.out.println("Total number of matches played : "+TicTacToe.matches);
            //           pool.calculateGenomeAdjustedFitness();

            pool.breedNewGeneration();
            generation++;

        }
        //System.out.println(topGenome.evaluateNetwork(new float[]{1,0})[0]);
    }
}