package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//question -> https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) return new ArrayList<>();

        Stack<Interval> piledIntervals = new Stack<Interval>();
        Collections.sort(intervals);

        piledIntervals.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval top = piledIntervals.peek();

            if (top.end < intervals.get(i).start) {
                piledIntervals.push(intervals.get(i));
            }

            //adjust two scope
            else if (top.end < intervals.get(i).end) {
                top.end = intervals.get(i).end;
                piledIntervals.pop();
                piledIntervals.push(top);
            }
        }
        return piledIntervals.stream().toList();
    }
}
