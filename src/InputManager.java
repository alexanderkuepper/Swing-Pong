import helper.Vector2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    public final static InputManager inputManager = new InputManager();
    private final Vector2D direction = new Vector2D(0,0);

    public Vector2D getDirection() {
        return direction;
    }

    static public InputManager getInstance() {
        return inputManager;
    }
    private InputManager() {}

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Hello");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_RIGHT) {
            direction.X = 1;
        }
        if(code == KeyEvent.VK_LEFT) {
            direction.X = -1;
        }
        if(code == KeyEvent.VK_UP) {
            direction.Y = -1;
        }
        if(code == KeyEvent.VK_DOWN) {
            direction.Y = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_RIGHT) {
            direction.X = 0;
        }
        if(code == KeyEvent.VK_LEFT) {
            direction.X = 0;
        }
        if(code == KeyEvent.VK_UP) {
            direction.Y = 0;
        }
        if(code == KeyEvent.VK_DOWN) {
            direction.Y = 0;
        }
    }
}
