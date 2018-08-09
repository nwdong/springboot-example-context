package nwdong.springbootprop;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =TestConfig.class,
		properties = { "nwdong.springbootprop.prop1-in-springboottest=prop1-value-in-springboottest"
				,"nwdong.springbootprop.prop2-in-springboottest=prop2-value-in-springboottest"
		}
)
@TestPropertySource("classpath:my-resources.properties")
// use @PropertySource in src/main
public class SpringbootExamplePropertiesApplicationTests {
	
	@Autowired
	MyClass1 myClz1;
	
	@Autowired
	MyClass2 myClz2;
	
	@Value("${nwdong.springbootprop.prop1-in-springboottest}")
	String prop1InSpringBootTest;

	@Value("${nwdong.springbootprop.prop2-in-springboottest}")
	String prop2InSpringBootTest;

	@Value("${nwdong.springbootprop.prop3-in-property-file}")
	String prop3InPropertyFile;

	@Value("${nwdong.springbootprop.prop4-in-property-file}")
	String prop4InPropertyFile;

	static {
		// do NOT put those in property file if it's through system.getProperty 
        System.setProperty("nwdong.springbootprop.prop5", "prop5-value");
    }
	
	@Test
	public void contextLoads() {
		System.out.println("prop1InSpringBootTest="+prop1InSpringBootTest);
		assertTrue("prop1-value-in-springboottest".equals(prop1InSpringBootTest));
		
		System.out.println("prop2InSpringBootTest="+prop2InSpringBootTest);
		assertTrue("prop2-value-in-springboottest".equals(prop2InSpringBootTest));
		
		System.out.println("prop3InPropertyFile="+prop3InPropertyFile);
		assertTrue("prop3-value-in-springboottest".equals(prop3InPropertyFile));
		
		System.out.println("prop4InPropertyFile="+prop4InPropertyFile);
		assertTrue("prop4-value-in-springboottest".equals(prop4InPropertyFile));
		
		System.out.println("from myclass1="+myClz1.getWhoAmI());
		assertTrue("I am MyClass1".equals(myClz1.getWhoAmI()));
		
		System.out.println("from myclass2="+myClz2.getWhoAmI());
		assertTrue("I am MyClass2".equals(myClz2.getWhoAmI()));
		
		// NULL, it can't be accessed through System.getProperty() but return null instead of throwing exception
		System.out.println("get prop1InSpringBootTest from System.getProperty(), result= " + System.getProperty("nwdong.springbootprop.prop1-in-springboottest"));
		assertNull(System.getProperty("nwdong.springbootprop.prop1-in-springboottest"));
		
		// NULL, it can't be accessed through System.getProperty() 
		System.out.println("get prop3InPropertyFile from System.getProperty(), result= " + System.getProperty("nwdong.springbootprop.prop3-in-property-file"));
		assertNull(System.getProperty("nwdong.springbootprop.prop3-in-property-file"));

		System.out.println("get nwdong.springbootprop.prop5 from System.getProperty(), result=" + System.getProperty("nwdong.springbootprop.prop5"));
		assertTrue("prop5-value".equals(System.getProperty("nwdong.springbootprop.prop5")));
	}

}
