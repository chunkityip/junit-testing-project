package com.example.junit_testing_project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MathsTest {

    private Maths maths;

    @BeforeAll
    public static void setBeforeAllTest() {
        System.out.println("Test begin:");
    }

    @AfterAll
    public static void setAfterAllTest() {
        System.out.println("Test finish");
    }

    @BeforeEach
    public void setUp() {
        maths = new Maths();
        System.out.println("Test case begin");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test case end");
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "10, 20",
            "7, 8"
    })
    @DisplayName("Testing add() with different arguments")
    public void addMethodShouldPass(int p1, int p2) {
        int result = maths.add(p1, p2);

        //happy part
        assertEquals(p1 + p2, result, "Sum should match");

        //Unhappy part
        assertNotEquals(p1 * p2, result, "Sum should not match product");
    }

    @ParameterizedTest
    @CsvSource({
            "3 , 5",
            "7 , 15",
            "10 , 20"
    })
    @DisplayName("Testing sub() with different arguments")
    public void subMethodShouldPass(int p1 , int p2) {
        int result = maths.sub(p1 , p2);

        //happy part
        assertEquals(p1 - p2 , result);

        //Unhappy part
        assertNotEquals(p1 + p2 , result);
    }

    @ParameterizedTest
    @CsvSource({
            "5 , 10",
            "15 , 20",
            "8 , 10"
    })
    public void multiplyShouldPass(int p1 , int p2) {
        int result = maths.multiply(p1 , p2);

        //happy part
        assertEquals(p1 * p2 , result);

        //Unhappy part
        assertNotEquals(p1 / p2 , result);
    }

    @ParameterizedTest
    @CsvSource({
            "50 , 10",
            "10 , 5",
            "2 , 4"
    })
    public void divideShouldPass(int p1 , int p2) {

        int result = maths.divide(p1 , p2);

        //Happy part
        assertEquals(p1 / p2 , result);

        //Unhappy part
        assertNotEquals(p1 * p2 , result);
    }
}

