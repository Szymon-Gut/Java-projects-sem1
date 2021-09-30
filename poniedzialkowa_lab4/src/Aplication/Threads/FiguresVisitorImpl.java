package Aplication.Threads;

import Aplication.Threads.CircleThreads;
import Aplication.Threads.FiguresVisitor;
import Aplication.Threads.SquareThreads;

public class FiguresVisitorImpl implements FiguresVisitor {
    @Override
    public void visitSquareThread(SquareThreads squareThreads) {
        squareThreads.getPromien();
    }

    @Override
    public void visitCircleThread(CircleThreads circleThreads) {
        circleThreads.getPromien();
    }
}
