package com.coding.task;


/**
 * Interval Class.
 */
public class Interval {
    private int start;
    private int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return start;
    }

    void setStart(int start) {
        this.start = start;
    }

    int getEnd() {
        return end;
    }

    void setEnd(int end) {
        this.end = end;
    }
}