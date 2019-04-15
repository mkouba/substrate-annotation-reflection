package com.github.mkouba;

import org.graalvm.nativeimage.Feature;
import org.graalvm.nativeimage.RuntimeReflection;

import com.oracle.svm.core.annotate.AutomaticFeature;

@AutomaticFeature
public class RuntimeReflectionRegistrationFeature implements Feature {
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        try {
            System.out.println("Registering for reflection");
            RuntimeReflection.register(TestAnnotation.class);
            RuntimeReflection.register(TestAnnotation.class.getDeclaredMethod("maxRetries"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
