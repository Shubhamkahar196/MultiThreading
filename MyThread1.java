
class MyThread1 extends Thread {

    // this code for yield()
    // public MyThread1(String name){
    //         super(name);
    // }    
    @Override

    public void run() {

        // this code for Interrupted
        // try {
        //     Thread.sleep(1000);
        //     System.out.println("Thread is running");
        // } catch (Exception e) {
        //     System.out.println("Thread Interrupted : " + e);
        // }
        //  this code for yield method
        // for(int i = 0; i<5; i++){
        //     System.out.println(Thread.currentThread().getName() + " is running ");
        //     Thread.yield();   // given to chance another thread
        // }
        //this code for setDaemon method
        while (true) {
            System.out.println("Hello world");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // this code for interrupt
        // MyThread1 t1 = new MyThread1();
        // t1.start();
        // t1.interrupt();

        // this code for yield method
        // MyThread1 t1 =  new MyThread1("t1");
        // MyThread1 t2 =  new MyThread1("t2");
        // t1.start();
        // t2.start();
        //this code for setDaemon method
        MyThread1 myThread = new MyThread1();
        myThread.setDaemon(true);
        myThread.start();
        System.out.println("Main done");
    }
}
