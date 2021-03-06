package com.evo.NEAT.config;

/**
 * Created by vishnughosh on 01/03/17.
 * 
 */
public class NEAT_Config {

    public static final int INPUTS = 2;
    public static final int OUTPUTS = 1;
    public static final int HIDDEN_NODES = 100;
    public static final int POPULATION = 100;

    public static final float COMPATIBILITY_THRESHOLD = 0.2f;
    public static final float EXCESS_COEFFICENT = 0.3f;
    public static final float DISJOINT_COEFFICENT = 0.6f;
    public static final float WEIGHT_COEFFICENT = 0.4f;

    public static final float STALE_SPECIES = 0.3f;


    public static final float STEPS = 0.1f;
    public static final float PERTURB_CHANCE = 0.9f;
    public static final float WEIGHT_CHANCE = 0.3f;
    public static final float WEIGHT_MUTATION_CHANCE = 0.99f;
    public static final float NODE_MUTATION_CHANCE = 0.03f;
    public static final float CONNECTION_MUTATION_CHANCE = 0.1f;
    public static final float BIAS_CONNECTION_MUTATION_CHANCE = 0.15f;
    public static final float DISABLE_MUTATION_CHANCE = 0.1f;
    public static final float ENABLE_MUTATION_CHANCE = 0.2f ;
    public static final float CROSSOVER_CHANCE = 0.75f;

    public static final int STALE_POOL = 20;
}
