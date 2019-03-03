import annotations.AnnotationField;
import annotations.AnnotationMethod;
import annotations.AnnotationParameter;
import annotations.AnnotationType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Putra Nugraha.
 * Date: 03/03/2019
 */

public class Main {
    public static void main(String[] args) {
        Task task = new Task(1, "Test Annotation");
        System.out.println("Print....");
        System.out.println("ID : " + task.getId());
        System.out.println("Task : " + task.getDescription());
        System.out.println();

        Class<Task> obj = Task.class;
        if (obj.isAnnotationPresent(AnnotationType.class)) {
            System.out.println("Annotation created from Type(Class)");

            Annotation annotation = obj.getAnnotation(AnnotationType.class);
            AnnotationType annotationType = (AnnotationType) annotation;

            System.out.println("Created by : " + annotationType.createdBy());
            for (String tag : annotationType.tags()) {
                System.out.println("Tag : " + tag);
            }
            System.out.println();
        }

        for (Field field: obj.getDeclaredFields()) {
            AnnotationField annotationField = field.getAnnotation(AnnotationField.class);
            if (annotationField != null)
                System.out.println(annotationField.value());
        }
        System.out.println();

        for (Method method : obj.getMethods()) {
            AnnotationMethod annotationMethod = method.getAnnotation(AnnotationMethod.class);
            if (annotationMethod != null)
                System.out.println("Annotation from Method created by : " + annotationMethod.createdBy());
        }
        System.out.println();

        for (Constructor constructor : obj.getConstructors()) {
            for (Parameter parameter : constructor.getParameters()) {
                AnnotationParameter annotationParameter = parameter.getAnnotation(AnnotationParameter.class);
                if (annotationParameter != null) {
                    System.out.println(annotationParameter.value());
                }
            }
        }
    }
}
