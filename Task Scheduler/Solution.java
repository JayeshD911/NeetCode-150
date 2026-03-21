class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        Queue<int[]> queue = new LinkedList<>(); //[remaining frequency, ready time]

        for (int f : freq){
            if(f > 0) maxHeap.offer(f);
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            //poll from heap whenever ready and fill the queue whenever a task is executed and has more remaining.
            //if the heap is empty just increment the time and go to next iteration in loop until we find suitable time.
            // when we find time == next task in the queue, push it to the heap to execute in the next iteration

            time++;

            // Step 1: execute task
            if(!maxHeap.isEmpty()){
                int x = maxHeap.poll(); //frequency
                x--;

                if(x > 0) queue.offer(new int[]{x, time + n});
            }

            // Step 2: release tasks from cooldown
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}