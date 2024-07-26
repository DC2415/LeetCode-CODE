class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
         int[][] matrix = new int[n][n];
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE / 2); 
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            matrix[from][to] = weight;
            matrix[to][from] = weight;
        }
        int city=Integer.MAX_VALUE;int ans=-1;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                else if(dijkstra(i,j,matrix)<=dt){
                    c+=1;
                }
            }
            if(city>=c){
                city=c;
                ans=i;
            }
        }
        return ans;

    }
    public static int dijkstra(int src, int dest, int[][] matrix) {
        int numNodes = matrix.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            
            // If the node is already visited, skip it
            if (visited[currentNode]) {
                continue;
            }
            
            // Mark the node as visited
            visited[currentNode] = true;
            
            // If we reached the destination node, return the distance
            if (currentNode == dest) {
                return currentDistance;
            }
            
            // Explore neighbors
            for (int neighbor = 0; neighbor < numNodes; neighbor++) {
                int weight = matrix[currentNode][neighbor];
                
                if (weight > 0 && !visited[neighbor]) { // Only consider positive weights
                    int newDistance = currentDistance + weight;
                    
                    // Only consider this path if it's better
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        pq.add(new int[]{neighbor, newDistance});
                    }
                }
            }
        }
        
        // If the destination is unreachable, return -1 or some indication
        return -1;
    }
}