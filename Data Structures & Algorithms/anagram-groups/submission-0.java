class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>(Arrays.asList(str)));
            } else {
                map.get(key).add(str);
            }
        }
        
        return new ArrayList<>(map.values());

    }
}
