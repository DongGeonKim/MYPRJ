package ex3;

public class TestMain {

	public final static String BB = Test.getAa();
	
	public static void main(String[] args) {
		System.out.println(TestMain.BB);
		
		Test.setAa("aaa");
		
		System.out.println(TestMain.BB);
		
	}

}
