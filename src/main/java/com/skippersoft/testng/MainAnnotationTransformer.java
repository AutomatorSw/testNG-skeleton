package com.skippersoft.testng;

import org.testng.internal.annotations.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MainAnnotationTransformer implements IAnnotationTransformer {
    List<IAnnotationTransformer> transformers;

    public MainAnnotationTransformer() {
        transformers = Arrays.asList(new GroupTransformer(), new FlakyTransformer());
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        transformers.forEach(t -> t.transform(annotation, testClass, testConstructor, testMethod, occurringClazz));
    }
}
