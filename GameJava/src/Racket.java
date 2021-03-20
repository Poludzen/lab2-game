
import java.awt.*;
import java.awt.event.KeyEvent;

public class Racket {
    private final int x_pos = 10;
    private int y_pos ;
    private int y_direction ;
    private final int width = 10;
    private final int height = 60;
    private GamePanel gamePanel;
    public Racket(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.setDefaultParameters();
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setDefaultParameters(){
        y_direction =0;
        y_pos=0;
    }
    public void move() {
        if ((y_pos + y_direction > 0) && (y_pos + y_direction < gamePanel.getHeight()-height)) {
            y_pos += y_direction;
        }
    }
    public Rectangle getBounds() {
        return new Rectangle(x_pos, y_pos, width, height);
    }

    public void paint(Graphics2D g) {
        g.fillRect(x_pos, y_pos, width, height);
    }

    public void keyReleased() {
        y_direction = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            y_direction = -2;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y_direction = 2;
        }
    }
}
