class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList= new ArrayList<>();
        backTrack(resultList , new ArrayList<>() , nums);
        return resultList;
        
}
private void backTrack(List<List<Integer>> resultList , ArrayList<Integer> tempList , int[] nums){

    if(tempList.size()== nums.length){
        resultList.add(new ArrayList<>(tempList));
        return;
    }
for(int number : nums){
    if(tempList.contains(number)) 
    continue ;

    tempList.add(number);

    backTrack(resultList , tempList, nums);

    tempList.remove(tempList.size()-1);
}

}
}