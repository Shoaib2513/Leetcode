class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int j=0;int i=0;
        while(i<pattern.length()){
            
            while(j<s.length() && s.charAt(j)!=' '){
                sb.append(String.valueOf(s.charAt(j)));
                j++;
            }
            String str = sb.toString();
            if(str.length()==0) return false;
            if(map.containsKey(pattern.charAt(i))){
                String a = map.get(pattern.charAt(i));
                if(!a.equals(str)) return false; 
            }else{
                if(map.containsValue(str)) return false;
                map.put(pattern.charAt(i),str);
            }
            sb.setLength(0);
            i++;
            j++;
        }
        if(j<s.length()) return false;
        return true;
    }
}