package com.test.referencecheck;

import java.util.ArrayList;
import java.util.List;

public class Hashmapreferencecheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Myclass a = new Myclass();
		Myclass b = new Myclass();
		Myclass c = new Myclass();
		
		a.setStr("srikanth");
		b.setStr("raghu");
		c.setStr("rohit");
		
		List<Myclass> list = new ArrayList<>();
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		
		
		System.out.println(list.toString());
		a.setStr("mohit");
		System.out.println(list.toString());
		a = b;
		a.setStr("srikanth");
		System.out.println(list.toString());
		
	}

}

class  Myclass {
	
	private String str ;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return str.equals(arg0.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return str.toString();
	}
	
}
