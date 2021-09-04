package tasks;

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

}
