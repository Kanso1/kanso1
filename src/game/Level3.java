package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
/**Level3 is made*/

public class Level3  extends GameLevel implements ActionListener {
    private Box box;
    private SoundClip gameMusic;
    public Level3(Game game) {
        super(game);

        box = new Box(this);
        box.setPosition(new Vec2(11, 4 ));
        getCoins().setPosition(new Vec2(30,11));
        getHero().setPosition(new Vec2(16, -12.4f));
        getVillain().setPosition(new Vec2(-26.8f, 11));

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

        Shape platform_2 = new BoxShape(35, 0.4f);
        StaticBody platform2 = new StaticBody(this, platform_2);
        platform2.setPosition(new Vec2(35.5f, 1.7f));

        Shape ground_2 = new BoxShape(2, 0.4f);
        StaticBody ground2 = new StaticBody(this, ground_2);
        ground2.setPosition(new Vec2(30, 9));


        StaticBody ground4 = new StaticBody(this, ground_2);
        ground4.setPosition(new Vec2(-27f,-2f));

        StaticBody ground5 = new StaticBody(this, ground_2);
        ground5.setPosition(new Vec2(-17.5f, -6.3f));

        StaticBody ground6 = new StaticBody(this, ground_2);
        ground6.setPosition(new Vec2(28, 2.8f));

        StaticBody ground7 = new StaticBody(this, ground_2);
        ground7.setPosition(new Vec2(-26.8f, 10));

        Shape ground_3 = new BoxShape(6.4f, 0.4f);
        StaticBody ground8 = new StaticBody(this, ground_3);
        ground8.setPosition(new Vec2(-11.5f, 1.7f));

        StaticBody ground9 = new StaticBody(this, ground_2);
        ground9.setPosition(new Vec2(-19.15f, 6.9f));



        /**These are the walls of the map*/
        Shape wallShape = new BoxShape(0.5f, 18f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-31.4f, 0));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(31.4f, 0));

        Timer t = new Timer(33000,this);
        t.start();
    }
    @Override
    public boolean isComplete () {
        if (getHero().getCoinCount() == 2)

            return true;
        else
            return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("COLLECT THE NEW COIN");
        Coins c = new Coins(this);
        c.setPosition(new Vec2(20, -14f));
        try {
            gameMusic = new SoundClip("data/CoinDropSFX.wav");
            gameMusic.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
            System.out.println(e);
        }
    }

    @Override
    public String getLevelName() {
        return "Level 3";
    }
}
