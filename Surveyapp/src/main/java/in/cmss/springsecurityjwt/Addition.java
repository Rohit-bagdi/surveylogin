package in.cmss.springsecurityjwt;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 @Document
public class Addition {
	 
	 
	int a,b;
	 
	 int c;

	 

	public Addition(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}



	public int getA() {
		return a;
	}



	public void setA(int a) {
		this.a = a;
	}



	public int getB() {
		return b;
	}



	public void setB(int b) {
		this.b = b;
	}



	public int getC() {
		return c;
	}



	public void setC(int c) {
		this.c = c;
	}

	 
	

}
