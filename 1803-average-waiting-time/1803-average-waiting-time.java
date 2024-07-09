// class Solution {
//     public double averageWaitingTime(int[][] customers) {
//         int t=0,tt=0;
//         for(int i=0;i<customers.length;i++){
//             int a=customers[i][0];
//             int p=customers[i][1];
//             if(t<a){
//                 t=a;
//             }
//             int x=t+p-a;
//             tt+=x;
//             t+=p;
         
//            // System.out.print(tt);
//         }
        
//         double ans =(double)tt/customers.length;
//         return ans;
//     }
// }
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total_waiting_time = 0; 
        int current_time = 0;
        for (int[] customer : customers) {
            int arrival = customer[0]; 
            int service = customer[1];
            
            if (current_time < arrival) {
                current_time = arrival;
            }
        
            int waiting_time = current_time - arrival + service;
            
            total_waiting_time += waiting_time;
           
            current_time += service;
        }

        return total_waiting_time / customers.length;
    }
}
