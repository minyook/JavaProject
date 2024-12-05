package schoolSystemManagement.manager.course;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;
import static org.junit.jupiter.api.Assertions.*;

public class CourseManagerHomeTest {

    private JsonFile coursesFile; // JsonFile 객체
    private JSONObject filteredObjects; // 개설된 강의 목록

    @BeforeEach
    public void setUp() {
        // JsonFile 객체 초기화
        coursesFile = new JsonFile("course_data.json", "course_data.json");

        // "status"가 "true"인 개설된 강의 목록 가져오기
        filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");
    }

    @Test
    public void testGetAllObjectsByKeyValue() {
        // "status"가 "true"인 개설된 강의 목록이 null이 아니어야 하고, 배열의 길이가 0보다 커야 한다
        assertNotNull(filteredObjects, "개설된 강의 목록이 null이면 안 됩니다.");

        // 강의가 하나 이상 있는지 확인
        assertFalse(filteredObjects.isEmpty(), "개설된 강의가 하나 이상 있어야 합니다.");
    }

    @Test
    public void testFilteredObjectsContainsValidCourses() {
        // "status"가 "true"인 강의 목록을 순회하면서 강의의 "name" 필드를 확인
        boolean validCourseFound = false;
        for (String key : filteredObjects.keySet()) {
            JSONObject course = filteredObjects.getJSONObject(key);
            if (course.getString("status").equals("true")) {
                validCourseFound = true;
                break;
            }
        }
        // 개설된 강의가 유효한지 체크
        assertTrue(validCourseFound, "개설된 강의 목록에서 유효한 강의를 찾을 수 없습니다.");
    }
}
