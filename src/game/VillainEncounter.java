package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/** Hero encounters Vilain*/

public class VillainEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;
    private static SoundClip villainSound;
    static{
        try{
            villainSound = new SoundClip("data/villainSFX.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }
    private static SoundClip villainSound2;
    static{
        try{
            villainSound2 = new SoundClip("data/villainSFX2.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /**
     * Hero encounter the villain
     * <p>
     * When hero encounter the villain many things occur.
     *
     * @param  level Level that user will be on after encountering villain.
     * @param  game Game switches level.
     * @return nothing
     */

    public VillainEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Villain
                && level.isComplete()){
            villainSound.play();
            game.goToNextLevel();
        }
        if (e.getOtherBody() instanceof Villain){
            villainSound2.play();
        }
    }
}