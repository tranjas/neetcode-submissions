class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int max1 = 0, max2 = 0, max3  = 0;
        for (int[] num : triplets) {
            int curr1 = num[0], curr2 = num[1], curr3 = num[2];
            if (curr1 <= target[0] && curr2 <= target[1] && curr3 <= target[2]) {
                max1 = Math.max(max1, curr1);
                max2 = Math.max(max2, curr2);
                max3 = Math.max(max3, curr3);
            }
        }
        return max1 == target[0] && max2 == target[1] && max3 == target[2];
    }
}
