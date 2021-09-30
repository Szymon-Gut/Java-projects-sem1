package pl.edu.pw.mini.po.visitor.shapesvisitor;

import pl.edu.pw.mini.po.MyWorkPanel;

public class Square extends Shape {

	private int bok;
	private int wielokrotnosc = 60;

	public int getBok() {
		return bok;
	}

	public Square(int x, int y, MyWorkPanel workPanel) {
		this.id = counter += 10;
		this.bok = 0;
		this.x = x;
		this.y = y;
		this.workPanel = workPanel;
		this.xNapis = x;
		this.yNapis = y;
	}

	@Override
	protected void apply(ShapeVisitor visitor) {
		visitor.visitSquare(this);
	}

	@Override
	public int doSth() {
		return 0;
	}

	@Override
	public synchronized void run() {
//		System.out.println("My id: " + id);
		while (true) {
			try {
				workPanel.repaint();
				bok += 2;
				x -= 1;
				y -= 1;
				sleep(100);
				if (bok > wielokrotnosc) {
					bok -= 2;
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
