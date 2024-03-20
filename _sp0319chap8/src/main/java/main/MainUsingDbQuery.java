package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQueryConfig;
import dbquery.DbQuery;

public class MainUsingDbQuery {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext
				(DbConfig.class, DbQueryConfig.class);
		
		DbQuery dbquery = ctx.getBean(DbQuery.class);
		int count = dbquery.count();
		System.out.println(count);
		ctx.close();

	}

}
