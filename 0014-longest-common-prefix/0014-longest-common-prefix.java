class Solution {
    public String longestCommonPrefix(String[] str) {
        StringBuilder ans = new StringBuilder();
        int[] size = new int[str.length];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<str.length;i++){
            size[i] = str[i].length();
            min = Math.min(min,size[i]);
        }
        int n = str.length;
        int i =0;
        while(i<min){
            char ch = str[0].charAt(i);
            boolean flag = false;
            for(int j=0;j<n;j++){
                if(str[j].charAt(i)!=ch) return ans.toString();
            }
            i++;
            ans.append(ch);
        }

        return ans.toString();
        
    }
}