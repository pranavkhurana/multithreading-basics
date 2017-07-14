public class Question1 {
    public static void main(String[] args){

        OddEven obj=new OddEven();
        new Thread(()->obj.printOdd()).start();
        new Thread(()->obj.printEven()).start();
    }
}

class OddEven{
    synchronized void printOdd(){
        for(int i=1;i<=20;i+=2) {
            System.out.println(i);
            try {
                notify();
                wait();
            } catch (Exception e) {e.printStackTrace();}
        }
    }
    synchronized void printEven(){
        for(int i=2;i<=20;i+=2){
            System.out.println(i);
            try {
                notify();
                wait();
            } catch (Exception e) {e.printStackTrace();}
        }
    }
}