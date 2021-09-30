package pl.pw.edu.mini.po.wyscigi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class Tor extends JPanel {

	private JPanel tor;
	public Tory tory;
	public static final Color defaultColor = Color.YELLOW;

	public Tor(Tory tory) {

		tor = new JPanel();

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseExited(MouseEvent e) {
//				System.out.println("Exited");
				changeColorToDefault();
				tory.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				System.out.println("Entered");
				changeColorToWhite();
				tory.repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int tmp = tory.srednica + (int) e.getWheelRotation();
				if (tmp < 50 && tmp > 1) {
					tory.srednica += (int) e.getWheelRotation();
				}
			}
		});
	}

	protected void changeColorToWhite() {
		this.setBackground(new Color(255, 255, 255));
	}

	protected void changeColorToDefault() {
		this.setBackground(defaultColor);
	}

}
