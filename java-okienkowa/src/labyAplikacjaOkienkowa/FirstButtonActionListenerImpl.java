package labyAplikacjaOkienkowa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FirstButtonActionListenerImpl implements ActionListener{

	private int greenColorValue; //aby kolor byl pamietany
		
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		if(source instanceof JButton) {
			JButton sourceButton = (JButton)source; 
			sourceButton.setBackground(new Color(0, greenColorValue++, 0));
			System.out.println("First Button pressed, curr green factor: " + greenColorValue);
		}
		
//		actionEvent.getSource();
//		System.out.println("First button pressed");
	}
	
}
