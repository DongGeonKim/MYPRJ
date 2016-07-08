package ex2;

public class ContributeTest {
	
	public static void main(String[] args) {
		Contributor[] crs = new Contributor[10];
		for(int i=0; i<10; i++){
			Contribution group = new Contribution();
			crs[i] = new Contributor(group, "Contributor"+i);
		}
		
		for(int i=0; i<10; i++){
			crs[i].start();
		}
		
	}

}
