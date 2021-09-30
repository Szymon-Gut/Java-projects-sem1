package Aplication.Threads;

import Aplication.Components.WorkPanel;

public class CircleThreads extends FIgures {
    private int promien;
    private int wielokrotnosc = 100;

    public CircleThreads(int x, int y, WorkPanel workPanel) {
        super(x,y,workPanel);
    }

    @Override
    protected void apply(FiguresVisitor figuresVisitor) {
        figuresVisitor.visitCircleThread(this);
    }

    @Override
    public synchronized void run() {
        super.run();
        while(true) {
            this.getWorkPanel().repaint();
            promien += 2;
            try {
                Thread.sleep(100);
                if (promien > wielokrotnosc) {
                    wielokrotnosc *= 2;
                    x -= 1;
                    y -= 1;
                    promien -= 2;
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPromien() {
        return promien;
    }
}
