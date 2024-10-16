import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> mheap = new PriorityQueue<>((x, y) -> y.feq - x.feq);  
        if (a > 0) {
            mheap.add(new pair(a, 'a'));
        }
        if (b > 0) {
            mheap.add(new pair(b, 'b'));
        }
        if (c > 0) {
            mheap.add(new pair(c, 'c'));
        }
        
        StringBuilder ans = new StringBuilder();
        
        while (!mheap.isEmpty()) {
            pair m = mheap.poll();
            int cfeq = m.feq;
            char ccha = m.ch;
            if (ans.length() >= 2 && ans.charAt(ans.length() - 1) == ccha && ans.charAt(ans.length() - 2) == ccha) {
                if (mheap.isEmpty()) {
                    break;
                }
                pair nn = mheap.poll();
                int nf = nn.feq;
                char nc = nn.ch;
                ans.append(nc);  
                nf--;
                if (nf > 0) {
                    mheap.add(new pair(nf, nc));
                }
              
                mheap.add(new pair(cfeq, ccha));
            } else {
                ans.append(ccha);  
                cfeq--;
                if (cfeq > 0) {
                    mheap.add(new pair(cfeq, ccha));
                }
            }
        }
        
        return ans.toString();
    }
}

class pair {
    int feq;
    char ch;

    public pair(int a, char sh) {
        feq = a;
        ch = sh;
    }
}
