package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void shouldDividePositives() {

        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {

        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

    @Test
    public void shouldMultiplyPositives() {
        assertEquals(4, calc.multiply(2, 2));
    }
    @Test
    public void shouldMultiplyNegatives(){
        assertEquals(200, calc.multiply(-2, -100));
    }

    @Test
    public void shouldMultiplyNegAndPos(){
        assertEquals(-20, calc.multiply(-2,10));
    }

    @Test
    public void shouldMultiplyZeros(){
        assertEquals(0, calc.multiply(0, 3));
        assertEquals(0, calc.multiply(0, 0));
        assertEquals(0, calc.multiply(4, 0));

    }
    @Test
    public void shouldAddPositives(){
        assertEquals(6, calc.add(3, 3));
    }
    @Test
    public void shouldAddNegatives(){
        assertEquals(-6,calc.add(-3, -3));
    }
    @Test
    public void shouldAddNegAndPos(){
        assertEquals(-20, calc.add(-22,2));
        assertEquals(3, calc.add(-1, 4));
    }
    @Test
    public void shouldAddZeros(){
        assertEquals(-2, calc.add(-2, 0));
        assertEquals(2, calc.add(2, 0));
        assertEquals(0, calc.add(0, 0));
    }
    @Test
    public void shouldSubtractPostives(){
        assertEquals(5, calc.subtract(10, 5));
        assertEquals(-5, calc.subtract(5, 10));
    }
    @Test
    public void shouldSubtractNegatives(){
        assertEquals(-10, calc.subtract(-15,-5));
        assertEquals(1, calc.subtract(-3, -4));
    }
    @Test
    public void shouldSubtractNegAndPos(){
        assertEquals(-12, calc.subtract(-10, 2));
        assertEquals(12, calc.subtract(10, -2));
    }

    @Test
    public void shouldSubtractZeros(){
        assertEquals(-4, calc.subtract(-4,0));
        assertEquals(4, calc.subtract(0,-4));
        assertEquals(0, calc.subtract(0,0));
    }
}


