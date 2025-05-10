class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        // phele num1 ka sum find kare then num2 ka
        //compare kar lo 
        // number of zero in each 
        // bade digit mei 1 add kar do .. jitne bhi zero ho aur choti waali mei sum(num2)-sum(num1)
        // we can add number acc to the above difference aur jitne num1 mei number of zeroes hai uss hisaab se divide kar do 
        // final ans should be equal to num1==num2 else -1 ;


        long countZ1 = 0;
        long countZ2=0;
        int n1= nums1.length;
        int n2= nums2.length;
        long sumn1=0;
        long  sumn2=0;

        for(int i=0;i<n1;i++ ){
            if(nums1[i]!=0){
                sumn1+=nums1[i];
            } else{
                countZ1++;
                sumn1+=1;
            }

        }
           for(int i=0;i<n2;i++ ){
            if(nums2[i]!=0){
                sumn2+=nums2[i];
            } else{
                countZ2++;
                sumn2+=1;
            }

        }
          if ((sumn1 < sumn2 && countZ1 == 0) || (sumn2 < sumn1 && countZ2 == 0)) {
            return -1;
        }

        return Math.max(sumn1, sumn2);

    
        
    }
}