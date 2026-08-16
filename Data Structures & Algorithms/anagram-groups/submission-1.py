class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        result = []
        for i in strs:
            key = tuple(sorted(i))
            if key not in anagrams:
                anagrams[key] = []
            anagrams[key].append(i)
        return anagrams.values()
