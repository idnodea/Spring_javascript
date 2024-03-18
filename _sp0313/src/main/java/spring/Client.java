// spring 패키지에 Client 클래스를 정의합니다.
package spring;

// InitializingBean, DisposableBean 인터페이스를 구현합니다.
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// Client 클래스 선언
public class Client implements InitializingBean, DisposableBean{

    // 호스트 정보를 저장할 변수 선언
    private String host;
    
    // 메시지를 전송하는 메서드
    public void send() {
        System.out.println("Client.send() to " + host);
    }
    
    // 호스트 정보를 설정하는 메서드
    public void setHost(String host) {
        this.host = host;
    }

    // DisposableBean 인터페이스의 메서드 구현
    @Override
    public void destroy() throws Exception {
        System.out.println("Client.destroy() 실행");
    }

    // InitializingBean 인터페이스의 메서드 구현
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Client.afterPropertiesSet() 실행");
    }
}