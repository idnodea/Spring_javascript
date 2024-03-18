package autoEx;

import org.springframework.beans.factory.annotation.Autowired;

public class Tire {  //엔진엔 추가했는데 여기는???
	private String postion;
	
	public void roll() {
		System.out.println("postion" +",");
		System.out.println("바퀴가 돈다");
	}
	
	public void setPostion(String postion) {
		this.postion = postion;
	}
	
	
}
