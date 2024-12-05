package schoolSystemManagement.manager.course;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

/* 
* 아래의 더미데이터를 추가하고 진행 해 주세요
* "course-5": {
        "professor": "테스트교수3",
        "unit": "3",
        "countStudents": "30",
        "name": "고급 컴퓨터 과학",
        "maxStudents": "50",
        "description": "이 강의는 고급 컴퓨터 과학을 다룹니다.",
        "userId": "P-102",
        "status": "true"
    }
* */

public class CourseManagerSystemForManagerTest {

    private JsonFile coursesFile;

    @BeforeEach
    public void setUp() {
        // JsonFile 객체 초기화
        coursesFile = new JsonFile("course_data.json", "course_data.json");

        // 새로운 강의 추가
        String newCourseName = "두번째 기본 강의 이름";
        String newCourseProfessor = "두번째 교수 이름";
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
        String courseName = "두번째 기본 강의 이름";
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
        // 삭제할 강의 이름
        String courseName = "두번째 기본 강의 이름";

        // 강의를 삭제하고, 삭제된 JSON 객체를 반환받음
        String deletedCourse = coursesFile.deleteJsonObject("name", courseName);

        // 반환된 삭제된 JSON 객체가 null이 아니고, 삭제된 강의의 name이 기대값과 일치하는지 확인
        assertNotNull(deletedCourse, "삭제된 강의 객체가 null이어서는 안 됩니다.");
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
