package com.study.hello.spring.basic.demo.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: fangxiangqian
 * @Date: 2022/2/9
 */
public class HelloDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.study.hello.spring.basic.demo.beans.Person"};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return HelloGroup.class;
    }
}
