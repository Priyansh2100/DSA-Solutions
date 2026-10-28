
class Solution {

    ArrayList<List<Integer>> result = new ArrayList<>();

    public void helper(int[] candidates, int i,
                       ArrayList<Integer> temp, int target) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < candidates.length; j++) {

            // Skip duplicate elements at the same recursion level
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            // Array is sorted, so stop if the value exceeds target
            if (candidates[j] > target) {
                break;
            }

            // Pick the current element
            temp.add(candidates[j]);

            // Move to the next index: each element is used once
            helper(candidates, j + 1, temp,
                   target - candidates[j]);

            // Backtrack
            temp.remove(temp.size() - 1);

            // ek or helper use (isliya nhi hua kuike , we already use the for loop)
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {

        result.clear();
        Arrays.sort(candidates);

        ArrayList<Integer> temp = new ArrayList<>();
        helper(candidates, 0, temp, target);

        return result;
    }
}
