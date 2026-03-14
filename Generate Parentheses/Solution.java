class Solution {

    public void solve (int n, List<String> ans, int open, int close, StringBuilder temp){
        if(temp.length() == n*2){
            ans.add(temp.toString());
            return;
        }

        if(open < n){
            temp.append("(");
            solve (n, ans, open + 1, close, temp);

            temp.deleteCharAt(temp.length() -1);
        }

        if(close < open){
            temp.append(")");
            solve (n, ans, open, close + 1, temp);
            temp.deleteCharAt(temp.length() -1);
        }


    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<String>();

        solve (n, ans, 0, 0, new StringBuilder());

        return ans;
    }
}