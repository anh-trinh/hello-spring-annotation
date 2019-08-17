package org.o7planning.spring.bean;

import java.util.Date;

import org.springframework.stereotype.Repository;

//@Repository là một annotation, 
//nó được sử dụng để chú thích trên một class để nói với Spring rằng 
//class này là một Spring BEAN.

//Không có sự khác biệt về cách sử dụng 
//của @Service, @Component và @Repository, 
//bạn sử dụng để chú thích trên các class của bạn 
//nên phù hợp với ý nghĩa và ngữ cảnh trong ứng dụng.
@Repository
public class MyRepository {

	public String getAppName() {
        return "Hello Spring App";
    }
 
    public Date getSystemDateTime() {
        return new Date();
    }
}
