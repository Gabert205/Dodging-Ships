import java.util.ArrayList;
import java.util.List;

public class Fleet {
    public List<Ship> ships;

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

    public void update(){
        for(int i = 0 ; i < ships.size() ; i++){
            ships.get(i).update();
        }
    }

    //==================================================================================================================

    public void draw(){
        for(int i = 0 ; i < ships.size() ; i++){
            if(ships.get(i).isTouchingMouse()){
                ships.get(i).draw(StdDraw.RED);
            }
            else{
                ships.get(i).draw(StdDraw.BLACK);
            }
        }
    }
}
