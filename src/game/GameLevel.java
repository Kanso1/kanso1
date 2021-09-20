package game;

import city.cs.engine.World;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/**Cointains everything each game level needs*/
public abstract class GameLevel extends World {

    private Hero hero;
    private Villain villain;
    private Coins coin;

    /**
     * Adds all Objects and Characters to the world.
     * <p>
     * Ensures that each level has all the objects needed.
     *
     * @param  game Game that is being played.
     * @return nothing
     */

    public GameLevel(Game game){

        hero = new Hero(this);
        villain = new Villain(this);
        coin = new Coins(this);
        VillainEncounter encounter = new VillainEncounter(this,game);
        hero.addCollisionListener(encounter);
    }
    /**  Hero is being added. */
    public Hero getHero(){return hero; }
    /**  Villain is being added. */
    public Villain getVillain(){return villain; }
    /**  Coin is being added. */
    public Coins getCoins(){return coin;}

    /**  If game is complete user moves on to next level. */
    public abstract boolean isComplete();

    public abstract String getLevelName();



}
