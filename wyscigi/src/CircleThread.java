import javax.swing.*;
import java.util.Random;

public class CircleThread extends  Thread{
    private Tory tory;
    private int x;
    private int y;
    private JButton dalejButton;
    private int id;
    private static int counter;
    public static boolean[] isStopped = new boolean[2] ;

    public CircleThread(Tory tory, int x, int y, JButton dalejButton) {
        this.tory = tory;
        this.x = x;
        this.y = y;
        this.id = counter++;
        this.dalejButton = dalejButton;
    }

    @Override
    public synchronized void run() {
        super.run();
        int iter = 1;
        while (y <= 400) {
            if (y == 200) {
                try {
                    isStopped[id] = true;
                    checkIfStopped();
                    y += 1;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            y+= iter;
            int tmp = new Random().nextInt(100);
            if (tmp > 90) {
                tmp += 300;
            } else if (tmp > 70) {
                tmp += 100;
            } else if (tmp < 20) {
                tmp = 1;
            }
            try {
                sleep(tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tory.repaint();
            if (y == 395) {
                System.out.println("Brawo. Wygrał: " + id + " gracz!");
                break;

            }
        }
    }
    private boolean checkIfStopped() {
        for (boolean b : isStopped) {
            if (!b) {
                System.out.println("nieaktywowane");
                System.out.println(isStopped);
                return false;
            }
        }
        System.out.println("Aktywowane");
        dalejButton.setEnabled(true);
        return true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
