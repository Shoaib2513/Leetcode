class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int n = positions.length;
        
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++) idx[i] = i;
        
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
        
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        for(int i : idx){
            
            if(directions.charAt(i) == 'R'){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && healths[i] > 0){
                    
                    int top = st.peek();
                    
                    if(directions.charAt(top) == 'L') break;
                    
                    if(healths[top] == healths[i]){
                        healths[top] = 0;
                        healths[i] = 0;
                        st.pop();
                        break;
                    }
                    else if(healths[top] > healths[i]){
                        healths[top]--;
                        healths[i] = 0;
                        break;
                    }
                    else{
                        healths[i]--;
                        healths[top] = 0;
                        st.pop();
                    }
                }
                
                if(healths[i] > 0){
                    st.push(i);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(healths[i] > 0){
                ans.add(healths[i]);
            }
        }
        
        return ans;
    }
}