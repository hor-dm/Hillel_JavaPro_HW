import instruction.AfterSuite;
import instruction.BeforeSuite;
import instruction.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void start (Class <?> cl) throws Exception {
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List <Method> testMethods = new ArrayList<>();
        for (Method method : cl.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException(
                            "@BeforeSuite methods founds in class"
                                    + cl.getName());
                }
                beforeSuiteMethod = method;
            }
            else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
            else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException(
                            "@AfterSuite methods found in class "
                                    + cl.getName());
                }
                afterSuiteMethod = method;
            }
        }
        testMethods.sort((m1, m2) -> {
            int priority1 = m1.getAnnotation(Test.class).priority();
            int priority2 = m2.getAnnotation(Test.class).priority();
            return Integer.compare(priority1, priority2);
        });
        Object testInstance = cl.getDeclaredConstructor().newInstance();
        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(testInstance);
        }
        for (Method testMethod : testMethods) {
            testMethod.invoke(testInstance);
        }
        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(testInstance);
        }
    }
}

