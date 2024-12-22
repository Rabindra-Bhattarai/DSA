public class stacks {
    int[] stk;
    int top = -1;
    int size;

    stacks(int size) {
        stk = new int[size];
        this.size = size;
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("stack overflow");
        } else {
            // top++
            stk[++top] = data;
        }

    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 'e';
        }
        // int temp=top;
        // top--
        // return stk[temp]
        return stk[top--];
    }

    char peek(){
        return stk[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    public static void main(String[] args) {
        // stacks s=new stacks(size:5);
        // s.push(data:10);
        // s.push(data:20);
        // System.out.println(s.pop());
    }
}