import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Fleet {
    public List<Ship> ships;
    private final Color SHIP_COLOR = new Color(0x404040);

    public Fleet(int size){
        ships = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if(Math.random() > .5){
                ships.add(new Ship( Math.random(), Math.round( Math.random() ) ));
            }
            else{
                ships.add(new Ship( Math.round(Math.random() ), Math.random() ));
            }
        }
    }

    //==================================================================================================================

    public void addShip(){
        if(Math.random() > .5){
            ships.add(new Ship( Math.random(), Math.round( Math.random() ) ));
        }
        else{
            ships.add(new Ship( Math.round(Math.random() ), Math.random() ));
        }
    }

    //==================================================================================================================

    public void update(int maxAge){
        for(int i = 0 ; i < ships.size() ; i++){
            if(ships.get(i).age++ > maxAge){
                ships.remove(i);
                i--;
                continue;
            }
            ships.get(i).update();
        }
    }

    //==================================================================================================================

    public void draw(boolean game){
        for(int i = 0 ; i < ships.size() ; i++){
            if(game) {
                if (ships.get(i).isTouchingMouse()) {
                    ships.get(i).draw(StdDraw.RED);
                } else {
                    ships.get(i).draw(SHIP_COLOR);
                }
            }
            else {
                ships.get(i).draw(SHIP_COLOR);
            }
        }
    }
}
