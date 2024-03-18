package component.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	@Autowired
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		UserService g = ctx.getBean(UserService.class);
		g.cal(3.14, 10.54);
		ctx.close();
	}

}
