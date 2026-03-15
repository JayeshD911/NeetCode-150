class Solution {
    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public void solve(String s, int start, ArrayList<String> temp, List<List<String>> ans){
        if (start == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start + 1 ; end <= s.length() ; end++){  // + 1 is added to start to avoid start = 0 at //HERE line
            if(isPalindrome(s, start, end - 1)){
                // Add this partition
                temp.add(s.substring(start, end));    //HERE
                solve( s,  end,  temp,  ans);    // new partition will start from end

                temp.remove(temp.size()-1); // Backtrack to explore other partitions
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        solve(s, 0, new ArrayList<String>(), ans);
        return ans;
    }
}