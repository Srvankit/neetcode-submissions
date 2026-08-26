class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int prevDay = stack.pop();

                arr[prevDay]= i-prevDay;
            }
            stack.push(i);
        }
        return arr;
    }
}
