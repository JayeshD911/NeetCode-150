class Solution {
    public boolean checkValidString(String s) {
        //counters for opening bracket
        int leftMin = 0;
        int leftMax = 0;

        for(int i = 0; i< s.length() ; i++){
            if (s.charAt(i) == '('){
                leftMin++;
                leftMax++;
            }else if(s.charAt(i) == ')'){
                leftMax--;
                leftMin--;
            }else{             // if it is '*'
                leftMax++;
                leftMin--;
            }
            if(leftMin < 0) leftMin = 0;
            if(leftMax < 0) return false;
        }

        if (leftMin == 0) return true;
        else return false;
    }
}