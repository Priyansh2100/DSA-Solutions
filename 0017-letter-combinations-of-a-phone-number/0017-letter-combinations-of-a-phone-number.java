class Solution {

    ArrayList<String> result = new ArrayList<>();

    public void solve(int idx, String digits, HashMap<Character, String> map, StringBuilder sb) {

        if (idx >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(idx);

        String temp = map.get(ch);

        for (int j = 0; j < temp.length(); j++) {

            // DO
            sb.append(temp.charAt(j));

            // Recursive call
            solve(idx + 1, digits, map, sb);

            // UNDO (Backtracking)
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, digits, map, sb);

        return result;

    }
}