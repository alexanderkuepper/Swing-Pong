import helper.Vector2D;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    static final int screenWidth = 400;
    static final int screenHeight = 400;
    final int FPS = 60;
    Thread gameThread;

    Player player = new Player(new Vector2D(20,20));
    Ball ball = new Ball(new Vector2D(300, 70));

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(InputManager.getInstance());
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000. / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update() {
       player.update();
       ball.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        player.draw(g);
        g.dispose();
    }
}
