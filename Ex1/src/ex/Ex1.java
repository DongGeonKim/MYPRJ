package ex;

public class Ex1 {
	String s;
	
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public void doA(String str){
		s = str;
		System.out.println("doA..." + ":" + s);
	}
}
