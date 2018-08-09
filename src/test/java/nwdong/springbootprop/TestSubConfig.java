package nwdong.springbootprop;

import org.springframework.context.annotation.Bean;

public class TestSubConfig {

	@Bean
    public MyClass2 getMyClass2() {
        return new MyClass2();
    }

}
