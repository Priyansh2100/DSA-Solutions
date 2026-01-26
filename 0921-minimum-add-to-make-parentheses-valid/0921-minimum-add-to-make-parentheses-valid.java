class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();

        int open =0;

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(ch);
            }else if(!stk.isEmpty()){
                stk.pop();
            }else{
               open++;
            }
        }

        return open + stk.size();
    }
}