class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left =0;
        int right =0;
        for(int i =0; i< s1.length(); i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        while(right < s2.length()){

            char ch = s2.charAt(right);
            window.put(ch, window.getOrDefault(ch,0)+1);

            if(right-left+1>s1.length()){
                char leftch = s2.charAt(left);

                window.put(leftch, window.get(leftch)-1);

                if(window.get(leftch)==0){
                    window.remove(leftch);
                }
                left++;
            }
            if(window.equals(map)){
                return true;
            }
            right++;
        }
        return false;
    }
}
