package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import spring.Client;

//메인 클래스 선언
public class Main3 {    //빈객체의 생성과 관리범위,   그리고 싱글톤인지
 
 // 메인 메서드
 public static void main(String[] args) {
     // AnnotationConfigApplicationContext를 생성하여 설정 클래스를 전달합니다.
    AbstractApplicationContext ctx =
             new AnnotationConfigApplicationContext(AppCtx.class);
    
     // 컨텍스트에서 Client 빈을 가져옵니다.
     Client client1 = ctx.getBean(Client.class);
     Client client2 = ctx.getBean(Client.class);
     Client client3 = ctx.getBean(Client.class);  //스코프추가이후 해보면? false 이거없이 하면 true
     
     System.out.println(client1 == client2);
     
     // 컨텍스트를 닫습니다.
     ctx.close();
 }
}
