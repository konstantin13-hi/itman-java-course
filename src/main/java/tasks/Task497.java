package tasks;

public class Task497 {
    public static int[] merge(int[] a, int[] b) {
        if (a.length!=0 && b.length!=0){
        int[] twoArrays = new int[a.length + b.length];
        int  length;
        if (a.length > b.length) {
            length = a.length;
        } else {
            length = b.length;
        }
        // 1 2 3 4 5 6 7 8 9 10
        // 3,4,5,6,7,8
            // 1 2 3 3 4 4 5 5 6 6 7 7
        for (int i = 0, j = 0,k=0; j < twoArrays.length; j++){
           if ( i<a.length&&k<b.length) {
               if (a[i] == b[k]) {
                   twoArrays[j++] = a[i++];
                   twoArrays[j] = b[k++];
               } else if (a[i] < b[k]) {
                   twoArrays[j] = a[i++];
               } else {
                   twoArrays[j] = b[k++];
               }

           }
           else  {
               if (a.length<b.length){
                   twoArrays[j]=b[k++];
               }
               else {
                   twoArrays[j]=a[i++];
               }
           }
        }
        return twoArrays;

    }
        int [] result;
        if (a.length==0){
            result=b;
        }
        else {
            result = a;
        }
    return result;}
}

