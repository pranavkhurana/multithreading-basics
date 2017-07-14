public class Question3 {
    public static void main(String[] args){
        Pattern obj=new Pattern();
        new Thread(()->obj.printPattern1()).start();
        new Thread(()->obj.printPattern2()).start();
        new Thread(()->obj.printPattern3()).start();
    }
}

class Pattern{
    volatile int turn=1;
    synchronized void printPattern1(){
        fun(1);
    }
    synchronized void printPattern2(){
        fun(2);
    }
    synchronized void printPattern3(){
        fun(3);
    }
    void fun(int x){
        while(true){
            try{
                if(turn==x){
                    System.out.print(x+" ");
                    turn=(x%3)+1;
                    notifyAll();
                }
                wait();
            }catch(Exception e){}
        }
    }
}