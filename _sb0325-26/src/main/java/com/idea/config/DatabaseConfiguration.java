package com.idea.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties") //프로젝트상위
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")//프로퍼티에서 
	public HikariConfig hikariConfig() {
		System.out.println("hikariConfig()");
		return new HikariConfig();
	}
	
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration") //프로퍼티 마이바티스부분
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		System.out.println("mybatisConfig()");
		return new org.apache.ibatis.session.Configuration(); 
	}
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("dataSource()");
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		//중요함
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		System.out.println("sqlSessionFactory()");
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		System.out.println("sqlSessionTemplate()");
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	//빈을 만드는 데 팩토리 필요하고 팩톨는 소스를 필요하고....
//	@Configuration: 이 어노테이션은 클래스가 빈 정의를 포함하고 있음을 
//	나타냅니다.
//
//	@PropertySource("classpath:/application.properties"): 이 어노테이션은 
//	구성 속성이 포함된 프로퍼티 파일의 위치를 지정합니다.
//
//	hikariConfig(): 이 메서드는 "spring.datasource.hikari"로 접두사가 
//	지정된 속성을 사용하여 HikariConfig 인스턴스를 생성하고 구성합니다.
//
//	mybatisConfig(): 이 메서드는 "mybatis.configuration"로 접두사가 지정된
//	속성을 사용하여 MyBatis 구성 (org.apache.ibatis.session.Configuration)의 
//	인스턴스를 생성하고 구성합니다.
//
//	dataSource(): 이 메서드는 HikariDataSource 구현을 사용하여
//	DataSource 빈을 생성하고 구성합니다. 이전에 생성된 HikariConfig 빈으로
//	구성합니다.
//
//	sqlSessionFactory(DataSource dataSource): 이 메서드는 SqlSessionFactoryBean을
//	사용하여 SqlSessionFactory 빈을 생성합니다. 
//	데이터 소스와 MyBatis 구성을 설정합니다. 
//	또한 클래스 패스에서 MyBatis 매퍼 XML 파일을 스캔하기 위해 
//	매퍼 위치를 설정합니다.
//
//	sqlSessionTemplate(SqlSessionFactory sqlSessionFactory): 이 메서드는 
//	SqlSessionFactory 빈을 사용하여 SqlSessionTemplate 빈을 생성합니다.
//
//	이 구성 클래스는 데이터 소스 구성 및 MyBatis 세션 관리를 포함하여
//	MyBatis를 Spring Boot와 통합하기 위한 필수 구성 요소를 설정합니다.
}
