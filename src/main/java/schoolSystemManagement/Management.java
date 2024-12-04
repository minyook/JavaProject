/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import schoolSystemManagement.manager.user.UserManagerHome;
import schoolSystemManagement.manager.course.CourseManagerHome;
import schoolSystemManagement.professor.ProfessorHome;
import schoolSystemManagement.student.StudentHome;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author limmi
 */
public class Management extends javax.swing.JFrame {

    private JPanel newpanel;
    // 주민번호 키를 String으로 처리
    private HashMap<String, HashMap<String, String>> userMap = new HashMap<>();
    private static final String FILE_PATH = "user_data.json"; // JSON 파일 경로
    private final Gson gson = new Gson(); // GSON 객체
    
    private HashMap<String, HashMap<String, Object>> userMapForSignUp = new HashMap<>();
    private final Gson gsonForSignUp = new Gson(); // GSON 객체
    

    /**
     * 기본 생성자.
     */
    public Management() {
        setTitle("대학 정보 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(884, 610);
        setLocationRelativeTo(null);
        
        initComponents();
        customizeComponents();
        loadFromJsonForSignUp();
        loadFromJson(); // 프로그램 시작 시 사용자 데이터 로드
        
        // 창 열릴 때 배경 이미지 설정
        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowOpened(java.awt.event.WindowEvent evt) {
            setBackgroundImage();
        }
        });
    
        // 창 크기 변경 리스너 추가
        addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            // 창 크기 변경시 배경 이미지 다시 설정
            setBackgroundImage();
        }
        });
        
        // 크기 조정 완전 금지
        setResizable(false);

        
        
        signUpPanel.setVisible(false);
        loginPanel.setVisible(true);
    }

    // 파일을 json 으로부터 불러옵니다.
    private void loadFromJson() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            // JSON 데이터를 읽어오는 Map 타입
            java.lang.reflect.Type type = new TypeToken<HashMap<String, Map<String, Object>>>() {}.getType();
            Map<String, Map<String, Object>> rawMap = gson.fromJson(reader, type);

            userMap = new HashMap<>();

            if (rawMap != null) {
                for (Map.Entry<String, Map<String, Object>> entry : rawMap.entrySet()) {
                    String key = entry.getKey();
                    Map<String, Object> userData = entry.getValue();

                    // 원본 그대로 userMap에 저장
                    HashMap<String, String> processedUserData = new HashMap<>();
                    for (Map.Entry<String, Object> userEntry : userData.entrySet()) {
                        processedUserData.put(userEntry.getKey(), userEntry.getValue().toString());  // 값 그대로 저장
                    }

                    userMap.put(key, processedUserData);
                }
            }

            System.out.println("JSON 파일에서 데이터가 로드되었습니다.");
            userMap.forEach((key, value) -> System.out.println("키: " + key + ", 값: " + value));
        } catch (FileNotFoundException e) {
            System.out.println("JSON 파일이 존재하지 않습니다. 새로 생성해야 합니다.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "데이터를 로드하는 중 오류가 발생했습니다.");
        }
    }

    // 배경 이미지를 설정합니다.
    private void setBackgroundImage() {
        try {
            String imageUrl = "test.jpeg";
            // 원본 이미지 로드
            // 원본 이미지 로드
            ImageIcon originalIcon = new ImageIcon(imageUrl);
            
            // 이미지의 크기 출력 (디버깅용)
            //System.out.println("Image width: " + originalIcon.getIconWidth());
            //System.out.println("Image height: " + originalIcon.getIconHeight());
            
            // 이미지를 라벨에 표시하고 크기 조정
            JLabel backgroundLabel = new JLabel(new ImageIcon(
                originalIcon.getImage().getScaledInstance(
                    mainImagePanel.getWidth(), 
                    mainImagePanel.getHeight(), 
                    Image.SCALE_SMOOTH)
            ));
            
            // 기존 컴포넌트 모두 제거
            mainImagePanel.removeAll();
            
            // BorderLayout으로 변경
            mainImagePanel.setLayout(new BorderLayout());
            
            // 라벨을 중앙에 추가
            mainImagePanel.add(backgroundLabel, BorderLayout.CENTER);
            
            // 패널 투명도 설정
            mainImagePanel.setOpaque(false);
            
            // 다시 그리기
            mainImagePanel.revalidate();
            mainImagePanel.repaint();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void customizeComponents() {
        userNumber.setColumns(6);
        userNumber1.setColumns(7);
    }

    // 파일을 json 에 저장합니다.
    private void saveToJson() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            // Save the entire userMap to JSON
            gsonForSignUp.toJson(userMapForSignUp, writer);
            System.out.println("데이터가 JSON 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("데이터를 저장하는 중 오류가 발생했습니다.");
        }
    }
    
    // JSON 파일에서 불러오기
    private void loadFromJsonForSignUp() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            // JSON을 HashMap<String, HashMap<String, Object>> 형식으로 읽어오기
            java.lang.reflect.Type type = new TypeToken<HashMap<String, HashMap<String, Object>>>() {}.getType();
            userMapForSignUp = gsonForSignUp.fromJson(reader, type);

            if (userMapForSignUp == null) {
                userMapForSignUp = new HashMap<>(); // 데이터가 없으면 새로운 HashMap 초기화
            }

            System.out.println("JSON 파일에서 데이터가 로드되었습니다.");
            userMapForSignUp.forEach((key, value) -> System.out.println("키: " + key + ", 값: " + value));
        } catch (FileNotFoundException e) {
            System.out.println("JSON 파일이 존재하지 않습니다. 새로 생성해야 합니다.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "데이터를 로드하는 중 오류가 발생했습니다.");
        }
    }
    private boolean isBackPartDuplicate(String backPart) {
        for (HashMap<String, Object> userData : userMapForSignUp.values()) {
            // 'number' 필드를 String으로 안전하게 캐스팅
            String existingBackPart = (String) userData.get("number"); // 주민번호 뒷자리
            if (existingBackPart != null && existingBackPart.equals(backPart)) {
                return true; // 중복 발견
            }
        }
        return false; // 중복 없음
    }

    // 사용자를 추가 합니다.
    private void addUser(String fullNumber, HashMap<String, Object> userData) {
        userMapForSignUp.put(fullNumber, userData);
        saveToJson(); // Save the updated userMap
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainImagePanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        loginTitleLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        loginIdLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JTextField();
        Signupbutton = new javax.swing.JButton();
        signUpPanel = new javax.swing.JPanel();
        userName = new javax.swing.JTextField();
        userNumber = new javax.swing.JTextField();
        Major = new javax.swing.JComboBox<>();
        Usertype = new javax.swing.JComboBox<>();
        Submit = new javax.swing.JButton();
        signUpNameLabel = new javax.swing.JLabel();
        signUpNumberLabel = new javax.swing.JLabel();
        signUpMajorLabel = new javax.swing.JLabel();
        signUpRoleLabel = new javax.swing.JLabel();
        signUpTitleLabel = new javax.swing.JLabel();
        userNumber1 = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        signUpExplainScrollPane = new javax.swing.JScrollPane();
        signUpExplain = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainImagePanelLayout = new javax.swing.GroupLayout(mainImagePanel);
        mainImagePanel.setLayout(mainImagePanelLayout);
        mainImagePanelLayout.setHorizontalGroup(
            mainImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        mainImagePanelLayout.setVerticalGroup(
            mainImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));

        loginTitleLabel.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        loginTitleLabel.setForeground(new java.awt.Color(73, 73, 73));
        loginTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginTitleLabel.setText("대학 정보 시스템");

        idField.setBackground(new java.awt.Color(255, 255, 255));
        idField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        loginIdLabel.setText("사용자 로그인");

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setText("로그인");
        loginButton.setToolTipText("");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passwordField.setBackground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Signupbutton.setBackground(new java.awt.Color(255, 255, 255));
        Signupbutton.setText("회원가입");
        Signupbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loginTitleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Signupbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(loginIdLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(loginTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(loginIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Signupbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        signUpPanel.setBackground(new java.awt.Color(255, 255, 255));

        userName.setBackground(new java.awt.Color(255, 255, 255));
        userName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        userNumber.setBackground(new java.awt.Color(255, 255, 255));
        userNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Major.setBackground(new java.awt.Color(255, 255, 255));
        Major.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "전산학과", "전자공학과", "기계공학과", "화학공학과", "항공우주공학과" }));

        Usertype.setBackground(new java.awt.Color(255, 255, 255));
        Usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "학생", "교수", "학사 담당자", "수업 담당자" }));

        Submit.setBackground(new java.awt.Color(255, 255, 255));
        Submit.setText("회원가입");
        Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        signUpNameLabel.setText("이름");

        signUpNumberLabel.setText("주민번호");

        signUpMajorLabel.setText("학과");

        signUpRoleLabel.setText("사용자 유형");

        signUpTitleLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        signUpTitleLabel.setForeground(new java.awt.Color(73, 73, 73));
        signUpTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpTitleLabel.setText("회원가입");
        signUpTitleLabel.setToolTipText("");

        userNumber1.setBackground(new java.awt.Color(255, 255, 255));
        userNumber1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setText("돌아가기");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        signUpExplain.setBackground(new java.awt.Color(255, 255, 255));
        signUpExplain.setColumns(20);
        signUpExplain.setForeground(new java.awt.Color(73, 73, 73));
        signUpExplain.setRows(5);
        signUpExplain.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        signUpExplain.setCaretColor(new java.awt.Color(73, 73, 73));
        signUpExplain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signUpExplain.setEnabled(false);
        signUpExplain.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                signUpExplainAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        signUpExplainScrollPane.setViewportView(signUpExplain);

        javax.swing.GroupLayout signUpPanelLayout = new javax.swing.GroupLayout(signUpPanel);
        signUpPanel.setLayout(signUpPanelLayout);
        signUpPanelLayout.setHorizontalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signUpTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signUpPanelLayout.createSequentialGroup()
                        .addComponent(userNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Major, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Usertype, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Submit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signUpPanelLayout.createSequentialGroup()
                        .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signUpNameLabel)
                            .addComponent(signUpNumberLabel)
                            .addComponent(signUpMajorLabel)
                            .addComponent(signUpRoleLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(signUpExplainScrollPane, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        signUpPanelLayout.setVerticalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signUpTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signUpExplainScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(signUpNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpMajorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Major, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpRoleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 582, Short.MAX_VALUE)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 310, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 582, Short.MAX_VALUE)
                    .addComponent(signUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainImagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(signUpPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed

        // 회원가입 버튼 클릭 시
        try {
            // 입력값 가져오기
            String name = userName.getText().trim();
            String numberPart1 = userNumber.getText().trim(); // 주민번호 앞자리
            String numberPart2 = userNumber1.getText().trim(); // 주민번호 뒷자리
            String major = Major.getSelectedItem().toString();
            String userType = Usertype.getSelectedItem().toString();

            // 필드 값이 비어 있으면 오류 메시지 출력
            if (name.isEmpty() || numberPart1.isEmpty() || numberPart2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 필드를 채워주세요!");
                return;
            }

            // 주민번호 형식 유지
            String fullNumber = numberPart1 + "-" + numberPart2; // 앞자리-뒷자리 형식

            // 중복 확인: 주민번호 뒷자리 중복 확인
            if (isBackPartDuplicate(numberPart2)) {
                JOptionPane.showMessageDialog(this, "이미 존재하는 주민번호 뒷자리입니다!");
                return;
            }

            // 사용자 유형에 따른 ID 생성
            String prefix = switch (userType) {
                case "학생" -> "S";
                case "교수" -> "P";
                case "학사 담당자" -> "H";
                case "수업 담당자" -> "G";
                default -> "E";
            };
            String uniqueId = prefix + "-" + String.format("%03d", (int) (Math.random() * 1000)); // ID 생성

            // 사용자 데이터 생성
            HashMap<String, Object> userData = new HashMap<>();
            userData.put("name", name);
            userData.put("major", major);
            userData.put("userType", userType);
            userData.put("userId", uniqueId);
            userData.put("number", numberPart2); // 주민번호 뒷자리 저장

            // 새로운 사용자 추가
            addUser(fullNumber, userData);

            // 전체 userMap을 JSON으로 저장
            saveToJson(); // 전체 userMap 저장

            // 성공 메시지 출력
            JOptionPane.showMessageDialog(this, "회원가입 완료! ID: " + uniqueId);
            
            // 파일 다시 불러오기
            loadFromJson();

            loginPanel.setVisible(true);
            signUpPanel.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "알 수 없는 오류가 발생했습니다.");
        }
    }//GEN-LAST:event_SubmitActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        loginPanel.setVisible(true);
        signUpPanel.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void signUpExplainAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_signUpExplainAncestorAdded
        signUpExplain.setText(" - 회원 가입시 ID는 회원가입 시 자동 생성 됩니다.\n - 첫 비밀번호는 주민번호 뒷자리 입니다.");
    }//GEN-LAST:event_signUpExplainAncestorAdded

    private void SignupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupbuttonActionPerformed
        loginPanel.setVisible(false);
        signUpPanel.setVisible(true);
    }//GEN-LAST:event_SignupbuttonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String idInput = idField.getText().trim(); // 사용자 ID
            String passwordInput = passwordField.getText().trim(); // 비밀번호

            if (idInput.isEmpty() || passwordInput.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력해주세요!");
                return;
            }

            // 로그인 검증
            HashMap<String, String> loggedInUser = null;

            // userMap을 순회하여 사용자가 입력한 아이디와 비밀번호 일치 여부 체크
            for (Map.Entry<String, HashMap<String, String>> entry : userMap.entrySet()) {
                HashMap<String, String> userData = entry.getValue();

                String userId = userData.get("userId").trim();  // userId에서 불필요한 공백 제거
                String userPassword = userData.get("number").trim();  // number에서 불필요한 공백 제거

                // 디버깅 출력을 추가하여 확인
                System.out.println("입력된 ID: " + idInput + ", 입력된 비밀번호: " + passwordInput);
                System.out.println("비교할 ID: " + userId + ", 비교할 비밀번호: " + userPassword);

                // 아이디(userId)와 비밀번호(number)가 일치하는지 비교
                if (userId != null && userPassword != null
                    && userId.equals(idInput)
                    && userPassword.equals(passwordInput)) {
                    loggedInUser = userData; // 로그인한 사용자 정보 저장
                    JOptionPane.showMessageDialog(this, "로그인 성공! " + userData.get("name") + "님 환영합니다.");
                    break;
                }
            }

            // 일치하는 사용자 정보가 없으면 로그인 실패 처리
            if (loggedInUser == null) {
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 일치하지 않습니다.");
                return;
            }

            // 사용자 유형에 따른 화면 이동
            String userType = loggedInUser.get("userType");

            if ("학생".equals(userType)) {
                StudentHome studentHomeScreen = new StudentHome(loggedInUser.get("name"), loggedInUser.get("userId"));
                // 기존 창 기준으로 좌측에 위치 설정
                studentHomeScreen.setLocation(this.getX() - studentHomeScreen.getWidth(), this.getY());
                studentHomeScreen.setVisible(true);
                this.setVisible(false);
            } else if ("교수".equals(userType)) {
                ProfessorHome professorScreen = new ProfessorHome(loggedInUser.get("name"), loggedInUser.get("userId"));
                // 기존 창 기준으로 좌측에 위치 설정
                professorScreen.setLocation(this.getX() - professorScreen.getWidth(), this.getY());
                professorScreen.setVisible(true);
                this.setVisible(false);
            } else if ("수업 담당자".equals(userType)) {
                CourseManagerHome courseManagerScreen = new CourseManagerHome(loggedInUser.get("name"), loggedInUser.get("userId"));
                // 기존 창 기준으로 좌측에 위치 설정
                courseManagerScreen.setLocation(this.getX() - courseManagerScreen.getWidth(), this.getY());
                courseManagerScreen.setVisible(true);
                this.setVisible(false);
            } else if ("학사 담당자".equals(userType)) {
                UserManagerHome userManagerScreen = new UserManagerHome(loggedInUser.get("name"), loggedInUser.get("userId"));
                // 기존 창 기준으로 좌측에 위치 설정
                userManagerScreen.setLocation(this.getX() - userManagerScreen.getWidth(), this.getY());
                userManagerScreen.setVisible(true);
                this.setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "로그인 처리 중 오류가 발생했습니다.");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Major;
    private javax.swing.JButton Signupbutton;
    private javax.swing.JButton Submit;
    private javax.swing.JComboBox<String> Usertype;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField idField;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginIdLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel loginTitleLabel;
    private javax.swing.JPanel mainImagePanel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextArea signUpExplain;
    private javax.swing.JScrollPane signUpExplainScrollPane;
    private javax.swing.JLabel signUpMajorLabel;
    private javax.swing.JLabel signUpNameLabel;
    private javax.swing.JLabel signUpNumberLabel;
    private javax.swing.JPanel signUpPanel;
    private javax.swing.JLabel signUpRoleLabel;
    private javax.swing.JLabel signUpTitleLabel;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userNumber;
    private javax.swing.JTextField userNumber1;
    // End of variables declaration//GEN-END:variables
}
