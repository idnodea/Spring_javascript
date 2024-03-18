//0318 pg186 1교시

package practice;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //0318 pg186 1교시
public class DbConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/project2?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("mysql");
		ds.setInitialSize(2);  //커넥션초기생성갯수
		ds.setMaxActive(10);
		return ds;
	}
}


//Java Spring 프레임워크에서 @Bean 어노테이션은 빈을 선언하는 데 사용됩니다.
//destroyMethod 속성은 빈이 파괴될 때 호출될 메서드를 지정하는 데 사용됩니다. 
//이 메서드는 주로 리소스 해제 또는 연결 종료와 같은 정리 작업에 사용됩니다.
