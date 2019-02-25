package perimeter_and_area_calc;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        double radius;
        double triangleSideA, triangleSideB;
        double rectangleSideA, rectangleSideB;
        Figure[] figures = new Figure[3];

        Main main = new Main();

        //Getting needed dimensions
        //Circle

        System.out.println("Enter radius length(cm): ");
        radius = main.getDimension();

        figures[0] = new Circle(radius);

        //Triangle

        System.out.println();
        System.out.println("Enter triangle's side A length(cm): ");
        triangleSideA = main.getDimension();
        System.out.println();
        System.out.println("Enter triangle's side B length(cm): ");
        triangleSideB = main.getDimension();

        figures[1] =  new Triangle(triangleSideA, triangleSideB);

        //Rectangle

        System.out.println();
        System.out.println("Enter rectangle's side A length(cm): ");
        rectangleSideA = main.getDimension();
        System.out.println();
        System.out.println("Enter rectangle's side B length(cm): ");
        rectangleSideB = main.getDimension();

        figures[2] = new Rectangle(rectangleSideA, rectangleSideB);


        //Print the results
        
        for (Figure figure: figures)
        {
            System.out.println(figure.getType());
            System.out.println("Perimeter: " + figure.getPerimeter());
            System.out.println("Area: " + figure.getArea());

        }
    }


    public double getDimension()
    {
        Scanner scanner = new Scanner(System.in);
        double dimension = scanner.nextDouble();
        return dimension;
    }

}