
import java.awt.*;

public class Ball {
    private final int diameter = 30;
    private int x_pos ;
    private int y_pos ;
    private int x_direction ;
    private int y_direction ;
    private int speed;
    private GamePanel gamePanel;

    public Ball(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.setDefaultParameters();
    }
    public void setDefaultParameters(){
        x_pos = 30;
        y_pos = 30;
        x_direction = 1;
        y_direction = 1;
        speed=1;
    }

    public void move() {
        if (x_pos + x_direction*speed > gamePanel.getWidth() - diameter) {
            x_direction = -1;

        }
        else if (x_pos + x_direction  < 0) {
            gamePanel.gameOver();
        }

        if (y_pos + y_direction*speed < 0) {
            y_direction = 1;
        }
        else if (y_pos + y_direction*speed > gamePanel.getHeight() - diameter) {
            y_direction = -1;
        }

        if(this.ifClashedWithRacket()){
            x_direction = 1;
            x_pos = gamePanel.getRacket().getX_pos() + diameter/2;
            speed +=1;
            gamePanel.setScore(speed*100);
        }
        x_pos += x_direction*speed;
        y_pos += y_direction*speed;
    }
    public void paint(Graphics2D g2d){
        g2d.fillOval(x_pos,y_pos,diameter,diameter);
    }
    public Rectangle getBounds() {
        return new Rectangle(x_pos, y_pos, diameter, diameter);
    }
    public boolean ifClashedWithRacket(){
        return gamePanel.getRacket().getBounds().intersects(this.getBounds());
    }

}
