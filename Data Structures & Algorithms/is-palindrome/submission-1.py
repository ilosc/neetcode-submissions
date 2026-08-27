class Solution:
	def isPalindrome(self, s: str) -> bool:
		alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"
		length = len(s)
		p_init, p_end = 0, length - 1
		while (p_init < length) and (p_end >= 0):
			ci = s[p_init].lower()
			if ci not in alphabet:
				p_init += 1
				if s[p_end].lower() not in alphabet:
					p_end -= 1
				continue
			ce = s[p_end].lower()
			if ce not in alphabet:
				p_end -= 1
				continue
			if ci != ce:
				return False
			p_init += 1
			p_end -= 1

		return True