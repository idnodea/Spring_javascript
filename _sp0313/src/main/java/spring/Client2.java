// spring 패키지에 Client 클래스를 정의합니다.
package spring;

// InitializingBean, DisposableBean 인터페이스를 구현합니다.
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

// Client 클래스 선언
//public class Client implements InitializingBean, DisposableBean{  //
	public class Client2 {

    // 호스트 정보를 저장할 변수 선언
    private String host;
    

    
   

    // DisposableBean 인터페이스의 메서드 구현
//    @Override
//    public void destroy() throws Exception {
//    public void destroy() {
//        System.out.println("Client.destroy() 실행");
//    }
  
    
    
    // InitializingBean 인터페이스의 메서드 구현
//    @Override
//    public void afterPropertiesSet() throws Exception {
//    public void afterPropertiesSet() {
//        System.out.println("Client.afterPropertiesSet() 실행");
//    }
//  // 메시지를 전송하는 메서드
  public void send() {
      System.out.println("Client2.send() to " + host);
  }
  // 호스트 정보를 설정하는 메서드
  public void setHost(String host) {
      this.host = host;
  }
  
    public void connect() {   //매개변수x  //개발할 때,여기에 매개변수를 쓸 리가;;?
    	System.out.println("Clent2.connect");
    }
    
//    public void closeClient2() {	//매개변수x///  그리고 디폴트이름이라 메서드이름수정불가능
//    	System.out.println("client2.closeClient2()");
//    }
    public void close() {	//매개변수x
    	System.out.println("client2.close()");
    }
}