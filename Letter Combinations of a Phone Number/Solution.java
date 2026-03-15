class Solution {
    public void solve(String digits, int currIdx, StringBuilder temp, List<String> ans , Map<Character, String> hm){
        if(currIdx == digits.length()){
            ans.add(temp.toString());
            return;
        }

        char digitAtIdx = digits.charAt(currIdx);
        String letters = hm.get(digitAtIdx);

        for(char letter : letters.toCharArray()){
            temp.append(letter);
            solve(digits, currIdx + 1, temp, ans , hm);
            temp.deleteCharAt(temp.length() -1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();

        if (digits.equals("")) return new ArrayList<String>();

        Map<Character, String> hm = new HashMap<Character, String>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");

        solve(digits, 0, new StringBuilder(), ans, hm);

        return ans;
    }
}