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

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Date;

/**
 * Created by ycaihua on 2017/3/30.
 * https://github.com/ycaihua/spring-core-tutorial
 */
public class BeanDefinitionBuilderExample {
    public static void main (String[] args) {
        DefaultListableBeanFactory beanFactory =
                new DefaultListableBeanFactory();
        BeanDefinitionBuilder builder=BeanDefinitionBuilder.rootBeanDefinition(MyBean.class)
                .addPropertyValue("date",new Date());
        beanFactory.registerBeanDefinition("myBean",builder.getBeanDefinition());


        MyBean bean = beanFactory.getBean(MyBean.class);
        bean.doSomething();
    }
}
