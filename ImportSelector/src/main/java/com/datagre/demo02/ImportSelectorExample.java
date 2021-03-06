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
package com.datagre.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ycaihua on 2017/3/30.
 * https://github.com/ycaihua/spring-core-tutorial
 */
public class ImportSelectorExample {
    public static void main(String[] args){
        System.setProperty("myprop", "someValue");

        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        ClientBean bean = context.getBean(ClientBean.class);
        bean.doSomething();
    }
}
