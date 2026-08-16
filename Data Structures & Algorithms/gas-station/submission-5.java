class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0, result = 0;
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0) return -1;
        sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += diff[i];
            if (sum < 0) {
                sum = 0;
                result = i + 1;
            }
        }
        return sum >= 0 ? result : -1;
    }
}
