class Solution {
    public int evalRPN(String[] tokens) {
        Stack <String> st=new Stack<>();
        int a=0;
        int b=0; int res=0;
        for(int x=0;x<tokens.length;x++)
        {
            String op =tokens[x];
            if(op.equals("+") || op.equals("-") ||op.equals("*") ||op.equals("/") )
            {
                 b = Integer.parseInt(st.pop());
                 a = Integer.parseInt(st.pop());

            if (op.equals("+"))
              res=(a + b);
            else if (op.equals("-"))
                res=(a - b);
            else if (op.equals("*"))
                res=(a * b);
            else if (op.equals("/"))
                res=(a / b);
                st.push(String.valueOf(res));
            }
            else 
            st.push(op);

        }
       
        return Integer.parseInt(st.pop());
        
    }
}