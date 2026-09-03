class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        // Frequency of characters required from t
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int have = 0;
        int need = map.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()){

            // Add right character
            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Character requirement satisfied
            if(map.containsKey(ch) &&
               window.get(ch).equals(map.get(ch))){
                have++;
            }

            // Window is valid → shrink it
            while(have == need){

                int len = right - left + 1;

                if(len < minLen){
                    minLen = len;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                // Removing this character broke the requirement
                if(map.containsKey(leftChar) &&
                   window.get(leftChar) < map.get(leftChar)){
                    have--;
                }

                left++;
            }

            right++;
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start + minLen);
    }
}