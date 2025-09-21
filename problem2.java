public class problem2 {

    // Greedy solution
    // TC= O(2^n), SC=O(2^n)
    int min;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.min= Integer.MAX_VALUE;
        helper(triangle,0,0,0);
        return min;
    }
    public void helper(List<List<Integer>> triangle,int row,int col,int sum){
        if (r==triangle.size())
        {
            min = Math.min(min,sum);
            return;
        }
        helper(triangle, r+1, c, sum+triangle.get(r).get(c));
        helper(triangle, r+1, c+1, sum+triangle.get(c).get(c));
    }

    // DP= memoization
    int[][] memo;
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n= triangle.size();
        this.memo = new int[n][n];
        for (int i=0;i<n;i++)
        {
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        return helper1(triangle,0,0);
    }
    private int helper1(List<List<Integer>> triangle,int row,int col){
        if (row==triangle.size())
        {
            return 0;
        }
        if (memo[row][col]!=Integer.MAX_VALUE){return memo[row][col];}
        int left= helper1(triangle,row+1,col);
        int right= helper1(triangle,row+1,col+1);
        memo[row][col]=Math.min(left,right);
        return memo[row][col];
    }

}