package nwdong.springbootprop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({TestSubConfig.class})
public class TestConfig {
	@Bean
    public MyClass1 getMyClass1() {
        return new MyClass1();
    }

}
