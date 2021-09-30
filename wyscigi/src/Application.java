import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Application {
    private WorkPanel workPanel;
    private ArrayList<CircleThread> watki;

    public void go() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(600, 590));
        Image imageIcon = Toolkit.getDefaultToolkit().getImage("D:\\Users\\Szymon\\mikolajaStatek\\JavaStudiaSem2\\Gui_domowe\\zdj.jpg");
        jFrame.setIconImage(imageIcon);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setTitle("Wyscigi");
        jFrame.add(getMainPanel());
        jFrame.setJMenuBar(getJMenuBar());
        jFrame.setVisible(true);

    }

    private JPanel getMainPanel() {
        JPanel result = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        result.setLayout(new GridLayout(1,3,0,0));
        left.setBackground(new Color(2, 62, 2));
        right.setBackground(new Color(2,62,2));
        result.add(left);
        result.add(getPanelsCombined());
        result.add(right);
        return result;
    }
    private JPanel getPanelsCombined() {
        JPanel result = new JPanel();
        result.setLayout(new GridLayout(2,1,0,0));
        result.add(getButtonPanel());
        workPanel = getWorkPanel();
        result.add(workPanel);
        result.setLayout(new BoxLayout(result,BoxLayout.Y_AXIS));
        return result;
    }

    private JPanel getButtonPanel() {
        JPanel result = new JPanel();
        result.setBackground(new Color(10, 229, 21));
        JButton start = new JButton("START");
        JButton dalej = new JButton("DALEJ");
        dalej.setEnabled(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                watki = new ArrayList<>();

                CircleThread watek1 = new CircleThread(workPanel.getTory(),50,0,dalej);
                CircleThread watek2 = new CircleThread(workPanel.getTory(),150,0,dalej);
                watki.add(watek1);
                watki.add(watek2);
                workPanel.getTory().setWatki(watki);
                workPanel.getTory().wystartujWatki();
            }
        });
        dalej.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(boolean b : CircleThread.isStopped) {
                    b = false;
                }
                System.out.println("wybudzanie watkow");
                workPanel.getTory().obudzWatki();
                dalej.setEnabled(false);
            }
        });
        result.add(start);
        result.add(dalej);
        result.setMaximumSize(new Dimension(200,50));
        return result;
    }

    private JMenuBar getJMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu optionsMenu = new JMenu("Main menu");
        result.add(optionsMenu);
        return result;

    }
    private WorkPanel getWorkPanel() {
        WorkPanel result = new WorkPanel();
        return result;
    }

}


