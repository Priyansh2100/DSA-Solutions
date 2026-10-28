class Solution {

    ArrayList<List<Integer>> result = new ArrayList<>();

    public void helper(int i,int k,ArrayList<Integer> temp,int n){

        if(k == 0){
            result.add(new ArrayList<>(temp));
            return;
        }


        // Pick the current element
       if(i<=n){

        temp.add(i);
      
        helper(i+1, k-1, temp,n);

        // Backtrack: remove the current element
        temp.remove(temp.size() - 1);

        // Do not pick the current element
        helper(i+1, k, temp,n);
       }


    }
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        helper(1,k,temp,n);
        return result;
    }
}