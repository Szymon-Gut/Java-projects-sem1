package Aplication.Threads;

import Aplication.Components.WorkPanel;

public abstract class FIgures extends Thread{
    public int x;
    public int y;
    private int id;
    private static int counter;
    private WorkPanel workPanel;
    public FIgures(int x, int y, WorkPanel workPanel) {
        this.x = x;
        this.y = y;
        counter += 10;
        this.id = counter;
        this.workPanel = workPanel;
    }

    protected abstract void apply(FiguresVisitor figuresVisitor);
    public abstract int getPromien();

    @Override
    public long getId() {
        return id;
    }

    public WorkPanel getWorkPanel() {
        return workPanel;
    }

}
