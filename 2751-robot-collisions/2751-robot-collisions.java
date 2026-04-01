class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int n = positions.length;
        
        int[][] robots = new int[n][4];
        
        for(int i = 0; i < n; i++){
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i) == 'R' ? 1 : 0;
            robots[i][3] = i;
        }
        
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            if(robots[i][2] == 1){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && robots[i][1] > 0){
                    
                    int top = st.peek();
                    
                    if(robots[top][2] == 0) break;
                    
                    if(robots[top][1] == robots[i][1]){
                        robots[top][1] = 0;
                        robots[i][1] = 0;
                        st.pop();
                        break;
                    }
                    else if(robots[top][1] > robots[i][1]){
                        robots[top][1]--;
                        robots[i][1] = 0;
                        break;
                    }
                    else{
                        robots[i][1]--;
                        robots[top][1] = 0;
                        st.pop();
                    }
                }
                
                if(robots[i][1] > 0){
                    st.push(i);
                }
            }
        }
        
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++){
            if(robots[i][1] > 0){
                int originalIndex = robots[i][3];
                result[originalIndex] = robots[i][1];
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(result[i] > 0){
                ans.add(result[i]);
            }
        }
        
        return ans;
    }
}