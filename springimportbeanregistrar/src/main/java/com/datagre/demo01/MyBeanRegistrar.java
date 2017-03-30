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
package com.datagre.demo01;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by ycaihua on 2017/3/30.
 * https://github.com/ycaihua/spring-core-tutorial
 */
public class MyBeanRegistrar implements ImportBeanDefinitionRegistrar{

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        System.out.println("registerBeanDefinitions");
        GenericBeanDefinition genericBeanDefinition=new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(AppBean.class);
        genericBeanDefinition.getPropertyValues().addPropertyValue("str","Value01");
        beanDefinitionRegistry.registerBeanDefinition("appBean",genericBeanDefinition);
        BeanDefinition beanDefinition= BeanDefinitionBuilder.genericBeanDefinition(MyBeanPostProcessor.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition(MyBeanPostProcessor.class.getName(),beanDefinition);
    }
}
