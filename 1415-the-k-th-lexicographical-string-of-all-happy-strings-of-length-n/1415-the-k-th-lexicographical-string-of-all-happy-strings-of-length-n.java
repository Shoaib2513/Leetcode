class Solution {
    public void helper(int n,ArrayList<String> list,String s){
        if(s.length()==n){
            list.add(s);
            return;
        }
        if(s.length()==0){
            helper(n,list,s+"a");
            helper(n,list,s+"b");
            helper(n,list,s+"c");

        }else{
           int len = s.length();
           if(s.charAt(len-1)=='a'){
            helper(n,list,s+"b");
            helper(n,list,s+"c");
           } else if(s.charAt(len-1)=='b'){
            helper(n,list,s+"a");
            helper(n,list,s+"c");
           }else if(s.charAt(len-1)=='c'){
            helper(n,list,s+"b");
            helper(n,list,s+"a");
           }
        }
    }
    public String getHappyString(int n, int k) {
        ArrayList<String> list = new ArrayList<>();
        helper(n,list,"");
        Collections.sort(list);
        int len = list.size();
        if(k>len) return "";
        return list.get(k-1);

    }
}