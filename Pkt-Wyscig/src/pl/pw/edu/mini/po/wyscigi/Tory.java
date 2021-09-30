package pl.pw.edu.mini.po.wyscigi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tory extends JPanel {

	private Tor tor1;
	private Tor tor2;
	public int srednica = 10;
	private ArrayList<CircleThread> watki = new ArrayList<>();

	public ArrayList<CircleThread> getWatki() {
		return watki;
	}

	public void setWatki(ArrayList<CircleThread> watki) {
		this.watki = watki;
	}

	public Tory() {
		tor1 = new Tor(this);
		tor2 = new Tor(this);

		JLabel gracz1 = new JLabel("1");
		tor1.add(gracz1);
		JLabel gracz2 = new JLabel("2");
		tor2.add(gracz2);

		tor1.setBackground(Tor.defaultColor);
		tor2.setBackground(Tor.defaultColor);

		this.setLayout(new GridLayout(1, 2, 0, 0));

		tor1.setMaximumSize(new Dimension(100, 400));
		tor2.setMaximumSize(new Dimension(100, 400));

		this.add(tor1);
		this.add(tor2);

	}

//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		revalidate();
//	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		rysujLinie(g);
		rysujPozycjeKolka(g);
	}

	private void rysujPozycjeKolka(Graphics g) {
		for (CircleThread circleThread : watki) {
			// moznaby usprawnic nieco program, dodajac mozliwosc zaznaczenia poczatkowej
			// fazy kółka
			g.drawOval(circleThread.x, circleThread.y, srednica, srednica);
		}
	}

	private void rysujLinie(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.drawLine(0, 200, 200, 200);
	}

	public Tor getTor1() {
		return tor1;
	}

	public Tor getTor2() {
		return tor2;
	}

	public void wystartuj() {
		for (CircleThread circleThread : watki) {
			circleThread.start();
		}

	}

	public void obudzWatki() {
		for (CircleThread circleThread : watki) {
			synchronized (circleThread) {
				circleThread.notify();
			}
		}
//		watki.get(0).notifyAll();
	}

}
