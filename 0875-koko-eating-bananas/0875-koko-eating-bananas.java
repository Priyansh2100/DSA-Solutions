class Solution {

    private boolean canEatAll(int[] piles, int speed, int h) {

        long actualHours = 0;

        for (int pile : piles) {

            actualHours += pile / speed;

            if (pile % speed != 0) {
                actualHours++;
            }
        }

        return actualHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}