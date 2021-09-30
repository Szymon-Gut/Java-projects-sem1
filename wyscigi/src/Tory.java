import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tory extends JPanel {
    private Tor tor1;
    private Tor tor2;
    public int srednica = 10;
    private ArrayList<CircleThread> watki = new ArrayList<>();

    public Tory() {
        tor1 = new Tor(this);
        tor2 = new Tor(this);
        JLabel gracz1 = new JLabel("1");
        tor1.add(gracz1);
        JLabel gracz2 = new JLabel("2");
        tor2.add(gracz2);
        tor1.setBackground(Tor.defaultColor);
        tor2.setBackground(Tor.defaultColor);
        this.setLayout(new GridLayout(1,2,0,0));
        tor1.setMaximumSize(new Dimension(100,400));
        tor2.setMaximumSize(new Dimension(100,400));
        this.add(tor1);
        this.add(tor2);
    }
    private void rysujLinie(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.drawLine(0, 200, 200, 200);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        rysujLinie(g);
        rysujPozycjeKolka(g);
    }

    public ArrayList<CircleThread> getWatki() {
        return watki;
    }

    public void setWatki(ArrayList<CircleThread> watki) {
        this.watki = watki;
    }
    public void rysujPozycjeKolka(Graphics g) {
        for (CircleThread circleThread : watki) {
            g.drawOval(circleThread.getX(),circleThread.getY(),srednica,srednica);
        }
    }
    public void wystartujWatki()  {
        for (CircleThread circleThread : watki) {
            circleThread.start();
        }
    }
    public void obudzWatki() {
        for (CircleThread circleThread : watki) {
            synchronized (circleThread) {
                circleThread.notify();
            }
        }
    }
}
