class Solution {
    public String longestCommonPrefix(String[] strs) {
        

          Arrays.sort(strs);
        
        String first = strs[0];
        String last = strs[strs.length-1];
        
        int idx =0;
        
        while(idx<first.length() && idx<last.length()){
            
            if(first.charAt(idx)!=last.charAt(idx)){
                
                break;
            }
            else {
                idx++;
            }
        }
        
        return first.substring(0,idx);
    }
}