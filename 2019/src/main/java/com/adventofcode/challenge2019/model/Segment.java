package com.adventofcode.challenge2019.model;

import lombok.Data;

@Data
public class Segment {

    private int x1;
    private int y1;

    private int x2;
    private int y2;

    public Segment() {
        super();

        this.x1 = 0;
        this.y1 = 0;

        this.x2 = 0;
        this.y2 = 0;
    }

    public Segment(int x1, int y1, int x2, int y2) {
        this();

        // Order left to right and down to up
        if (x1 <= x2) {
            this.x1 = x1;
            this.x2 = x2;

            if (y1 <= y2) {
                this.y1 = y1;
                this.y2 = y2;
            } else {
                this.y1 = y2;
                this.y2 = y1;
            }
        } else {
            this.x1 = x2;
            this.x2 = x1;

            if (y1 <= y2) {
                this.y1 = y2;
                this.y2 = y1;
            } else {
                this.y1 = y1;
                this.y2 = y2;
            }

        }
    }

    public boolean isHorizontal() {
        return y1 == y2;
    }

    public boolean isVertical() {
        return x1 == x2;
    }
}