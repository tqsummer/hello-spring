package com.study.hello.spring.basic.demo.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: fangxiangqian
 * @Date: 2022/2/9
 */
public class HelloImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.study.hello.spring.basic.demo.beans.Person"};
    }
}
