package pl.pw.edu.mini.po.wyscigi;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Starter {

	private JButton startButton;
	private MyWorkPanel workpanel;
	private ArrayList<CircleThread> watki = new ArrayList<>(); // mimo ze tylko 2 to lecimy z listą

	public static void main(String[] args) {
		Starter starter = new Starter();
		starter.go();
	}

	private void go() {
		JFrame jFrame = new JFrame();
//		jFrame.setBackground(new Color(0, 225, 0));

//		jFrame.getContentPane().setBackground(Color.GREEN); //???
//		jFrame.repaint();

		jFrame.setSize(new Dimension(600, 590));
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jFrame.setTitle("Wyścigi");

		jFrame.add(getMainPanel());
		jFrame.setJMenuBar(getMainJMenuBar());

//		jFrame.pack();
	}

	private JPanel getMainPanel() {
		JPanel result = new JPanel();

		JPanel left = new JPanel();
		JPanel right = new JPanel();

		result.setLayout(new GridLayout(1, 1, 0, 0));

		left.setBackground(new Color(20, 150, 20));
		right.setBackground(new Color(20, 150, 20));

		result.add(left);
		result.add(getPanelsCombined());
		result.add(right);

		return result;
	}

	private JPanel getPanelsCombined() {
		JPanel result = new JPanel();

		result.setLayout(new GridLayout(2, 1, 0, 0));
		result.add(getButtonPanel());
		workpanel = getWorkPanel();
		result.add(workpanel);
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
		return result;
	}

	private MyWorkPanel getWorkPanel() {
		MyWorkPanel result = new MyWorkPanel();
		return result;
	}

	private JPanel getButtonPanel() {
		JPanel result = new JPanel();

		result.setBackground(new Color(0, 200, 0));

		startButton = new JButton("Start");
		JButton dalejButton = new JButton("Dalej");
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				startButton.setEnabled(false);

				watki = new ArrayList<>();

				CircleThread watek1 = new CircleThread(workpanel.getTory(), 50, 0, dalejButton);
				CircleThread watek2 = new CircleThread(workpanel.getTory(), 150, 0, dalejButton);

				watki.add(watek1);
				watki.add(watek2);

				workpanel.getTory().setWatki(watki);
				workpanel.getTory().wystartuj();
			}
		});

		dalejButton.setEnabled(false);
		dalejButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (boolean b : CircleThread.isStopAll) {
					b = false;
				}

				workpanel.getTory().obudzWatki();

			}
		});

		result.add(startButton);
		result.add(dalejButton);
		result.setMaximumSize(new Dimension(200, 50));

		return result;
	}

	private JMenuBar getMainJMenuBar() {
		JMenuBar result = new JMenuBar();

		JMenu optionsMenu = new JMenu("Main menu");
		JMenuItem restartItem = new JMenuItem("Restart");

		restartItem.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(true);
				for (CircleThread circleThread : watki) {
					circleThread.stop();
				}
				workpanel.getTory().setWatki(new ArrayList<>());
				workpanel.getTory().repaint();
			}
		});
		optionsMenu.add(restartItem);
		result.add(optionsMenu);
		result.setPreferredSize(new Dimension(30, 30));
		return result;
	}

}
