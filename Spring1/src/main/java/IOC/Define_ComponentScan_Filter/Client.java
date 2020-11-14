package IOC.Define_ComponentScan_Filter;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 况祥彬
 * @date 2020/11/5 9:51
 * 自定义的Filter，判断被扫描的类如果是IService接口类型的，就让其注册到容器中。
 **/
public class Client {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOC.Define_ComponentScan_Filter.ScanBean.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName+" "+context.getBean(beanName));
        }
    }
}
