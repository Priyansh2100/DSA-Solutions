class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stk = new Stack<>();

        String result = "";

        for(int i =0;i<s.length();i++){

            if(stk.isEmpty()){
                stk.push(s.charAt(i));
            }
            else if(stk.peek()!=s.charAt(i)){
                stk.push(s.charAt(i));
            }
            else{
                if(stk.peek()==s.charAt(i)){
                    stk.pop();
                }
            }

        }

        while(!stk.isEmpty()){
            result = stk.pop() + result;
        }

        return result;
    }
}