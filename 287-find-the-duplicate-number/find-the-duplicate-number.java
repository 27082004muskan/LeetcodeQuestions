class Solution {
    public int findDuplicate(int[] nums) {
         cycleSort(nums);
      //  List<Integer> list=new ArrayList<Integer>();
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return nums[i];
               // list.add(i+1);
            }
        }
        return -1;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void cycleSort(int nums[]){
        int n=nums.length;
        int index=0;
        while(index<n){
            int element=nums[index];
            int correctPos=element-1;
            if(nums[index]!=nums[correctPos]){
                swap(nums,index,correctPos);
            }else{
                index++;
            }
        }
    }
}