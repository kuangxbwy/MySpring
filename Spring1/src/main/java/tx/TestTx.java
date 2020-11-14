package tx;

import tx.demo1.MainConfig;
import tx.demo1.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 况祥彬
 * @date 2020/11/9 20:04
 **/
public class TestTx {
    @Test
    public void  test(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        ioc.register(MainConfig.class);
        ioc.refresh();
        UserService bean = ioc.getBean(UserService.class);
        int count = bean.insertBeach(
                "java高并发系列",
                "mysql系列",
                "maven系列",
                "mybatis系列");
        System.out.println(count+"条");
        System.out.println(bean.selectList());


    }
}
