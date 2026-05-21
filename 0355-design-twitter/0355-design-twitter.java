class Twitter {

    Map<Integer, Set<Integer>> followMap;

    Map<Integer, List<int[]>> tweetMap;

    int time;

    public Twitter() {

        followMap = new HashMap<>();
        tweetMap = new HashMap<>();

        time = 0;        
    }
    
    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new int[]{time++, tweetId});
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

         List<Integer> result = new ArrayList<>();

        // Max Heap based on latest time
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // add user's own tweets
        if (tweetMap.containsKey(userId)) {

            List<int[]> tweets = tweetMap.get(userId);

            for (int[] tweet : tweets) {
                maxHeap.offer(tweet);
            }
        }

        // add followees tweets
        if (followMap.containsKey(userId)) {

            for (int followee : followMap.get(userId)) {

                if (tweetMap.containsKey(followee)) {

                    List<int[]> tweets = tweetMap.get(followee);

                    for (int[] tweet : tweets) {
                        maxHeap.offer(tweet);
                    }
                }
            }
        }

        // get top 10 latest tweets
        while (!maxHeap.isEmpty() && result.size() < 10) {

            result.add(maxHeap.poll()[1]);
        }

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followMap.containsKey(followerId)){

            followMap.get(followerId).remove(followeeId);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */