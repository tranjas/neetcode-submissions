
class TimeMap {
    // Outer HashMap: key -> inner HashMap (timestamp -> value)
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // If the key doesn't exist, create a new TreeMap for it
        map.putIfAbsent(key, new TreeMap<>());
        // Add the (timestamp, value) pair to the TreeMap
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        // If the key doesn't exist, return an empty string
        if (!map.containsKey(key)) {
            return "";
        }

        // Get the TreeMap for the key
        TreeMap<Integer, String> treeMap = map.get(key);

        // Find the largest timestamp <= the given timestamp
        Integer floorKey = treeMap.floorKey(timestamp);

        // If such a timestamp exists, return the corresponding value; otherwise, return an empty string
        return floorKey != null ? treeMap.get(floorKey) : "";
    }
}