class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i <numRows ; i++){
            List<Integer> a = new ArrayList<>();
            for(int j =0 ; j <= i ; j++){
                if(j == 0 || j == i){
                    a.add(1);
                }else{
                    int num = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                    a.add(num);
                }
            }
            ans.add(a);
        }
        return ans ;
    }
}