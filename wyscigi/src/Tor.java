import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Tor extends JPanel {
    private JPanel tor;
    public Tory tory;
    public static final Color defaultColor = Color.YELLOW;

    public Tor(Tory tory) {
        this.tory = tory;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                changeColorToWhite();
                tory.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                changeColorToDefault();
                tory.repaint();
            }
        });
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int tmp = tory.srednica + (int) e.getWheelRotation();
                if (tmp < 50 && tmp > 1) {
                    tory.srednica += (int) e.getWheelRotation();
                }
            }
        });
    }
    protected void changeColorToWhite() {
        this.setBackground(new Color(255,255,255));
    }
    protected void changeColorToDefault() {
        this.setBackground(defaultColor);
    }
}
