package Aplication.Components;

import Aplication.Threads.CircleThreads;
import Aplication.Threads.FIgures;
import Aplication.Threads.SquareThreads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WorkPanel extends JPanel {
    private ArrayList<FIgures> fIgures = new ArrayList<>();


    public WorkPanel() {

        this.setMaximumSize(new Dimension(600,550));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(MouseEvent.BUTTON1 == e.getButton()) {
                    SquareThreads squareThreads = new SquareThreads(e.getX(),e.getY(),getWorkPanel());
                    squareThreads.start();
                    fIgures.add(squareThreads);

                } else if (MouseEvent.BUTTON3 == e.getButton()) {
                    CircleThreads circleThreads = new CircleThreads(e.getX(),e.getY(),getWorkPanel());
                    circleThreads.start();
                    fIgures.add(circleThreads);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0,0,0));
        paintThread(g);
    }

    private void paintThread(Graphics g) {
        for(FIgures fIgures : fIgures) {
            if (fIgures instanceof SquareThreads) {
                g.setColor(new Color(14, 14, 227));
                g.drawRect(fIgures.x,fIgures.y, ((SquareThreads) fIgures).getBok(),((SquareThreads) fIgures).getBok());
            } else if (fIgures instanceof CircleThreads) {
                g.setColor(new Color(37, 238, 15));
                g.drawOval(fIgures.x,fIgures.y,((CircleThreads) fIgures).getPromien(),((CircleThreads) fIgures).getPromien());
            }
            g.drawString(new String("My id: " + fIgures.getId()),fIgures.x,fIgures.y);

        }
    }

    public ArrayList<FIgures> getfIgures() {
        return fIgures;
    }
    private WorkPanel getWorkPanel() {
        return this;
    }
}
