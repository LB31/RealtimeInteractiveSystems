
public class ThreadTest implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
        for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
    }
    
    
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Runnable runnable = new ThreadTest();
	        Thread thread = new Thread(runnable);
	        thread.start();
		}
    }

}
