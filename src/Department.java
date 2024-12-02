import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Professor> professors = new ArrayList<>();
    private Professor director;

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void deleteProfessor(Professor professor) {
        professors.remove(professor);
    }

    public Professor getProfessor(int index) {
        return professors.get(index);
    }

    public Professor getDirector() {
        return director;
    }

    public void setDirector(Professor director) {
        this.director = director;
    }
}
