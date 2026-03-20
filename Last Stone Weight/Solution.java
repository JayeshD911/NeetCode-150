class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x != y) maxHeap.offer(Math.abs(x-y));
        }

        if(maxHeap.size() == 0) return 0; //if in the end two equal items remain, the heap will become null

        return maxHeap.peek();
    }
}