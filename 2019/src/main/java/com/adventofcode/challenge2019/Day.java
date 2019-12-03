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

    public List<Long> readFileToLongList(String inputFilePath) {
        List<Long> data = new ArrayList();

		try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
			stream.forEach(line -> data.add(Long.parseLong(line)));
		} catch (IOException ioe) {
			log.error("Unable to read the following file :" + inputFilePath, ioe);
        }

        return data;
    }
}