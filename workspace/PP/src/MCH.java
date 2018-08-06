
public class MCH {

	public static void main(String[] args) {
		Dustbin dBin = new Dustbin();
		
		User satya = new User(dBin);
		User sandeep = new User(dBin);
		User hassan = new User(dBin);
		User haritha = new User(dBin);
		
		Cleaner c1 = new Cleaner(dBin);
		Cleaner c2 = new Cleaner(dBin);
		
		new Thread(c1, "cleaner-1").start();
		new Thread(c2, "cleaner-2").start();
		
		new Thread(satya, "Satya").start();
		new Thread(sandeep, "Sandeep").start();
		new Thread(hassan, "Hassan").start();
		new Thread(haritha, "Haritha").start();
	}

}
