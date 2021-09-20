package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */
/**Level1 is made*/


public class Level1  extends GameLevel{
    /**
     * Adds all Objects and Characters to the world.
     * <p>
     * Ensures that each level has all the objects needed.
     *
     * @param  game Game where the objects will be added.
     * @return nothing
     */
    public Level1(Game game) {

        super(game);


        getCoins().setPosition(new Vec2(20, -2f));
        getHero().setPosition(new Vec2(8, -10));
        getVillain().setPosition(new Vec2(0, -3.9f));

        getHero().addCollisionListener(new CoinsPickup(getHero()));

        // make the ground (this covers the whole bottom part of the map
        Shape shape = new BoxShape(300f, 0.4f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(8f, -16.4f));

        StaticBody ground1 = new StaticBody(this, shape);
        ground1.setPosition(new Vec2(8f, 16.4f));

        Shape platform_1 = new BoxShape(7f, 0.4f);
        StaticBody platform1 = new StaticBody(this, platform_1);
        platform1.setPosition(new Vec2(-25f, -13f));

        StaticBody platform3 = new StaticBody(this, platform_1);
        platform3.setPosition(new Vec2(-32f, -10));

        Shape platform_2 = new BoxShape(46, 0.4f);
        StaticBody platform2 = new StaticBody(this, platform_2);
        platform2.setPosition(new Vec2(25f, -6.3f));

        Shape ground_2 = new BoxShape(2, 0.4f);
        StaticBody ground2 = new StaticBody(this, ground_2);
        ground2.setPosition(new Vec2(20, -2.6f));

        StaticBody ground3 = new StaticBody(this, ground_2);
        ground3.setPosition(new Vec2(-6f, -3f));


        // make a platform
        /// Shape platform1Shape = new BoxShape(4, 0.5f);
        //StaticBody platform1 = new StaticBody(this, platform1Shape);
        // platform1.setPosition(new Vec2(-9, 6.5f));

        // add another platform here
        // StaticBody platform2 = new StaticBody(this, platform1Shape);
        // platform2.setPosition(new Vec2(5, -2.9f));

        //  StaticBody platform3 = new StaticBody(this, platform1Shape);
        // platform3.setPosition(new Vec2(-17f, -3.9f));

        // add another platform here
        Shape wallShape = new BoxShape(0.5f, 18f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-31.4f, 0));

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(31.4f, 0));




    }


    @Override
    public boolean isComplete () {
        if (getHero().getCoinCount() == 1)

            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "Level 1";
    }


}

