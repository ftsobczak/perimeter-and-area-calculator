package perimeter_and_area_calc;

public class Rectangle implements Figure
{
    double sideA;
    double sideB;
    double perimeter;
    double area;

    public Rectangle(double sideA, double sideB)
    {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getPerimeter()
    {
        perimeter = 2*sideA + 2*sideB;
        perimeter *= 100;
        perimeter = Math.round(perimeter);
        perimeter /= 100;
        return perimeter;
    }

    @Override
    public double getArea()
    {
        area = sideA*sideB;
        area *= 100;
        area = Math.round(area);
        area /= 100;
        return area;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }


}
