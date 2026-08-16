class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        int low =  newInterval[0];
        int max = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            low = Math.min(low, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
            i++;
        }
        result.add(new int[]{low, max});
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}
