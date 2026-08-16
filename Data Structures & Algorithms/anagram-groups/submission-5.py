class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {} 
        for s in strs:
            ss = "".join(sorted(s))
            if ss not in m:
                m[ss] = []
            m[ss].append(s)
        return list(m.values())