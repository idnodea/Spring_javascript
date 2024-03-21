package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbQueryConfig;
import config.Dbconfig;
import dbquery.DbQuery;

public class MainUsingDbQuery {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(Dbconfig.class,DbQueryConfig.class);
		DbQuery dbQuery = ctx.getBean(DbQuery.class);
		int count = dbQuery.count();
		System.out.println(count);
		ctx.close();
	}

}
