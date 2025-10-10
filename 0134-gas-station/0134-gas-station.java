class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];
            if (tank < 0) {
                // Can't reach next station, reset start
                start = i + 1;
                tank = 0;
            }
        }

        // If total gas < total cost, it's impossible
        if (totalGas < totalCost) return -1;

        return start;
    }
}
