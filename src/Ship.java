import java.awt.*;

public class Ship {
    private Vector pos;
    private Vector vel;
    private Vector acc;
    public int age;

    public Ship(double posX, double posY){
        pos = new Vector(posX, posY);
        vel = new Vector(Math.random() * 2 - 1, Math.random() * 2 - 1);
        acc = new Vector();
        age = 0;
    }

    //==================================================================================================================

    private double distance(double x1, double y1){
        return Math.sqrt( Math.pow( pos.getX() - x1, 2) + Math.pow( pos.getY() - y1, 2));
    }

    public boolean isTouchingMouse(){
        return distance(StdDraw.mouseX(), StdDraw.mouseY()) <= 1 / 60.;
    }

    public void update(){
        acc = pos.differenceVector(new Vector( StdDraw.mouseX(), StdDraw.mouseY() ));
        vel.update(acc.scaledVector(.5));

        //capping the speed
        if(vel.magnitude() > 1){
            vel = vel.unitVector();
        }

        pos.update(vel.scaledVector(.001));

        pos.setX((pos.getX() + 1) % 1);
        pos.setY((pos.getY() + 1) % 1);

        draw(StdDraw.BLACK);
    }

    //==================================================================================================================

    public void draw(Color color){
        double[] posX = new double[3];
        double[] posY = new double[3];
        double direction = vel.getRadian();
        double rand = + Math.random() / 2 - .25;

        posX[0] = -Math.cos(direction + rand) / 50 + pos.getX();
        posX[1] = Math.cos(direction + 2.0944) / 100 + pos.getX();
        posX[2] = Math.cos(direction + 4.1888) / 100 + pos.getX();

        posY[0] = -Math.sin(direction + rand) / 50 + pos.getY();
        posY[1] = Math.sin(direction + 2.0944) / 100 + pos.getY();
        posY[2] = Math.sin(direction + 4.1888) / 100 + pos.getY();

        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);

        StdDraw.filledPolygon(posX, posY);

        //drawing the ship
        posX[0] = Math.cos(direction) / 30 + pos.getX();
        posX[1] = Math.cos(direction + 2.0944) / 60 + pos.getX();
        posX[2] = Math.cos(direction + 4.1888) / 60 + pos.getX();

        posY[0] = Math.sin(direction) / 30 + pos.getY();
        posY[1] = Math.sin(direction + 2.0944) / 60 + pos.getY();
        posY[2] = Math.sin(direction + 4.1888) / 60 + pos.getY();

        StdDraw.setPenColor(color);

        StdDraw.filledPolygon(posX, posY);
    }
}
