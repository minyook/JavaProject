package schoolSystemManagement.dto;

public class CourseData {

    // 과목 이름
    private String name;

    // 담당 교수
    private String professor;

    // 해당 과목 담당 교수의 아이디
    private String userId;

    // 최대 인원
    private int maxStudents;

    // 과목의 학점
    private int unit;

    // 과목에 대한 설명
    private String description;

    // @생성자
    /**
     * 생성자 입니다.
     *  과목의 이름을 입력받아 저장합니다.
     * @param name 과목의 이름
     */
    public CourseData(String name) {
        this.name = name;
    }

    /**
     * 생성자 입니다.
     *  과목의 이름, 담당교수, 최대 학생 수, 과목의 학점을 입력받아 저장합니다.
     * @param name 과목의 이름
     * @param professor 담당교수 이름
     * @param maxStudents 최대 수강인원
     * @param unit 과목의 학점
     */
    public CourseData(String name, String professor, int maxStudents, int unit) {
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.unit = unit;
    }

    /**
     * 생성자 입니다.
     * 과목의 이름, 담당교수, 최대 학생 수, 과목의 학점, 담당교수 아이디를 입력받아 저장합니다.
     * @param name 과목의 이름
     * @param professor 담당교수 이름
     * @param maxStudents 최대 수강인원
     * @param unit 과목의 학점
     * @param userId 담당 교수의 아이디
     */
    public CourseData(String name, String professor, int maxStudents, int unit, String userId) {
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.unit = unit;
        this.userId = userId;
    }

    /**
     * 생성자 입니다.
     * 과목의 이름, 담당교수, 최대 학생 수, 과목의 학점, 담당교수 아이디, 과목에 대한 설명를 입력받아 저장합니다.
     * @param name 과목의 이름
     * @param professor 담당교수 이름
     * @param maxStudents 최대 수강인원
     * @param unit 과목의 학점
     * @param userId 담당 교수의 아이디
     * @param description 과목에 대한 설명
     */
    public CourseData(String name, String professor, int maxStudents, int unit, String userId, String description) {
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.unit = unit;
        this.userId = userId;
        this.description = description;
    }

    // @gettor
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
