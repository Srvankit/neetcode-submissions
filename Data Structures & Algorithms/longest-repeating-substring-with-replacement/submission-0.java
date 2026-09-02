class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int ans = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            int windowSize = right - left + 1;

            int replacements = windowSize - maxFreq;

            while (replacements > k) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                left++;

                windowSize = right - left + 1;
                replacements = windowSize - maxFreq;
            }

            ans = Math.max(ans, windowSize);

            right++;
        }

        return ans;
    }
}