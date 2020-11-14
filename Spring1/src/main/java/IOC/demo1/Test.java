import IOC.demo1.MainConfig;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 况祥彬
 * @date 2020/11/10 12:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {
    @org.junit.Test
    public void test(){
        AnnotationConfigApplicationContext ioc =
                new AnnotationConfigApplicationContext(MainConfig.class);
        for (String s : ioc.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

}
