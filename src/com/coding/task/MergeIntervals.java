package com.coding.task;
/*
    Program to merge intervals
 */
import java.util.*;


public class MergeIntervals {
    /**
     * Main program.
     * @param args Commandline arguments
     */
    public static void main(String[] args) {
        List<Interval> intervals;
        if(args.length > 1) {
            intervals = parseIntervals(args[1]);
        }
        else {
            intervals = Arrays.asList(
                    new Interval(25, 30),
                    new Interval(2, 19),
                    new Interval(14, 23),
                    new Interval(4, 8)
            );
        }
        // merge example intervals
        List<Interval> mergedIntervals = Merge(intervals);
        // Print result (Expected: [2,23][25,30])
        System.out.print("Merge result: ");
        for (Interval interval : mergedIntervals) {
            System.out.print("[" + interval.getStart() + "," + interval.getEnd() + "]");
        }
    }

    /**
     * Parse Intervals Method.
     * Parses Intervals from String
     * Expected string format: [start,end][start,end][start,end]
     * @param serialized string of intervals in expected format
     */
    static List<Interval> parseIntervals(String serialized) {
        ArrayList<Interval> intervals = new ArrayList<>();
        if(serialized.length() <= 2) return intervals;
        String[] splitStr = serialized.replace("[", "").split("]");
        for (String intervalStr: splitStr) {
            try {
                String[] pair = intervalStr.split(",");
                intervals.add(new Interval(Integer.parseInt(pair[0].trim()), Integer.parseInt(pair[1].trim())));
            }
            catch (Exception ex) {
                System.err.println("Failed to parse Interval-String: '" + intervalStr + "' - " + ex.getMessage());
            }
        }
        return intervals;
    }

    /**
     * Merge Intervals Method.
     * Merges overlapping intervals
     * run-time: O(n*log(n))
     * memory: O(n)
     * @param intervals List of intervals to merge
     * @return mergedIntervals List of merged intervals
     * @throws NullPointerException if the list or a Element within the list is null
     */
    static List<Interval> Merge(List<Interval> intervals)
    {
        if(intervals.size() <= 1){
            // Return if the array is empty or contains only 1 element
            return intervals;
        }
        // Order intervals by start value
        intervals.sort(Comparator.comparingInt(i -> {
            if(i.getStart() > i.getEnd()) {
                // Fix Start/End order if inverted
                int endVal = i.getStart();
                i.setStart(i.getEnd());
                i.setEnd(endVal);
            }
            return i.getStart();
        }));
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
