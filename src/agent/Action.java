/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent;

/**
 *
 * @author Clemens Lode, 1151459, University Karlsruhe (TH)
 */
public class Action extends GeneticData {
    public static final int ACTION_SIZE = 1;
    private static final int MAX_ACTIONS = Grid.MAX_DIRECTIONS + 1;
    
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final int NO_DIRECTION = 4;
    public static final int RANDOM_DIRECTION = 5;    
    
    private static String[] actionString = {"North", "East", "South", "West", "Random", "No direction"};
    
    public Action() {
        super(ACTION_SIZE);
    }
    
    public Action(int[] data) {
        super(data);
    }    

    @Override
    public Action clone() {
        Action new_action = new Action(data);
        return new_action;
    }
    
    public void randomize() {
        data[0] = Misc.nextInt(MAX_ACTIONS);
    }

    public void mutate(double mutation_probability) {
        if(Misc.nextDouble() < mutation_probability) {
            data[0] = Misc.nextInt(MAX_ACTIONS);
        }
    }
    
    public int getDirection() {
        return data[0];
    }
    
   @Override
    public String toString() {
        String output = new String();
        for(int i = 0; i < data.length; i++) {
            output += "" + Grid.shortDirectionString[data[i]];//actionString[data[i]];
        }        
        return output;
    }

}