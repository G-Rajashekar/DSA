class Solution {
    public int countServers(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;

        int[] rowServer=new int[n];
        int[] colServer=new int[m];

        for (int i=0;i<n;i++){
            int cnt=0;
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){
                    cnt++;
                    colServer[j]++;
                }
            }
            rowServer[i]=cnt;
        }

        int result=0;

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){

                    if (rowServer[i]>1 || colServer[j]>1){
                        result++;
                    }
                }
            }
        }

        return result;
    }
}