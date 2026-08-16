class Solution:

    def encode(self, strs: List[str]) -> str:
        result = ""
        for str in strs:
            result += str + "¥"
        return result

    def decode(self, s: str) -> List[str]:
        result = []
        curr = ""
        for i in s:
            if i == "¥":
                result.append(curr)
                curr = ""
            else:
                curr += i
        return result
            
