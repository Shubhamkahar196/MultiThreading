

public class LambdaExpression {

    public static void main (String[] args){
        // Runnable runnable = () -> {
        //     //anonymous funtion
        //     System.out.println("hello");
        // };
        // Thread t1 = new Thread(runnable);
        // t1.start();

        //another way of writing lambda expression

       Thread t1 = new Thread(()-> System.out.println("Hello"));
       t1.start();
    }
}