class Solution {
    public boolean isPalindrome(String s) {
		String alpha = "abcdefghijklmnopqrstuvwxyz0123456789";
		final int len = s.length();
		int posFront = 0;
		int posBack = len - 1;

		while (posFront < posBack) {
			char charFront = Character.toLowerCase(s.charAt(posFront));
			if (alpha.indexOf(charFront) == -1) {
				posFront++;
				if (alpha.indexOf(Character.toLowerCase(s.charAt(posBack))) == -1) {
					posBack--;
				}
				continue;
			}
			
			char charBack = Character.toLowerCase(s.charAt(posBack));
			if (alpha.indexOf(charBack) == -1) {
				posBack--;
				continue;
			}

			if (charFront != charBack) {
				return false;
			}
			posFront++;
			posBack--;
		}
		return true;
	}
}
