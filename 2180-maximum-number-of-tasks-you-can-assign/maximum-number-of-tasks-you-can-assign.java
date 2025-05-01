// class Solution {
//     public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
//         int n = tasks.length;
//         int op =0;
//         for(int i =0;i<n-1;i++){
//            if(tasks[i]>tasks[i+1]){
//               Arrays.sort(tasks);
//               break;
//            }
//         }
//         for(int i =0;i<n;i++){
//         if(workers[i]<tasks[i] && pills!=0){
//             workers[i]=strength ;
//             pills--;
//         }
//         if(workers[i]>=tasks[i]){
//             op++;
//         }
//         }
//         return op;
//     }
// }


class Solution {

    public int maxTaskAssign(
        int[] tasks,
        int[] workers,
        int pills,
        int strength
    ) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, m = workers.length;
        int left = 1, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(
        int[] tasks,
        int[] workers,
        int pills,
        int strength,
        int mid
    ) {
        int p = pills;
        TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; ++i) {
            ws.put(workers[i], ws.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; --i) {
            Integer key = ws.lastKey();
            if (key >= tasks[i]) {
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
            } else {
                if (p == 0) {
                    return false;
                }
                key = ws.ceilingKey(tasks[i] - strength);
                if (key == null) {
                    return false;
                }
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
                --p;
            }
        }
        return true;
    }
}

