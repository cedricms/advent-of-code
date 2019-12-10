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

    @Test
    public void getNumberOfPasswordsGiven123787_123794Then1() throws Exception {
        // Given
        String input = "123787-123794";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswords(input);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void getNumberOfPasswordsGiven123787_123802Then2() throws Exception {
        // Given
        String input = "123787-123802";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswords(input);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getNumberOfPasswordsGiven100001_100100Then17() throws Exception {
        // Given
        String input = "111111-111130";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswords(input);

        // Then
        assertThat(result).isEqualTo(17);
    }

    @Test
    public void getNumberOfPasswordsGiven264360_746325Then945() throws Exception {
        // Given
        String input = "264360-746325";
        Day4 day = new Day4();

        // When
        int result = day.getNumberOfPasswords(input);

        // Then
        assertThat(result).isEqualTo(945);
    }
}