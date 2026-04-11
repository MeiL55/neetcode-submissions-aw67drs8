class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //merge it, and return the size - 1
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        //List<int[]> merge = new ArrayList<>();
        int count = 0;
        int lastEnd = intervals[0][1];
        //merge.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            //int lastEnd = merge.get(merge.size()-1)[1];
            if (start < lastEnd) {
                count++; //there is an overlap
                lastEnd = Math.min(end, lastEnd);//so that we can keep more intervals
            } else {
                lastEnd = end; //no-overlap
            }
        }
        return count;
    }
}
