class Solution {
    public boolean check(int[][] mat,int[][] target){
        int n = mat.length;
        boolean flag = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
    public int[][] rotate(int[][] arr){
        int n = arr.length;
        for(int k=0;k<n;k++){
            int i=0,j=n-1;
            while(i<j){
                int temp = arr[i][k];
                arr[i][k]= arr[j][k];
                arr[j][k]=temp;
                i++;j--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        return arr;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean flag = false;
        for(int i=0;i<=3;i++){
            if(check(mat,target)==true) return true;
            else {
                mat = rotate(mat);
            }
        }
        return false;
    }
}