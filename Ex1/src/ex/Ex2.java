package ex;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
	
	public void doA(){
		List<Ex1> l = new ArrayList<>();
		Ex1 e = new Ex1();
		e.setS("11");
		l.add(e);
		
		for(int i=0; i<l.size(); i++){
			Ex1 ee = l.get(i);
			System.out.println(ee.getS());
		}
	}
	
	public void doB(){
		List l = new ArrayList();
		Ex1 e = new Ex1();
		e.setS("11");
		l.add(e);
		
		for(int i=0; i<l.size(); i++){
			Ex1 ee = (Ex1)l.get(i);
			System.out.println(ee.getS());
		}
	}
	
	public void doC(){
		StringBuilder sb = new StringBuilder();
		sb.append("11");
		sb.append("22");
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("11");
		sb2.append("22");
		
		String sb3 = "";
		sb3 += "11";
		sb3 += "22";
	}

	public static void main(String[] args) {
		
	}
}
