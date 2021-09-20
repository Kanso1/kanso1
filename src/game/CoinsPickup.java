package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

public class CoinsPickup implements CollisionListener {
    private Hero hero;
    public CoinsPickup(Hero h){ this.hero = h; }
    @Override
    /**Hero has the ability to pick up a coin*/
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coins) {
            ((Hero)e.getReportingBody()).addCoins();
            e.getOtherBody().destroy();
            System.out.println("YOU COLLECTED THE COIN!");
        }

    }
}
