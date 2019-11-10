import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Screen {
    private String mode;
    private List<Button> buttons;
    private boolean done;
    private Fleet fleet;

    public Screen(){
        mode = "startup";
        buttons = new ArrayList<>();
        fleet = new Fleet(0);
        buttons.add(new Button(.5, .5, .2, .1,
                "Start Game", new Font(Font.SANS_SERIF, Font.BOLD, 18), StdDraw.GRAY, "game_start"));
        done = false;
    }

    //==================================================================================================================

    //region Gets and Sets
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public void addButton(Button button){
        buttons.add(button);
    }

    public void clearButtons(){
        buttons.clear();
    }
    //endregion

    //==================================================================================================================

    public void run(){
        while (true){
            StdDraw.clear();

            switch (mode) {
                case "startup":
                    startup();
                    break;
                case "gameplay":
                    gameplay();
                    break;
                case "game_over":
                    gameOver();
                    break;
            }

            draw();
        }
    }

    public void startup(){
        if(buttons.get(0).checkClick()){
            buttons.clear();
            mode = "gameplay";
            draw();
        }
    }

    public void gameplay(){
        done = false;
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                fleet.addShip();

                if(done) {
                    timer.cancel();
                    fleet.ships.clear();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 100);

        loop: while(true){
            StdDraw.clear();

            for(int i = 0 ; i < fleet.ships.size() ; i++){
                if(fleet.ships.get(i).isTouchingMouse()) break loop;
            }

            fleet.update();

            draw();
        }

        mode = "game_over";
    }

    public void gameOver(){
        fleet.ships.clear();
        buttons.add(new Button(.5, .5, .2, .1,
                "Start Game", new Font(Font.SANS_SERIF, Font.BOLD, 18), StdDraw.GRAY, "game_start"));
        done = true;
        mode = "startup";
    }

    //==================================================================================================================

    public void draw(){
        for(Button button : buttons){
            button.draw();
        }

        fleet.draw();

        StdDraw.show();
    }
}
