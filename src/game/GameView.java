package game;
/*Vidoe to my game*/
/*https://www.youtube.com/watch?v=Ndza7u0s6H0*/

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */
/**contains the layout of the game*/
public class GameView extends UserView {
    private Image background;
    private Game game;
    private Hero hero;




    /**
     * Background is made here
     * Ensures that each level has a background.
     *
     * @param  w World will have the background added.
     * @param  g  Game that every level will have the same background.
     * @return nothing
     */
    public GameView(World w, Game g, int width, int height) {
        super(w, 1280, 680);
        background = new ImageIcon("data/Background.png").getImage();
        game = g;
    }



    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, -5, 4, this);
        g.drawString("GET PAST THE VILLAIN AND COLLECT THE COIN!" , 30 ,50);
        g.drawString("ONCE THE COIN HAS BEEN COLLECTED MEET THE VILLAIN AND GIVE HIM THE COIN. THAT WAY YOU WILL MOVE ON TO THE NEXT LEVEL", 30, 69);
        g.drawString("GOOD LUCK!", 30, 88);
        g.drawString("hint: you can climb on the box to collect the coin", 985, 35 );

    }


    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " +game.getCoinCount(), 985, 60 );/*Game needs to be changed to hero*/
        g.drawString("HighScore: 4",985, 75);
    }


}
