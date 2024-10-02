class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp=new int[arr.length];
        int i=0;
        for(int a:arr){
            temp[i++]=a;
        }
        Arrays.sort(temp);
        HashMap<Integer ,Integer> map=new HashMap();
        int p=0;
        for(int q:temp){
            if(map.containsKey(q)){
                continue;
            }else{
                p++;
                map.put(q,p);
            }
        }
        int[] ans= new int[arr.length];
        for(int iq=0;iq<arr.length;iq++){
            int j=map.get(arr[iq]);
            ans[iq]=j;
        }
        return ans;
    }
   
}