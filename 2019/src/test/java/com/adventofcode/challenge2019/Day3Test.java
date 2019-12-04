package com.adventofcode.challenge2019;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day3Test {

    @Test
    public void findManhattanDistanceFromCentralPortToClosestIntersectionGivenFile1Then159() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day3Test1.data";
        Day3 day = new Day3();

        // When
        int manhattanDistance = day.findManhattanDistanceFromCentralPortToClosestIntersection(inputFilePath);

        // Then
        assertThat(manhattanDistance).isEqualTo(159);
    }

}