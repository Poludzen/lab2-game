
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private Ball ball;
    private Racket racket;
    private int score = 0;
    public GamePanel(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                racket.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racket.keyReleased();
            }
        });
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Racket getRacket() {
        return racket;
    }

    public void setRacket(Racket racket) {
        this.racket = racket;
    }

    public void move(){
        ball.move();
        racket.move();
    }
    public void gameOver(){
        int dialogResult = JOptionPane.showConfirmDialog (null,
                "Game Over!!\nScore = "+score+"\nRepeat?","GAME OVER",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION){
            score = 0;
            ball.setDefaultParameters();
            racket.setDefaultParameters();
        }
        else if(dialogResult==JOptionPane.NO_OPTION || dialogResult==JOptionPane.CLOSED_OPTION){
            System.exit(0);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racket.paint(g2d);
    }


}
