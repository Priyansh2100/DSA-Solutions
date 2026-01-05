class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score =0;
        int total_sum =0;

        int i = 0;
        int j = tokens.length-1;

        Arrays.sort(tokens);

        while(i<=j){
            if(power >= tokens[i]){
                power = power -tokens[i];
                score++;
                total_sum = Math.max(score,total_sum);
                i++;
            }
            else if(score>=1){
                power = power + tokens[j];
                score--;
                  total_sum = Math.max(score,total_sum);
                j--;
                
            }
            else{
                break;
            }

        }
return total_sum;
    }
}