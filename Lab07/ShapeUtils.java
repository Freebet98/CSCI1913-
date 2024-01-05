//CSCI 1913 FALL 2022 KLUVER
//Author: Bethany Freeman
public class ShapeUtils
{
    /**
     * This function uses the distance formula to calculate the
     * distance between p1 and p2
     * @param p1 is a Point object
     * @param p2 is a Point object
     * @return the distance between Point p1 and Point p2
     */
    public static double distance(Point p1, Point p2)
    {
        double distance;
        double distanceX = p1.getX() - p2.getX();
        double distanceY = p1.getY() - p2.getY();

        distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));

        return distance;
    }

    /**
     * This function takes the average of the x-coordinate of the Points in the
     * points array, and it also takes the average of the y-coordinate of the Points
     * in the points array. These averages become the new center Point. If an empty
     * array is given. The center defaults to (0,0)
     * @param points this is an array of Point objects.
     * @return a Point object that represents the center Point
     */
    public static Point getCenter(Point[] points)
    {
        double centerX = 0;
        double centerY = 0;
        double sumX = 0;
        double sumY = 0;
        Point center;

        if(points.length == 0)
        {
            center = new Point(centerX, centerY);
            return center;
        }
        else
        {
            for(int i = 0; i < points.length; i++)
            {
                sumX += points[i].getX();
                sumY += points[i].getY();
            }

            centerX = sumX/ points.length;
            centerY = sumY/ points.length;

            center = new Point(centerX, centerY);
            return center;
        }
    }

    /**
     * This creates an array of triangles from an array of points.
     * It is assumed that there are at least 3 points in the points
     * array.
     * @param points is an array of point objects
     * @return This returns an array of triangle objects
     */
    public static Triangle[] makeFakePoly(Point[] points)
    {
        Triangle[] triangles = new Triangle[points.length];
        Point centerPoint = getCenter(points);

        for(int i = 0; i < triangles.length; i++)
        {
            if(i == triangles.length - 1)
            {
               Triangle tempTriangle = new Triangle(points[i], points[0], centerPoint);
               triangles[i] = tempTriangle;
            }
            else
            {
                Triangle tempTriangle = new Triangle(points[i], points[i + 1], centerPoint);
                triangles[i] = tempTriangle;
            }
        }

        return triangles;
    }

    /**
     * This calculates the area of a Circle using the standard Circle
     * area equation.
     * @param c is a Circle object
     * @return the area of the Circle c
     */
    public static double getArea(Circle c)
    {
        double area;
        area = Math.PI*(Math.pow(c.getRadius(), 2));

        return area;
    }

    /**
     * This calculates the area of a triangle using the usual
     * equation.
     * @param t is a Triangle object
     * @return the area of a triangle
     */
    public static double getArea(Triangle t)
    {
        double t1 = t.getP1().getX() * (t.getP2().getY() - t.getP3().getY());
        double t2 = t.getP2().getX() * (t.getP3().getY() - t.getP1().getY());
        double t3 = t.getP3().getX() * (t.getP1().getY() - t.getP2().getY());

        double area = 0.5 * Math.abs(t1+ t2 + t3);

        return area;
    }

    /**
     * Determines if a point is within a
     * triangle or not.
     * @param t is a Triangle object
     * @param p is a Point object
     * @return a boolean value
     */
    public static boolean isIn(Triangle t, Point p)
    {
        double triangleArea = getArea(t);
        Triangle subTriangle1 = new Triangle(p, t.getP2(), t.getP3());
        Triangle subTriangle2 = new Triangle(t.getP1(), p, t.getP3());
        Triangle subTriangle3 = new Triangle(t.getP1(), t.getP2(), p);

        double subTri1Area = getArea(subTriangle1);
        double subTri2Area = getArea(subTriangle2);
        double subTri3Area = getArea(subTriangle3);

        double totalArea = subTri1Area + subTri2Area + subTri3Area;

        if(totalArea == triangleArea)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks to see if the Point is within the Circle by
     * using the distance function and comparing that to the
     * circle radius
     * @param c is a Circle object
     * @param p is a Point object
     * @return a boolean value depending on if the Point is within
     * the Circle
     */
    public static boolean isIn(Circle c, Point p)
    {
        Point circleCenter = c.getCenter();
        double circleRadius = c.getRadius();
        double distance = distance(circleCenter, p);

        if(distance <= circleRadius)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks to see if the two circles overlap each other
     * by checking if the distance is less than the
     * sum of the radii.
     * @param c1 a Circle object
     * @param c2 a Circle object
     * @return a boolean value based on if the distance is less
     * than the radii or not
     */
    public static boolean isThereOverlap(Circle c1, Circle c2)
    {
        Point centerC1 = c1.getCenter();
        Point centerC2 = c2.getCenter();
        double sumRadii = c1.getRadius() + c2.getRadius();
        double distance = distance(centerC1, centerC2);

        if (distance < sumRadii)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}