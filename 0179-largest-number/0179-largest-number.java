class Solution {
    public String largestNumber(int[] num) {
        String[] nums=new String[num.length];
        for(int i=0;i<num.length;i++){
            nums[i]=String.valueOf(num[i]);
        }
        Arrays.sort(nums,new Comparator<String>(){
            public int compare(String a,String b){
                return (b+a).compareTo(a+b);
            }
        });
         if(nums[0].equals("0")){
            return "0";
        }
        String ans="";
        for(String a: nums){
            ans+=a;
            //System.out.println(a);
        }
        return ans;
    }
}