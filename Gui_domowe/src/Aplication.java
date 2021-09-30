import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Aplication {
    private JFrame jFrame = new JFrame();
    private WorkPanel workPanel;


    public void go() {
        jFrame.setSize(new Dimension(400,600));
        jFrame.setVisible(true);
        Image imageIcon = Toolkit.getDefaultToolkit().getImage("D:\\Users\\Szymon\\mikolajaStatek\\JavaStudiaSem2\\Gui_domowe\\zdj.jpg");
        jFrame.setIconImage(imageIcon);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setTitle("Domowe do lab4");
        jFrame.add(getMainPanel());
        jFrame.setJMenuBar(getMainMenuBar());
        jFrame.pack();


    }
    private JPanel getMainPanel() {
        JPanel result = new JPanel();
        result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
        result.add(getButtonPanel());
        this.workPanel = randomColoring();
        result.add(workPanel);
        return result;
    }
    private JPanel getButtonPanel() {
        JPanel result = new JPanel();
        result.setBackground(new Color(0,50,0));
        JButton start = new JButton("START");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton sourceButton = (JButton) source;
                    SquareThread squareThread = new SquareThread(randomColor(),workPanel);
                    squareThread.start();
                }
            }
        });
        JButton stop = new JButton("STOP");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton sourceButton = (JButton) source;
                    workPanel.stopRectangles();
                }
            }
        });
        result.add(start);
        result.add(stop);
        return result;
    }
    private JMenuBar getMainMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem firstOptionMenuItem = new JMenuItem("Zatrzymaj wszystkie");
        JMenuItem secondOptionMenuItem = new JMenuItem("Wyczysc");
        secondOptionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workPanel.changeBackground();
                workPanel.removeSquares();
            }
        });
        optionsMenu.add(firstOptionMenuItem);
        optionsMenu.add(secondOptionMenuItem);
        result.add(optionsMenu);
        return result;
    }
    private WorkPanel randomColoring() {
        WorkPanel workPanel = new WorkPanel();
        Random random = new Random();
        int redSaturation = random.nextInt(255);
        int greenSaturation = random.nextInt(255);
        int blueSaturation = random.nextInt(255);
        workPanel.setBackground(new Color(redSaturation,greenSaturation,blueSaturation));
        workPanel.setPreferredSize(new Dimension(400,400));
        return workPanel;
    }
    private Color randomColor() {
        Random random = new Random();
        int redSaturation = random.nextInt(255);
        int greenSaturation = random.nextInt(255);
        int blueSaturation = random.nextInt(255);
        return new Color(redSaturation,greenSaturation,blueSaturation);
    }
}
