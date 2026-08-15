class Solution:

    def encode(self, strs: List[str]) -> str:
        out = ""
        for string in strs:
            out += f"{len(string):03}{string}"
        return out


    def decode(self, s: str) -> List[str]:
        out = []
        while len(s) > 0:
            limit = int(s[0:3]) + 3
            out.append(s[3:limit])
            s = s[limit:]
        return out

