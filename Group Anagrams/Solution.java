class Solution {
    // private String toFrequencyString(String str){
    //     int[] count = new int[26];

    //     for(int i =0; i< str.length(); i++){
    //         count[str.charAt(i) - 'a'] +=1;
    //     }

    //     return Arrays.toString(count);

    // }

    private String toFrequencyString(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        String key;

        for(String str : strs){
            key = toFrequencyString(str);
            hm.putIfAbsent(key,new ArrayList<String>());
            hm.get(key).add(str);
        }
        return new ArrayList<>(hm.values());
  
    }
}
