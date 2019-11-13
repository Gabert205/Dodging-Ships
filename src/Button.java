import java.awt.*;

public class Button {
    private String id;
    private double posX;
    private double posY;
    private double halfWidth;
    private double halfHeight;
    private double outlineSize;
    private Color outlineColor;
    private String text;
    private Font font;
    private Color textColor;
    private Color color;

    public Button(double posX, double posY, double halfWidth, double halfHeight, Color color, String id) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.text = "";
        font = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        this.textColor = StdDraw.BLACK;
        this.color = color;
        outlineSize = .0075;
        outlineColor = StdDraw.BLACK;
    }

    public Button(double posX, double posY, double halfWidth, double halfHeight, String text, Color color, String id) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.text = text;
        font = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        this.textColor = StdDraw.BLACK;
        this.color = color;
        outlineSize = .0075;
        outlineColor = StdDraw.BLACK;
    }

    public Button(double posX, double posY, double halfWidth, double halfHeight,
                  String text, Color textColor, Color color, String id) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.text = text;
        this.font = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        this.textColor = textColor;
        this.color = color;
        outlineSize = .0075;
        outlineColor = StdDraw.BLACK;
    }

    public Button(double posX, double posY, double halfWidth, double halfHeight,
                  String text, Font font, Color color, String id) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.text = text;
        this.font = font;
        this.textColor = StdDraw.BLACK;
        this.color = color;
        outlineSize = .0075;
        outlineColor = StdDraw.BLACK;
    }

    public Button(double posX, double posY, double halfWidth, double halfHeight,
                  String text, Font font, Color textColor, Color color, String id) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.text = text;
        this.font = font;
        this.textColor = textColor;
        this.color = color;
        outlineSize = .0075;
        outlineColor = StdDraw.BLACK;
    }

    public Button(double posX, double posY, double halfWidth, double halfHeight, double outlineSize, Color outlineColor,
                  String text, Font font, Color textColor, Color color, String id) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.text = text;
        this.font = font;
        this.textColor = textColor;
        this.color = color;
        this.outlineSize = outlineSize;
        this.outlineColor = outlineColor;
    }

    //==================================================================================================================

    //returns true if the mouse is pressed inside the button's borders
    public boolean checkClick(){
        if(StdDraw.isMousePressed()){
            if(StdDraw.mouseX() >= posX - halfWidth && StdDraw.mouseX() <= posX + halfWidth){
                if(StdDraw.mouseY() >= posY - halfHeight && StdDraw.mouseY() <= posY + halfHeight){
                    return true;
                }
            }
        }

        return false;
    }

    //==================================================================================================================

    public void draw(){
        //draws the button
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(posX, posY, halfWidth, halfHeight);

        //gives the button a outline (just for design)
        StdDraw.setPenColor(outlineColor);
        StdDraw.setPenRadius(outlineSize);
        StdDraw.rectangle(posX, posY, halfWidth, halfHeight);

        StdDraw.setPenColor(textColor);
        StdDraw.setFont(font);
        StdDraw.text(posX, posY, text);
    }
}
