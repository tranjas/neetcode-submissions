class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList();
        Set<Character> set = new HashSet();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : s.toCharArray()) {
            set.add(c);
            start++;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                set.remove(c);
            }
            if (set.isEmpty()) {
                result.add(start);
                start = 0;
            }
        }
        return result;
    }
}
