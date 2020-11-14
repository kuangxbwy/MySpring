package other.cache;


import other.cache.demo1.MainConfig;
import org.junit.Test;
import org.redisson.spring.cache.RedissonCache;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import other.cache.demo1.Service;
import other.cache.demo2.BookService;
import other.cache.demo2.MainConfig2;

/**
 * @author 况祥彬
 * @date 2020/11/9 14:19
 **/
public class cacheTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
        ioc.register(MainConfig.class);
        ioc.refresh();
        Service bean = ioc.getBean(Service.class);
        System.out.println(bean.list());
        System.out.println(bean.list());
    }
    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService.list());
        System.out.println(bookService.list());

        {
            System.out.println("下面打印出cache1缓存中的key列表");
            RedissonSpringCacheManager cacheManager = context.getBean(RedissonSpringCacheManager.class);
            RedissonCache cache1 = (RedissonCache) cacheManager.getCache("cache1");
            cache1.getNativeCache().keySet().stream().forEach(System.out::println);
        }
    }
}
