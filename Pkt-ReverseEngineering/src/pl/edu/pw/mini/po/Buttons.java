package pl.edu.pw.mini.po;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.edu.pw.mini.po.visitor.shapesvisitor.Shape;

public class Buttons extends JPanel {

	private static int numberOfRays = 0;
	private JButton getRays;
	private JTextField textField;
	public ArrayList<Shape> arrayList;

	public Buttons() {
		this.getRays = new JButton("Get rays");
		this.textField = new JTextField();
		textField.setEnabled(false);

		textField.setPreferredSize(new Dimension(100, 25));

		getRays.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refreshNumberOfRays();
				textField.setText(String.valueOf(numberOfRays));
			}
		});

		this.add(getRays);
		this.add(textField);
		arrayList = new ArrayList<>();
	}

	private void refreshNumberOfRays() {
		numberOfRays = 0;
		for (Shape shape : arrayList) {
			numberOfRays += shape.doSth();
		}
	}

}
