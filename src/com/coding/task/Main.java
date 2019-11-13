/*
    Program to merge intervals
 */

package com.coding.task;

import java.util.*;


public class Main {
    /**
     * Main program.
     * @param args Commandline arguments
     */
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(25, 30),
                new Interval(2, 19),
                new Interval(14, 23),
                new Interval(4, 8)
        );
        // merge example intervals
        List<Interval> mergedIntervals = MergeIntervals(intervals);
        // Print result (Expected: [2,23][25,30])
        System.out.print("Merge result: ");
        for (Interval interval : mergedIntervals) {
            System.out.print("[" + interval.getStart() + "," + interval.getEnd() + "]");
        }
    }

    /**
     * Merge Intervals Method.
     * Merges overlapping intervals
     * run-time: O(n*log(n))
     * memory: O(n)
     * @param intervals array of intervals to merge
     */
    private static List<Interval> MergeIntervals(List<Interval> intervals)
    {
        if(intervals.size() <= 1)
            // Return if the array is empty or contains only 1 element
            return intervals;
        // Order intervals by start value
        intervals.sort(Comparator.comparingInt(Interval::getStart));

        Stack<Interval> mergedIntervals = new Stack<>();
        mergedIntervals.push(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++) {
            Interval top = mergedIntervals.peek();
            // If the current interval overlaps with top
            if(top.getEnd() >= intervals.get(i).getStart()) {
                // set end value to maximum between top and intervals[i]
                top.setEnd(Math.max(top.getEnd(), intervals.get(i).getEnd()));
                // set start value to minimum between top and intervals[i]
                top.setStart(Math.min(top.getStart(), intervals.get(i).getStart()));
            }
            else
            {
                // push current interval to result-stack
                mergedIntervals.push(intervals.get(i));
            }
        }
        return new ArrayList<>(mergedIntervals);
    }
}
