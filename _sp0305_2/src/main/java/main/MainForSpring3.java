package main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConf1;
import config.AppConf2;


public class MainForSpring3 {
	private static ApplicationContext ctx = null;
		
	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext
				(AppConf1.class, AppConf2.class);
		AppConf1 appConf1 = ctx.getBean(AppConf1.class);
		System.out.println(appConf1 != null);
		AppConf2 appConf2 = ctx.getBean(AppConf2.class);
		System.out.println(appConf2 != null);
		
	}
}
