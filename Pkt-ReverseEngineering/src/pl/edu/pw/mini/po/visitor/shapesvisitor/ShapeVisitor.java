package pl.edu.pw.mini.po.visitor.shapesvisitor;

public interface ShapeVisitor {

	void visitSquare(Square square);

	void visitCircle(Circle circle);

}
