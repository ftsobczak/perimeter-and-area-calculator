package perimeter_and_area_calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

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

        circleEquationPanel.add(dimensionA);
        JButton calculateButton = new JButton("Calculate");
        circleEquationPanel.add(calculateButton);
        circleResultPanel.add(resultPerimeter);
        circleResultPanel.add(resultArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {


                // Avoid entering something else besides a number.

                try
                {
                    double radius = Double.parseDouble(dimensionA.getText());
                    Figure circle = new Circle(radius);
                    resultPerimeter.setText("Perimeter = " + circle.getPerimeter() + " cm2");
                    resultArea.setText("Area = " + circle.getArea() + " cm2");
                    errorLabel.setText("");
                }
                catch(NumberFormatException err)
                {
                    circleResultPanel.add(errorLabel);
                    resultArea.setText("");
                    resultPerimeter.setText("");
                    errorLabel.setText("This is not a number!");

                }

            }
        });

        dimensionA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    try
                    {
                        double radius = Double.parseDouble(dimensionA.getText());
                        Figure circle = new Circle(radius);
                        resultPerimeter.setText("Perimeter = " + circle.getPerimeter() + " cm2");
                        resultArea.setText("Area = " + circle.getArea() + " cm2");
                        errorLabel.setText("");
                    }
                    catch(NumberFormatException err)
                    {
                        circleResultPanel.add(errorLabel);
                        resultArea.setText("");
                        resultPerimeter.setText("");
                        errorLabel.setText("This is not a number!");

                    }
                }
            }
        });

        // Triangle Tab

        tabbedPane.addTab("Triangle", triangleMainSplit);



        // Rectangle Tab

        tabbedPane.addTab("Rectangle", rectangleMainSplit);

        

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

    final JTextField dimensionA = new JTextField(7);
    final JTextField dimensionB = new JTextField(7);

    private JLabel circleImg = new JLabel(new ImageIcon("Circle.png"));
    private JLabel triangleImg = new JLabel(new ImageIcon("Triangle.png"));
    private JLabel rectangleImg = new JLabel(new ImageIcon("Rectangle.png"));
    private JLabel resultPerimeter = new JLabel();
    private JLabel resultArea = new JLabel();
    private JLabel errorLabel = new JLabel();

    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

    private JSplitPane circleSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, circleFigurePanel, circleEquationPanel);
    private JSplitPane circleMainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, circleSplit, circleResultPanel);

    private JSplitPane triangleSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, trinagleFigurePanel, trinagleEquationPanel);
    private JSplitPane triangleMainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, triangleSplit, trinagleResultPanel);

    private JSplitPane rectangleSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, rectangleFigurePanel, rectangleEquationPanel);
    private JSplitPane rectangleMainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rectangleSplit, rectangleResultPanel);


    public static void main(String[] args)
    {
//        double radius;
//        double triangleSideA, triangleSideB;
//        double rectangleSideA, rectangleSideB;
//        Figure[] figures = new Figure[3];
//
//        Main main = new Main();
//
//        //Getting needed dimensions
//        //Circle
//
//        System.out.println("Enter radius length(cm): ");
//        radius = main.getDimension();
//
//        figures[0] = new Circle(radius);
//
//        //Triangle
//
//        System.out.println();
//        System.out.println("Enter triangle's side A length(cm): ");
//        triangleSideA = main.getDimension();
//        System.out.println();
//        System.out.println("Enter triangle's side B length(cm): ");
//        triangleSideB = main.getDimension();
//
//        figures[1] =  new Triangle(triangleSideA, triangleSideB);
//
//        //Rectangle
//
//        System.out.println();
//        System.out.println("Enter rectangle's side A length(cm): ");
//        rectangleSideA = main.getDimension();
//        System.out.println();
//        System.out.println("Enter rectangle's side B length(cm): ");
//        rectangleSideB = main.getDimension();
//
//        figures[2] = new Rectangle(rectangleSideA, rectangleSideB);
//
//
//        //Print the results
//
//        for (Figure figure: figures)
//        {
//            System.out.println(figure.getType());
//            System.out.println("Perimeter: " + figure.getPerimeter());
//            System.out.println("Area: " + figure.getArea());
//
//        }


        new Main().setVisible(true);
    }


    public double getDimension()
    {
        Scanner scanner = new Scanner(System.in);
        double dimension = scanner.nextDouble();
        return dimension;
    }

}