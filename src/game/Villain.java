package game;

import city.cs.engine.*;



/**Villain is made here*/
public class Villain extends Walker {

    private static final Shape villainShape = new PolygonShape(
            1.82f,2f,
            1.97f,-0.3f,
            1.5f,-2.36f,
            -0.47f,-2.33f,
            -1.98f,1.69f,
            -0.5f,2.46f);


    private static final BodyImage image =
            new BodyImage("data/villain.png", 6f);



    public Villain(World world) {
        super(world, villainShape);
        addImage(image);
    }
}
