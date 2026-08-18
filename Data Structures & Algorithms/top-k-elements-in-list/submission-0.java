
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of every number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        // Index = frequency
        // Value = list of numbers having that frequency
        List<Integer>[] buckets = new List[nums.length + 1];

        // Step 3: Put each number into its frequency bucket
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int num = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        // Step 4: Traverse from highest frequency to lowest
        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            if (buckets[frequency] != null) {

                for (int num : buckets[frequency]) {

                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}