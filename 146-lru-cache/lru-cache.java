// -----------------------BRUTE FORCE -------------
// class LRUCache {
    
//     List<int[]> cache;
//     int n;
    
//     public LRUCache(int capacity) {
//         n = capacity;
//         cache = new ArrayList<>();
//     }
    
//     public int get(int key) {
//         for (int i = 0; i < cache.size(); i++) {
//             if (cache.get(i)[0] == key) {   //first value
//                 int val = cache.get(i)[1];   //second will be the answer
                
//                 int[] temp = cache.get(i);    //store becuase we haver to push back
//                 cache.remove(i); 
//                 cache.add(temp);   //pushed in temp
                
//                 return val;
//             }
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         for (int i = 0; i < cache.size(); i++) {   
//             if (cache.get(i)[0] == key) {       //already present ?
//                 cache.remove(i);                
//                 cache.add(new int[]{key, value});
//                 return;
//             }
//         }
        
//         if (cache.size() == n) {
//             cache.remove(0);
//             cache.add(new int[]{key, value});
//         } else {
//             cache.add(new int[]{key, value});
//         }
//     }
// }




class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // accessOrder = true makes it behave like your DLL + map
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value); // updates and moves to MRU (because accessOrder=true)
            return;
        }

        if (cache.size() == capacity) {
            // remove least recently used (eldest entry)
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        cache.put(key, value);
    }
}
