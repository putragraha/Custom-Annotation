import annotations.AnnotationField;
import annotations.AnnotationMethod;
import annotations.AnnotationParameter;
import annotations.AnnotationType;

/**
 * Created by Putra Nugraha.
 * Date: 03/03/2019
 */

@AnnotationType(createdBy = "Putra Nugraha")
public class Task {

    @AnnotationField("Annotation created from Field")
    private int id;
    private String description;

    public Task(@AnnotationParameter("Getting Id from Parameter") int id, String description) {
        this.id = id;
        this.description = description;
    }

    @AnnotationMethod
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
