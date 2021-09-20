package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**Level2 is made*/
public class Level2  extends GameLevel {
    private Box box;
    public Level2(Game game) {
        super(game);

        box = new Box(this);


        box.setPosition(new Vec2(11, 4 ));
        getCoins().setPosition(new Vec2(30,11));
        getHero().setPosition(new Vec2(11, -10));
        getVillain().setPosition(new Vec2(29, -15f));

        getHero().addCollisionListener(new CoinsPickup(getHero()));

        /**Start the ground and ceiling of the map*/
        Shape shape = new BoxShape(300f, 0.4f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(8f, -16.4f));

        StaticBody ground1 = new StaticBody(this, shape);
        ground1.setPosition(new Vec2(8f, 16.4f));
        /**End of the ground and ceiling of map*/

        Shape platform_1 = new BoxShape(7f, 0.4f);
        StaticBody platform1 = new StaticBody(this, platform_1);
        platform1.setPosition(new Vec2(-24f, -12f));

        StaticBody platform3 = new StaticBody(this, platform_1);
        platform3.setPosition(new Vec2(-32f, -8.8f));

        Shape platform_2 = new BoxShape(46, 0.4f);
        StaticBody platform2 = new StaticBody(this, platform_2);
        platform2.setPosition(new Vec2(27.5f, 1.7f));

        Shape ground_2 = new BoxShape(2, 0.4f);
        StaticBody ground2 = new StaticBody(this, ground_2);
        ground2.setPosition(new Vec2(30, 9));

//        StaticBody ground3 = new StaticBody(this, ground_2);
//        ground3.setPosition(new Vec2(-6f, -3f));

        StaticBody ground4 = new StaticBody(this, ground_2);
        ground4.setPosition(new Vec2(-27f,-2f));

        StaticBody ground5 = new StaticBody(this, ground_2);
        ground5.setPosition(new Vec2(-17.5f, -6.3f));

        StaticBody ground6 = new StaticBody(this, ground_2);
        ground6.setPosition(new Vec2(28, 2.8f));


        // make a platform
        /// Shape platform1Shape = new BoxShape(4, 0.5f);
        //StaticBody platform1 = new StaticBody(this, platform1Shape);
        // platform1.setPosition(new Vec2(-9, 6.5f));

        // add another platform here
        // StaticBody platform2 = new StaticBody(this, platform1Shape);
        // platform2.setPosition(new Vec2(5, -2.9f));

        //  StaticBody platform3 = new StaticBody(this, platform1Shape);
        // platform3.setPosition(new Vec2(-17f, -3.9f));

        /**These are the walls of the map*/
        Shape wallShape = new BoxShape(0.5f, 18f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-31.4f, 0));

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
        return "Level 2";
    }
}
