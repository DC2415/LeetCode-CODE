class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> m1= new HashSet<>();
        Set<Integer> m2= new HashSet<>();
        List<Integer> ans1=new ArrayList<Integer>();
        List<Integer> ans2=new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        for(int a : nums1){
            m1.add(a);
        }
        for(int a : nums2){
            m2.add(a);
        }
        for(int a : m1){
            if(m2.contains(a)==false){
                ans1.add(a);
            }
        }
        for(int a : m2){
            if(m1.contains(a)==false){
                ans2.add(a);
            }
        }
        ans.add(ans1);
        ans.add(ans2);
        return ans;
        
        
        
    }
}