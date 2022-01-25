package com.skippersoft.testng;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static java.lang.Boolean.*;

public class FlakyTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        String skipProp = System.getProperty("skipUnstable", "false");
        boolean toSkip = skipProp.isEmpty() || parseBoolean(skipProp);
        if (toSkip && (testMethod.getAnnotation(Unstable.class) != null)) {
            System.out.printf(
                    "Skipping unstable test %s.%s%n", occurringClazz.getName(), testMethod.getName()
            );
            annotation.setEnabled(false);
        }
    }
}
