package schoolSystemManagement.student;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class CourseManagementSystemForStudentsTest {

    private JsonFile usersFile;
    private JsonFile coursesFile;
    private String studentId;
    private String selectedCourseName;
    private String courseNameData;

    @BeforeEach
    public void setUp() {
        // usersFile 및 coursesFile 객체 초기화 (파일 경로에 맞게 수정)
        usersFile = new JsonFile("user_data.json", "user_data.json");
        coursesFile = new JsonFile("course_data.json", "course_data.json");

        // 테스트용 데이터 설정 (예시)
        studentId = "S-184"; // 학생 ID
        selectedCourseName = "고급 컴퓨터 과학"; // 선택된 강의 이름
        courseNameData = "고급 컴퓨터 과학"; // 강의 이름
    }

    @Test
    public void testGetCourseValuesByUserId() {
        // 특정 조건에 따라 JSON 배열 값 가져오기
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "course");

        // courseValues가 null이 아니어야 함
        assertNotNull(courseValues, "학생의 강의 목록이 null이면 안 됩니다.");

        // 강의 목록에 선택된 강의가 포함되어 있는지 확인
        boolean courseFound = false;
        for (Object course : courseValues) {
            if (course.equals(selectedCourseName)) {
                courseFound = true;
                break;
            }
        }
        assertTrue(courseFound, "선택된 강의가 강의 목록에 포함되어야 합니다.");
    }

    @Test
    public void testGetCourseScore() {
        // 선택된 과목 이름을 사용하여 score 가져오기
        String courseScore = (usersFile.getJsonArrayValue("userId", studentId, "courseList", "course", selectedCourseName, "score")).toString();

        // score 값이 null이 아니어야 함
        assertNotNull(courseScore, "과목의 점수가 null이면 안 됩니다.");

        // 점수가 숫자로 변환될 수 있어야 함
        try {
            Double.parseDouble(courseScore);
        } catch (NumberFormatException e) {
            fail("과목 점수는 숫자여야 합니다.");
        }
    }

    @Test
    public void testGetProfessorName() {
        // 담당 교수 이름을 가져오기
        String professor = (coursesFile.getUserValueByStandardKey("name", selectedCourseName , "professor")).toString();

        // 교수 이름이 null이 아니어야 함
        assertNotNull(professor, "교수 이름이 null이면 안 됩니다.");
    }

    @Test
    public void testUpdateCourseCountStudents() {
        // 데이터 확인 (현재 수강 학생 수)
        Object countStudentsObject = coursesFile.getUserValueByStandardKey("name", courseNameData, "countStudents");

        // countStudents 값이 null이 아니어야 함
        assertNotNull(countStudentsObject, "수강 학생 수가 null이면 안 됩니다.");

        // 데이터 추가 (수강 학생 수 증가)
        int nowCountStudents = Integer.parseInt(countStudentsObject.toString()) + 1;
        coursesFile.setValueByStandardKey("name", courseNameData, "countStudents", nowCountStudents);

        // 갱신된 수강 학생 수 확인
        String updatedCountStudents = coursesFile.getUserValueByStandardKey("name", courseNameData, "countStudents").toString();
        assertEquals(String.valueOf(nowCountStudents), updatedCountStudents, "수강 학생 수가 갱신되어야 합니다.");
    }

    @Test
    public void testGetCourseDescription() {
        // 선택된 과목의 설명을 가져오기
        String descriptionData = coursesFile.getUserValueByStandardKey("name", selectedCourseName, "description").toString();

        // 설명이 null이 아니어야 함
        assertNotNull(descriptionData, "과목 설명이 null이면 안 됩니다.");
    }

    @Test
    public void testGetCourseUnitValues() {
        // 학생의 모든 강의 단위 값 가져오기
        Object[] courseUnitValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "unit");

        // courseUnitValues가 null이 아니어야 함
        assertNotNull(courseUnitValues, "강의 단위 목록이 null이면 안 됩니다.");
    }

    @Test
    public void testGetCountStudents() {
        // 현재 수강 인원 수 확인
        String countStudentsData = coursesFile.getUserValueByStandardKey("name", selectedCourseName, "countStudents").toString();

        // 수강 인원 수가 null이 아니어야 함
        assertNotNull(countStudentsData, "수강 인원 수가 null이면 안 됩니다.");
    }

    @Test
    public void testGetMaxStudents() {
        // 최대 수강 인원 수 확인
        String maxStudentsData = coursesFile.getUserValueByStandardKey("name", selectedCourseName, "maxStudents").toString();

        // 최대 수강 인원 수가 null이 아니어야 함
        assertNotNull(maxStudentsData, "최대 수강 인원 수가 null이면 안 됩니다.");
    }

    @Test
    public void testGetCourseUnit() {
        // 해당 과목 학점 출력
        String courseUnitData = coursesFile.getUserValueByStandardKey("name", selectedCourseName, "unit").toString();

        // 학점이 null이 아니어야 함
        assertNotNull(courseUnitData, "과목 학점이 null이면 안 됩니다.");
    }

    @Test
    public void testGetProfessorNameFromCourse() {
        // 담당 교수 이름 출력
        String professorData = coursesFile.getUserValueByStandardKey("name", selectedCourseName , "professor").toString();

        // 교수 이름이 null이 아니어야 함
        assertNotNull(professorData, "교수 이름이 null이면 안 됩니다.");
    }

    @Test
    public void testGetFilteredCourses() {
        // 개설된 강의 목록 가져오기 (status == "true")
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");

        // 필터링된 강의 목록이 null이 아니어야 함
        assertNotNull(filteredObjects, "개설된 강의 목록이 null이면 안 됩니다.");

        // 개설된 강의가 하나 이상 있어야 함
        assertTrue(filteredObjects.length() > 0, "개설된 강의가 하나 이상 있어야 합니다.");
    }
}
