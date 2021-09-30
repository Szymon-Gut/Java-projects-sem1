package pl.edu.pw.mini.po;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import pl.edu.pw.mini.po.visitor.shapesvisitor.Circle;
import pl.edu.pw.mini.po.visitor.shapesvisitor.Shape;
import pl.edu.pw.mini.po.visitor.shapesvisitor.Square;

public class MyWorkPanel extends JPanel {

	private Buttons buttons;

	public Buttons getButtons() {
		return buttons;
	}

	public MyWorkPanel() {

		buttons = new Buttons();
		this.setLayout(new BorderLayout());

		this.add(buttons, BorderLayout.PAGE_END);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (MouseEvent.BUTTON1 == e.getButton()) {
					Square square = new Square(e.getX(), e.getY(), getWorkPanel());
					square.start();
					buttons.arrayList.add(square);
				} else if (MouseEvent.BUTTON3 == e.getButton()) {
					Circle circle = new Circle(e.getX(), e.getY(), getWorkPanel());
					circle.start();
					buttons.arrayList.add(circle);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	protected MyWorkPanel getWorkPanel() {
		return this;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		rysuj(g);
	}

	private void rysuj(Graphics g) {
		for (Shape shape : buttons.arrayList) {
			g.setColor(Color.red);
			g.drawString(new String("My id " + shape.getId()), shape.getxNapis(), shape.getyNapis());
			// mozna uzyc patternu visitor
			if (shape instanceof Square) {
				g.setColor(Color.green);

				g.drawRect(shape.getX(), shape.getY(), ((Square) shape).getBok(), ((Square) shape).getBok());
			} else if (shape instanceof Circle) {
				g.setColor(Color.black);
				g.drawOval(shape.getX(), shape.getY(), ((Circle) shape).getRadius(), ((Circle) shape).getRadius());
			}

		}
	}

}
