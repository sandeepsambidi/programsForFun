
public class User implements Runnable{

	Dustbin dustbin;
	
	User(Dustbin dustbin) {
		this.dustbin = dustbin;
	}
	@Override
	public void run() {
		synchronized (dustbin) {
			int i = 0;
			while (true) {
				if (dustbin.isFull() == true) {
					try {
						dustbin.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					String dust = ": d"+i;
					System.out.println(Thread.currentThread().getName() + " putting in dustbin: "+dust);
					dustbin.put(dust);
					dustbin.notifyAll();
					try {
						//dustbin.wait();
						Thread.sleep(15);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				i++;
				
			}
			
		}
		
	}
	

}
