package com.adventofcode.challenge2019;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class Day2Test {

    @Test
    public void readFileWithCommasToIntegerListGivenFileThenIntegerList() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/LongCommasTestList.data";
        Day2 day = new Day2();

        // When
        List<Integer> integerList = day.readFileWithCommasToIntegerList(inputFilePath);

        // Then
        assertThat(integerList).isNotNull();
        assertThat(integerList.size()).isEqualTo(12);
    }

    @Test
    public void processIntcodePart1GivenFile1ThenCorrectString() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test1.data";
        Day2 day = new Day2();

        // When
        String result = day.processIntcodePart1(inputFilePath);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("3500,9,10,70,2,3,11,0,99,30,40,50");
    }

    @Test
    public void processIntcodePart1GivenFile2ThenCorrectString() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test2.data";
        Day2 day = new Day2();

        // When
        String result = day.processIntcodePart1(inputFilePath);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("2,0,0,0,99");
    }

    @Test
    public void processIntcodePart1GivenFile3ThenCorrectString() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test3.data";
        Day2 day = new Day2();

        // When
        String result = day.processIntcodePart1(inputFilePath);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("2,3,0,6,99");
    }

    @Test
    public void processIntcodePart1GivenFile4ThenCorrectString() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test4.data";
        Day2 day = new Day2();

        // When
        String result = day.processIntcodePart1(inputFilePath);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("2,4,4,5,99,9801");
    }

    @Test
    public void processIntcodePart1GivenFile5ThenCorrectString() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test5.data";
        Day2 day = new Day2();

        // When
        String result = day.processIntcodePart1(inputFilePath);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("30,1,1,4,2,5,6,0,99");
    }

    @Test
    public void processIntcodePart1GivenFileThenCorrectString() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test.data";
        Day2 day = new Day2();

        // When
        String result = day.processIntcodePart1WithCorrectedData(inputFilePath);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("3306701,12,2,2,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,60,1,9,19,63,2,23,13,315,1,27,9,318,2,31,6,636,1,5,35,637,1,10,39,641,2,43,6,1282,1,10,47,1286,2,6,51,2572,1,5,55,2573,1,59,9,2576,1,13,63,2581,2,6,67,5162,1,5,71,5163,2,6,75,10326,2,79,6,20652,1,13,83,20657,1,9,87,20660,1,9,91,20663,1,5,95,20664,1,5,99,20665,2,13,103,103325,1,6,107,103327,1,9,111,103330,2,6,115,206660,1,13,119,206665,1,123,6,206667,1,127,5,206668,2,10,131,826672,2,135,10,3306688,1,13,139,3306693,1,10,143,3306697,1,2,147,3306699,1,6,151,0,99,2,14,0,0");

        // The solution is : 3306701
    }

    @Test
    public void findNounAndVerbByOutputGivenFileAnd3306701Then1202() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test.data";
        String output = "3306701";
        Day2 day = new Day2();

        // When
        String result = day.findNounAndVerbByOutput(inputFilePath, output);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("1202");
    }

    @Test
    public void findNounAndVerbByOutputGivenFileAnd19690720Then7621() throws Exception {
        // Given
        String inputFilePath = "./src/test/resources/Day2/Day2Test.data";
        String output = "19690720";
        Day2 day = new Day2();

        // When
        String result = day.findNounAndVerbByOutput(inputFilePath, output);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("7621");
    }
}