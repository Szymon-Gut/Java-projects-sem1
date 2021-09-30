package pl.edu.pw.mini.po.visitor.shapesvisitor;

public class ShapeVisitorImpl implements ShapeVisitor {

	@Override
	public void visitSquare(Square square) {
		square.doSth();
	}

	@Override
	public void visitCircle(Circle circle) {
		circle.doSth();
	}

}
