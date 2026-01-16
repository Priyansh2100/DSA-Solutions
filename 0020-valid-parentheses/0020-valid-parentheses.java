class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i) =='{' ||s.charAt(i)=='['){
                stk.push(s.charAt(i));
            }
            else{
                if(stk.isEmpty()){
                    return false;
                }
                else if(!match(stk.peek(),s.charAt(i))){
                    return false;
                }
                else{
                    stk.pop();
                }
            }

        }
        return stk.isEmpty();
    }
    static boolean match(char a , char b){
        return ( (a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'));
    }
}