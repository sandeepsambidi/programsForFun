import java.util.ArrayList;
import java.util.List;

public class Dustbin {

	List<String> bin = new ArrayList<>();
	
	boolean isFull() {
		if (bin.size() >= 3) {
			return true;
		}
		return false;
	}
	
	boolean put(String str) {
		if (isFull() != true) {
			bin.add(str);
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		if (bin.size() == 0) {
			return true;
		}
		return false;
	}
}
