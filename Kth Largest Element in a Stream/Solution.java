class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0 ; i< nums.length ; i++){
            minHeap.offer(nums[i]);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        while(minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}


//Theoretically more optimised but slower in leetcode

class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {

        if(minHeap.size() < k){
            minHeap.offer(val);
        }
        else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */