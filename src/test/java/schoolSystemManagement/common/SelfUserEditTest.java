package schoolSystemManagement.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelfUserEditTest {

    private JsonFile usersFile; // JsonFile 객체
    private String userId;     // 테스트에 사용할 사용자 ID

    @BeforeEach
    public void setUp() {
        // 테스트 데이터를 준비
        usersFile = new JsonFile("user_data.json", "user_data.json");
        userId = "S-184";

        // JsonFile 객체에 가상의 테스트 데이터를 미리 저장
        usersFile.setValueByStandardKey("userId", userId, "number", "12345");
        usersFile.setValueByStandardKey("userId", userId, "major", "전산학과");
        usersFile.setValueByStandardKey("userId", userId, "userType", "학생");
    }

    @Test
    public void testSaveAndRetrieveUserPassword() {
        // 사용자 비밀번호를 저장하고 올바르게 불러오는지 확인
        String userPasswordData = usersFile.getUserValueByStandardKey("userId", userId, "number").toString();
        assertEquals("12345", userPasswordData, "비밀번호가 올바르게 저장되고 불러와야 합니다.");
    }

    @Test
    public void testRetrieveUserMajor() {
        // 전공 정보를 올바르게 불러오는지 확인
        String userMajorData = usersFile.getUserValueByStandardKey("userId", userId, "major").toString();
        assertEquals("전산학과", userMajorData, "전공 정보가 올바르게 저장되고 불러와야 합니다.");
    }

    @Test
    public void testRetrieveUserType() {
        // 사용자 타입 정보를 올바르게 불러오는지 확인
        String userTypeData = usersFile.getUserValueByStandardKey("userId", userId, "userType").toString();
        assertEquals("학생", userTypeData, "사용자 타입 정보가 올바르게 저장되고 불러와야 합니다.");
    }
}