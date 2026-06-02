class MinStack {

    int arr[];

    public MinStack() {

        arr = new int[10000];
        
    }

    int idx = 0;

    public void push(int val) {

        arr[idx] = val;
        idx++;

    }

    public void pop() {
      //  if (idx == 0)
           // return -1;

        int top = arr[idx - 1];
        arr[idx - 1] = 0;
        idx--;

    }

    public int top() {

        if (idx == 0)
            return -1;

        return arr[idx - 1];

    }

    public int getMin() {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < idx; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */