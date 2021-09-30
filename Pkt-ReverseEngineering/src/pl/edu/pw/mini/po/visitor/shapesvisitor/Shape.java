package pl.edu.pw.mini.po.visitor.shapesvisitor;

import pl.edu.pw.mini.po.MyWorkPanel;

public abstract class Shape extends Thread {

	protected static int counter;
	protected int id;
	protected int x, y;
	protected MyWorkPanel workPanel;
	protected int xNapis, yNapis;

	public int getxNapis() {
		return xNapis;
	}

	public int getyNapis() {
		return yNapis;
	}

	protected abstract void apply(ShapeVisitor visitor);

	public abstract int doSth();

	public synchronized void run() {
	}

	public long getId() { // trzeba dac long
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
