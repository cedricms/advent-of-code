package com.adventofcode.challenge2019;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Day4Test {

    @Test
    public void isPasswordValidGiven111111ThenTrue() throws Exception {
        // Given
        String input = "111111";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValid(input);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void isPasswordValidGiven223450ThenFalse() throws Exception {
        // Given
        String input = "223450";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValid(input);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void isPasswordValidGiven123789ThenFalse() throws Exception {
        // Given
        String input = "123789";
        Day4 day = new Day4();

        // When
        boolean result = day.isPasswordValid(input);

        // Then
        assertThat(result).isFalse();
    }
}