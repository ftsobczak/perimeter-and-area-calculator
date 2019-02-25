package perimeter_and_area_calc;

public class Circle implements Figure
{
    double radius;
    double perimeter;
    double area;
    final double PI = Math.PI;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getPerimeter()
    {
        perimeter = 2*PI*radius;
        perimeter *= 100;
        perimeter = Math.round(perimeter);
        perimeter /= 100;

        return perimeter;
    }

    @Override
    public double getArea()
    {
        area = PI*Math.pow(radius,2);
        area *= 100;
        area = Math.round(area);
        area /= 100;

        return area;
    }

    @Override
    public String getType() {
        return "Circle";
    }


}
