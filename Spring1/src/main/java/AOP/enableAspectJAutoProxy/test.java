package AOP.enableAspectJAutoProxy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 况祥彬
 * @date 2020/11/8 17:31
 **/

public class test {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig4.class);
        context.refresh();
        Service4 bean = context.getBean(Service4.class);
        System.out.println(bean.say("hello kk"));



    }
}
