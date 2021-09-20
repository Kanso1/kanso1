package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/**Save and Load Abilities*/


public class GameSaverLoader {

    /**
     * Saves a game to a file
     * <p>
     * Saves the whole state
     *
     * @param  level Level that user will be in.
     * @param  fileName File where you want to save.
     * @return nothing
     */
    public static void save(GameLevel level, String fileName)
            throws IOException
    {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "," + level.getHero().getCoinCount() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    /**
     * Loads a game file
     * <p>
     * Saves the whole state
     *
     * @param  game Game that you are in.
     * @param  fileName File that you would like to load.
     * @return nothing
     */

    public static GameLevel load(Game game, String fileName)
        throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int coinCount = Integer.parseInt(tokens[1]);
            GameLevel level = null;
            if(name.equals("Level 1"))
                level = new Level1(game);
            else if (name.equals("Level 2"))
                level = new Level2(game);

            level.getHero().setCoinCount(coinCount);

            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

    }

}
