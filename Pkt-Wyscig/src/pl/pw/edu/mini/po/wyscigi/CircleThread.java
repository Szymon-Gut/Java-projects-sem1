package pl.pw.edu.mini.po.wyscigi;

import java.util.Random;

import javax.swing.JButton;

public class CircleThread extends Thread {

	private Tory tory;
	public int x, y;
	private int id;
	private static int counter;
	public static boolean[] isStopAll = new boolean[2]; // limit z gory ustalony na potrzeby implementacji
	private JButton dalejButton;

	public CircleThread(Tory tory, int x, int y, JButton daleJButton) {
		this.tory = tory;
		this.x = x;
		this.y = y;
		this.dalejButton = daleJButton;
		this.id = counter++;
	}

	@Override
	public synchronized void run() {
		super.run();
		int iter = 1;

		while (y <= 400) {

			y += iter;

			try {
				if (y == 200) {
					isStopAll[id] = true;
					checkStopAll();
					y += 1;
					wait();
				}
				int tmp = new Random().nextInt(100);
				if (tmp > 90) {
					tmp += 300;
				} else if (tmp > 70) {
					tmp += 100;
				} else if (tmp < 20) {
					tmp = 1;
				}

				sleep(tmp);
				tory.repaint();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		if (y > 395) {
			this.interrupt();
			System.out.println(id + 1);// komunikat o wygranej
		}

	}

	private boolean checkStopAll() {
		for (boolean b : isStopAll) {
			if (!b) {
				return false;
			}
		}
		dalejButton.setEnabled(true);
		return true;
	}

}
