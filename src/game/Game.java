package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private HeroController controller;

    private SoundClip gameMusic;

    private int coinCount;


    /** Actual Game. */
    public Game() {

        // make the world
        level = new Level1(this);


        // make a view
        view = new GameView(level, this, 500, 500);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        //view.addMouseListener(new MouseHandler1(world, view));
        controller = new HeroController(level.getHero(),this);
//        HeroController controller = new HeroController(level.getHero());
        view.addKeyListener(controller);

        //MouseHandler1 mh = new MouseHandler1(world, view);
        view.addMouseListener(new GiveFocus(view));
        /**Use this for the tracker*/
        //Tracker tracker = new Tracker(view, world.getHero());
        //world.addStepListener(tracker);

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Kanso's world");
        frame.add(view);

        UserView wideView = new UserView(level, 150, 200);
        wideView.setZoom(3);
        frame.add(wideView, BorderLayout.EAST);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        JFrame window = new JFrame("My Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        Game game = new Game();
//        GameView panel = new GameView(game);
//        window.add(panel, BorderLayout.CENTER);

        ControlPanel controlPanel = new ControlPanel(level.getHero(), this);
        frame.add(controlPanel.getMainPanel(),BorderLayout.WEST);


        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        /**debugging view*/
        //JFrame debugView = new DebugViewer(level, 500, 500);

        // start our game world simulation!
        level.start();


        try {
            gameMusic = new SoundClip("data/GameSound.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

    }
    /**  Level game is set here. */
    public GameLevel getLevel() {return level;}

    public void setLevel(GameLevel level){
        this.level.stop();
        /**create the new level*/
        /**level now refers to new level*/
        this.level = level;
        view.setWorld(this.level);
        //start the simulation in the new level
//        controller.updateHero(level.getHero());
        this.level.start();

    }
    /**  Once one level is completed you move on to the next level. */
    public void goToNextLevel(){

        if (level instanceof Level1){
            /**stop the current level*/
            level.stop();
            /**create the new level*/
            /**level now refers to new level*/
            level = new Level2(this);
            view.setWorld(level);
            //start the simulation in the new level
            controller.updateHero(level.getHero());
            level.start();
        }
        else if (level instanceof Level2){
            /**stop the current level*/
            level.stop();
            /**create the new level*/
            /**level now refers to new level*/
            level = new Level3(this);
            view.setWorld(level);
            //start the simulation in the new level
            controller.updateHero(level.getHero());
            level.start();
        }

        else if (level instanceof Level3){
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }


//    public  GameLevel getLevel(){
//        return level;
//    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();

    }

    /**  Number of coins collected is counted. */
    public int getCoinCount(){
        return  coinCount; }


}
