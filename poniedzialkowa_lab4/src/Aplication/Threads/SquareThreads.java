package Aplication.Threads;

import Aplication.Components.WorkPanel;

public class SquareThreads extends FIgures {
    private int bok;
    private int wielokrotnosc = 60;
    public SquareThreads(int x, int y, WorkPanel workPanel) {
        super(x,y,workPanel);

    }

    @Override
    protected void apply(FiguresVisitor figuresVisitor) {
        figuresVisitor.visitSquareThread(this);
    }
    public int getPromien() {
        return 0;
    }

    @Override
    public synchronized void run() {
        super.run();
        while(true) {
            getWorkPanel().repaint();
            bok += 2;
            x -= 1;
            y -= 1;
            try {
                sleep(100);
                if (bok > wielokrotnosc) {
                    bok -= 2;
                    wielokrotnosc *= 2;
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getBok() {
        return bok;
    }
}
