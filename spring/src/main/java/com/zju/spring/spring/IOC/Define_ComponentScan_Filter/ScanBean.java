package com.zju.spring.spring.IOC.Define_ComponentScan_Filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author 况祥彬
 * @date 2020/11/5 9:23
 *
 **/
@ComponentScan(
        basePackages = {"com.zju.spring.spring.IOC.Define_ComponentScan_Filter"},
        useDefaultFilters = false,
         includeFilters = {@ComponentScan.Filter(type= FilterType.CUSTOM,classes = MyFilter.class)}
)
public class ScanBean {
}
