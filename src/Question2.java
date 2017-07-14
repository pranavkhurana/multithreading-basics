public class Question2 {
    public static void main(String[] args){

        Prime obj=new Prime();
        new Thread(()->obj.printPrime()).start();
        new Thread(()->obj.printNonPrime()).start();
    }
}

class Prime{
    synchronized void printPrime(){
        try{
            wait();
        }catch(Exception e){}
        for(int i=2;i<=20;i++) {
            if(isPrime(i)){
                System.out.println(i+"(p)");
                try {
                    notify();
                    wait();
                } catch (Exception e){e.printStackTrace();}
            }
        }
    }
    synchronized void printNonPrime(){
        for(int i=2;i<=20;i++){
            if(isPrime(i)){
               try {
                    notify();
                    wait();
               } catch (Exception e) {e.printStackTrace();}
            }
            else
                System.out.println(i);
        }
    }
    boolean isPrime(int i){
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0) return false;
        }
        return true;
    }
}