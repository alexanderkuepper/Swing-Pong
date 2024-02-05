import helper.Vector2D;

import javax.swing.text.Position;
import java.awt.*;

public class Ball {
    private final Vector2D position;
    private Vector2D speed = new Vector2D(1,1);
    private final double acceleration = 1.04;
    private int width = 20;
    private int height =  20;

    public Ball(Vector2D position) {
        this.position = position;
    }

    public void update() {

        if(position.Y + height + speed.Y >= GamePanel.screenHeight) {
            position.Y = GamePanel.screenHeight -height;
            speed.Y = speed.Y * -1;
        } else if(position.Y + speed.Y < 0) {
            position.Y = 0;
            speed.Y = speed.Y * -1;
        } else {
            position.Y = (speed.Y + position.Y);
        }

        if(position.X + width + speed.X >= GamePanel.screenWidth) {
            position.X = GamePanel.screenWidth - width;
            speed.X = speed.X * -1;
        } else if(position.X + speed.X < 0) {
            position.X = 0;
            speed.X = speed.X * -1;
        } else {
            position.X = (speed.X + position.X);
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(position.X, position.Y, width,height);
    }
}
