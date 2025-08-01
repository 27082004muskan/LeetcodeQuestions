class Solution {
    public List<List<Integer>> generate(int numRows) {
        // List<List<Integer>> triangle=new ArrayList<>();
        // List<Integer> first_Row=new ArrayList<>();
        //  first_Row.add(1);
        //  triangle.add(first_Row);

        //  for(int i =1;i<numRows ;i++){
        //     List<Integer> prev_Row=triangle.get(i-1);
        //     List<Integer> curr_Row=new ArrayList<>();

        //     curr_Row.add(1);
        //     for(int j =1;j<i;j++){
        //         curr_Row.add(prev_Row.get(j-1)+prev_Row.get(j));
        //     }
        //     curr_Row.add(1);
        //     triangle.add(curr_Row);

        //  }
        //  return triangle;
        
        List<List<Integer>> result = new ArrayList<>();

        for(int i =0;i<numRows;i++){
            List<Integer> row = new ArrayList<>(i+1);

            for(int j =0;j<=i;j++){
                if(j==0 || j==i)
                row.add(1);
                else{
                    int num = result.get(i-1).get(j)+result.get(i-1).get(j-1);
                    row.add(num);
                }
            }
            result.add(row);
        }
        return result;
    }
}