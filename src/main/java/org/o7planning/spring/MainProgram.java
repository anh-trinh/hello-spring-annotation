package org.o7planning.spring;

import org.o7planning.spring.bean.GreetingService;
import org.o7planning.spring.bean.MyComponent;
import org.o7planning.spring.config.AppConfiguration;
import org.o7planning.spring.lang.Language;
import org.o7planning.spring.lang.impl.Vietnamese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProgram {

	public static void main(String[] args) {

		// Tạo ra một đối tượng ApplicationContext bằng cách đọc cấu hỉnh
		// trong class AppConfiguration

		// Spring sẽ tạo các Spring BEAN,
		// theo các định nghĩa trong class AppConfiguration,
		// (lúc này đang là tạo new Vietnamese)
		// (Chú ý: Class AppConfiguration 
		//phải được chú thích bởi @Configuration).

		// Tiếp theo Spring sẽ tìm kiếm trong package "org.o7planning.spring.bean"
		// để tạo các Spring BEAN khác,
		// (Tạo các đối tượng từ các class được chú thích bởi 
		//@Service, @Component hoặc @Repository).
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfiguration.class);

		System.out.println("----------");
		Language language = (Language) context.getBean("language");

		System.out.println("Bean Language: " + language);
		System.out.println("Call language.sayBye(): " + language.getBye());

		System.out.println("----------");

		GreetingService service = (GreetingService) context.getBean("greetingService");

		service.sayGreeting();

		System.out.println("----------");

		MyComponent myComponent = (MyComponent) context.getBean("myComponent");

		myComponent.showAppInfo();
		
		//Viết theo cách thông thường ko cần spring sẽ là
		System.out.println("----------");
		System.out.println("Normal Way");
		AppConfiguration appConfiguration = new AppConfiguration();
		Vietnamese language2 = (Vietnamese) appConfiguration.getLanguage();
		System.out.println("Call language.sayBye(): " + language2.getBye());
		System.out.println("Greeting: " + language2.getGreeting());
		//Nhưng nó sẽ bị phụ thuộc các class với nhau
		//ví dụ như ở trên vẫn phải khai Vietnamese và lấy từ AppConfiguration
		//không thể chỉ dùng một cái context.getBean() là tạo được object BEAN
	}
}
