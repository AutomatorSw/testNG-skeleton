package com.skippersoft.testng;

import org.testng.IMethodSelector;
import org.testng.IMethodSelectorContext;
import org.testng.ITestNGMethod;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class ExpressionSelector implements IMethodSelector {
    @Override
    public boolean includeMethod(IMethodSelectorContext iMethodSelectorContext, ITestNGMethod iTestNGMethod, boolean b) {
        Optional<String> tagInput = Optional.ofNullable(System.getProperty("tags"));
        return !tagInput.isPresent() ||
                asList(iTestNGMethod.getGroups())
                        .containsAll(asList(tagInput.get().split("&")));
    }

    @Override
    public void setTestMethods(List<ITestNGMethod> list) {
    }
}
