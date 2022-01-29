package com.evo.NEAT;

/**
 * Created by vishnughosh on 04/03/17.
 */
public class InnovationCounter {

    private static int innovation = 0;

    public static int newInnovation() {
        innovation++;
        System.out.println(innovation);
        return innovation;
    }
}
