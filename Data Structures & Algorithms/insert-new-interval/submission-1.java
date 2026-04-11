class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int n = intervals.length;
        int target = newInterval[0];
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //at last, left will at right, where mid - 1
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            list.add(intervals[i]);
        }
        list.add(newInterval);
        for (int i = left; i < n; i++) {
            list.add(intervals[i]);
        }
        List<int[]> merge = new ArrayList<>();
        merge.add(list.get(0));
        for (int[] interval: list) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = merge.get(merge.size()-1)[1];
            if (start <= lastEnd) {
                merge.get(merge.size()-1)[1] = Math.max(end, lastEnd);
            } else {
                merge.add(new int[]{start, end});
            }
        }
        return merge.toArray(new int[merge.size()][2]);
    }
}
