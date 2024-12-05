package schoolSystemManagement.professor;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorHomeTest {

    private JsonFile coursesFile;

    @BeforeEach
    public void setUp() {
        // JsonFile 객체 초기화 (파일 경로에 맞게 수정)
        coursesFile = new JsonFile("course_data.json", "course_data.json");
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

    @Test
    public void testGetFilteredCoursesAndUpdate() {
        // 개설된 강의 목록 가져오기 (status == "true")
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");

        // 필터링된 강의 목록이 null이 아니어야 함
        assertNotNull(filteredObjects, "개설된 강의 목록이 null이면 안 됩니다.");

        // 강의가 하나 이상이어야 함
        assertTrue(filteredObjects.length() > 0, "개설된 강의가 하나 이상 있어야 합니다.");

        // 여기에 강의 정보를 업데이트하는 테스트 부분

        String courseName = filteredObjects.keys().next();
        JSONObject course = filteredObjects.getJSONObject(courseName);
        course.put("name", "변경된 강의 이름");
        course.put("status", "false");

        // 변경 후, 실제 값이 잘 반영되었는지 확인
        assertEquals("변경된 강의 이름", course.getString("name"), "강의 이름이 변경되어야 합니다.");
        assertEquals("false", course.getString("status"), "강의 상태가 변경되어야 합니다.");
    }
}
