class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);

        int move =0;
        for(int i =0;i<n;i++){

          int steps = Math.abs(students[i]-seats[i]);
          move+=steps;
        
        }

         return move;
    }

}