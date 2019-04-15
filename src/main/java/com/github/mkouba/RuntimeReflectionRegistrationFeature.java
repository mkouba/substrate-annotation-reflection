package com.github.mkouba;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.graalvm.nativeimage.Feature;
import org.graalvm.nativeimage.RuntimeReflection;

import com.oracle.svm.core.annotate.AutomaticFeature;

@AutomaticFeature
public class RuntimeReflectionRegistrationFeature implements Feature {

    public void beforeAnalysis(BeforeAnalysisAccess access) {
        try {

            System.out.println("Registering for reflection");
            RuntimeReflection.register(TestAnnotation.class);

            Method maxRetries = TestAnnotation.class.getDeclaredMethod("maxRetries");
            TestAnnotation mainTestAnnotation = Main.class.getAnnotation(TestAnnotation.class);
            System.out.println("Invoked " + maxRetries + ": " + maxRetries.invoke(mainTestAnnotation));

            RuntimeReflection.register(maxRetries);

        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
