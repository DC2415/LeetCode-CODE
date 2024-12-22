
// class Solution {
//     public int romanToInt(String s) {
//       String a=s;
//         int ans=0;
//         int num;
//         for (int i=0 ;i<a.length();i++){
//             if(a.charAt(i)=='I'){
//                 ans+=1;
                
//             }else if(a.charAt(i)=='V'){
//                 if(num<a.charAt)ans+=5;}
//             else if(s.charAt(i)=='X'){ans+=10;}
//             else if(a.charAt(i)=='L'){ans+=50;}
//             else if(a.charAt(i)=='C'){ans+=100;}
//             else if(a.charAt(i)=='D'){ans+=500;}
//             else if(a.charAt(i)=='M'){ans+=1000;}   
//         }
//         return ans;
//     }
// }
class Solution {
         public int romanToInt(String s) {
        Map <Character,Integer> dict= new HashMap<>();
             dict.put('I',1);
             dict.put('V',5);
             dict.put('X',10);
             dict.put('L',50);
             dict.put('C',100);
             dict.put('D',500);
             dict.put('M',1000);
             int ans=0;
           
             for(int i=0;i<s.length()-1;i++){
                 if(dict.get(s.charAt(i))<dict.get(s.charAt(i+1))){
                     ans-=dict.get(s.charAt(i));
                     //ans+=dict.get(s.charAt(i));    
                 }
                 else{
                     ans+=dict.get(s.charAt(i));
                 }
             }
             int a=s.length();
            // if(dict.get(s.charAt(a-1))<dict.get(s.charAt(a-2))){
            //    ans-=dict.get(s.charAt(a-1)); 
            // }
            // else{
                ans+=dict.get(s.charAt(a-1));
            // }
            return ans;
             
         }
}