/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */


 
class Solution {
    private int findPeak(MountainArray mountainArr) {
    int left = 0, right = mountainArr.length() - 1;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
            left = mid + 1; // Peak is on the right
        } else {
            right = mid; // Peak is on the left or at mid
        }
    }
    return left; // Peak index
}

private int binarySearchAscending(MountainArray mountainArr, int target, int left, int right) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midVal = mountainArr.get(mid);
        
        if (midVal == target) return mid;
        else if (midVal < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

private int binarySearchDescending(MountainArray mountainArr, int target, int left, int right) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midVal = mountainArr.get(mid);
        
        if (midVal == target) return mid;
        else if (midVal > target) left = mid + 1; // Note: reversed logic
        else right = mid - 1;
    }
    return -1;
}

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find peak
        int peak = findPeak(mountainArr);
        
        // Step 2: Search in ascending part (left side)
        int result = binarySearchAscending(mountainArr, target, 0, peak);
        if (result != -1) return result; // Found on left side
        
        // Step 3: Search in descending part (right side)  
        return binarySearchDescending(mountainArr, target, peak + 1, n - 1);
    }
    
    // ... (include the helper methods above)
}
