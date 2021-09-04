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
        return result;
    }

   public boolean equals(MyString that){
        if(that==null){
            return false;
        }
        return Arrays.equals(that.chars, chars);
   }

}
