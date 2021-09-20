package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton restartButton;
    private JButton saveButton;
    private JButton quitButton;
    private JButton load1Button;
    private JButton load2Button;
    private JButton load3Button;
    private JButton loadButton;
    private GameLevel level;
    public Game game;

    private Hero hero;
    public ControlPanel(Hero hero, Game game) {
        this.hero = hero;
        this.game = game;
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You Quit the game!");
                System.exit(0);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameSaverLoader.save(game.getLevel(), "data/save.txt" );
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero.setPosition(new Vec2(8, -10));

            }
        });
        load1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.stop();
                level = new Level1(game);
                level.start();
            }
        });
        load2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.stop();
                level = new Level2(game);
                level.start();
            }
        });
        load3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.stop();
                level = new Level3(game);
                level.start();

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                    game.setLevel(level);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }

    public JPanel getMainPanel()
    {
        return mainPanel;

    }

}
