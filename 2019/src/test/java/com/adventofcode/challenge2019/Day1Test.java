package com.adventofcode.challenge2019;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import com.adventofcode.challenge2019.Day1;

public class Day1Test {

    @Test
    public void readFileToLongListGivenFileThenLongList() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/LongTestList.data";
        Day1 day = new Day1();

        // When
        List<Long> longList = day.readFileToLongList(inputFilePath);

        // Then
        assertThat(longList).isNotNull();
        assertThat(longList.size()).isEqualTo(4);
    }

    @Test
    public void processFuelNeedsGiven12Then2() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day1/Day1Test1.data";
        Day1 day = new Day1();

        // When
        Long fuelNeeds = day.processFuelNeeds(inputFilePath);

        // Then
        assertThat(fuelNeeds).isNotNull();
        assertThat(fuelNeeds).isEqualTo(2L);
    }

    @Test
    public void processFuelNeedsGiven14Then2() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day1/Day1Test2.data";
        Day1 day = new Day1();

        // When
        Long fuelNeeds = day.processFuelNeeds(inputFilePath);

        // Then
        assertThat(fuelNeeds).isNotNull();
        assertThat(fuelNeeds).isEqualTo(2L);
    }

    @Test
    public void processFuelNeedsGiven1969Then654() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day1/Day1Test3.data";
        Day1 day = new Day1();

        // When
        Long fuelNeeds = day.processFuelNeeds(inputFilePath);

        // Then
        assertThat(fuelNeeds).isNotNull();
        assertThat(fuelNeeds).isEqualTo(654L);
    }

    @Test
    public void processFuelNeedsGiven100756Then33583() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day1/Day1Test4.data";
        Day1 day = new Day1();

        // When
        Long fuelNeeds = day.processFuelNeeds(inputFilePath);

        // Then
        assertThat(fuelNeeds).isNotNull();
        assertThat(fuelNeeds).isEqualTo(33583L);
    }

    @Test
    public void processFuelNeedsGivenChallengeFileThen3393938() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day1/Day1Test.data";
        Day1 day = new Day1();

        // When
        Long fuelNeeds = day.processFuelNeeds(inputFilePath);

        // Then
        assertThat(fuelNeeds).isNotNull();
        assertThat(fuelNeeds).isEqualTo(3393938L);
    }
}