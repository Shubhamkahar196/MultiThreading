class World implements Runnable {
    @Override
    public void run(){
        for (; ;) {
            System.out.println("World");
        }
    }
}



public  class Test_1{

    public static void main(String[] args) {
        World world = new World();  // NEW
       Thread t1 = new Thread(world);  // RUNNABLE
       t1.start();  // RUNNING

        for (; ;) {
            System.out.println(Thread.currentThread().getName());
        }

    }
}