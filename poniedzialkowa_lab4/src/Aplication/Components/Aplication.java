package Aplication.Components;

import Aplication.Threads.FIgures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplication {
    private WorkPanel workPanel;

    public void go() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(600,600));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Szymon Gut-moja pierwsza ramka oceniana");
        jFrame.add(getmainPanel());
        jFrame.setJMenuBar(getMainJMenubar());
        jFrame.setVisible(true);
    }


    public JPanel getmainPanel() {
        JPanel result = new JPanel();
        result.setLayout(new BoxLayout(result,BoxLayout.Y_AXIS));
        this.workPanel = getWorkPanel();
        result.add(workPanel);
        result.add(getBottomPanel());
        return result;
    }

    public JPanel getBottomPanel() {
        JPanel result = new JPanel();
        JTextField textField = new JFormattedTextField("300");
        textField.setEnabled(false);
        JButton GetRays = new JButton("Get rays");
        GetRays.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //uzyty tutaj visitor
                int rays = 0;
                for(FIgures fIgures : workPanel.getfIgures()) {
                   rays += fIgures.getPromien();
                }
                textField.setText(String.valueOf(rays));

            }
        });
        result.add(GetRays);
        result.add(textField);
        result.setMaximumSize(new Dimension(600,50));
        return result;
    }
    public WorkPanel getWorkPanel() {
        WorkPanel result = new WorkPanel();
        return result;
    }
    public JMenuBar getMainJMenubar() {
        JMenuBar result = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem releaseItem = new JMenuItem("Release");
        releaseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (FIgures fIgures : workPanel.getfIgures()) {
                    synchronized (fIgures){
                        fIgures.notify();
                    }

                }
            }
        });
        optionsMenu.add(releaseItem);
        result.add(optionsMenu);
        result.setBorderPainted(true);
        return result;
    }
}
