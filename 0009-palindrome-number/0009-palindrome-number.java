class Solution {
    public boolean isPalindrome(int x) {
        // negative numbers and numbers ending with 0 (but not zero itself) can't be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // when even length, x == reversedHalf
        // when odd length, reversedHalf/10 removes the middle digit
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
