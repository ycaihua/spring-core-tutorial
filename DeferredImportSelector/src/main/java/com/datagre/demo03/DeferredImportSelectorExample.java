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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by ycaihua on 2017/3/30.
 * https://github.com/ycaihua/spring-core-tutorial
 */
public class DeferredImportSelectorExample {
    public static void main (String[] args) {
        System.setProperty("myProp", "someValue");

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        MainConfig.class);
        ClientBean bean = context.getBean(ClientBean.class);
        bean.doSomething();
    }

    @Configuration
    @Import(MyImportSelector.class)
    public static class MainConfig {

        @Bean
        ClientBean clientBean () {
            return new ClientBean();
        }

        @Bean
        AppBean appBean () {
            return new AppBean("from main config");
        }

    }

    public static class ClientBean {
        @Autowired
        private AppBean appBean;

        public void doSomething () {
            System.out.println(appBean.getMessage());
        }

    }


    public static class MyImportSelector implements DeferredImportSelector {

        @Override
        public String[] selectImports (AnnotationMetadata importingClassMetadata) {
            System.out.println(importingClassMetadata.getClassName());
            String prop = System.getProperty("myProp");
            if ("someValue".equals(prop)) {
                return new String[]{MyConfig1.class.getName()};
            } else {
                return new String[]{MyConfig2.class.getName()};
            }
        }
    }

    public static class AppBean {
        private String message;

        public AppBean (String message) {
            this.message = message;
        }

        public String getMessage () {
            return message;
        }
    }

    @Configuration
    public static class MyConfig1 {
        @Bean
        AppBean appBean () {
            return new AppBean("from config 1");
        }
    }

    @Configuration
    public static class MyConfig2 {
        @Bean
        AppBean appBean () {
            return new AppBean("from config 2");
        }
    }
}
