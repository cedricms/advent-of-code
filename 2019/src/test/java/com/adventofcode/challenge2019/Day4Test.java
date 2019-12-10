package com.adventofcode.challenge2019;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day4Test {

    @Test
    public void isPasswordValidPart1Given111111ThenTrue() throws Exception {
        // Given
        String input = "111111";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart1(input);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void isPasswordValidPart1Given223450ThenFalse() throws Exception {
        // Given
        String input = "223450";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart1(input);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void isPasswordValidPart1Given123789ThenFalse() throws Exception {
        // Given
        String input = "123789";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart1(input);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void getNumberOfPasswordsPart1Given123787_123794Then1() throws Exception {
        // Given
        String input = "123787-123794";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswordsPart1(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getNumberOfPasswordsPart1Given123787_123802Then2() throws Exception {
        // Given
        String input = "123787-123802";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswordsPart1(input);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getNumberOfPasswordsPart1Given100001_100100Then17() throws Exception {
        // Given
        String input = "111111-111130";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswordsPart1(input);

        // Then
        assertThat(result).isEqualTo(17);
    }

    @Test
    public void getNumberOfPasswordsPart1Given264360_746325Then945() throws Exception {
        // Given
        String input = "264360-746325";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswordsPart1(input);

        // Then
        assertThat(result).isEqualTo(945);
    }

    @Test
    public void isPasswordValidPart2Given112233ThenTrue() throws Exception {
        // Given
        String input = "112233";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart2(input);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void isPasswordValidPart2Given123444ThenFalse() throws Exception {
        // Given
        String input = "123444";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart2(input);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void isPasswordValidPart2Given111122ThenTrue() throws Exception {
        // Given
        String input = "111122";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart2(input);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void isPasswordValidPart2Given112223ThenTrue() throws Exception {
        // Given
        String input = "112223";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValidPart2(input);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void getNumberOfPasswordsPart2Given264360_746325Then617() throws Exception {
        // Given
        String input = "264360-746325";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswordsPart2(input);

        // Then
        assertThat(result).isEqualTo(617);
    }
}