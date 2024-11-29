package schoolSystemManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.*;

public class StudentProfessorUpdate extends JFrame {

    private JTextField nameField, idField, departmentField, idNumberField;
    private JPasswordField passwordField;
    private JButton updateButton;
    private static final String JSON_FILE_PATH = "user_data.json"; // JSON 파일 경로
    private Map<String, Map<String, String>> userMap; // 사용자 정보 저장

    public StudentProfessorUpdate() {
        setTitle("학생/교수 정보 수정");
        setSize(450, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 컴포넌트 초기화
        initComponents();

        // 데이터 로드
        loadDataFromJSON();
    }

    private void initComponents() {
        // 이름 필드
        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setBounds(50, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);
        nameField.setEditable(false);  // 이름 수정 불가
        add(nameField);

        // ID 필드
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 70, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 70, 200, 25);
        idField.setEditable(false);  // ID 수정 불가
        add(idField);

        // 학과 필드
        JLabel departmentLabel = new JLabel("학과:");
        departmentLabel.setBounds(50, 110, 100, 25);
        add(departmentLabel);

        departmentField = new JTextField();
        departmentField.setBounds(150, 110, 200, 25);
        departmentField.setEditable(false);  // 학과 수정 불가
        add(departmentField);

        // 주민등록번호 필드
        JLabel idNumberLabel = new JLabel("주민등록번호:");
        idNumberLabel.setBounds(50, 150, 100, 25);
        add(idNumberLabel);

        idNumberField = new JTextField();
        idNumberField.setBounds(150, 150, 200, 25);
        idNumberField.setEditable(false);  // 주민등록번호 수정 불가
        add(idNumberField);

        // 비밀번호 필드
        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(50, 190, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 190, 200, 25);
        add(passwordField);

        // 비밀번호 수정 버튼
        updateButton = new JButton("수정");
        updateButton.setBounds(150, 230, 150, 30);
        add(updateButton);

        // 비밀번호 수정 버튼 클릭 시
      updateButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 새 비밀번호 가져오기
        String newPassword = new String(passwordField.getPassword());

        // 비밀번호 유효성 검사
        if (newPassword.length() < 7) {
            JOptionPane.showMessageDialog(null, "비밀번호는 7자 이상이어야 합니다.");
            return;
        }

        // 현재 로그인한 사용자의 정보를 업데이트 (비밀번호만 수정)
        String userId = idField.getText().trim();
        Map<String, String> userData = userMap.get(userId);

        if (userData == null) {
            JOptionPane.showMessageDialog(null, "사용자 데이터를 찾을 수 없습니다.");
            return;
        }

        userData.put("number", newPassword); // 비밀번호 수정
        saveDataToJSON(); // 수정된 데이터를 JSON에 저장
        JOptionPane.showMessageDialog(null, "비밀번호가 수정되었습니다.");
    }
});
    }

private void loadDataFromJSON() {
    try {
        if (!Files.exists(Paths.get(JSON_FILE_PATH))) {
            System.out.println("JSON 파일이 존재하지 않습니다. 기본 데이터를 생성합니다.");
            initializeDefaultData();
            return;
        }

        String content = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)), "UTF-8");
        if (content.trim().isEmpty()) {
            System.out.println("JSON 파일이 비어 있습니다. 기본 데이터를 생성합니다.");
            initializeDefaultData();
            return;
        }

        JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();

        if (jsonObject == null || jsonObject.entrySet().isEmpty()) {
            System.out.println("JSON 데이터가 비어 있습니다. 기본 데이터를 생성합니다.");
            initializeDefaultData();
            return;
        }

        userMap = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String idNumber = entry.getKey(); // 주민등록번호 전체는 JSON의 키로 사용
            JsonObject userData = entry.getValue().getAsJsonObject();

            Map<String, String> userMapData = new HashMap<>();
            userMapData.put("name", userData.get("name").getAsString());
            userMapData.put("userId", userData.get("userId").getAsString());
            userMapData.put("major", userData.get("major").getAsString());
            userMapData.put("userType", userData.get("userType").getAsString());
            userMapData.put("number", userData.get("number").getAsString()); // 비밀번호 그대로 유지
            userMapData.put("idNumber", idNumber); // 주민등록번호 추가

            userMap.put(userData.get("userId").getAsString(), userMapData); // userId를 key로 사용
        }

        // 특정 사용자 정보 로드
        String currentUserId = "S-027"; // 예시로 "S-027" 사용
        if (userMap.containsKey(currentUserId)) {
            Map<String, String> currentUser = userMap.get(currentUserId);
            nameField.setText(currentUser.get("name"));
            idField.setText(currentUser.get("userId"));
            departmentField.setText(currentUser.get("major"));
            idNumberField.setText(currentUser.get("idNumber")); // 주민등록번호 전체 표시
        }

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("JSON 데이터를 읽는 중 오류가 발생했습니다. 기본 데이터를 생성합니다.");
        initializeDefaultData();
    }
}


private void initializeDefaultData() {
    userMap = new HashMap<>();

    Map<String, String> defaultUser = new HashMap<>();
    defaultUser.put("name", "홍길동");
    defaultUser.put("userId", "S-027");
    defaultUser.put("major", "전산학과");
    defaultUser.put("userType", "학생");
    defaultUser.put("number", "1234567"); // 비밀번호
    defaultUser.put("idNumber", "020811-1234567"); // 주민등록번호 전체

    userMap.put("S-027", defaultUser);
    saveDataToJSON();
}

private void saveDataToJSON() {
    try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
        JsonObject jsonObject = new JsonObject();

        for (Map.Entry<String, Map<String, String>> entry : userMap.entrySet()) {
            Map<String, String> userData = entry.getValue();

            JsonObject userObject = new JsonObject();
            userObject.addProperty("name", userData.get("name"));
            userObject.addProperty("userId", userData.get("userId"));
            userObject.addProperty("major", userData.get("major"));
            userObject.addProperty("userType", userData.get("userType"));
            userObject.addProperty("number", userData.get("number")); // 비밀번호 그대로 저장

            String idNumber = userData.get("idNumber"); // 주민등록번호 (JSON 키)
            jsonObject.add(idNumber, userObject);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonObject, writer);

    } catch (IOException e) {
        e.printStackTrace();
    }
}



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentProfessorUpdate().setVisible(true);
        });
    }
}