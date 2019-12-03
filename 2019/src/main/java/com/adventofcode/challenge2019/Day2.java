package com.adventofcode.challenge2019;

import java.util.List;

public class Day2 extends Day {

    public String processIntcodePart1(String inputFilePath) {
        List<Integer> dataList = this.readFileWithCommasToIntegerList(inputFilePath);

        int[] data = convertListToIntArray(dataList);

        data = processIntcodePart1BusinessRules(data);

        return convertListToCommaSeperatedString(data);
    }

    private int[] processIntcodePart1BusinessRules(int[] data) {
        int i = 0;
        while (i < data.length) {
                int opcode = data[i];

            if (opcode != 99) {
                int position1 = data[i + 1];
                int position2 = data[i + 2];
                int position3 = data[i + 3];

                switch (opcode) {
                    case 1 :
                        data[position3] = data[position1] + data[position2];
                        break;
                    case 2 :
                        data[position3] = data[position1] * data[position2];
                        break;
                    default :
                        break;
                }
            } else {
                break;
            }

            i = i + 4;
        }

        return data;
    }

    private int[] convertListToIntArray(List<Integer> dataList) {
        if (dataList != null) {
            int[] data = new int[dataList.size()];

            for(int i = 0 ; i < dataList.size() ; i++) {
                data[i] = dataList.get(i).intValue();
            }

            return data;
        } else {
            return null;
        }
    }

    private String convertListToCommaSeperatedString(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < data.length ; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }

            stringBuilder.append(data[i]);
        }

        return stringBuilder.toString();
    }

    public String processIntcodePart1WithCorrectedData(String inputFilePath) {
        List<Integer> dataList = this.readFileWithCommasToIntegerList(inputFilePath);

        int[] data = convertListToIntArray(dataList);

        data = correctDataPart1(data);

        data = processIntcodePart1BusinessRules(data);

        return convertListToCommaSeperatedString(data);
    }

    private int[] correctDataPart1(int[] data) {
        data[1] = 12;
        data[2] = 2;

        return data;
    }
}