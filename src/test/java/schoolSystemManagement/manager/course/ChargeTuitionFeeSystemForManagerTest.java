package schoolSystemManagement.manager.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class ChargeTuitionFeeSystemForManagerTest {

    private JsonFile usersFile;  // JsonFile 객체
    private String userId;       // 테스트에 사용할 사용자 ID

    @BeforeEach
    public void setUp() {
        // JsonFile 객체 생성 및 테스트 데이터를 설정합니다.
        usersFile = new JsonFile("user_data.json", "user_data.json");
        userId = "S-184";  // 테스트에 사용할 사용자 ID 설정
    }

    @Test
    public void testGetAllJsonObjectWhereTargetKeyExists() {
        // "courseList" 내에 "course" 키가 있는 객체들을 가져오는 메서드 테스트
        Object[] subStudentsData = usersFile.getAllJsonObjectWhereTargetKeyExists("courseList", "course");

        // 결과가 null이 아니고, 배열의 길이가 0보다 큰지 확인
        assertNotNull(subStudentsData, "courseList에서 'course' 키를 가진 객체들을 가져올 수 있어야 합니다.");
        assertTrue(subStudentsData.length > 0, "'course' 키를 가진 객체들이 존재해야 합니다.");
    }

    @Test
    public void testGetAllJsonArrayValueForCourseUnit() {
        // 특정 "userId"의 "courseList"에서 "unit" 배열 값을 가져오는 메서드 테스트
        Object[] updateCourseUnitValues = usersFile.getAllJsonArrayValue("userId", userId, "courseList", "unit");

        // 결과가 null이 아니고, 배열의 길이가 0보다 큰지 확인
        assertNotNull(updateCourseUnitValues, "'courseList'에서 'unit' 값을 가져올 수 있어야 합니다.");
        assertTrue(updateCourseUnitValues.length > 0, "'unit' 배열 값들이 존재해야 합니다.");
    }

    @Test
    public void testGetAllJsonArrayValueForCourse() {
        // 특정 "userId"의 "courseList"에서 "course" 배열 값을 가져오는 메서드 테스트
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", userId, "courseList", "course");

        // 결과가 null이 아니고, 배열의 길이가 0보다 큰지 확인
        assertNotNull(courseValues, "'courseList'에서 'course' 값을 가져올 수 있어야 합니다.");
        assertTrue(courseValues.length > 0, "'course' 배열 값들이 존재해야 합니다.");
    }
}
