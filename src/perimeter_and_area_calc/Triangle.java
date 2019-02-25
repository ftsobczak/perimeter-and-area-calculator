package perimeter_and_area_calc;

public class Triangle implements Figure
{
    double sideA;
    double sideB;
    double sideC;
    double perimeter;
    double area;

    public Triangle(double sideA, double sideB)
    {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = Math.sqrt(sideA*sideA+sideB*sideB);
    }

    @Override
    public double getPerimeter()
    {
        perimeter = sideA+sideB+sideC;
        perimeter *= 100;
        perimeter = Math.round(perimeter);
        perimeter /= 100;

        return perimeter;
    }

    @Override
    public double getArea()
    {
        area = (sideA*sideB)/2;
        area *= 100;
        area = Math.round(area);
        area /= 100;

        return area;
    }

    @Override
    public String getType()
    {
        return "Triangle";
    }
}
