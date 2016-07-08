package ex1;

public class ContributeTest {

	public static void main(String[] args) {
		Contributor[] crs = new Contributor[10];
		Contribution group = new Contribution();
		for(int i=0; i<10; i++){
			
			crs[i] = new Contributor(group, "Contributor"+i);
		}
		
		for(int i=0; i<10; i++){
			crs[i].start();
		}
		
	}

}
