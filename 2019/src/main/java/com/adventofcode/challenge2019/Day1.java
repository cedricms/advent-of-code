package com.adventofcode.challenge2019;

import java.util.List;

public class Day1 extends Day {

    public Long processFuelNeeds(String inputFilePath) {
        List<Long> data = this.readFileToLongList(inputFilePath);

        Long fuelNeeds = 0L;
        for(Long moduleMass : data) {
            Long fuelNeed = processModuleFuelNeed(moduleMass);

            fuelNeeds += fuelNeed;
        }

        return fuelNeeds;
    }

    private Long processModuleFuelNeed(Long moduleMass) {
        if (moduleMass != null) {
            return (moduleMass / 3) - 2;
        } else{
            return 0L;
        }
    }
}