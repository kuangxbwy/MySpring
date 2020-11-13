package com.zju.spring.spring.IOC.Define_ComponentScan_Filter;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author 况祥彬
 * @date 2020/11/5 9:15
 **/
public class MyFilter implements TypeFilter {
    Class curClass=null;
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        try {
            curClass=Class.forName(metadataReader.getClassMetadata().getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean result = IService.class.isAssignableFrom(curClass);
        return result;
    }
}


 interface IService {
}

class service1 implements IService{

}

class service2 implements IService{

}
