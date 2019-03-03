package perimeter_and_area_calc;

/**
 * Class <code>Rectangle</code> has two methods which calculates the perimeter and area of rectangle.
 */

public class Rectangle implements Figure
{
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB)
    {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    /**
     *
     * @return the perimeter of rectangle.
     */
    @Override
    public double getPerimeter()
    {
        double perimeter = 2 * sideA + 2 * sideB;
        perimeter *= 100;
        perimeter = Math.round(perimeter);
        perimeter /= 100;
        return perimeter;
    }

    /**
     *
     * @return the area of rectangle.
     */
    @Override
    public double getArea()
    {
        double area = sideA * sideB;
        area *= 100;
        area = Math.round(area);
        area /= 100;
        return area;
    }
}
