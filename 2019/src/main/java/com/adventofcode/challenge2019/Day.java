package com.adventofcode.challenge2019;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class Day {

    public List<Long> readFileWithLinesToLongList(String inputFilePath) {
        List<Long> data = new ArrayList();

		try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
			stream.forEach(line -> data.add(Long.parseLong(line)));
		} catch (IOException ioe) {
			log.error("Unable to read the following file :" + inputFilePath, ioe);
        }

        return data;
    }

    public List<Integer> readFileWithCommasToIntegerList(String inputFilePath) {
        List<String> lines = new ArrayList();
        List<Integer> data = new ArrayList();

		try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
            stream.forEach(line -> lines.add(line));

            for (String line : lines) {
                data.addAll(parseCommaSeperatedLineToIntegerList(line));
            }
		} catch (IOException ioe) {
			log.error("Unable to read the following file :" + inputFilePath, ioe);
        }

        return data;
    }

    private List<Integer> parseCommaSeperatedLineToIntegerList(String line) {
        List<Integer> data = new ArrayList();

        String[] stringDatalist = line.split(",");

        for (String stringData : stringDatalist) {
            if (stringData != null) {
                data.add(Integer.parseInt(stringData));
            }
        }

        return data;
    }

    public List<String> readFileWithLinesToStringList(String inputFilePath) {
        List<String> data = new ArrayList();

		try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
			stream.forEach(line -> data.add(line));
		} catch (IOException ioe) {
			log.error("Unable to read the following file :" + inputFilePath, ioe);
        }

        return data;
    }
}