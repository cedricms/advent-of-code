package com.adventofcode.challenge2019.model;

import lombok.Data;

@Data
public class Point {

    private int x;
    private int y;

    public Point() {
        super();

        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this();

        this.x = x;
        this.y = y;
    }
}