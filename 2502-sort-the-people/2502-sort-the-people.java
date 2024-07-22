class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        ArrayList<pair> ds=new ArrayList();

        for(int i=0;i<heights.length;i++){
            ds.add(new pair(names[i],heights[i]));
        }
        Collections.sort(ds,(a,b)->b.h-a.h);
        String[]  ans=new String[names.length];
        for(int i=0;i<names.length;i++){
            ans[i]=ds.get(i).name;
        }
        return ans;        
    }
}
class pair{
    String name;
    int h;

    public pair(String n, int a){
        name=n;
        h=a;
    }
}