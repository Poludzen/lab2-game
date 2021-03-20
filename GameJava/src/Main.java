
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis, score = 0");
        GamePanel game = new GamePanel();
        game.setFocusable(true);
        game.setBall(new Ball(game));
        game.setRacket(new Racket(game));
        frame.add(game);
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            game.move();
            game.repaint();
            frame.setTitle("Mini Tennis , score = "+game.getScore());
            Thread.sleep(10);
        }
    }
}
