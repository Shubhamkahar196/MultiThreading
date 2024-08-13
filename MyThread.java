
class MyThread extends Thread {

    // @Override
    // public void run() {
    //   System.out.println("Running");
    //   try {
    //       Thread.sleep(2000);  
    //   } catch (InterruptedException e) {
    //     System.out.println(e);
    //   }
    // }
    // set priority
    public MyThread(String name) {
        super(name);
    }

    @Override

    public void run() {
        String a = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10000; j++) {
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " - Priority : " + Thread.currentThread().getPriority() + " current : " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Low Priority Thread");
        MyThread t2 = new MyThread("Medium Priority Thread");
        MyThread t3 = new MyThread("High Priority Thread");

        // System.out.println(t1.getState());
        // t1.start();
        // System.out.println(t1.getState());
        // Thread.sleep(100);
        // System.out.println(t1.getState());
        // t1.join();
        // System.out.println(t1.getState());
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

    }

}
