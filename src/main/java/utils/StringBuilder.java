package utils;

public class StringBuilder {
    char[] chars ;
    private int capacity;
    private int logicalSize;
    public StringBuilder(int capacity){
        this.capacity=capacity;
        chars = new char[this.capacity];

    }
    public StringBuilder(){
        this.capacity=16;
        chars= new char[capacity];
    }
    public int length() {
        return logicalSize;
    }

     public   StringBuilder append(String s){
         char[] y;
         if (s != null) {
             y = s.toCharArray();
         } else {
             String x = "null";
             y = x.toCharArray();
         }
             if(this.capacity<=logicalSize+y.length){
                 this.capacity=this.capacity+y.length;
                 logicalSize+=y.length;                //  1 1 1 1 1 /2 2 2 2 2 2 2
                 char[]newChar=new char[capacity];
                System.arraycopy(chars,0,newChar,0,logicalSize-y.length);
                 System.arraycopy(y,0,newChar,logicalSize-y.length,y.length);
                 chars=newChar;
             }
             else {
                 System.arraycopy(y,0,chars,logicalSize,y.length);
                 logicalSize+=y.length;
             }

         return this;

     }
    public StringBuilder append(boolean x){
        String str = "Hi";
        if (!x) {
             str = "false";
        } else {
             str = "true";
        }
        char[] y = str.toCharArray();
        if(this.capacity<=logicalSize+y.length){
            this.capacity=this.capacity+y.length;
            logicalSize+=y.length;                //  1 1 1 1 1 /2 2 2 2 2 2 2
            char[]newChar=new char[capacity];
            System.arraycopy(chars,0,newChar,0,logicalSize-y.length);
            System.arraycopy(y,0,newChar,logicalSize-y.length,y.length);
            chars=newChar;}
        else {
            System.arraycopy(y,0,chars,logicalSize,y.length);
            logicalSize+=y.length;
        }


        return this;
    }
    public StringBuilder append(int x){
        String str = Integer.toString(x);
        char[] y = str.toCharArray();
        if(this.capacity<=logicalSize+y.length){
            this.capacity=this.capacity+y.length;
            logicalSize+=y.length;                //  1 1 1 1 1 /2 2 2 2 2 2 2
            char[]newChar=new char[capacity];
            System.arraycopy(chars,0,newChar,0,logicalSize-y.length);
            System.arraycopy(y,0,newChar,logicalSize-y.length,y.length);
            chars=newChar;
        }
        else {
            System.arraycopy(y,0,chars,logicalSize,y.length);
            logicalSize+=y.length;
        }
        return this;
    }
    public StringBuilder append(double x){
        String str = Double.toString(x);
        char[] y = str.toCharArray();
        if(this.capacity<=logicalSize+y.length){
            this.capacity=this.capacity+y.length;
            logicalSize+=y.length;                //  1 1 1 1 1 /2 2 2 2 2 2 2
            char[]newChar=new char[capacity];
            System.arraycopy(chars,0,newChar,0,logicalSize-y.length);
            System.arraycopy(y,0,newChar,logicalSize-y.length,y.length);
            chars=newChar;
        }
        else {
            System.arraycopy(y,0,chars,logicalSize,y.length);
            logicalSize+=y.length;
        }
        return this;

    }
    public StringBuilder append(long x){
        String str = Long.toString(x);
        char[] y = str.toCharArray();
        if(this.capacity<=logicalSize+y.length){
            this.capacity=this.capacity+y.length;
            logicalSize+=y.length;                //  1 1 1 1 1 /2 2 2 2 2 2 2
            char[]newChar=new char[capacity];
            System.arraycopy(chars,0,newChar,0,logicalSize-y.length);
            System.arraycopy(y,0,newChar,logicalSize-y.length,y.length);
            chars=newChar;
        }
        else {
            System.arraycopy(y,0,chars,logicalSize,y.length);
            logicalSize+=y.length;
        }
        return this;
    }
    public String toString() {
        char[]newCh =new char[logicalSize];
        System.arraycopy(chars, 0, newCh, 0, newCh.length);

        return new String(newCh);

    }

}
