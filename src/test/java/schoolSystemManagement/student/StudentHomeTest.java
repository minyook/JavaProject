package schoolSystemManagement.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class StudentHomeTest {

    private JsonFile usersFile;
    private String studentId;

    @BeforeEach
    public void setUp() {
        // usersFile 객체 초기화 (파일 경로에 맞게 수정)
        usersFile = new JsonFile("user_data.json", "user_data.json");

        // 테스트용 학생 ID 설정
        studentId = "S-184"; // 예시 학생 ID
    }

    @Test
    public void testGetStudentMajor() {
        // 학생 전공 값 가져오기
        Object studentMajor = usersFile.getUserValueByStandardKey("userId", studentId, "major");

        // 전공 값이 null이 아니어야 함
        assertNotNull(studentMajor, "학생의 전공이 null이면 안 됩니다.");
    }

    @Test
    public void testGetCourseListByStudentId() {
        // 특정 조건에 따라 학생의 강의 목록을 가져오기
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "course");

        // 강의 목록이 null이 아니어야 함
        assertNotNull(courseValues, "학생의 강의 목록이 null이면 안 됩니다.");

        // 강의 목록에 적어도 하나의 강의가 있어야 함
        assertTrue(courseValues.length > 0, "학생의 강의 목록에 강의가 있어야 합니다.");
    }

    @Test
    public void testGetCourseValuesFromUserFile() {
        // 특정 조건에 따라 JSON 배열 값 가져오기
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "course");

        // 강의 목록이 null이 아니어야 함
        assertNotNull(courseValues, "강의 목록이 null이면 안 됩니다.");

        // 강의 목록에 적어도 하나의 강의가 포함되어야 함
        assertTrue(courseValues.length > 0, "학생의 강의 목록에 강의가 있어야 합니다.");
    }

    @Test
    public void testGetCourseValuesAfterReinitialization() {
        // JsonFile 객체 다시 초기화
        usersFile = new JsonFile("user_data.json", "user_data.json");

        // 특정 조건에 따라 JSON 배열 값 가져오기
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "course");

        // 강의 목록이 null이 아니어야 함
        assertNotNull(courseValues, "강의 목록이 null이면 안 됩니다.");

        // 강의 목록에 적어도 하나의 강의가 포함되어야 함
        assertTrue(courseValues.length > 0, "학생의 강의 목록에 강의가 있어야 합니다.");
    }
}
