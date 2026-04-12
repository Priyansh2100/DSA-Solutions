class Solution {
    public int findContentChildren(int[] g, int[] s) {
         int gLen = g.length; // Greed Factor for students
        int sLen = s.length; // Cookies

        // Sort the array so the we can gready select the least required cookies for ith children with greedFactor greater than or equals to its requirement.
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        int ith_greedFactor = 0;
        int jth_cookies = 0;
        while(ith_greedFactor < gLen && jth_cookies < sLen){
            if(s[jth_cookies] >= g[ith_greedFactor]){ // Given Condition
                ith_greedFactor++; 
                res++;
            }
            jth_cookies++;
        }
        return res;
    }
}