class Solution {
    public int firstUniqChar(String s) {
        
       Map<Character,Integer> map=new HashMap<>();
       for(char ch : s.toCharArray())
       {
         map.put(ch,map.getOrDefault(ch,0)+1);
       }

       // Step 2: scan in order, return index of first char with count == 1
       for(int i=0;i<s.length();i++)
       {
         if(map.get(s.charAt(i))==1)   // appears exactly once -> first unique
         {
           return i;
         }
       }

       return -1;   // no unique character found
    }
}