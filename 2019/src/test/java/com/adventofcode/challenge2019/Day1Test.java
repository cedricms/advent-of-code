package com.adventofcode.challenge2019;

import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import com.adventofcode.challenge2019.Day1;

public class Day1Test {

    @Test
    public void readFileToLongListGivenFileThenLongList() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/LongTestList.txt";
        Day1 day = new Day1();

        // When
        List<Long> longList = day.readFileToLongList(inputFilePath);

        // Then
        assertThat(longList).isNotNull();
        assertThat(longList.size()).isEqualTo(4);
    }
}