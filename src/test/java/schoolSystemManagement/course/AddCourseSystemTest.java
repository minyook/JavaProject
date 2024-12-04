package schoolSystemManagement.course;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddCourseSystemTest {

    private JsonFile coursesFile;
    private String courseName;
    private String courseProfessor;
    private String courseProfessorId;
    private String courseUnitStr;
    private String courseStatus;
    private String courseCountStudentsStr;
    private String courseMaxStudentsStr;
    private String courseDescription;

    @BeforeEach
    public void setUp() {
        // 테스트에 사용할 초기 강의 정보 설정
        coursesFile = new JsonFile("course_data.json", "course_data.json");
        courseName = "컴퓨터 과학 개론";
        courseProfessor = "테스트교수1";
        courseProfessorId = "P-101";
        courseUnitStr = "3";
        courseStatus = "true";
        courseCountStudentsStr = "30";
        courseMaxStudentsStr = "50";
        courseDescription = "이 강의는 컴퓨터 과학의 기초를 다룹니다.";

        // 기존 강의 데이터를 파일에 설정
        coursesFile.updateCourse(courseName, courseProfessor, courseProfessorId, courseUnitStr, courseStatus, courseCountStudentsStr, courseMaxStudentsStr, courseDescription);
    }

    @Test
    public void testUpdateCourse() {
        // 강의 정보를 업데이트
        String updatedCourseName = "자바 프로그래밍";
        String updatedCourseProfessor = "테스트교수2";
        coursesFile.updateCourse(updatedCourseName, updatedCourseProfessor, courseProfessorId, courseUnitStr, courseStatus, courseCountStudentsStr, courseMaxStudentsStr, courseDescription);

        // 업데이트된 강의 정보를 파일에서 읽어오기
        JSONObject courseData = coursesFile.getCourseByName(updatedCourseName);

        // 올바르게 업데이트되었는지 확인
        assertNotNull(courseData, "업데이트된 강의가 파일에서 조회되지 않았습니다.");
        assertEquals(updatedCourseName, courseData.getString("name"), "강의명이 올바르게 업데이트되어야 합니다.");
        assertEquals(updatedCourseProfessor, courseData.getString("professor"), "교수명이 올바르게 업데이트되어야 합니다.");
    }

    @Test
    public void testAddCourse() {
        // 새로운 강의 추가
        String newCourseName = "파이썬 프로그래밍";
        String newCourseProfessor = "테스트교수3";
        coursesFile.updateCourse(newCourseName, newCourseProfessor, "P-102", "3", "true", "25", "40", "웹 개발에 대한 강의");

        // 추가된 강의 정보가 올바르게 파일에 반영되었는지 확인
        JSONObject newCourseData = coursesFile.getCourseByName(newCourseName);
        assertEquals(newCourseName, newCourseData.getString("name"), "새로 추가된 강의명이 올바르게 저장되어야 합니다.");
    }
}
