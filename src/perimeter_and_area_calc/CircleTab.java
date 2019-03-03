package perimeter_and_area_calc;

/**
 *
 * Class <code>CircleTab</code> defines how the tab with calculations related to the circle looks like.
 * This class extends JPanel.
 *
 * @author Filip Sobczak
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CircleTab extends JPanel {
    /**
     * This is the panel where is an image of a circle.
     */
    private JPanel figurePanel = new JPanel();
    /**
     * This is the panel where the values ​​needed for calculations are entered.
     */
    private JPanel equationPanel = new JPanel();
    /**
     * This is the panel where the results of perimeter and area calculations are shown.
     */
    private JPanel resultPanel = new JPanel();

    /**
     * In this text field the value of the radius of the circle is entered.
     */
    private JTextField radiusDimension = new JTextField(7);

    /**
     * This parameter shows the value of perimeter.
     */
    private JLabel resultPerimeter = new JLabel();
    /**
     * This parameter shows the value of area.
     */
    private JLabel resultArea = new JLabel();
    /**
     * This parameter shows an error message when something besides numbers is entered in radiusDimension.
     */
    private JLabel errorLabel = new JLabel();

    private JSplitPane topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, figurePanel, equationPanel);

    /**
     * This JSplitPane defines how whole rectangle tab is splitted.
     */
    private JSplitPane mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topSplit, resultPanel);



    /**
     * <pre>
     * It forms the layout of everything placed in this tab.
     * In figurePanel is added an image of circle.
     * At the top of equationPanel is JLabel with information that is required to use '.' (dot) not ',' (coma), because it prevents throwing an NumberFormatException.
     * Under this there is a group of JLabel which informs what value must be entered and text field to enter this value.
     * In the bottom, right corner of this panel there is added JButton which runs the getResult method.
     * To the resultPanel are added JLabels withe the results of calculations and errorLabel.
     *</pre>
     */
    public CircleTab()
    {

        JLabel img = new JLabel(new ImageIcon("Circle.png"));
        figurePanel.add(img);

        GroupLayout equationPanelLayout = new GroupLayout(equationPanel);
        equationPanel.setLayout(equationPanelLayout);

        equationPanelLayout.setAutoCreateGaps(true);
        equationPanelLayout.setAutoCreateContainerGaps(true);

        JLabel separator = new JLabel("As a separator please use '.' (dot) not ',' (coma).");
        JLabel radiusLength = new JLabel("Enter radius length: ");

        JButton calculateButton = new JButton("Calculate");


        equationPanelLayout.setHorizontalGroup(
                equationPanelLayout.createSequentialGroup()
                        .addGroup(
                                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                        .addComponent(separator)
                                        .addGap(40)
                                        .addGroup(equationPanelLayout.createSequentialGroup()
                                                .addComponent(radiusLength, 80,80,Short.MAX_VALUE)
                                                .addComponent(radiusDimension))
                        )
                        .addComponent(radiusDimension)

                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(calculateButton)
        );

        equationPanelLayout.setVerticalGroup(
                equationPanelLayout.createSequentialGroup()
                        .addComponent(separator)
                        .addGap(40)
                        .addGroup(
                                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(radiusLength)
                                        .addComponent(radiusDimension)
                        )
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(calculateButton)

        );

        resultPanel.add(resultPerimeter);
        resultPanel.add(resultArea);

        //Action listener which listen if the calculateButton is clicked, and then runs the getResult method.
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getResult();
            }
        });

        //Key listener which listen if the Enter is clicked, and then runs the getResult method.
        radiusDimension.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    getResult();
                }
            }
        });
    }

    /**
     * @return the result of perimeter and area calculations.
     */
    private void getResult()
    {
        // Avoid entering something else besides a number.

        try
        {
            double radius = Double.parseDouble(radiusDimension.getText());
            Figure circle = new Circle(radius);
            resultPerimeter.setText("Perimeter = " + circle.getPerimeter() + " cm2");
            resultArea.setText("Area = " + circle.getArea() + " cm2");
            errorLabel.setText("");
        }
        catch(NumberFormatException err)
        {
            resultPanel.add(errorLabel);
            resultArea.setText("");
            resultPerimeter.setText("");
            errorLabel.setText("This is not a number!");

        }
    }

    /**
     *
     * @return the main split of a tab.
     */
    JSplitPane getSplit()
    {
        return mainSplit;
    }
}
