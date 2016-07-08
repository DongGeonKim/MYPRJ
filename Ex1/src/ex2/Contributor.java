package ex2;

public class Contributor extends Thread {
	
	private Contribution myContribution;
	private String myName;
	
	public Contributor(Contribution myContribution, String myName) {
		super();
		this.myContribution = myContribution;
		this.myName = myName;
	}

	@Override
	public void run() {
		for(int i=0; i<1000; i++){
			myContribution.donate();
		}
		System.out.println(myName + ":" + myContribution.getTotal());
	}

}
