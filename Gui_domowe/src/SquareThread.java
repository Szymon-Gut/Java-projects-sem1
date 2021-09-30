import java.awt.*;
import java.util.Random;

public class SquareThread extends  Thread{
    Random random = new Random();
    private boolean draw = true;
    private Color color;
    private WorkPanel workPanel;
    private int x;
    private int y;
    private int dirx;
    private int diry;

    public SquareThread(Color color, WorkPanel workPanel) {
        this.color = color;
        this.workPanel = workPanel;
        workPanel.addThreads(this);
        this.x = random.nextInt(380);
        this.y =  random.nextInt(380);
        this.dirx = random.nextInt(5)-2;
        this.diry = random.nextInt(5)-2;
    }

    @Override
    public void run() {
        super.run();
        while(draw) {
            workPanel.repaint();
            try {
                sleep(30);
                checkCollision();
                this.x += dirx;
                this.y += diry;

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
    public void stopSquare() {
        this.draw = false;
    }
    public void checkCollision() {
        if (x >= 390){
            dirx = -dirx;
        } else if (x <= 0) {
            dirx = -dirx;
        }
         else if (y >= 390) {
            diry= -diry;
        } else if ( y <= 0) {
            diry = -diry;
        }
    }
}
