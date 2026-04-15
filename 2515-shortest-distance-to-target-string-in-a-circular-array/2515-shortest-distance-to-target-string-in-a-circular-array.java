class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        
        int shortest = Integer.MAX_VALUE;
        int n = words.length;

        boolean flag = false;

        for(int i =0;i<n;i++){
            if(words[i].equals(target)){
                flag = true;
                int  diff = Math.abs(i-startIndex);
                int mindiff = Math.min(diff,(n-diff));
                shortest = Math.min(mindiff,shortest);
            }
        }
        if(flag){
            return shortest;
        }
       
        return -1;
    }
}