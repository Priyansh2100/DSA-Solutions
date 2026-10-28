class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> totalsubsets(
            int[] nums, int i, ArrayList<Integer> temp) {

        if (i >= nums.length) {
            result.add(new ArrayList<>(temp));
            return result;
        }

        // Pick the current element
        temp.add(nums[i]);
        totalsubsets(nums, i + 1, temp);

        // Backtrack: remove the current element
        temp.remove(temp.size() - 1);

        // Do not pick the current element
        totalsubsets(nums, i + 1, temp);

        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        result.clear();

        return totalsubsets(nums, 0, temp);
    }
}