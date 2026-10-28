class Solution {

    ArrayList<List<Integer>> result = new ArrayList<>();

    public void helper(int[] candidates, int i, ArrayList<Integer> temp, int target) {

         if(i == candidates.length) return;

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

       // Pick the current element (only if it doesn't exceed target)
        if (candidates[i] <= target) {
            temp.add(candidates[i]);

            // Same index because unlimited reuse is allowed
            helper(candidates, i, temp, target - candidates[i]);

            // Backtrack
            temp.remove(temp.size() - 1);
        }

        // Don't pick the current element
        helper(candidates, i + 1, temp, target);
        }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<Integer> temp = new ArrayList<>();
        helper(candidates,0, temp, target);
        return result;

    }
}