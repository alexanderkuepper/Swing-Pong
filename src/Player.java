import helper.Vector2D;

import java.awt.*;

public class Player {
    private final Vector2D position;
    private final int SPEED = 3;
    private final int width = 60;
    private final int height = 20;

    public Player(Vector2D position) {
        this.position = position;
    }

    public void update() {
        Vector2D direction = InputManager.getInstance().getDirection();
        int stepSize = direction.X * SPEED;

        if(direction.X == -1 && stepSize + position.X < 0) {
            position.X = 0;
        } else {
            position.X += stepSize;
        }

        if(direction.X == 1 && stepSize + position.X + width  > GamePanel.screenWidth) {
            position.X = GamePanel.screenWidth - width;
        } else {
            position.X += stepSize;
        }

    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(position.X, GamePanel.screenHeight-height, width,height);
    }


}
