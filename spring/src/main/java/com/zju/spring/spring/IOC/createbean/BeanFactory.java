package com.zju.spring.spring.IOC.createbean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author 况祥彬
 * @date 2020/11/4 11:10
 **/
public class BeanFactory implements FactoryBean<UserModel> {

    int count=1;
    @Nullable
    @Override
    public UserModel getObject() throws Exception {
        UserModel model = new UserModel();
        model.setName("kk: "+ count++ );
        model.setAge(18);
        return model;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return UserModel.class;
    }
}
