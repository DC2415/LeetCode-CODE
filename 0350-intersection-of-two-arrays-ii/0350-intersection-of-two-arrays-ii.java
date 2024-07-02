class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    // Set<Integer> set1 =new HashSet<Integer>();
    //     for(int i=0 ;i<nums1.length;i++){
    //         set1.add(nums1[i]);
    //     }
    //     Set<Integer> set2 =new HashSet<Integer>();
    //    for(int i1=0 ;i1<nums2.length;i1++){
    //         set2.add(nums2[i1]);
    //     }
    //     set1.retainAll(set2);
    //      int [] ans =new int[set1.size()];
    //      int i = 0;
    //     for (int x : set1)
    //         ans[i++] = x;
    //      return ans;
    // }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    ArrayList<Integer> arr = new ArrayList<>();
    int i=0, j=0; 
    while(i<nums1.length && j <nums2.length){
        if(nums1[i] < nums2[j]){
            i++;
        }
        else if(nums1[i]> nums2[j]){
            j++;
        }
        else{
            arr.add(nums1[i]);
            i++;
            j++;
        }
    }
      int[] out = new int[arr.size()];
        int k=0;
        while(k<arr.size()){
            out[k]=arr.get(k);
            k++;
        }
        return out;
    }
    
}