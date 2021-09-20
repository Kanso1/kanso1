package game;

import city.cs.engine.*;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */
/**Hero is created here*/
public class Hero extends Walker {
    private static final Shape heroShape = new PolygonShape(
            -0.11f,1.48f,
            0.88f,1.48f,
            0.99f,0.29f,
            0.24f,-1.8f,
            -1.14f,-1.8f,
            -1.24f,1.21f);

    private static final BodyImage image =
            new BodyImage("data/hero.png", 4f);
    private int coinCount;

    /**
     * Hero is added to the world.
     * @param  world World the hero will be in.
     * @return nothing
     */

    public Hero(World world) {
        super(world, heroShape);
        addImage(image);

    }

    //Coincount allows the user to keep track of how many coins have been collected in the print section.
    public void addCoins(){
        coinCount++;
        System.out.println("Becoming richer: " +
                "Coins collected on this level = " + coinCount);
    }

    public int getCoinCount(){
        return coinCount;

    }

    public void setCoinCount(int bc){
        coinCount = bc;
    }


}