import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WorkPanel extends JPanel {
    private List<SquareThread> squareThreads = new ArrayList<>();
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (SquareThread squareThread: squareThreads) {
            g.setColor(squareThread.getColor());
            g.fillRect(squareThread.getX(),squareThread.getY(),10,10);
        }

    }
    public void addThreads(SquareThread e) {
        squareThreads.add(e);
    }
    public void stopRectangles() {
        for(SquareThread t : squareThreads) {
            t.stopSquare();
        }
    }
    public void changeBackground() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        this.setBackground(new Color(r,g,b));
    }
    public void removeSquares() {
        squareThreads = new ArrayList<>();
    }

}
