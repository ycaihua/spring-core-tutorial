/**
 * Copyright 2016-2017 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datagre.demo03;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Date;

/**
 * Created by ycaihua on 2017/3/30.
 * https://github.com/ycaihua/spring-core-tutorial
 */
public class GenericBeanDefinitionExample {
    public static void main(String args[]){
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        GenericBeanDefinition genericBeanDefinition= new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(MyBean.class);
        MutablePropertyValues mutablePropertyValues=new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("date",new Date());
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        beanFactory.registerBeanDefinition("myBeanName",genericBeanDefinition);
        MyBean myBean=beanFactory.getBean(MyBean.class);
        myBean.doSomething();
    }
}
