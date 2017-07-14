public class Demo extends Thread{
    @Override
    public void run(){
        for(int i=0;i<3;i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Application{
/*
    public static void main(String[] args) {
        Demo d1=new Demo();
        Demo d2=new Demo();
        d1.start();
        d2.start();
    }
*/

    public static void main(String[] args) {
        Application a=new Application();
        new Thread(() -> a.printEven()).start();
        new Thread(() -> a.printOdd()).start();
    }
    public void printEven(){
        for(int i = 0; i <= 10; i= i+2){
            // sleeping for 500 millis
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Even : "+i);
            try {
                notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void printOdd(){
        for(int i = 1; i <= 10; i= i+2){
            System.out.println("Odd : "+i);
            try {
                notify();
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // sleeping for 500 millis
        }
    }
}
