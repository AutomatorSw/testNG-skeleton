package com.skippersoft.testng;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static java.util.Arrays.stream;
import static java.util.stream.Stream.concat;


public class GroupTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        Groups groups = occurringClazz.getAnnotation(Groups.class);
        if (groups != null) {
            annotation.setGroups(
                    concat(stream(annotation.getGroups()), stream(groups.value()))
                            .toArray(size -> (String[]) Array.newInstance(String.class, size))
            );
        }
    }
}
