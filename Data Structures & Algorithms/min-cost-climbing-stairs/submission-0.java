class Solution {
    int[] cache;
    
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            cache[i] = -1;
        }
        // Start from step 0 or step 1, whichever is cheaper
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    
    public int dfs(int[] cost, int curr) {
        if (curr >= cost.length) {
            return 0; // Reached the top, no more cost
        }
        if (cache[curr] != -1) {
            return cache[curr]; // Return cached result if available
        }
        // Calculate the cost if we take 1 step or 2 steps from the current position
        int costOneStep = cost[curr] + dfs(cost, curr + 1);
        int costTwoSteps = cost[curr] + dfs(cost, curr + 2);
        
        // Store the minimum cost to reach the top from the current step
        cache[curr] = Math.min(costOneStep, costTwoSteps);
        return cache[curr];
    }
}