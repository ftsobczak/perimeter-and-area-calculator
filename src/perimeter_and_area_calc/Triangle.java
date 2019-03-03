package perimeter_and_area_calc;
/**
 * Class <code>Triangle</code> has two methods which calculates the perimeter and area of triangle.
 */


public class Triangle implements Figure
{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB)
    {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = Math.sqrt(sideA*sideA+sideB*sideB);
    }

    /**
     *
     * @return the perimeter of triangle.
     */
    @Override
    public double getPerimeter()
    {
        double perimeter = sideA + sideB + sideC;
        perimeter *= 100;
        perimeter = Math.round(perimeter);
        perimeter /= 100;

        return perimeter;
    }

    /**
     *
     * @return the area of triangle.
     */
    @Override
    public double getArea()
    {
        double area = (sideA * sideB) / 2;
        area *= 100;
        area = Math.round(area);
        area /= 100;

        return area;
    }
}
