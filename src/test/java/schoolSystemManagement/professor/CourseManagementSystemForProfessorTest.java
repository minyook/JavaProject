package schoolSystemManagement.professor;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import schoolSystemManagement.file.JsonFile;

public class CourseManagementSystemForProfessorTest {

    private JsonFile coursesFile;
    private JsonFile usersFile;

    @BeforeEach
    public void setUp() {
        // JsonFile 객체 초기화 (강의 데이터 및 사용자 데이터)
        coursesFile = new JsonFile("course_data.json", "course_data.json");
        usersFile = new JsonFile("user_data.json", "user_data.json");
    }

    @Test
    public void testGetOpenCourses() {
        // 개설된 강의만 필터링해서 가져오기 (status == "true")
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");

        // 개설된 강의 목록이 null이 아니고, 하나 이상의 강의가 있어야 함
        assertNotNull(filteredObjects, "개설된 강의 목록이 null이면 안 됩니다.");
        assertTrue(filteredObjects.length() > 0, "개설된 강의가 하나 이상 있어야 합니다.");
    }

    @Test
    public void testFilterCourseByName() {
        // 주어진 courseNameData에 해당하는 강의를 필터링
        String courseNameData = "고급 컴퓨터 과학";

        // "courseList" 내에서 "course" 값이 courseNameData와 일치하는 항목을 필터링
        Object[] filteredCourses = usersFile.getAllJsonObjectWhereTargetKeyValue("courseList", "course", courseNameData);

        // "filteredCourses"에서 각 객체를 순회하면서 "courseList" 배열을 검색
        boolean courseFound = false;

        for (Object courseObj : filteredCourses) {
            // 각 객체에서 "courseList" 배열을 가져옴
            JSONObject userObject = (JSONObject) courseObj;
            JSONArray courseList = userObject.getJSONArray("courseList");

            // "courseList" 배열 내에서 "course" 값이 "고급 컴퓨터 과학"인지 확인
            for (int i = 0; i < courseList.length(); i++) {
                JSONObject course = courseList.getJSONObject(i);
                String courseName = course.getString("course");

                if (courseName.equals(courseNameData)) {
                    courseFound = true;
                    break;  // 일치하는 강의를 찾았으므로 더 이상 순회할 필요 없음
                }
            }

            if (courseFound) {
                break;  // 강의가 이미 찾았으면 더 이상 순회할 필요 없음
            }
        }

        // 결과 확인
        assertTrue(courseFound, "강의 목록에서 '고급 컴퓨터 과학'을 찾을 수 없습니다.");
    }



    @Test
    public void testGetScore() {
        // 주어진 courseNameData에 대한 점수를 가져오는 테스트
        String userId = "S-184"; // 예시 사용자 ID
        String courseNameData = "고급 컴퓨터 과학";
        double score = Double.parseDouble(usersFile.getJsonArrayValue("userId", userId, "courseList", "course", courseNameData, "score").toString());

        // 점수가 유효한지 확인 (예시로 0 이상으로 가정)
        assertTrue(score >= 0, "점수는 0 이상이어야 합니다.");
    }
}
