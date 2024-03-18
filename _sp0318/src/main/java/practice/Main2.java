//0318  2교시

package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main2 {
	
//	private static Logger LOGGER= LoggerFactory.getLogger(Main.class); //LOGGER 변수명
	private static Logger LOGGER= LoggerFactory.getLogger    //이거까진 고정형
			(Main2.class); 									//클래스이름과 똑같이.
	public static void main(String[] args) {
		LOGGER.info("나온다");
//		LOGGER.error("나온다");
		
//		System.out.println("나온다");
	}
}
