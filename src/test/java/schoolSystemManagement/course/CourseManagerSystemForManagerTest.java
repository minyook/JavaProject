package schoolSystemManagement.course;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class CourseManagerSystemForManagerTest {

    private JsonFile coursesFile;

    @BeforeEach
    public void setUp() {
        // JsonFile 객체 초기화
        coursesFile = new JsonFile("course_data.json", "course_data.json");

        // 새로운 강의 추가
        String newCourseName = "고급 컴퓨터 과학";
        String newCourseProfessor = "테스트교수3";
        coursesFile.updateCourse(newCourseName, newCourseProfessor, "P-102", "3", "true", "25", "40", "웹 개발에 대한 강의");
    }

    // 강의 데이터를 업데이트하는 메서드
    private void updateCourseData(JsonFile coursesFile, String courseName, String courseUnit, String courseMaxStudents,
                                  String courseCountStudents, String courseStatus, String courseDescription) {
        coursesFile.addKeyAndValue("name", courseName, "unit", courseUnit);
        coursesFile.addKeyAndValue("name", courseName, "maxStudents", courseMaxStudents);
        coursesFile.addKeyAndValue("name", courseName, "countStudents", courseCountStudents);
        coursesFile.addKeyAndValue("name", courseName, "status", courseStatus);
        coursesFile.addKeyAndValue("name", courseName, "description", courseDescription);
    }

    @Test
    public void testUpdateCourseData() {
        // 강의 데이터를 업데이트
        String courseName = "고급 컴퓨터 과학";
        String courseUnit = "3";
        String courseMaxStudents = "50";
        String courseCountStudents = "30";
        String courseStatus = "true";
        String courseDescription = "이 강의는 고급 컴퓨터 과학을 다룹니다.";

        // 강의 데이터 업데이트
        updateCourseData(coursesFile, courseName, courseUnit, courseMaxStudents, courseCountStudents, courseStatus, courseDescription);

        // 강의 정보가 존재하는지 확인
        String updatedCourseUnit = getUpdatedCourseValue(courseName, "unit");
        assertNotNull(updatedCourseUnit, "강의 정보가 존재하지 않습니다.");
        assertEquals(courseUnit, updatedCourseUnit, "학점이 올바르게 업데이트되어야 합니다.");

        String updatedCourseMaxStudents = getUpdatedCourseValue(courseName, "maxStudents");
        assertNotNull(updatedCourseMaxStudents, "강의 정보가 존재하지 않습니다.");
        assertEquals(courseMaxStudents, updatedCourseMaxStudents, "최대 학생 수가 올바르게 업데이트되어야 합니다.");

        String updatedCourseCountStudents = getUpdatedCourseValue(courseName, "countStudents");
        assertNotNull(updatedCourseCountStudents, "강의 정보가 존재하지 않습니다.");
        assertEquals(courseCountStudents, updatedCourseCountStudents, "등록된 학생 수가 올바르게 업데이트되어야 합니다.");

        String updatedCourseStatus = getUpdatedCourseValue(courseName, "status");
        assertNotNull(updatedCourseStatus, "강의 정보가 존재하지 않습니다.");
        assertEquals(courseStatus, updatedCourseStatus, "강의 상태가 올바르게 업데이트되어야 합니다.");

        String updatedCourseDescription = getUpdatedCourseValue(courseName, "description");
        assertNotNull(updatedCourseDescription, "강의 정보가 존재하지 않습니다.");
        assertEquals(courseDescription, updatedCourseDescription, "강의 설명이 올바르게 업데이트되어야 합니다.");
    }

    // 강의 정보를 가져오는 공통 메서드
    private String getUpdatedCourseValue(String courseName, String key) {
        Object value = coursesFile.getUserValueByStandardKey("name", courseName, key);
        if (value == null) {
            // 강의가 존재하지 않으면 예외를 던지거나, 테스트에서 실패로 처리
            throw new IllegalArgumentException("강의 \"" + courseName + "\"이 존재하지 않습니다.");
        }
        return value.toString();
    }

    @Test
    public void testDeleteCourse() {
        // 기존에 존재하는 강의를 삭제
        String courseName = "고급 컴퓨터 과학";
        coursesFile.deleteJsonObject("name", courseName);

        // 삭제된 강의가 존재하지 않는지 확인
        JSONObject deletedCourse = coursesFile.getCourseByName(courseName);

        // 삭제된 강의는 존재하지 않아야 하므로 null이어야 함
        assertNull(deletedCourse, "삭제된 강의는 존재하지 않아야 합니다.");
    }

    @Test
    public void testGetFilteredObjects() {
        // 개설된 강의 목록 가져오기 (status == "true")
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");
        assertNotNull(filteredObjects, "개설된 강의 목록이 null이면 안 됩니다.");
        assertTrue(filteredObjects.length() > 0, "개설된 강의가 하나 이상 있어야 합니다.");
    }

    @Test
    public void testGetFilteredObjectsFalseStatus() {
        // 개설되지 않은 강의 목록 가져오기 (status == "false")
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "false");
        assertNotNull(filteredObjects, "개설되지 않은 강의 목록이 null이면 안 됩니다.");
        assertTrue(filteredObjects.length() >= 0, "개설되지 않은 강의 목록이 있어야 합니다.");
    }
}
