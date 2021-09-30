package pl.edu.pw.mini.po.visitor.shapesvisitor;

import pl.edu.pw.mini.po.MyWorkPanel;

public class Circle extends Shape {

	private int radius;
	private int wielokrotnosc = 100;

	public int getRadius() {
		return radius;
	}

	public Circle(int x, int y, MyWorkPanel workPanel) {
		this.id = counter += 10;
		this.radius = 0;
		this.x = x;
		this.y = y;
		this.workPanel = workPanel;
		this.xNapis = x;
		this.yNapis = y;
	}

	@Override
	protected void apply(ShapeVisitor visitor) {
		visitor.visitCircle(this);
	}

	@Override
	public int doSth() {
		return radius;
	}

	@Override
	public synchronized void run() {
//		System.out.println("My id: " + id);
		while (true) {
			try {
				workPanel.repaint();
				radius += 2;
				x -= 1;
				y -= 1;
				sleep(100);
				if (radius > wielokrotnosc) {
					radius -= 2;
					wielokrotnosc *= 2;
					this.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("siemano kolano");
			}
		}
	}

}
