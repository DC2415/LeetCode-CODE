// class Solution {
    
//     public int numTeams(int[] rating) {
//         List<List<Integer>>ans=new ArrayList();
//         int an=0;    
//         List<Integer> ds=new ArrayList();
//         subset(0,3,rating,ds,ans);
//         for(List<Integer> d: ans){
//             System.out.print(d.get(0));
//             System.out.print(d.get(1));
//             System.out.print(d.get(2));
//             System.out.println();
//             if(check(d)){
//                 an++;
//             }
//         }
//         return an;
//     }
//     public void subset(int ind ,int k,int[] rating,List<Integer> ds,List<List<Integer>> ans){
//         if(ind>=rating.length){
//             return ;
//         }
//         if(ds.size()==k){
//            ans.add(new ArrayList<>(ds));
//             return;
//         }
//         // exclude
//         subset(ind+1,k,rating,ds,ans);

//         ds.add(rating[ind]);
//         subset(ind+1,k,rating,ds,ans);
//         ds.remove(ds.size()-1);
//         return;
//     }
//     public boolean check(List<Integer> ds){
//         if(ds.get(0) < ds.get(1) &&   ds.get(1) < ds.get(2)){
//             return true;
//         }
//         if(ds.get(0) > ds.get(1) && ds.get(1) > ds.get(2)){
//             return true;
//         }
//         return false;
//     }
// }
class Solution {
    public int numTeams(int[] rating) {

        int ans = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i; j < rating.length - 1; j++) {
                for (int k = j; k < rating.length; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) ||
                            (rating[i] > rating[j] && rating[j] > rating[k])) {
                        ans++;
                    }
                }
            }
        }

        return ans;

    }
}