package solutions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    public void testNonOverlappingIntervals() {
        List<MergeIntervals.Interval> intervals = new ArrayList<>();
        intervals.add(create(3, 4));
        intervals.add(create(5, 6));
        intervals.add(create(1, 2));

        List<MergeIntervals.Interval> result = MergeIntervals.merge(intervals);

        assertEquals(result.size(), 3);
    }

    @Test
    public void testOverlappingIntervals() {
        List<MergeIntervals.Interval> intervals = new ArrayList<>();
        intervals.add(create(3, 9));
        intervals.add(create(5, 6));
        intervals.add(create(1, 2));

        List<MergeIntervals.Interval> result = MergeIntervals.merge(intervals);

        assertEquals(result.size(), 2);
    }

    private MergeIntervals.Interval create(int start, int end) {
        return new MergeIntervals.Interval(start, end);
    }
}
