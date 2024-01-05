//CSCI 1913 FALL 2022 KLUVER
//Author: Bethany Freeman

import java.awt.*;

public class DrawTree
{
    public static void main(String[] args)
    {
        //Variables
        //tree trunk
        Point p1 = new Point(100, 75);
        Point p2 = new Point(80, 200);
        Point p3 = new Point(120, 200);
        Triangle treeTrunk = new Triangle(p1, p2, p3);

        //Tree top
        Point tr1 = new Point(80, 70);
        Point tr2 = new Point(40, 120);
        Point tr3 = new Point(160, 120);
        Point tr4 = new Point(132,70);
        Point tr5 = new Point(100, 75);

        Point[] points = new Point[] {tr1, tr2, tr3, tr4, tr5};
        Triangle[] triangles = ShapeUtils.makeFakePoly(points);

        //Moon
        Point center = new Point(25, 25);
        double radius = 10.0;
        Circle moon = new Circle(center, radius);

        Point centerDark = new Point(30, 25);
        Circle moonDark = new Circle(centerDark, radius);

        //Tree decorations
        Point fruitCenter = new Point(120, 120);
        Point fruitCenter2 = new Point (130, 100);
        Point fruitCenter3 = new Point (90, 95);
        double fruitRadius = 4;
        Circle fruit = new Circle(fruitCenter, fruitRadius);
        Circle fruit2 = new Circle(fruitCenter2, fruitRadius);
        Circle fruit3 = new Circle(fruitCenter3, fruitRadius);


        //Colors
        Color treeTopColor = new Color(214, 75, 189);
        Color treeTrunkColor = new Color(111, 156,214);
        Color treeTopOutline = new Color(224, 135,92);
        Color treeFruitColor = new Color(227, 207,129);
        Color moonColor = new Color(202,240,192);

        //create shapeDrawer
        /*
        Origin starts with (0,0) in the upper left corner.
        Moving right, x increases.
        Moving down, y increases.
         */
        ShapeDrawer drawer = new ShapeDrawer(200,200);

        //Create Tree
        drawer.setStroke(treeTrunkColor);
        drawer.setFill(treeTrunkColor);
        drawer.draw(treeTrunk);

        //Create Tree-top
        drawer.setStroke(treeTopOutline);
        drawer.setFill(treeTopColor);
        for(int i = 0;i < triangles.length; i++)
        {
            drawer.draw(triangles[i]);
        }

        //Create Moon
        drawer.setStroke(moonColor);
        drawer.setFill(moonColor);
        drawer.draw(moon);
        drawer.setFill(Color.BLACK);
        drawer.setStroke(Color.BLACK);
        drawer.draw(moonDark);

        //Create Tree Decoration
        drawer.setStroke(treeFruitColor);
        drawer.setFill(treeFruitColor);
        drawer.draw(fruit);
        drawer.draw(fruit2);
        drawer.draw(fruit3);

        //Create image
        boolean file = drawer.writeToFile("tree.png");
        System.out.print(file);
    }
}
