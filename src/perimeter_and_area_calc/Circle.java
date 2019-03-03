package perimeter_and_area_calc;
/**
 * Class <code>Circle</code> has two methods which calculates the perimeter and area of circle.
 */


public class Circle implements Figure
{
    private double radius;
    private final double PI = Math.PI;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    /**
     *
     * @return the perimeter of circle.
     */
    @Override
    public double getPerimeter()
    {
        double perimeter = 2 * PI * radius;
        perimeter *= 100;
        perimeter = Math.round(perimeter);
        perimeter /= 100;

        return perimeter;
    }

    /**
     *
     * @return the area of circle.
     */
    @Override
    public double getArea()
    {
        double area = PI * Math.pow(radius, 2);
        area *= 100;
        area = Math.round(area);
        area /= 100;

        return area;
    }
}
