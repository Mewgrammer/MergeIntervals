package com.coding.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervalsTests {

    @Test
    public void testParseIntervals() {
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
}
