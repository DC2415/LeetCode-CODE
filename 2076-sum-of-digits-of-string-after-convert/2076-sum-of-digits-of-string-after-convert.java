class Solution {
    public int getLucky(String s, int k) {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            ans.append(s.charAt(i)-'a'+1);
        }
        String q=ans.toString();
        int data=0;
        for(char a: q.toCharArray()){
            data+=a-'0';
        }
        for(int i=1;i<k;i++){
            data =helper(data);
        }
        return data;
    }
    public int helper(int data){
        int sum=0;
        while(data>0){
            sum+=data%10;
            data/=10;
        }
        return sum;
    }
}