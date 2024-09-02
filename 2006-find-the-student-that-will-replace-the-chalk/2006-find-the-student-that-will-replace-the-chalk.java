class Solution {
    // public int chalkReplacer(int[] chalk, int k) {
    //     int i=0;
    //     if(chalk.length==1){
    //         return 0;
    //     }
    //     while(true){
    //         if(k-chalk[i]>=0){
    //             k=k-chalk[i];
    //             i=(i+1)%chalk.length;
    //             //System.out.println(i);
    //             //System.out.println(k);
    //         }
    //         else{
    //             return i;
    //         }
           
    //     }
    //   //  return -1;
    // }
    public int chalkReplacer(int[] chalk, int k) {
    long tc=0;
    for(int a: chalk){
        tc+=a;
    }
    int rm=(int)(k%tc);
    for(int i=0;i<chalk.length;i++){
        if(rm<chalk[i]){
            return i;
        }
        rm-=chalk[i];
    }
    return 0;
    }
}