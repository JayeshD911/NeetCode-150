class Solution {
    public double myPow(double x, int n) {
        // long N = n; //to avoid overflow
        int N = n;
        if (n < 0){       // x^(-n) = 1 / x^n
            x = 1/x;
            N = -N;
        }
        return fastPow(x,N);
    }

    public double fastPow(double x, int n) {
        if (n == 0) return 1L;

        double temp = fastPow(x, n/2);

        if( n % 2 == 0) return temp * temp;
        else return temp * temp * x;
    }
}