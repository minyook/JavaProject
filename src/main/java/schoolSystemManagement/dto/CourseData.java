package schoolSystemManagement.dto;

public class CourseData {

    // 과목 이름
    private String name;

    // 담당 교수
    private String professor;

    // 최대 인원
    private int maxStudents;

    // 학점
    private int unit;
    
    private String userId;

    private String description;

    public CourseData(String name, String professor, int maxStudents, int unit) {
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.unit = unit;
    }
    public CourseData(String name, String professor, int maxStudents, int unit, String userId) {
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.unit = unit;
        this.userId = userId;
    }

    public CourseData(String name, String professor, int maxStudents, int unit, String userId, String description) {
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.unit = unit;
        this.userId = userId;
        this.description = description;
    }

    public CourseData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getProfessor() {
        return professor;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public int getUnit() {
        return unit;
    }
    public String getUserId(){
        return userId;
    }
    public String getDescription() { return description; }
}
