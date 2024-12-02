public class Subject {
    private String name;
    private String subjectId;

    public Subject(String name, String subjectId) {
        this.name = name;
        this.subjectId = subjectId;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
