package com.study.hello.spring.basic.demo.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;

/**
 * @Author: fangxiangqian
 * @Date: 2022/2/9
 */
public class HelloGroup implements DeferredImportSelector.Group {
    @Override
    public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {

    }

    @Override
    public Iterable<Entry> selectImports() {
        return new ArrayList<>();
    }
}
