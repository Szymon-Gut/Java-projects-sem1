package pl.pw.edu.mini.po.wyscigi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class MyWorkPanel extends JPanel {

	private Tory tory;
	private JPanel downJPanel;
	private JPanel upperJPanel;

	public MyWorkPanel() {
		super();
		this.tory = new Tory();
		this.downJPanel = new JPanel();
		this.upperJPanel = new JPanel();
		makeWorkPanel();
		this.setPreferredSize(new Dimension(600, 450));
		this.setBackground(new Color(1, 25, 1));

	}

	public void makeWorkPanel() {
		this.setLayout(new GridLayout(4, 1, 0, 0));

//		upperJPanel.setPreferredSize(new Dimension(25, 25));
		upperJPanel.setMaximumSize(new Dimension(200, 35));
		upperJPanel.setBackground(new Color(100, 170, 0));
		this.add(upperJPanel);

		tory.setMaximumSize(new Dimension(200, 400));
//		tory.setBackground(new Color(0, 50, 50));
		this.add(tory);

		downJPanel.setMaximumSize(new Dimension(200, 35));
		downJPanel.setBackground(new Color(100, 170, 0));
		this.add(downJPanel);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public Tory getTory() {
		return tory;
	}

	public void setTory(Tory tory) {
		this.tory = tory;
	}

}
