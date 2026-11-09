class Solution {

    ArrayList<String> result = new ArrayList<>();

    public boolean isValid(String curr){
        int sum = 0;

        int i =0;
        while(i<curr.length()){
            if(curr.charAt(i)== '('){
                sum = sum +1;
            }
            else{
                 sum = sum -1;
            }

            if (sum < 0) {
            return false;
        }
            i++;
            
        }
        return sum == 0;
    }

    public void generate(String curr,int n,int length,ArrayList<String> result){

        if(length == 2*n){
            if(isValid(curr)){
                result.add(curr);
            }
            return;
        }

        curr = curr + '(';
        generate(curr,n,length+1,result);
        curr = curr.substring(0,curr.length()-1);

        curr = curr + ')';
        generate(curr,n,length+1,result);

    }
    public List<String> generateParenthesis(int n) {
        
        generate("",n,0,result);
        return result;
    }
}





    //                      generate("", 2, 0)
    //                             |
    //               -------------------------
    //               |                       |
    //            Pick (                  Pick )
    //               |                       |
    //          generate("(")           generate(")")
    //               |                       |
    //          ------------             ------------
    //          |          |             |          |
    //       Pick (     Pick )        Pick (     Pick )
    //          |          |             |          |
    //       "(("        "()"           ")("        "))"
    //          |          |             |          |
    //       --------    --------      --------    --------
    //       |      |    |      |      |      |    |      |
    //     Pick ( Pick ) Pick ( Pick ) Pick ( Pick ) Pick ( Pick )
    //       |     |     |     |        |     |     |     |
    //     "((("  "(()"  "()(" "())"  ")((" ")()"  "))(" ")))"
    //       |     |     |     |     |     |     |     |
    //     ------ ------ ------ ------ ------ ------ ------
    //     |    | |    | |    | |    | |    | |    | |    |
    //     (    ) (    ) (    ) (    ) (    ) (    ) (    )
    //     |    | |    | |    | |    | |    | |    | |    |
    //    ------------------------------------------------
    //                Length = 4