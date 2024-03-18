package autoEx;

import org.springframework.beans.factory.annotation.Autowired;

public class Engine {
//	@Autowired //오토와이어드추가
	public void engineRunning() {
		System.out.println("엔진 가동중");
	}
}
