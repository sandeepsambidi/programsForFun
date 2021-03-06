
public class Cleaner implements Runnable{

	Dustbin dustbin;
	Cleaner(Dustbin dustbin) {
		this.dustbin = dustbin;
	}
	@Override
	public void run() {
		synchronized (dustbin) {
			while (true) {
				if (dustbin.isEmpty() == true) {
					try {
						dustbin.wait();
						System.out.println(Thread.currentThread().getName() + " : waiting to clean");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					String item = dustbin.bin.remove(dustbin.bin.size()-1);
					System.out.println("cleaner: "+Thread.currentThread().getName() + " : removed item: "+item);
					dustbin.notifyAll();
					try {
						//dustbin.wait();
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}
		
	}

}
