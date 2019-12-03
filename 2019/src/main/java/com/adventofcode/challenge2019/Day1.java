package com.adventofcode.challenge2019;

import java.util.List;

public class Day1 extends Day {

    public Long processFuelNeedsPart1(String inputFilePath) {
        List<Long> data = this.readFileWithLinesToLongList(inputFilePath);

        Long fuelNeeds = 0L;
        for(Long moduleMass : data) {
            Long fuelNeed = processModuleFuelNeedPart1(moduleMass);

            fuelNeeds += fuelNeed;
        }

        return fuelNeeds;
    }

    private Long processModuleFuelNeedPart1(Long moduleMass) {
        if (moduleMass != null) {
            return (moduleMass / 3) - 2;
        } else{
            return 0L;
        }
    }

    public Long processFuelNeedsPart2(String inputFilePath) {
        List<Long> data = this.readFileWithLinesToLongList(inputFilePath);

        Long fuelNeeds = 0L;
        for(Long moduleMass : data) {
            Long fuelNeed = processModuleFuelNeedPart2(moduleMass);

            fuelNeeds += fuelNeed;
        }

        return fuelNeeds;
    }

    private Long processModuleFuelNeedPart2(Long moduleMass) {
        if (moduleMass != null) {
            Long fuelNeed = (moduleMass / 3) - 2;

            if (fuelNeed <= 0) {
                return 0L;
            }

            Long fuelMass = processModuleFuelNeedPart2(fuelNeed);

            if (fuelMass >= 0) {
                return fuelNeed + fuelMass;
            } else {
                if (fuelNeed > 0) {
                    return fuelNeed;
                } else {
                    return 0L;
                }
            }
        } else{
            return 0L;
        }
    }
}