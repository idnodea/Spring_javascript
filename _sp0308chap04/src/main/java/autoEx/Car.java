package autoEx;

import org.springframework.beans.factory.annotation.Autowired;

public class Car { //세터에 추가
	@Autowired //오토와이어드추가
	private Engine engine;
	@Autowired //오토와이어드추가
	private Tire tire1;
	@Autowired //오토와이어드추가
	private Tire tire2;
	@Autowired //오토와이어드추가
	private Tire tire3;
	@Autowired //오토와이어드추가
	private Tire tire4;
	
	
	
//	@Autowired 
public void setEngine(Engine engine) {
		this.engine = engine;
	}




	//	@Autowired //추가하지 않고 세터에 추가함
	public void run() {
		engine.engineRunning();
		tire1.setPostion("왼쪽 앞");
		tire1.roll();
		tire2.setPostion("오른쪽 앞");
		tire2.roll();
		tire3.setPostion("왼쪽 뒤");
		tire3.roll();
		tire4.setPostion("오른쪽 뒤");
		tire4.roll();
	}
}
