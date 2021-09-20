package game;

import city.cs.engine.*;
/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */

/**
 * A Box is created here.
 */

/**
 * @author      Mohamad Kanso, mohamad.kanso@city.ac.uk
 * @version     3.0
 * @since       Mar 2021
 */
public class Box extends Walker {

    private static final Shape boxShape = new PolygonShape(
            1.1f,1.9f,
            1.5f,-0.3f,
            1.5f,-1.8f,
            -1.9f,-1.8f,
            -1.9f,1.69f,
            -0.5f,1.9f);

    private static final BodyImage image =
            new BodyImage("data/Box.png", 3.5f);



    public Box(World world) {
        super(world, boxShape);
        addImage(image);
    }
}