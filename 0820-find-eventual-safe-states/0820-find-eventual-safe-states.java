class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         int n=graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int a : graph[i]){
                adj.get(a).add(i);
            }
        }
         int inde[] =new int[n];
        for(int i=0;i<n;i++){
            for(int j: adj.get(i)){
                inde[j]++;
            }
        }
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inde[i]==0){
                qu.add(i);
            }
        }
        List<Integer> topo=new ArrayList();
        int s=0;
        while(!qu.isEmpty()){
            int q=qu.poll();
            topo.add(q);
            s++;
            for(int h:adj.get(q)){
                inde[h]--;
                if(inde[h]==0){
                    qu.add(h);
                }
            }
        }
         Collections.sort(topo);
         return topo;
    }
}