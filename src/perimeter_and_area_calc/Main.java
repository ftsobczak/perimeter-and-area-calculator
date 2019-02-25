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

        //Circle

        System.out.println("Podaj długość promienia (w cm): ");
        radius = main.getDimension();

        figures[0] = new Circle(radius);

        //Triangle

        System.out.println();
        System.out.println("Podaj długość boku A trójkąta(w cm): ");
        triangleSideA = main.getDimension();
        System.out.println();
        System.out.println("Podaj długość boku B trójkąta(w cm): ");
        triangleSideB = main.getDimension();

        figures[1] =  new Triangle(triangleSideA, triangleSideB);

        // Rectangle

        System.out.println();
        System.out.println("Podaj długość boku A prostokąta(w cm): ");
        rectangleSideA = main.getDimension();
        System.out.println();
        System.out.println("Podaj długość boku B prostokąta(w cm): ");
        rectangleSideB = main.getDimension();

        figures[2] = new Rectangle(rectangleSideA, rectangleSideB);


        for (Figure figure: figures)
        {
            System.out.println(figure.getType());
            System.out.println("Obwód: " + figure.getPerimeter());
            System.out.println("Pole: " + figure.getArea());

        }


    }


    public double getDimension()
    {
        Scanner scanner = new Scanner(System.in);
        double dimension = scanner.nextDouble();
        return dimension;
    }

}