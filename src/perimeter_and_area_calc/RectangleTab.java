package perimeter_and_area_calc;

/**
 *
 * Class <code>RectangleTab</code> defines how the tab with calculations related to the rectangle looks like.
 * This class extends JPanel.
 *
 * @author Filip Sobczak
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RectangleTab extends JPanel
{
    /**
     * This is the panel where is an image of a rectangle
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
     * In this text field the value of the side A of the rectangle is entered.
     */
    private JTextField dimensionA = new JTextField(7);
    /**
     * In this text field the value of the side B of the rectangle is entered.
     */
    private JTextField dimensionB = new JTextField(7);

    /**
     * This parameter shows the value of perimeter.
     */
    private JLabel resultPerimeter = new JLabel();
    /**
     * This parameter shows the value of area.
     */
    private JLabel resultArea = new JLabel();
    /**
     * This parameter shows an error message when something besides numbers is entered in dimensionA or dimensionB.
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
     * In figurePanel is added an image of rectangle.
     * At the top of equationPanel is JLabel with information that is required to use '.' (dot) not ',' (coma), because it prevents throwing an NumberFormatException.
     * Under this there is a group of JLabel which informs what value must be entered and text field to enter this value.
     * At the bottom there is a similar group of JLabel and JTextField which is dedicated to value of side B.
     * In the bottom, right corner of this panel there is added JButton which runs the getResult method.
     * To the resultPanel are added JLabels withe the results of calculations and errorLabel.
     *</pre>
     */
    public RectangleTab()
    {


        JLabel img = new JLabel(new ImageIcon("Rectangle.png"));
        figurePanel.add(img);

        GroupLayout equationPanelLayout = new GroupLayout(equationPanel);
        equationPanel.setLayout(equationPanelLayout);

        equationPanelLayout.setAutoCreateGaps(true);
        equationPanelLayout.setAutoCreateContainerGaps(true);

        JLabel separator = new JLabel("As a separator please use '.' (dot) not ',' (coma).");
        JLabel aLength = new JLabel("Enter side A length: ");
        JLabel bLength = new JLabel("Enter side B length: ");

        JButton calculateButton = new JButton("Calculate");


        equationPanelLayout.setHorizontalGroup(
                equationPanelLayout.createSequentialGroup()
                        .addGroup(
                                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                                        .addComponent(separator)
                                        .addGap(40)
                                        .addGroup(equationPanelLayout.createSequentialGroup()
                                                .addComponent(aLength, 60,60,Short.MAX_VALUE)
                                                .addComponent(dimensionA))
                                        .addGroup(equationPanelLayout.createSequentialGroup()
                                                .addComponent(bLength, 60,60,Short.MAX_VALUE)
                                                .addComponent(dimensionB))
                        )

                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(calculateButton)
                );

        equationPanelLayout.setVerticalGroup(
                equationPanelLayout.createSequentialGroup()
                        .addComponent(separator)
                        .addGap(40)
                        .addGroup(
                                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(aLength)
                                        .addComponent(dimensionA)
                        )
                        .addGroup(
                                equationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bLength)
                                        .addComponent(dimensionB)
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
        dimensionB.addKeyListener(new KeyAdapter() {
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
            double sideA = Double.parseDouble(dimensionA.getText());
            double sideB = Double.parseDouble(dimensionB.getText());
            Figure rectangle = new Rectangle(sideA, sideB);
            resultPerimeter.setText("Perimeter = " + rectangle.getPerimeter() + " cm2");
            resultArea.setText("Area = " + rectangle.getArea() + " cm2");
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