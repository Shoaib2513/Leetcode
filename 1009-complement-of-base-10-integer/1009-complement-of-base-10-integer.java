class Solution {
    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0') sb.append('1');
            else sb.append('0');
        }

        String s = sb.toString();
        int num = Integer.parseInt(s,2);
        return num;
    }
}