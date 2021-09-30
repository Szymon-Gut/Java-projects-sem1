package labyAplikacjaOkienkowa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//pozytywne lenistwo - jakies rozszerzenie (designera), ktory automatycznie wygeneruje schemat
//docs.oracle.com/javase/tutorial/swing

public class Starter {

	private JTextField myTextField;
	private JCheckBox firstBox;
	private JCheckBox secondBox;
	private JPanel workPanel;
	private JFrame jFrame;

	public static void main(String[] args) {
		Starter starter = new Starter();
		starter.go();

	}

	private void go() {
		JFrame jFrame = new JFrame(); // element graficzny
		jFrame.setVisible(true);

		// aby proces nie dzialal jak zamkniemy 'X', mozna sprawdzic debuggerem
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jFrame.setTitle("Moja pierwsza ramka!");
		jFrame.setSize(new Dimension(600, 600));

		jFrame.add(getMainPanel());

		jFrame.setJMenuBar(getMainJMenuBar());
//		jFrame.setMenuBar(null); // tak nie!!

		jFrame.pack();//dostosuje wielkosc ramki do 'zawartosci'
	}

	private JPanel getMainPanel() {

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // dzieki temu niebieski panel 'poszedl na dol'

		mainPanel.add(getButtonPanel()); // trzeba rozbijac na panele

		// TUTAJ COS MOZE SMIERDZIEC
		mainPanel.add(getWorkPanel());
		mainPanel.add(getOprationalPanel());
		return mainPanel;
	}

	private JMenuBar getMainJMenuBar() {
		JMenuBar result = new JMenuBar();

		JMenu optionMenu = new JMenu("Options");// trzeba dac napis :D

		JMenuItem firstOptionMenuItem = new JMenuItem("First");
		firstOptionMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// poczestowalismy sie :D
//				FileSystemView.getFileSystemView().getHomeDirectory()
				JFileChooser jfc = new JFileChooser();

				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
				}

			}
		});

		JMenuItem secondOptionMenuItem = new JMenuItem("Second");
		secondOptionMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// tutaj ewidentnie kurwi
				JColorChooser myColorChooser = new JColorChooser();
				Color color = myColorChooser.showDialog(null, "", null);

				workPanel.setBackground(color);
				System.out.println("Color " + color);
			}
		});

		JMenuItem thirdOptionMenuItem = new JMenuItem("Third");

		optionMenu.add(firstOptionMenuItem);
		optionMenu.add(secondOptionMenuItem);
		optionMenu.add(thirdOptionMenuItem);

		result.add(optionMenu);

		return result;
	}

	private JPanel getWorkPanel() {
		workPanel = new JPanel();
		workPanel.setBackground(new Color(61, 3, 89));
		workPanel.setSize(new Dimension(400, 400));
		return workPanel;
	}

	private JPanel getButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(100, 50, 50)); // duzo konstruktorow

		JButton firstButton = new JButton("My first button"); // ctrl + lpm, sprawdzenie konstruktora

		// analogicznie do klasy FirstButtonActionListener

		class GreenColorWrapper {
			private int greenColorValue = 0;

			public int getGreenColorValue() {
				return greenColorValue;
			}

			public void increase() {
				greenColorValue++;
			}

			public void setGreenColorValue(int greenColorValue) {
				this.greenColorValue = greenColorValue;
			}

		}

//		firstButton.addActionListener(new FirstButtonActionListenerImpl()); //powinno tak niz jedna linia nizej (dlaczego nie dzial??)
//		firstButton.addActionListener(new FirstButtonActionListenerImpl() {}); //mozna tak

		final GreenColorWrapper greenColorWrapper = new GreenColorWrapper();

		// klasa anonimowa
		firstButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Object source = actionEvent.getSource();
				if (source instanceof JButton) {
					JButton sourceButton = (JButton) source;
//					sourceButton.setEnabled(false);//przycisk nieaktywny (po przycisnieciu)
					sourceButton.setBackground(new Color(0, greenColorWrapper.getGreenColorValue(), 0));
					greenColorWrapper.increase();
					System.out.println("First Button pressed");
				}

//				actionEvent.getSource();
//				System.out.println("First button pressed");
			}
		});

		// mozna tak (3opcja)
		/*
		 * firstButton.addActionListener(new ActionListener() { private int
		 * greenColorFactor;
		 * 
		 * @Override public void actionPerformed(ActionEvent actionEvent) { Object
		 * source = actionEvent.getSource(); if(source instanceof JButton) { JButton
		 * sourceButton = (JButton)source; // sourceButton.setEnabled(false);//przycisk
		 * nieaktywny (po przycisnieciu) sourceButton.setBackground(new Color(0,
		 * greenColorFactor++, 0)); greenColorWrapper.increase();
		 * System.out.println("First Button pressed"); }
		 * 
		 * // actionEvent.getSource(); // System.out.println("First button pressed"); }
		 * 
		 * private void meth() {
		 * 
		 * }
		 * 
		 * });
		 */

		buttonPanel.add(firstButton);

		JButton secondButton = new JButton("My second button");
		secondButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {

//				this.myTextField; // odwola sie do klasy anonimowej!!

				if (firstBox.isSelected() && !secondBox.isSelected()) {
					myTextField.setText("Button!!!");
				}

			}
		});

		buttonPanel.add(secondButton);

		JButton thirdButton = new JButton("My third button");
		buttonPanel.add(thirdButton);

		return buttonPanel;
	}

	private JPanel getOprationalPanel() {
		JPanel result = new JPanel();
		result.setBackground(new Color(255, 150, 0));

		// cel - dodanie pola tekstowego z opisem
		result.add(getTextPanel());
		result.add(getRadioButtonsPanel());
		result.add(getCheckboxesPanel());

		return result;
	}

	private JPanel getTextPanel() {
		JPanel result = new JPanel();

		JLabel myLabel = new JLabel("My text");
		myTextField = new JTextField("AAAA");
		myTextField.setText("Write here...");

		result.add(myLabel);
		result.add(myTextField);

		return result;
	}

	private JPanel getRadioButtonsPanel() {
		JPanel result = new JPanel();

		JRadioButton first = new JRadioButton("First");
		JRadioButton second = new JRadioButton("Second");
		JRadioButton third = new JRadioButton("Third");

		// aby tylko jeden mogl byc zaznaczony
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(first);
		buttonGroup.add(second);
		buttonGroup.add(third);

		result.add(first);
		result.add(second);
		result.add(third);

		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

		return result;
	}

	private JPanel getCheckboxesPanel() {
		JPanel result = new JPanel();

		firstBox = new JCheckBox("First");
		secondBox = new JCheckBox("Second");

		result.add(firstBox);
		result.add(secondBox);

		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

		return result;
	}
}
