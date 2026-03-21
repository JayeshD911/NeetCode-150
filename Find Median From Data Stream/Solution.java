class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {

        //add to heap
        if(!maxHeap.isEmpty() && num > maxHeap.peek()) minHeap.offer(num);
        else maxHeap.offer(num);

        //balance heap
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }else if(maxHeap.size() - minHeap.size() < -1 ){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.size() - minHeap.size() == 0){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        else return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


//class MedianFinder {
//    PriorityQueue<Integer> minHeap;
//    PriorityQueue<Integer> maxHeap;
//    public MedianFinder() {
//        minHeap = new PriorityQueue<>();
//        maxHeap = new PriorityQueue<>((a,b) -> b - a);
//    }
//
//    public void addNum(int num) {
//
//        maxHeap.offer(num);
//
//        //compare top values
//        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) minHeap.offer(maxHeap.poll());
//
//        //balance heaps
//        if(maxHeap.size() - minHeap.size() > 1){
//            minHeap.offer(maxHeap.poll());
//        }
//        else if(maxHeap.size() - minHeap.size() == -1 ){
//            maxHeap.offer(minHeap.poll());
//        }
//    }
//
//    public double findMedian() {
//        if(maxHeap.size() - minHeap.size() == 0){
//            return (maxHeap.peek() + minHeap.peek()) / 2.0;
//        }
//        else return maxHeap.peek();
//    }
//}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */