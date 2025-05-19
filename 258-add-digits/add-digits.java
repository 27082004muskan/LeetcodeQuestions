class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;  // get last digit
                num /= 10;        // remove last digit
            }
            num = sum;  // continue until single digit
        }
        return num;
    }
}
