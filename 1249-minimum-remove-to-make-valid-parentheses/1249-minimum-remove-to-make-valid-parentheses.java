class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stk = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stk.push(result.length());
                result.append(ch);
            }
            else if (ch == ')') {
                if (!stk.isEmpty()) {
                    stk.pop();
                    result.append(ch);
                }
            }
            else {
                result.append(ch);
            }
        }

        // Remove unmatched opening parentheses
        while (!stk.isEmpty()) {
            result.deleteCharAt(stk.pop());
        }

        return result.toString();
    }
}