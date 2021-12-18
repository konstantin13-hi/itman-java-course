package tasks;
import collections.Stack;
public class Task514 {

    public static int solve(int[] books, int[] queue){
        Stack stack=new Stack();
        int result=0;
        for (int i =0;i<books.length;i++){
            stack.push(books[i]);
        }
        for (int i=0;i<queue.length;i++){
            if (queue[i]<0){
                stack.pop();
            }
            else {
                stack.push(queue[i]);
            }

        }

        return stack.size();
    }


}
