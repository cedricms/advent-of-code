package com.adventofcode.challenge2019;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day3Test {

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFileNoIntersectionThen0() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3TestNoIntersection.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(0);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFileSimpleIntersectionThen0() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3TestSimpleIntersection.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(5);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFileSimpleInversedIntersectionThen5() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3TestSimpleInversedIntersection.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(5);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFileDoubleIntersectionThen6() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3TestDoubleIntersection.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(6);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFile0Then6() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test0.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(6);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFile1Then159() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test1.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(159);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFile2Then135() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test2.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(135);
    }

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenPart1FileThen721() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(721);
    }

    @Test
    public void findFewestCombinedStepsWiresMustTakeToReachAnIntersectionGivenFile1Then610() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test1.data";
        Day3 day = new Day3();

        // When
        int fewestCombinedStepsWiresMustTakeToReachAnIntersection = day.findFewestCombinedStepsWiresMustTakeToReachAnIntersection(inputFilePath);

        // Then
        assertThat(fewestCombinedStepsWiresMustTakeToReachAnIntersection).isEqualTo(610);
    }

    @Test
    public void findFewestCombinedStepsWiresMustTakeToReachAnIntersectionFile2Then410() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test2.data";
        Day3 day = new Day3();

        // When
        int fewestCombinedStepsWiresMustTakeToReachAnIntersection = day.findFewestCombinedStepsWiresMustTakeToReachAnIntersection(inputFilePath);

        // Then
        assertThat(fewestCombinedStepsWiresMustTakeToReachAnIntersection).isEqualTo(410);
    }

    @Test
    public void findFewestCombinedStepsWiresMustTakeToReachAnIntersectionPart1FileThen7388() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day3/Day3Test.data";
        Day3 day = new Day3();

        // When
        int fewestCombinedStepsWiresMustTakeToReachAnIntersection = day.findFewestCombinedStepsWiresMustTakeToReachAnIntersection(inputFilePath);

        // Then
        assertThat(fewestCombinedStepsWiresMustTakeToReachAnIntersection).isEqualTo(7388);
    }
}