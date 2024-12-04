package schoolSystemManagement.user;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import schoolSystemManagement.file.JsonFile;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerHomeTest {

    // 가상의 파일을 사용하는 것으로 가정
    private JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");

    @Test
    public void testGetJsonObjectByUserId() {
        // userId로 JSON 객체 가져오기 (예상되는 JSON 객체)
        String userId = "S-111";  // 검증할 userId
        JSONObject filteredObjects = usersFile.getJsonObject();

        // JSON 객체가 null이 아니어야 함
        assertNotNull(filteredObjects, "JSON 객체가 null이면 안 됩니다.");

        // userId에 해당하는 JSON 객체를 찾아야 함
        JSONObject userObject = filteredObjects.getJSONObject("666666-12345"); // userId에 해당하는 객체 가져오기

        // userId가 "S-111"인 사용자 확인
        assertEquals("S-111", userObject.getString("userId"), "userId가 일치하지 않습니다.");
    }
}
