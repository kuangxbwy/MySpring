package other.cache.demo2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author 况祥彬
 * @date 2020/11/9 16:00
 **/
@Component
public class BookService {
    @Cacheable(cacheNames = "cache1", key = "#root.targetClass.name+'-'+#root.method.name")
    public List<String> list(){
        System.out.println("模拟从db中取出数据");
        return Arrays.asList("java高并发", "springboot", "springcloud");
    }
}
