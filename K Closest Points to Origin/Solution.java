class Solution {
    public int[][] kClosest(int[][] points, int k) {


        //Eclidean distance formula = √(x1 - x2)2 + (y1 - y2)2. here point 2 is (0,0). We are comparing so root is also not required as it is on both sides

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        // maintain heap of size k
        for ( int[] point : points){
            if(maxHeap.size() < k) maxHeap.offer(point);
            else{
                int[] heapMaxPoint = maxHeap.peek();
                int heapMaxDistance = heapMaxPoint[0] * heapMaxPoint[0] + heapMaxPoint[1] * heapMaxPoint[1];
                int pointDistance = point[0] * point[0] + point[1] * point[1];

                if(pointDistance < heapMaxDistance){
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }

        return maxHeap.toArray(new int[k][2]);


        // // maintain heap of size k without checking before inserting
        // for ( int[] point : points){
        //     maxHeap.offer(point);

        //     if(maxHeap.size() > k) maxHeap.poll(); // remove maximum
        // }

        // return result with loop
        // int[][] result = new int[k][2];
        // int counter = 0;
        // while (counter < k){
        //     result[counter] = maxHeap.poll();
        //     counter++;
        // }

        // return result;
    }
}