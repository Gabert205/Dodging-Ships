import java.awt.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(700,700);
        Screen screen = new Screen();
        screen.run();
        /*
        Fleet fleet = new Fleet(5);
        while (true){
            StdDraw.clear();
            fleet.update();
            fleet.draw();
            StdDraw.show();
        }

        // */
    }
}
