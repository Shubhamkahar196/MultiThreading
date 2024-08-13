
class World extends Thread {  //A  new class World is created that extends Thread.



    @Override   

    public void run() {   //The run method is overriden to define the code that constitutes the new thread.
  
        for (; ; ) {  // infinite loop
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class Test {

    public static void main(String[] args) {

        World world = new World();
        world.start();    //-> Start method is called to intiate the new thread
        for (;;) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
