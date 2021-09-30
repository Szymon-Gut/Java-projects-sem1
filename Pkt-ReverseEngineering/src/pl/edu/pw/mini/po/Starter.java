package pl.edu.pw.mini.po;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import pl.edu.pw.mini.po.visitor.shapesvisitor.Circle;
import pl.edu.pw.mini.po.visitor.shapesvisitor.Shape;
import pl.edu.pw.mini.po.visitor.shapesvisitor.Square;

public class Starter {

	private MyWorkPanel workpanel;

	public static void main(String[] args) {

		Starter starter = new Starter();
		starter.go();
	}

	private void go() {
		JFrame jFrame = new JFrame("Hubert Bujakowski - moja pierwsza oceniana ramka!");
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jFrame.setSize(new Dimension(700, 700));
//		jFrame.pack();

		jFrame.setJMenuBar(getMainJMenuBar());
		generateWorkPanel();
		assert workpanel != null;
		jFrame.add(workpanel);
		jFrame.setVisible(true);
	}

	private void generateWorkPanel() {
		workpanel = new MyWorkPanel();
	}

	private JMenuBar getMainJMenuBar() {
		JMenuBar result = new JMenuBar();
		JMenu optionsMenu = new JMenu("Options");

		JMenuItem releaseItem = new JMenuItem("Release");

		releaseItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Shape shape : workpanel.getButtons().arrayList) {
					synchronized (shape) {
						shape.notify();
					}
				}
			}
		});

		optionsMenu.add(releaseItem);
		result.add(optionsMenu);

		return result;
	}

}
