class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        m = {}
        for s in strs:
            s_sorted = "".join(sorted(s))
            if s_sorted in m:
                m[s_sorted].append(s)
            else:
                m[s_sorted] = [s]
            
        result = list(m.values())
        return result
