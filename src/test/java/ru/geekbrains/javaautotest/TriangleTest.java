package ru.geekbrains.javaautotest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    TriangleArea triangleArea = new TriangleArea();
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Start testing");
    }

    @Test
    @DisplayName("Позитивный тест, все значения больше 0")
    public void testAllSidesNotZero() {
        boolean result = triangleArea.calculateTriangleArea(5, 5, 7);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Позитивный тест, расчет работает")
    public void testCalculated() {
        triangleArea.calculateTriangleArea(3, 3, 3);
        Assertions.assertEquals(2, triangleArea.getTriangleArea());
    }

    @Test
    @DisplayName("Первая сторона меньше или равна 0")
    public void testFirstSidesIsZero() {
        boolean result = triangleArea.calculateTriangleArea(0, 5, 7);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Вторая сторона меньше или равна 0")
    public void testSecondtSidesIsZero() {
        boolean result = triangleArea.calculateTriangleArea(55, 0, 17);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Третья сторона меньше или равна 0")
    public void testThirdtSidesIsZero() {
        boolean result = triangleArea.calculateTriangleArea(55, 4, 0);
        Assertions.assertFalse(result);
    }
}
