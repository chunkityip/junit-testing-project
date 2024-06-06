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
        System.out.println("Test begin to start....");
    }

    @AfterAll
    public static void setAfterAllTest() {
        System.out.println("Test begin to exit....");
    }

    @BeforeEach
    public void setUp() {
        maths = new Maths();
        System.out.println("Test case starting.....");
    }

    @AfterEach
    public void tearDown() {
        maths = null;
        System.out.println("Test cast exiting......");
    }

    //happy part
    @Test
    @DisplayName("add() should work since the expected number is correct")
    public void addShouldWork() {
        //Given
        int p1 = 3 , p2 = 10;

        //When
        int num = maths.add(p1 , p2);

        //Then
        assertEquals(13 , num);
    }

    //unhappy part
    @Test
    @DisplayName("add() shouldn't work since the expected number isn't correct")
    public void addShouldNotWork() {
        //Given
        int p1 = 3 , p2 = 10;

        //When
        int num = maths.add(p1 , p2);

        //Then
        assertNotEquals(8 , num);
    }

    @Test
    @DisplayName("sub() should work since the expected number is correct")
    public void subShouldWork() {
        //Given
        int p1 = 15 , p2 = 5;

        //When
        int num = maths.sub(p1 , p2);

        //Then
        assertEquals(10 , num);
    }

    @Test
    @DisplayName("sub() should not work since the expected number isn't correct")
    public void subShouldNotWork() {
        //Given
        int p1 = 15 , p2 = 5;

        //When
        int num = maths.sub(p1 , p2);

        //Then
        assertNotEquals(20 , num);
    }

    @ParameterizedTest
    @CsvSource({"3, 5"})
    @DisplayName("multiply() should work since the the expected number is correct")
    public void multiplyShouldWork(int p1 , int p2) {
        int num = maths.multiply(p1 , p2);
        assertEquals(15 , num);
    }

    @ParameterizedTest
    @CsvSource({"3 ,5"})
    public void multiplyShouldNotWork(int p1 , int p2) {
        int num = maths.multiply(p1 , p2);
        assertNotEquals(25 , num);
    }

    @ParameterizedTest
    @CsvSource({"20 , 5"})
    public void divideShouldWork(int p1 , int p2) {
        int num = maths.divide(p1 , p2);
        assertEquals(4 , num);
    }

    @ParameterizedTest
    @CsvSource({"20 , 5"})
    public void divideShouldNotWork(int p1 , int p2) {
        int num = maths.divide(p1 , p2);
        assertNotEquals(50 , num);
    }


}

