class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a=helper(0,cost1,cost2,costBoth,need1,need2);
        long b=helper(Math.min(need1,need2),cost1,cost2,costBoth,need1,need2);
        long c=helper(Math.max(need1,need2),cost1,cost2,costBoth,need1,need2);

        return Math.min(a,Math.min(b,c));

    }

    public long helper(int k,int cost1, int cost2, int costBoth, int need1, int need2){

        return (long)k*costBoth+(long)Math.max(0,need1-k)*cost1+(long)Math.max(0,need2-k)*cost2;
    }
}

