class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map <Integer, Integer> map = new HashMap();
        Arrays.sort(hand);
        for (int i = 0 ; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for (int i : hand) {
            if (map.get(i) == 0) continue;
            for (int j = i; j < i + groupSize; j++) {
                if (map.getOrDefault(j, 0) == 0) return false;
                map.put(j, map.get(j) - 1);
            }
        }
        return true;
    }
}
