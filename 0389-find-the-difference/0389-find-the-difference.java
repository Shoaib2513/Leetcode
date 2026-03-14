class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i),freq+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                int freq = map.get(t.charAt(i));
                map.put(t.charAt(i),freq+1);
            }else{
                map.put(t.charAt(i),1);
            }
        }

        for(Character ch:map.keySet()){
            int freq = map.get(ch);
            if(freq%2==1) return ch;
        }

        char ans = 'a';
        return ans;
    }
}