package schoolSystemManagement.update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class AdministratorUpdate extends JFrame {
    private JTextField searchField, nameField, idField, idNumberFrontField, idNumberBackField;
    private JPasswordField passwordField;
    private JComboBox<String> departmentComboBox, userTypeComboBox;
    private JTable resultsTable;
    private JButton searchButton, updateButton;

    private static final String JSON_FILE_PATH = "user_data.json"; // 저장할 JSON 파일 경로
    private Map<String, Map<String, String>> userMap; // JSON 데이터 저장할 맵

    public AdministratorUpdate() {
        setTitle("담당자 정보 수정");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 컴포넌트 초기화
        initComponents();

        // 데이터 로드
        loadDataFromJSON();
    }

    private void initComponents() {
        // 검색 필드
        JLabel searchLabel = new JLabel("이름/ID로 검색:");
        searchLabel.setBounds(50, 30, 150, 25);
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(200, 30, 200, 25);
        add(searchField);

        searchButton = new JButton("검색");
        searchButton.setBounds(420, 30, 100, 25);
        add(searchButton);

        // 테이블 생성
        String[] columns = {"이름", "ID", "학과", "사용자 유형", "주민등록번호"};
        resultsTable = new JTable(new DefaultTableModel(new Object[0][0], columns));
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        scrollPane.setBounds(50, 70, 500, 150);

        add(scrollPane);

        //테이블 열 크기 조정
        resultsTable.getColumnModel().getColumn(0).setPreferredWidth(100); // 이름
        resultsTable.getColumnModel().getColumn(1).setPreferredWidth(100); // ID
        resultsTable.getColumnModel().getColumn(2).setPreferredWidth(100); // 학과
        resultsTable.getColumnModel().getColumn(3).setPreferredWidth(100); // 사용자 유형
        resultsTable.getColumnModel().getColumn(4).setPreferredWidth(150); // 주민등록번호


        // 정보 수정 버튼
        updateButton = new JButton("정보 수정");
        updateButton.setBounds(200, 250, 150, 30);
        add(updateButton);

        // 학과 목록 드롭다운 메뉴
        JLabel departmentLabel = new JLabel("학과:");
        departmentLabel.setBounds(50, 100, 100, 25);
        add(departmentLabel);

        String[] departments = {"전산학과", "전자공학과", "기계공학과", "화학공학과", "항공우주공학과"};
        departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.setBounds(150, 100, 200, 25);
        departmentComboBox.setEnabled(true); // 수정 가능하도록 설정
        add(departmentComboBox);

        // 사용자 유형 드롭다운 메뉴
        JLabel userTypeLabel = new JLabel("사용자 유형:");
        userTypeLabel.setBounds(50, 130, 100, 25);
        add(userTypeLabel);

        String[] userTypes = {"학생", "교수", "학사당담자", "수업당담자"};
        userTypeComboBox = new JComboBox<>(userTypes);
        userTypeComboBox.setBounds(150, 130, 200, 25);
        userTypeComboBox.setEnabled(true); // 수정 가능하도록 설정
        add(userTypeComboBox);

        // 검색 버튼 클릭 시
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText().trim().toLowerCase();
                DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();

                // 검색 필드가 비어 있는 경우 (새로고침 동작)
                if (searchText.isEmpty()) {
                    populateTable(); // 모든 데이터를 다시 테이블에 로드
                    JOptionPane.showMessageDialog(null, "테이블이 새로고침되었습니다.");
                    return;
                }

                // 기존 검색 로직
                model.setRowCount(0); // 기존 검색 결과 삭제
                boolean found = false;

                // JSON 데이터에서 검색
                for (String key : userMap.keySet()) {
                    Map<String, String> user = userMap.get(key);

                    if (user.get("name").toLowerCase().contains(searchText) || user.get("userId").toLowerCase().contains(searchText)) {
                        found = true;
                        model.addRow(new Object[]{
                                user.get("name"),
                                user.get("userId"),
                                user.get("major"),
                                user.get("userType"),
                                key // 주민등록번호 그대로 추가
                        });
                    }
                }

                // 검색 결과가 없을 때
                if (!found) {
                    JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = resultsTable.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "수정할 사용자 정보를 선택해주세요.");
                    return;
                }

                // 테이블에서 데이터를 가져오기
                String name = (String) resultsTable.getValueAt(selectedRow, 0);
                String id = (String) resultsTable.getValueAt(selectedRow, 1);
                String department = (String) resultsTable.getValueAt(selectedRow, 2);
                String userType = (String) resultsTable.getValueAt(selectedRow, 3);
                String jumin = (String) resultsTable.getValueAt(selectedRow, 4); // 주민등록번호

                // 유효성 검사
                if (jumin == null || jumin.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "유효하지 않은 주민등록번호입니다.");
                    return;
                }

                if (!userMap.containsKey(jumin)) {
                    JOptionPane.showMessageDialog(null, "해당 주민등록번호에 대한 데이터를 찾을 수 없습니다.");
                    return;
                }

                // userMap에서 데이터 가져오기
                Map<String, String> userData = userMap.get(jumin);
                if (userData == null) {
                    JOptionPane.showMessageDialog(null, "데이터를 로드하는 중 오류가 발생했습니다.");
                    return;
                }

                String password = userData.get("number"); // 비밀번호 가져오기

                // 수정 창 호출
                showEditDialog(name, id, department, userType, jumin, password);
            }
        });
// 테이블 데이터를 업데이트하는 메서드

    }
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) resultsTable.getModel();
        model.setRowCount(0); // 기존 데이터를 삭제

        // userMap 데이터를 테이블에 추가
        for (Map.Entry<String, Map<String, String>> entry : userMap.entrySet()) {
            String jumin = entry.getKey(); // 주민등록번호 키
            Map<String, String> user = entry.getValue();

            model.addRow(new Object[]{
                    user.get("name"),           // 이름
                    user.get("userId"),         // ID
                    user.get("major"),          // 학과
                    user.get("userType"),       // 사용자 유형
                    jumin                       // 주민등록번호 그대로 추가
            });
        }
    }

    private void loadDataFromJSON() {
        try {
            if (!Files.exists(Paths.get(JSON_FILE_PATH))) {
                System.out.println("JSON 파일이 존재하지 않습니다. 기본 데이터를 생성합니다.");
                userMap = new HashMap<>();
                saveDataToJSON(); // 기본 데이터로 파일 생성
                return;
            }

            String content = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)), "UTF-8");
            if (content.trim().isEmpty()) {
                System.out.println("JSON 파일이 비어 있습니다. 기본 데이터를 생성합니다.");
                userMap = new HashMap<>();
                saveDataToJSON();
                return;
            }

            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();

            if (jsonObject == null || jsonObject.entrySet().isEmpty()) {
                System.out.println("JSON 데이터가 비어 있습니다. 기본 데이터를 생성합니다.");
                userMap = new HashMap<>();
                saveDataToJSON();
                return;
            }

            userMap = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String jumin = entry.getKey();
                JsonObject userData = entry.getValue().getAsJsonObject();

                Map<String, String> userMapData = new HashMap<>();
                userMapData.put("name", userData.get("name").getAsString());
                userMapData.put("userId", userData.get("userId").getAsString());
                userMapData.put("major", userData.get("major").getAsString());
                userMapData.put("userType", userData.get("userType").getAsString());
                userMapData.put("number", userData.get("number").getAsString());

                userMap.put(jumin, userMapData);

                // 디버깅 출력
                System.out.println("로드된 데이터: " + jumin + " -> " + userMapData);
            }

            populateTable();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            userMap = new HashMap<>();
            saveDataToJSON();
        }
    }

    private void saveDataToJSON() {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            if (userMap.isEmpty()) {
                System.out.println("기본 데이터를 추가합니다.");
                // 기본 데이터 추가
                Map<String, String> defaultUser = new HashMap<>();
                defaultUser.put("name", "홍길동");
                defaultUser.put("userId", "hong123");
                defaultUser.put("major", "전산학과");
                defaultUser.put("userType", "학생");
                defaultUser.put("number", "password123");
                userMap.put("123456-1234567", defaultUser);
            }

            JsonObject jsonObject = new JsonObject();
            for (Map.Entry<String, Map<String, String>> entry : userMap.entrySet()) {
                String jumin = entry.getKey();
                Map<String, String> userData = entry.getValue();

                JsonObject userObject = new JsonObject();
                userObject.addProperty("name", userData.get("name"));
                userObject.addProperty("userId", userData.get("userId"));
                userObject.addProperty("major", userData.get("major"));
                userObject.addProperty("userType", userData.get("userType"));
                userObject.addProperty("number", userData.get("number"));

                jsonObject.add(jumin, userObject);
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditDialog(String name, String id, String department, String userType, String jumin, String password) {
        JDialog editDialog = new JDialog(this, "정보 수정 및 삭제", true);
        editDialog.setLayout(null);
        editDialog.setSize(500, 500); // 다이얼로그 크기 조정

        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setBounds(50, 30, 100, 25);
        editDialog.add(nameLabel);

        nameField = new JTextField(name);
        nameField.setBounds(150, 30, 300, 25);
        editDialog.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 70, 100, 25);
        editDialog.add(idLabel);

        idField = new JTextField(id);
        idField.setBounds(150, 70, 300, 25);
        idField.setEditable(false); // ID는 수정 불가능
        editDialog.add(idField);

        JLabel juminLabel = new JLabel("주민등록번호:");
        juminLabel.setBounds(50, 110, 100, 25);
        editDialog.add(juminLabel);

        JTextField juminField = new JTextField(jumin); // 주민등록번호 필드
        juminField.setBounds(150, 110, 300, 25);
        juminField.setEditable(false); // 주민등록번호는 수정 불가능 (요구 사항에 따라 변경 가능)
        editDialog.add(juminField);

        JLabel departmentLabel = new JLabel("학과:");
        departmentLabel.setBounds(50, 150, 100, 25);
        editDialog.add(departmentLabel);

        departmentComboBox = new JComboBox<>(new String[]{"전산학과", "전자공학과", "기계공학과", "화학공학과", "항공우주공학과"});
        departmentComboBox.setBounds(150, 150, 300, 25);
        departmentComboBox.setSelectedItem(department);
        editDialog.add(departmentComboBox);

        JLabel userTypeLabel = new JLabel("사용자 유형:");
        userTypeLabel.setBounds(50, 190, 100, 25);
        editDialog.add(userTypeLabel);

        userTypeComboBox = new JComboBox<>(new String[]{"학생", "교수", "학사당담자", "수업당담자"});
        userTypeComboBox.setBounds(150, 190, 300, 25);
        userTypeComboBox.setSelectedItem(userType);
        editDialog.add(userTypeComboBox);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(50, 230, 100, 25);
        editDialog.add(passwordLabel);

        passwordField = new JPasswordField(password);
        passwordField.setBounds(150, 230, 300, 25);
        editDialog.add(passwordField);

        // 저장 버튼
        JButton saveButton = new JButton("저장");
        saveButton.setBounds(100, 300, 100, 30);
        editDialog.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updatedName = nameField.getText().trim();
                String updatedDepartment = (String) departmentComboBox.getSelectedItem();
                String updatedUserType = (String) userTypeComboBox.getSelectedItem();
                String updatedPassword = new String(passwordField.getPassword()).trim();

                // JSON 데이터 업데이트
                Map<String, String> updatedUser = userMap.get(jumin); // 주민등록번호를 키로 가져옴
                updatedUser.put("name", updatedName);
                updatedUser.put("major", updatedDepartment);
                updatedUser.put("userType", updatedUserType);
                updatedUser.put("number", updatedPassword); // 비밀번호 업데이트

                saveDataToJSON(); // JSON 저장

                populateTable(); // 테이블 즉시 갱신 (추가된 부분)

                editDialog.dispose();
                JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
            }
        });

        // 삭제 버튼
        JButton deleteButton = new JButton("삭제");
        deleteButton.setBounds(250, 300, 100, 30);
        editDialog.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(editDialog, "정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    userMap.remove(jumin); // JSON 데이터에서 해당 사용자 삭제
                    saveDataToJSON(); // 변경 사항 저장
                    populateTable();
                    editDialog.dispose();
                    JOptionPane.showMessageDialog(null, "사용자가 삭제되었습니다.");//삭제
                }
            }
        });

        editDialog.setVisible(true);
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        SwingUtilities.invokeLater(() -> {
            new AdministratorUpdate().setVisible(true);
        });
    }
}