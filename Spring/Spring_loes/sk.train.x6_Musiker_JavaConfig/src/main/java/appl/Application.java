package appl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ifaces.Performer;

public class Application {
	public static void main(String[] args) {
		try (final AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplConfig.class)) {
			
			//mal das Orchester bauen
			Performer klavierspieler1 = (Performer) ctx.getBean("klavierspieler");
			Performer klavierspieler2 = (Performer) ctx.getBean("klavierspieler");
			Performer klavierspieler3 = (Performer) ctx.getBean("klavierspieler");
			
			klavierspieler1.perform();
			klavierspieler2.perform();
			klavierspieler3.perform();
			
			Performer gitarist1 = (Performer) ctx.getBean("gitarist");
			Performer gitarist2 = (Performer) ctx.getBean("gitarist");
			
			gitarist1.perform();
			gitarist2.perform();
			
			
			
			
			
			


			
		}
	}
}
