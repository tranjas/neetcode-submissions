class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String temp = s2.substring(i, i + s1.length());
            if (perm(s1, temp)) return true;
        }
        return false;
    }

    public boolean perm (String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String n1 = new String(c1);
        String n2 = new String(c2);
        return n1.equals(n2);
    }

}
