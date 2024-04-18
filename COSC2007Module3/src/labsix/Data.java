package labsix;

public class Data {
	private int data;
	
	Data(int data) {
		this.data = data;
	}
	
	public int compareTo(Integer i) {
		if ((Integer)data == i) {
			return 0;
		} else if ((Integer)data < i) {
			return -1;
		} else {
			return 1;
		}
	}
}
