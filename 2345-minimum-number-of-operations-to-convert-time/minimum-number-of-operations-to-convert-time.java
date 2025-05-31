class Solution {
    public int convertTime(String current, String correct) {
        // Step 1: Convert current and correct to total minutes
        int currentMinutes = toMinutes(current);
        int correctMinutes = toMinutes(correct);

        // Step 2: Calculate the difference in minutes
        int diff = correctMinutes - currentMinutes;
        int operations = 0;

        // Step 3: Apply greedy steps
        int[] steps = {60, 15, 5, 1};
        for (int step : steps) {
            operations += diff / step;
            diff %= step;
        }

        return operations;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
