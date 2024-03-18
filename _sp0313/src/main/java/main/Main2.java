package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Client;
import spring.Client2;

//메인 클래스 선언
public class Main2 {
 
 // 메인 메서드
 public static void main(String[] args) {
     // AnnotationConfigApplicationContext를 생성하여 설정 클래스를 전달합니다.
     AnnotationConfigApplicationContext ctx =
             new AnnotationConfigApplicationContext(AppCtx.class);
     // 컨텍스트에서 Client 빈을 가져옵니다.
     Client2 client = ctx.getBean(Client2.class);
     // Client 객체의 send 메서드를 호출하여 메시지를 전송합니다.
     client.send();
     // 컨텍스트를 닫습니다.
     ctx.close();
 }
}
