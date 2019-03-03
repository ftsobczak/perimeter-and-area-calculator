package perimeter_and_area_calc;

/**
 * @author Filip Sobczak
 */

import javax.swing.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Perimeter and area calculator");
        this.setBounds(400,400, 900,600);

        CircleTab ct = new CircleTab();
        TriangleTab tb = new TriangleTab();
        RectangleTab rt = new RectangleTab();

        //Add Circle Tab

        tabbedPane.addTab("Circle", ct.getSplit());

        //Add Triangle Tab

        tabbedPane.addTab("Triangle", tb.getSplit());

        //Add Rectangle Tab

        tabbedPane.addTab("Rectangle", rt.getSplit());



        this.getContentPane().add(tabbedPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);


    public static void main(String[] args)
    {
        new Main().setVisible(true);
    }

}