class Solution {
    public int findKthPositive(int[] arr, int k) {
        // int num =1;
        // int n = arr.length;
        // int i =0;
        // while(i<n && k>0){
        //     if(arr[i]==num)
        //     i++;
        //     else
        //     k--;

        //     num++;
        // }
        //    if (k > 0) {
        //     num += (k - 1);
        // } else {
        //     num--;
        // }
        // return num;






            int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // After loop, l is the index where the k-th missing number should fit
        return l + k;
    }
}