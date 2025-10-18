class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
         TreeMap<Long, Integer> map = new TreeMap<>();
          int n = arr.length;
        long mult = (long)n + 1L; // bucket size larger than any index

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int diff = Math.abs(val - x);
            long key = ((long)diff) * mult + (long)i; // unique and preserves diff order
            map.put(key, val);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // now take first k closest elements
        int count = 0;
        for (long key : map.keySet()) {
            if (count == k) break;
            Integer val = map.get(key);
            if (val != null) {
                list.add(val);
                count++;
            }
        }
         Collections.sort(list);

        return list;
    }
}