class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        char[] s1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] s2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int[] res = new int[s1.length + s2.length];

        for (int i = 0; i < s1.length; i++) {

            int carry = 0;
            int start = i;

            for (int j = 0; j < s2.length; j++) {

                int n1 = s1[i] - '0';
                int n2 = s2[j] - '0';

                int sum = (n1 * n2) + res[start] + carry;

                int digit = sum % 10;
                carry = sum / 10;

                res[start] = digit;
                start++;
            }

            if (carry != 0) {
                res[start] += carry;
            }
        }

        int i = res.length - 1;

        while (i > 0 && res[i] == 0) {
            i--;
        }

        StringBuilder ans = new StringBuilder();

        while (i >= 0) {
            ans.append(res[i]);
            i--;
        }

        return ans.toString();
    }
}