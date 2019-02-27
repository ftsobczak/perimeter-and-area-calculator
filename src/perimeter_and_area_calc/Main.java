package perimeter_and_area_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

        // Circle Tab

        tabbedPane.addTab("Circle", circleMainSplit);

        circleFigurePanel.add(circleImg);
        circleEquationPanel.add(new JLabel("Enter radius length(cm): "));

        circleEquationPanel.add(radiusDimension);
        circleEquationPanel.add(new JLabel("As a separator please use '.' not ','."));
        circleEquationPanel.add(circleCalculateButton);
        circleResultPanel.add(circleResultPerimeter);
        circleResultPanel.add(circleResultArea);

        circleCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                // Avoid entering something else besides a number.

                try
                {
                    double radius = Double.parseDouble(radiusDimension.getText());
                    Figure circle = new Circle(radius);
                    circleResultPerimeter.setText("Perimeter = " + circle.getPerimeter() + " cm2");
                    circleResultArea.setText("Area = " + circle.getArea() + " cm2");
                    circleErrorLabel.setText("");
                }
                catch(NumberFormatException err)
                {
                    circleResultPanel.add(circleErrorLabel);
                    circleResultArea.setText("");
                    circleResultPerimeter.setText("");
                    circleErrorLabel.setText("This is not a number!");

                }

            }
        });

        radiusDimension.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    try
                    {
                        double radius = Double.parseDouble(radiusDimension.getText());
                        Figure circle = new Circle(radius);
                        circleResultPerimeter.setText("Perimeter = " + circle.getPerimeter() + " cm2");
                        circleResultArea.setText("Area = " + circle.getArea() + " cm2");
                        circleErrorLabel.setText("");
                    }
                    catch(NumberFormatException err)
                    {
                        circleResultPanel.add(circleErrorLabel);
                        circleResultArea.setText("");
                        circleResultPerimeter.setText("");
                        circleErrorLabel.setText("This is not a number!");

                    }
                }
            }
        });

        // Triangle Tab

        tabbedPane.addTab("Triangle", triangleMainSplit);

        trinagleFigurePanel.add(triangleImg);

        trinagleEquationPanel.add(new JLabel("Enter side A length: "));
        trinagleEquationPanel.add(triangleDimensionA);
        trinagleEquationPanel.add(new JLabel("Enter side B/height length: "));
        trinagleEquationPanel.add(triangleDimensionB);
        trinagleEquationPanel.add(new JLabel("As a separator please use '.' not ','."));
        trinagleEquationPanel.add(triangleCalculateButton);

        trinagleResultPanel.add(triangleResultPerimeter);
        trinagleResultPanel.add(triangleResultArea);

        triangleCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Avoid entering something else besides a number.
                try
                {
                    double triangleSideA = Double.parseDouble(triangleDimensionA.getText());
                    double triangleSideB = Double.parseDouble(triangleDimensionB.getText());
                    Figure triangle = new Triangle(triangleSideA, triangleSideB);
                    triangleResultPerimeter.setText("Perimeter = " + triangle.getPerimeter() + " cm2");
                    triangleResultArea.setText("Area = " + triangle.getArea() + " cm2");
                    triangleErrorLabel.setText("");
                }
                catch(NumberFormatException err)
                {
                    trinagleResultPanel.add(triangleErrorLabel);
                    triangleResultPerimeter.setText("");
                    triangleResultArea.setText("");
                    triangleErrorLabel.setText("This is not a number!");

                }

            }
        });

        triangleDimensionB.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    try
                    {
                        double triangleSideA = Double.parseDouble(triangleDimensionA.getText());
                        double triangleSideB = Double.parseDouble(triangleDimensionB.getText());
                        Figure triangle = new Triangle(triangleSideA, triangleSideB);
                        triangleResultPerimeter.setText("Perimeter = " + triangle.getPerimeter() + " cm2");
                        triangleResultArea.setText("Area = " + triangle.getArea() + " cm2");
                        triangleErrorLabel.setText("");
                    }
                    catch(NumberFormatException err)
                    {
                        trinagleResultPanel.add(triangleErrorLabel);
                        triangleResultPerimeter.setText("");
                        triangleResultArea.setText("");
                        circleErrorLabel.setText("This is not a number!");

                    }
                }
            }
        });



        // Rectangle Tab

        tabbedPane.addTab("Rectangle", rectangleMainSplit);

        rectangleFigurePanel.add(rectangleImg);

        rectangleEquationPanel.add(new JLabel("Enter side A length: "));
        rectangleEquationPanel.add(rectangleDimensionA);
        rectangleEquationPanel.add(new JLabel("Enter side B length: "));
        rectangleEquationPanel.add(rectangleDimensionB);
        rectangleEquationPanel.add(new JLabel("As a separator please use '.' not ','."));
        rectangleEquationPanel.add(rectangleCalculateButton);

        rectangleResultPanel.add(rectangleResultPerimeter);
        rectangleResultPanel.add(rectangleResultArea);

        rectangleCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Avoid entering something else besides a number.
                try
                {
                    double rectangleSideA = Double.parseDouble(rectangleDimensionA.getText());
                    double rectangleSideB = Double.parseDouble(rectangleDimensionB.getText());
                    Figure rectangle = new Rectangle(rectangleSideA, rectangleSideB);
                    rectangleResultPerimeter.setText("Perimeter = " + rectangle.getPerimeter() + " cm2");
                    rectangleResultArea.setText("Area = " + rectangle.getArea() + " cm2");
                    rectangleErrorLabel.setText("");
                }
                catch(NumberFormatException err)
                {
                    rectangleResultPanel.add(rectangleErrorLabel);
                    rectangleResultPerimeter.setText("");
                    rectangleResultArea.setText("");
                    rectangleErrorLabel.setText("This is not a number!");

                }

            }
        });

        rectangleDimensionB.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    try
                    {
                        double rectangleSideA = Double.parseDouble(rectangleDimensionA.getText());
                        double rectangleSideB = Double.parseDouble(rectangleDimensionB.getText());
                        Figure rectangle = new Rectangle(rectangleSideA, rectangleSideB);
                        rectangleResultPerimeter.setText("Perimeter = " + rectangle.getPerimeter() + " cm2");
                        rectangleResultArea.setText("Area = " + rectangle.getArea() + " cm2");
                        rectangleErrorLabel.setText("");
                    }
                    catch(NumberFormatException err)
                    {
                        rectangleResultPanel.add(rectangleErrorLabel);
                        rectangleResultPerimeter.setText("");
                        rectangleResultArea.setText("");
                        rectangleErrorLabel.setText("This is not a number!");

                    }
                }
            }
        });


        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.getContentPane().add(tabbedPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel circleFigurePanel = new JPanel();
    private JPanel circleEquationPanel = new JPanel();
    private JPanel circleResultPanel = new JPanel();

    private JPanel trinagleFigurePanel = new JPanel();
    private JPanel trinagleEquationPanel = new JPanel();
    private JPanel trinagleResultPanel = new JPanel();

    private JPanel rectangleFigurePanel = new JPanel();
    private JPanel rectangleEquationPanel = new JPanel();
    private JPanel rectangleResultPanel = new JPanel();

    private JTextField radiusDimension = new JTextField(7);

    private JTextField triangleDimensionA = new JTextField(7);
    private JTextField triangleDimensionB = new JTextField(7);

    private JTextField rectangleDimensionA = new JTextField(7);
    private JTextField rectangleDimensionB = new JTextField(7);

    private JButton circleCalculateButton = new JButton("Calculate");
    private JButton triangleCalculateButton = new JButton("Calculate");
    private JButton rectangleCalculateButton = new JButton("Calculate");


    private JLabel circleImg = new JLabel(new ImageIcon("Circle.png"));
    private JLabel triangleImg = new JLabel(new ImageIcon("Triangle.png"));
    private JLabel rectangleImg = new JLabel(new ImageIcon("Rectangle.png"));

    private JLabel circleResultPerimeter = new JLabel();
    private JLabel circleResultArea = new JLabel();
    private JLabel circleErrorLabel = new JLabel();

    private JLabel triangleResultPerimeter = new JLabel();
    private JLabel triangleResultArea = new JLabel();
    private JLabel triangleErrorLabel = new JLabel();

    private JLabel rectangleResultPerimeter = new JLabel();
    private JLabel rectangleResultArea = new JLabel();
    private JLabel rectangleErrorLabel = new JLabel();

    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

    private JSplitPane circleSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, circleFigurePanel, circleEquationPanel);
    private JSplitPane circleMainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, circleSplit, circleResultPanel);

    private JSplitPane triangleSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, trinagleFigurePanel, trinagleEquationPanel);
    private JSplitPane triangleMainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, triangleSplit, trinagleResultPanel);

    private JSplitPane rectangleSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, rectangleFigurePanel, rectangleEquationPanel);
    private JSplitPane rectangleMainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rectangleSplit, rectangleResultPanel);


    public static void main(String[] args)
    {
        new Main().setVisible(true);
    }

}