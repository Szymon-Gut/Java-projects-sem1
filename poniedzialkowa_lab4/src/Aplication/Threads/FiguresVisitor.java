package Aplication.Threads;

import Aplication.Threads.CircleThreads;
import Aplication.Threads.SquareThreads;

public interface FiguresVisitor {
    void visitSquareThread(SquareThreads squareThreads);
    void visitCircleThread(CircleThreads circleThreads);
}
