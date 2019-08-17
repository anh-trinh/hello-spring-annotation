package org.o7planning.spring.config;

import org.o7planning.spring.lang.Language;
import org.o7planning.spring.lang.impl.Vietnamese;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration là một annotation, 
//nó được chú thích trên một class, 
//class này sẽ định nghĩa các Spring BEAN. 

//@ComponentScan nói cho Spring các package để tìm kiếm các Spring BEAN khác
//Spring sẽ quét (scan) các package đó để tìm kiếm.
@Configuration
@ComponentScan({"org.o7planning.spring.bean"})
public class AppConfiguration {

	@Bean(name ="language")
    public Language getLanguage() {
 
        return new Vietnamese();
    }
	//Các Spring BEAN được tạo ra 
	//sẽ được quản lý trong Spring IoC Container (Bộ chứa Spring IoC).
}
