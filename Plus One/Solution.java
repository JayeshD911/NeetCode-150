class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        int i = n-1;
        while(carry != 0 && i >= 0){
            digits[i] = digits[i] + carry;
            if(digits[i] >= 10){
                digits[i] = digits[i] % 10;
                carry = 1;
            }
            else carry = 0;
            i--;
        }
        if(carry == 0){
            return digits;
        }
        else{
            int[] result = new int[n+1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        }
    }
}