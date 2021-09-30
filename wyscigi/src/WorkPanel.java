import javax.swing.*;
import java.awt.*;


public class WorkPanel extends JPanel {
    private Tory tory;
    private JPanel downJPanel;
    private JPanel upperJpanel;

    public WorkPanel() {
        this.tory = new Tory();
        this.downJPanel = new JPanel();
        this.upperJpanel = new JPanel();
        makeWorkPanel();
        this.setMaximumSize(new Dimension(200,500));

    }
    public void makeWorkPanel() {
        this.setLayout(new GridLayout(3, 1, 0, 0));
        upperJpanel.setMaximumSize(new Dimension(200, 35));
        upperJpanel.setBackground(new Color(186, 241, 205));
        this.add(upperJpanel);
        tory.setMaximumSize(new Dimension(200, 400));
        this.add(tory);
        downJPanel.setMaximumSize(new Dimension(200, 35));
        downJPanel.setBackground(new Color(186, 241, 205));
        this.add(downJPanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public Tory getTory() {
        return tory;
    }
}
