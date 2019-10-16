import java.util.Vector;

class Token {
	volatile int counter = 0; 
}

public class ThreadTest implements Runnable{

	Token obj;
	
	public ThreadTest(Token obj) {
		this.obj = obj;
	}
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
        	if(i % 20 == 0) {
        		synchronized (obj) {
        			try {
        				obj.counter++;
        				if(obj.counter < 5-1) {
        					obj.wait();
        				}
        				
        				obj.counter = 0;
        				obj.notifyAll();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
        		
        	}
        	
			System.out.println(i + " " + Thread.currentThread().getName());
		}
    }
    
    
	public static void main(String[] args) {
		Token obj = new Token();
		
		for (int i = 0; i < 5; i++) {
			Runnable runnable = new ThreadTest(obj);
	        Thread thread = new Thread(runnable);
	        thread.start();
		}
    }

}
