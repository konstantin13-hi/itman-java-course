package tasks;

import java.util.Arrays;

public class MyString {
    char[] chars;
    public MyString(char[]a){
         chars=a;

    }
    public String toString(){
        String string = new String(chars);
        return string;
    }

    public int length(){
        return chars.length;
    }

    public char charAt(int index){
        return chars[index];
    }

    public int compareTo(MyString that){
        int result=0;
        if (that==null){
            return 1;
        }
       if( that.chars.length>chars.length){
           result=-1;
       }
       if ( that.chars.length<chars.length){
           result= 1;
       }
       if (( that.chars.length==chars.length)&&!Arrays.equals(that.chars, chars)){
           for (int i=0;i<chars.length;i++){
               if(that.chars[i] !=chars[i]){
                   if((int)that.chars[i]<(int)chars[i]){
                           result=1;
                   }
                   else result=-1;
               }
           }
       }

        return result;
    }

   public boolean equals(MyString that){
        if(that==null){
            return false;
        }
        return Arrays.equals(that.chars, chars);
   }

    public static MyString plus(MyString a, MyString b){
        char[] twochars = new char[a.length()+ b.length()];/// 1 2 3     4 5 6
        for (int i=0;i<twochars.length;i++){
            if (i<a.length()){
            twochars[i]=a.chars[i];}
            if (i>=a.length()){
            twochars[i]=b.chars[i-b.length()];}
        }
        MyString doble = new MyString(twochars);

        return doble;
    }

}
