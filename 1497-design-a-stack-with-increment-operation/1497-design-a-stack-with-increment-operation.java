class CustomStack {
    int[] arr;int i=-1;
    public CustomStack(int maxSize) {
        this.arr =new int[maxSize];
    }
    
    public void push(int x) {
        if(i < this.arr.length -1){
            i++;
            this.arr[i]=x;
        }
    }
    
    public int pop() {
        if(i!=-1){
            return this.arr[i--];
        }
        return -1;

    }
    
    public void increment(int k, int val) {
        for(int j=0;j<Math.min(i+1,k);j++){
            this.arr[j] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */