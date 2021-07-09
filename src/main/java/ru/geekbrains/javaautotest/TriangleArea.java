package ru.geekbrains.javaautotest;

import java.text.DecimalFormat;

public class TriangleArea {

    private static double triangleArea;

    public static boolean calculateTriangleArea(int firstSideTriangle, int secondSideTriangle, int thirdSideTriangle) {

        if (firstSideTriangle > 0 && secondSideTriangle > 0 && thirdSideTriangle > 0) {
            double halfPerimeter = (firstSideTriangle + secondSideTriangle + thirdSideTriangle) / 2;
            triangleArea = Math.sqrt(halfPerimeter * (halfPerimeter - firstSideTriangle)
                    * (halfPerimeter - secondSideTriangle) * (halfPerimeter - thirdSideTriangle));
            DecimalFormat df = new DecimalFormat("#0.00");
            System.out.println(df.format(triangleArea));
            return true;
        } else {
            System.out.println("Одно из значений меньше 0");
            return false;
        }

    }

    public double getTriangleArea() {
        return triangleArea;
    }
}
