package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/**This is where the hero controls are made*/
public class HeroController implements KeyListener {

   private static final float WALKING_SPEED = 6;


    private Hero hero;
    public Game game;

    /**
     * Hero controls are made here.
     * <p>
     * Ensures that user can control the hero.
     *
     * @param  s Hero will use these controls.
     * @param  game Game where the hero will be able to use the controls.
     * @return nothing
     */

    public HeroController(Hero s, Game game){
       this.hero = s;
       this.game = game;
    }



    @Override
    public void keyTyped(KeyEvent e) {
    }
/**User presses certain keys which enable the hero to move and jump*/
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            hero.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_D) {
            hero.startWalking(WALKING_SPEED);
        }else if (code == KeyEvent.VK_W){
            hero.jump(10);
        }
        else if (code == KeyEvent.VK_S){
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt" );
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            hero.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            hero.stopWalking();
        }
    }
    public void updateHero(Hero hero) {this.hero = hero; }
}
