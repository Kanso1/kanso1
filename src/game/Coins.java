package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/**The Coin is made here*/

public class Coins extends DynamicBody {

    private static final Shape coinshape = new CircleShape(1);
    private static SoundClip coinSound;
    static{
        try{
            coinSound = new SoundClip("data/coinSFX.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    private static final BodyImage image =
            new BodyImage("data/coin.png", 2f);

    public Coins(World w) {
        super(w,coinshape);
        addImage(image);

    }
    @Override
    public void destroy()
    {
        coinSound.play();
        super.destroy();

    }

}
