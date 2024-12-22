public class findMinMax {

    public class pair {
        int min;
        int max;

        pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    pair findMinMax(int a[ ], int s, int e){
        if(s==e){
         
            return new pair (a[s], a[s]);
        }
        if(s+1==e){
         
            if(a[s]>a[e]){
                return new pair(a[e], a[s]);
            }
            else{
                return new pair ([s], a[e]);
            }
        }
        int mid=(s+e)/2;
        pair leftpair =findMinMax(a, s, m);
        pair rightpair=findMinMax(a, mid+1, e);
        int overallmin=Math.min(leftpair.min, rightpair.min);
        int overallmax=Math.max(leftpair.max,rightpair.max);
        return new pair(overallmin, overallmax);
        
    }

}
