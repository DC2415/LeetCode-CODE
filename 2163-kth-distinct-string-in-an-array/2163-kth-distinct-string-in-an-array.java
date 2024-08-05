class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map =new HashMap();
        for(String a: arr){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        for(String i:arr){
            if(map.containsKey(i) && map.get(i)==1){
                k--;
            }
            if(k==0){
                return i;
            }
        }
        return "";
    }
}