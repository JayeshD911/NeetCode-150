class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        // Step 1: Count frequencies
        for(int i : nums){
            if (hm.containsKey(i)) hm.put(i, hm.get(i)+1);
            else hm.put(i,1);
        }

        // Step 2: Create buckets
        // Index = frequency, value = list of numbers with that frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        //create empty bucket of frequency
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        //fill the bucket 
        for (int num : hm.keySet()){
            int frequency = hm.get(num);
            bucket[frequency].add(num);
        }

        // create answer list
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int x = nums.length ; x >= 0 && count < k ; x-- ){
            for (int i : bucket[x]) {
                ans.add(i);
                count += 1;
            }
        }

        int[] result = new int[count];

        //convert into int
        for (int y = 0 ; y < count ; y++){
            result[y] = (int) ans.get(y);
        }
        return result;

    }
}



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        //Max frequency (To use in creating the next list)
        int max_count = 0;

        for(int num: nums){
            // hm.putIfAbsent(num,0);
            // hm.put(num,hm.get(num)+1);
            // max_count = Math.max(max_count, hm.get(num));

            //Upper is easier to understand but is decreases the lookups
            int a = hm.getOrDefault(num,0) + 1;
            hm.put(num, a);
            max_count = Math.max(max_count, a);
        }

        ArrayList<Integer>[] count_array = new ArrayList[max_count + 1];

        for (int i = 0; i<= max_count ; i++){
            count_array[i] = new ArrayList<>();
        }
        
        for(int num : hm.keySet()){
            count_array[hm.get(num)].add(num);
        }

        int[] ans = new int[k];
        int added_count = 0;

        for (int i = max_count ; i > 0 && added_count < k ; i-- ){

            if (count_array[i].isEmpty()) continue;

            ArrayList<Integer> temp = count_array[i];

            for (int x : temp){
                ans[added_count] = x;
                added_count++;
                if (added_count == k) break;
            }      
        }
        return ans;    

        // int[] ans = new int[k];    
        // int idx = max_count;
        // int added_count = 0;

        // while (added_count < k){
        //     ArrayList<Integer> temp = count_array[idx];
        //     for (int i : temp){
        //         ans[added_count] = i;
        //         added_count++;
        //         if (added_count > k) break;
        //     }
        //     idx--;
        // }
        // return ans;
    }
}