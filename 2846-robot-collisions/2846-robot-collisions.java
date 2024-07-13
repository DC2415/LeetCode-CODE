// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//         ArrayList<pair> vl=new ArrayList();
//         for(int i=0;i<positions.length;i++){
//                 vl.add(new pair(positions[i],directions.charAt(i),healths[i]));
//         }
//         // Collections.sort(vl, new Comparator<pair>() {
//         //     public int compare(pair a, pair b) {
//         //         return a.p - b.p;
//         //     }
//         // });
//         Stack<pair> st=new Stack();
//         for(int i=0;i<vl.size();i++){
//             if(st.isEmpty()){
//                 st.push(vl.get(i));
//             }
//             else if(st.peek().d != vl.get(i).d){
//                  pair x= st.pop();
//                  int ps=x.p;
//                  char ds=x.d;
//                  int hl=x.h;
//                  if(hl> vl.get(i).h){
//                     st.push(new pair(ps,ds,hl-1));
//                  }else if(hl < vl.get(i).h){
//                     pair w=vl.get(i);
//                     int pa=w.p;
//                     char da=w.d;
//                     int ha=w.h;
//                     st.push(new pair(pa,da,ha-1));
//                  }
//             }
//             else{
//                     st.push(vl.get(i));
//                 }
//         }
     
//         List<Integer> ans = new ArrayList<>();
//         while (!st.isEmpty()) {
//             ans.add(st.pop().h);
//         }
//         // Reverse the list to maintain the order of surviving robots
//         Collections.reverse(ans);
        
//         return ans;
//     }
// }
// class pair{
//     int p;
//     char d;
//     int h;
//     pair(int a,char b,int c){
//         p=a;
//         d=b;
//         h=c;
//     }
// }
class Solution {

    public List<Integer> survivedRobotsHealths(
        int[] positions,
        int[] healths,
        String directions
    ) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
            indices,
            (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}