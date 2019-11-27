package com.coding.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MergeIntervalsTests {

    private void InputsMatchExpectedOutput(List<Interval> inputs, List<Interval> expectedOutputs) {
        Assert.assertEquals(expectedOutputs.size(), inputs.size());
        for (Interval expected: expectedOutputs ) {
            Assert.assertTrue(inputs.stream().anyMatch(i -> i.getStart() == expected.getStart() && i.getEnd() == expected.getEnd()));
        }
    }

    @Test
    void testParseIntervals() {
        String serialized = "[ 25,  30][2 , 19] [14,23] [4, 8]";
        List<Interval> parsed = MergeIntervals.parseIntervals(serialized);
        Assert.assertEquals(4, parsed.size());
        Assert.assertEquals(25, parsed.get(0).getStart());
        Assert.assertEquals(30, parsed.get(0).getEnd());
        Assert.assertEquals(2, parsed.get(1).getStart());
        Assert.assertEquals(19, parsed.get(1).getEnd());
        Assert.assertEquals(14, parsed.get(2).getStart());
        Assert.assertEquals(23, parsed.get(2).getEnd());
        Assert.assertEquals(4, parsed.get(3).getStart());
        Assert.assertEquals(8, parsed.get(3).getEnd());
    }

    @Test
    void testMergeIntervalsHappyFlow() {
        ArrayList<Interval> intervals = new ArrayList<Interval>() {
            {
                add(new Interval(1,5));
                add(new Interval(3,7));
                add(new Interval(0,10));
                add(new Interval(8,12));
                add(new Interval(14,22));
                add(new Interval(17,24));
            }
        };
        ArrayList<Interval> expectedResults = new ArrayList<Interval>() {
            {
                add(new Interval(0,12));
                add(new Interval(14,24));
            }
        };
        List<Interval> mergedIntervals = MergeIntervals.Merge(intervals);
        InputsMatchExpectedOutput(mergedIntervals, expectedResults);
    }

    @Test
    void testMergeIntervalsValues() {
        ArrayList<Interval> intervals = new ArrayList<Interval>() {
            {
                add(new Interval(0,0));     // 0 Interval
                add(new Interval(0,5));     // Overlapping Start
                add(new Interval(5,5));     // Overlapping + Zero
                add(new Interval(5,8));     // Overlapping End
                add(new Interval(6,7));     // Enclosed Values
                add(new Interval(-5,0));    // negative Start, End = current Start
            }
        };
        ArrayList<Interval> expectedResults = new ArrayList<Interval>() {
            {
                add(new Interval(-5,8));
            }
        };
        List<Interval> mergedIntervals = MergeIntervals.Merge(intervals);
        InputsMatchExpectedOutput(mergedIntervals, expectedResults);
    }

    @Test
    void testMergeIntervalsEmptyList() {
        ArrayList<Interval> intervals = new ArrayList<>();
        List<Interval> mergedIntervals = MergeIntervals.Merge(intervals);
        Assert.assertTrue(mergedIntervals.isEmpty());
    }

    @Test
    void testMergeIntervalsInvertedValues() {
        ArrayList<Interval> intervals = new ArrayList<Interval>() {
            {
                add(new Interval(5,1));
                add(new Interval(7,3));
                add(new Interval(10,-5));
                add(new Interval(8,12));
                add(new Interval(14,22));
                add(new Interval(17,24));
            }
        };
        ArrayList<Interval> expectedResults = new ArrayList<Interval>() {
            {
                add(new Interval(-5,12));
                add(new Interval(14,24));
            }
        };
        List<Interval> mergedIntervals = MergeIntervals.Merge(intervals);
        InputsMatchExpectedOutput(mergedIntervals, expectedResults);
    }

    @Test
    void testMergeIntervalsNull() {
        try {
            ArrayList<Interval> intervals = new ArrayList<Interval>() {
                {
                    add(new Interval(5,1));
                    add(null); // :)
                    add(new Interval(7,3));
                }
            };
            List<Interval> mergedIntervals = MergeIntervals.Merge(intervals);
        }
        catch (NullPointerException ex) {
            // Expected behavior
        }
        catch (Exception ex ) {
            Assert.fail();
        }
    }

}
