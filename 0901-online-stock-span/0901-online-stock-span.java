class StockSpanner {

    Stack<int[]> stk = new Stack<>();
    // int count = 1;

    public StockSpanner() {
    }
    
    public int next(int price) {

         int count = 1;

        while(!stk.isEmpty() && stk.peek()[0]<=price){
            count = count + stk.pop()[1];
        }

        stk.push(new int[]{price,count});

        return count; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */