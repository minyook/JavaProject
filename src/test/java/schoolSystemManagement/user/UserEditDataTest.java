package schoolSystemManagement.user;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class UserEditDataTest {

    private JsonFile usersFile;
    private String userId;
    private String password;
    private String major;
    private String type;
    private String userKey;

    @BeforeEach
    public void setUp() {
        // usersFile 객체 초기화 (파일 경로에 맞게 수정)
        usersFile = new JsonFile("user_data.json", "user_data.json");

        // 테스트용 데이터 초기화
        userId = "S-111"; // 예시 유저 ID
        password = "12345";
        major = "전산학과";
        type = "학생";
        userKey = "666666-12345";
    }

    @Test
    public void testGetJsonObject() {
        // 데이터를 가져와서 테이블에 삽입하는 부분
        JSONObject filteredObjects = usersFile.getJsonObject();

        // JSON 객체가 null이 아니어야 함
        assertNotNull(filteredObjects, "데이터가 null이면 안 됩니다.");
    }

    @Test
    public void testUpdatePassword() {
        // 비밀번호 수정 테스트
        String currentPassword = usersFile.getUserValueByStandardKey("userId", userId, "number").toString();
        if (!currentPassword.equals(password)) {
            usersFile.addKeyAndValue("userId", userId, "number", password);
        }

        // 비밀번호가 수정되었는지 확인
        String updatedPassword = usersFile.getUserValueByStandardKey("userId", userId, "number").toString();
        assertEquals(password, updatedPassword, "비밀번호가 올바르게 수정되지 않았습니다.");
    }

    @Test
    public void testUpdateMajor() {
        // 전공 수정 테스트
        String currentMajor = usersFile.getUserValueByStandardKey("userId", userId, "major").toString();
        if (!currentMajor.equals(major)) {
            usersFile.addKeyAndValue("userId", userId, "major", major);
        }

        // 전공이 수정되었는지 확인
        String updatedMajor = usersFile.getUserValueByStandardKey("userId", userId, "major").toString();
        assertEquals(major, updatedMajor, "전공이 올바르게 수정되지 않았습니다.");
    }

    @Test
    public void testUpdateUserType() {
        // 직책 수정 테스트
        String currentType = usersFile.getUserValueByStandardKey("userId", userId, "userType").toString();
        if (!currentType.equals(type)) {
            usersFile.addKeyAndValue("userId", userId, "userType", type);
        }

        // 직책이 수정되었는지 확인
        String updatedType = usersFile.getUserValueByStandardKey("userId", userId, "userType").toString();
        assertEquals(type, updatedType, "직책이 올바르게 수정되지 않았습니다.");
    }

    @Test
    public void testDeleteUser() {
        // 유저 삭제 테스트
        String result = usersFile.deleteJsonObject("userId", userId);

        // result가 null이면 삭제가 실패한 것이므로 실패로 처리
        assertNotNull(result, "유저 삭제에 실패했습니다. 삭제된 유저의 ID가 반환되지 않았습니다.");

        // result 값이 존재하면 삭제가 성공적으로 진행된 것
        assertEquals(result, userKey, "삭제된 유저의 ID와 반환된 ID가 일치하지 않습니다.");
    }

}
