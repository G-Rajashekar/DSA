class Solution {
    static final int INF=1_000_000;
    int n;
    String s;
    int[][] c;
    int[][] dp;
    public int minimumChanges(String s, int k) {
        this.n=s.length();
        this.s=s;
        c=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                c[i][j]=cost(i,j);
            }
        }
        dp=new int[n][k+1];
        for (int[] row:dp) Arrays.fill(row,-1);
        return solve(0,k);

    }

    public int solve(int i,int k){
        if (k==1) return c[i][n-1];
        if (dp[i][k]!=-1) return dp[i][k];
        int best=INF;
        for (int j=i+1;n-1-j>=2*(k-1);j++){
            if (c[i][j]>=INF) continue;
            int rest=solve(j+1,k-1);
            if (rest>=INF) continue;
            best=Math.min(best,c[i][j]+rest);
        }
        return dp[i][k]=best;
    }
    public int cost(int i,int j){
        int len=j-i+1;
        if (len<2) return INF;
        int res=INF;
        for (int d=1;d<len;d++){
            if (len%d!=0) continue;
            int m=len/d,c=0;
            for (int g=0;g<d;g++){
                int l=i+g;
                int h=i+g+(m-1)*d;
                while(l<h){
                    if (s.charAt(l)!=s.charAt(h)) c++;
                    l+=d;
                    h-=d;
                }
            }
            res=Math.min(res,c);
        }
        return res;
    }
}