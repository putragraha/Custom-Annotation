package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Putra Nugraha.
 * Date: 03/03/2019
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnotationType {
    String createdBy() default "nSystem";
    String[] tags() default {"Java", "Annotation"};
}
