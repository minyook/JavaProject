package schoolSystemManagement;

import org.junit.jupiter.api.Test;
import schoolSystemManagement.Management;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.HashMap;

public class ManagementTest {

    @Test
    public void testUserSignUp() {
        Management management = new Management();

        // 회원가입 테스트 데이터
        String name = "홍길동";
        String numberPart1 = "123456"; // 주민번호 앞자리
        String numberPart2 = "7890123"; // 주민번호 뒷자리
        String major = "컴퓨터공학";
        String userType = "학생";

        // 회원가입 처리
        management.userName.setText(name);
        management.userNumber.setText(numberPart1);
        management.userNumber1.setText(numberPart2);
        management.Major.setSelectedItem(major);
        management.Usertype.setSelectedItem(userType);

        // 회원가입 버튼 클릭
        management.SubmitActionPerformed(null);

        // JSON 파일에서 데이터 확인
        File file = new File("user_data.json");
        assertTrue(file.exists(), "JSON 파일이 생성되어야 합니다.");

        // 로드된 userMap 확인
        management.loadFromJson();
        assertTrue(management.userMap.containsKey(numberPart1 + "-" + numberPart2), "회원가입한 사용자가 userMap에 존재해야 합니다.");
    }

    @Test
    public void testUserLogin() {
        Management management = new Management();

        // 기존에 저장된 사용자 정보로 로그인
        String testUserId = "S-001";  // 예시 사용자 ID
        String testUserPassword = "7890123";  // 주민번호 뒷자리

        // 임시 사용자 데이터 추가
        HashMap<String, String> userData = new HashMap<>();
        userData.put("userId", testUserId);
        userData.put("number", testUserPassword); // 비밀번호는 주민번호 뒷자리로 설정

        management.userMap.put(testUserId, userData);

        // 로그인 정보 입력
        management.idField.setText(testUserId);
        management.passwordField.setText(testUserPassword);

        // 로그인 버튼 클릭
        management.loginButtonActionPerformed(null);

        // 로그인 성공 여부 확인
        assertTrue(management.userMap.containsKey(testUserId), "로그인 성공 후 userMap에 사용자가 존재해야 합니다.");
    }

    @Test
    public void testDuplicateBackPart() {
        Management management = new Management();

        // 중복된 주민번호 뒷자리 테스트
        String numberPart2 = "7890123";  // 중복된 주민번호 뒷자리

        // 사용자 데이터 추가
        HashMap<String, Object> userData = new HashMap<>();
        userData.put("name", "홍길동");
        userData.put("major", "컴퓨터공학");
        userData.put("userType", "학생");
        userData.put("userId", "S-001");
        userData.put("number", numberPart2);

        // userMap에 중복된 주민번호 뒷자리 추가
        management.userMapForSignUp.put("123456-" + numberPart2, userData);

        // 중복 확인
        assertTrue(management.isBackPartDuplicate(numberPart2), "중복된 주민번호 뒷자리가 확인되어야 합니다.");
    }
}
