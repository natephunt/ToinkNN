# ToinkNN

Neural Network version of Toink game by Nathan H.

Approach:
1) NEAT based training for multiple generations
2) Each generation consists of some set number of cars completing.
   A fitness score is assigned to each Car based on performance.
   fitness = number of rounds won during the generational playoff ++
3) NEAT is used to track performance and identify traits going forward.

## Terminal Commands:
   - 0 - makes the time between frames 0
   - 8 - makes time between frames 8 (milliseconds I belive)
   - f - toggles display for faster training
   - r - toggles random start positions (on by default)

## Screen Commands:
   - up arrow - makes the time between frames lower
   - down arrow - opposite of up arrow

## Configurations:

Go to NEAT_Config to change the generation size, mutaion speed, ect...
Haven't been able to make the agents do too much smart stuff... try changing configs
Also can change the imputs to the agents through the imputs array in player. 

## Background:

evo-neat was used as the basis for the NEAT implementation.