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
    private long score;
    private final Color SPACE_COLOR = new Color(0x000040);
    private final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 30);
    private final Font SUBTITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 24);
    private int timeDelay = 100;

    public Screen(){
        mode = "startup";
        buttons = new ArrayList<>();
        fleet = new Fleet(0);
        buttons.add(new Button(.5, .5, .2, .1,
                "Start Game", new Font(Font.SANS_SERIF, Font.BOLD, 18), StdDraw.DARK_GRAY, "game_start"));
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
        startScreenAddShips();

        while (true){
            StdDraw.clear(SPACE_COLOR);

            switch (mode) {
                case "startup":
                    startup();
                    fleet.update(5000);
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
            fleet.ships.clear();
            mode = "gameplay";
            draw();
        }
    }

    public void gameplay(){
        score = 0;
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
        timer.scheduleAtFixedRate(task,1500, timeDelay);

        loop: while(true){
            StdDraw.clear(SPACE_COLOR);

            for(int i = 0 ; i < fleet.ships.size() ; i++){
                if(fleet.ships.get(i).isTouchingMouse()) break loop;
            }

            score += fleet.ships.size();

            fleet.update( timeDelay * 15 );

            draw();
        }

        mode = "game_over";
    }

    public void gameOver(){
        while (!StdDraw.isMousePressed());
        while (StdDraw.isMousePressed());
        fleet.ships.clear();
        buttons.add(new Button(.5, .5, .2, .1,
                "Start Game", new Font(Font.SANS_SERIF, Font.BOLD, 18), StdDraw.DARK_GRAY, "game_start"));
        done = true;
        mode = "startup";
        startScreenAddShips();
    }

    public void startScreenAddShips(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                fleet.addShip();

                if(!mode.equals("startup")) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    //==================================================================================================================

    public void draw(){
        fleet.draw(!mode.equals("startup"));

        for(Button button : buttons){
            button.draw();
        }

        StdDraw.setPenColor(StdDraw.WHITE);

        if(mode.equals("startup")){
            StdDraw.setFont(TITLE_FONT);
            StdDraw.text(.5, .85, "Dodging Ships");

            StdDraw.setFont(SUBTITLE_FONT);
            //StdDraw.text(.5, .78, "Crazy Galaxy Studios");
        }

        if(score > 0){
            StdDraw.textLeft(0.01, .975, String.format("%,d", score));
        }

        StdDraw.show();
    }
}
