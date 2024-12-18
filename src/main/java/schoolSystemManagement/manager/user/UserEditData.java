/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.manager.user;

import org.json.JSONObject;
import schoolSystemManagement.dto.UserData;
import schoolSystemManagement.file.JsonFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class UserEditData extends javax.swing.JFrame {

    // 전체적으로 사용하기 위해 파일을 불러오는 부분입니다.
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    // 파일 내용을 업데이트 하기 위한 메서드 입니다.
    public void updateJsonFile(){
        // 파일 내용 업데이트
        usersFile = new JsonFile("user_data.json", "user_data.json");
    }

    // 프레임 내의 테이블을 갱신 하는 메서드 입니다.
    public void updateTable(){
        // 데이터를 가져와서 테이블에 삽입하는 부분입니다.

        JSONObject filteredObjects = usersFile.getJsonObject(); // 이미 정의된 JSON 데이터 객체

        ArrayList<UserData> usersDataList = new ArrayList<>();

        // JSON 데이터를 파싱하여 DTO 객체로 변환
        for (String key : filteredObjects.keySet()) {
                JSONObject user = filteredObjects.getJSONObject(key);

                // 속성 추출
                String name = user.optString("name", "N/A");
                String userId = user.optString("userId", "N/A");
                String number = user.optString("number", "N/A");
                String major = user.optString("major", "N/A");
                String userType = user.optString("userType", "N/A");
                String studentNumber = key;

                // DTO 객체로 저장
                UserData usersDTO = new UserData(name, userId, number, major, userType, studentNumber);
                usersDataList.add(usersDTO);
            }

            // JTable 테이블 모델 생성
            String[] columnNames = {"이름", "아이디", "비밀먼호", "전공", "직책", "학번"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // 데이터를 테이블 모델에 추가
            for (UserData user : usersDataList) {
                Object[] rowData = {
                    user.getName(),
                    user.getUserId(),
                    user.getNumber(),
                    user.getMajor(),
                    user.getUserType(),
                    user.getStudentNumber()
                };
                tableModel.addRow(rowData);
            }

            // jTable1에 모델 설정
            userDataListFrame.setModel(tableModel);
    }

    /**
     * 기본 생성자 입니다.
     */
    public UserEditData() {
        initComponents();
        setTitle("사용자 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        userDataScrollPane = new javax.swing.JScrollPane();
        userDataListFrame = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        majorLabel = new javax.swing.JLabel();
        userNumber = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        userNumberPassword = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        searchFrame = new javax.swing.JTextField();
        userType = new javax.swing.JComboBox<>();
        userMajor = new javax.swing.JComboBox<>();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        userDataListFrame.setBackground(new java.awt.Color(255, 255, 255));
        userDataListFrame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userDataListFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userDataListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userDataListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        userDataListFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userDataListFrameMouseClicked(evt);
            }
        });
        userDataScrollPane.setViewportView(userDataListFrame);

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setText("수정하기");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("사용자 관리 시스템");

        roleLabel.setText("직책");

        majorLabel.setText("학과");

        userNumber.setBackground(new java.awt.Color(255, 255, 255));

        passwordLabel.setText("비밀번호");

        idLabel.setText("아이디");

        userId.setEditable(false);
        userId.setBackground(new java.awt.Color(255, 255, 255));
        userId.setEnabled(false);

        userName.setEditable(false);
        userName.setBackground(new java.awt.Color(255, 255, 255));
        userName.setEnabled(false);

        nameLabel.setText("이름");

        numberLabel.setText("학번");

        userNumberPassword.setEditable(false);
        userNumberPassword.setBackground(new java.awt.Color(255, 255, 255));
        userNumberPassword.setEnabled(false);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setEnabled(false);

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setText("검색");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        searchFrame.setBackground(new java.awt.Color(255, 255, 255));

        userType.setBackground(new java.awt.Color(255, 255, 255));
        userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userType.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userTypeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        userMajor.setBackground(new java.awt.Color(255, 255, 255));
        userMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userMajor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userMajorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("삭제하기");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(userDataScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(searchFrame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNumberPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(userNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(userId, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jTextField8)
                    .addComponent(userType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleLabel)
                            .addComponent(majorLabel)
                            .addComponent(numberLabel)
                            .addComponent(nameLabel)
                            .addComponent(passwordLabel)
                            .addComponent(idLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchFrame, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNumberPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(majorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(userDataScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userDataListFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userDataListFrameAncestorAdded
        // 데이터를 가져와서 테이블에 삽입하는 부분입니다.
        JSONObject filteredObjects = usersFile.getJsonObject(); // 이미 정의된 JSON 데이터 객체

        ArrayList<UserData> usersDataList = new ArrayList<>();

        // JSON 데이터를 파싱하여 DTO 객체로 변환
        for (String key : filteredObjects.keySet()) {
                JSONObject user = filteredObjects.getJSONObject(key);

                // 속성 추출
                String name = user.optString("name", "N/A");
                String userId = user.optString("userId", "N/A");
                String number = user.optString("number", "N/A");
                String major = user.optString("major", "N/A");
                String userType = user.optString("userType", "N/A");
                String studentNumber = key;

                // DTO 객체로 저장
                UserData usersDTO = new UserData(name, userId, number, major, userType, studentNumber);
                usersDataList.add(usersDTO);
            }

            // JTable 테이블 모델 생성
            String[] columnNames = {"이름", "아이디", "비밀먼호", "전공", "직책", "학번"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // 데이터를 테이블 모델에 추가
            for (UserData user : usersDataList) {
                Object[] rowData = {
                    user.getName(),
                    user.getUserId(),
                    user.getNumber(),
                    user.getMajor(),
                    user.getUserType(),
                    user.getStudentNumber()
                };
                tableModel.addRow(rowData);
            }

            // jTable1에 모델 설정
            userDataListFrame.setModel(tableModel);
    }//GEN-LAST:event_userDataListFrameAncestorAdded

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // 검색 버튼에 대한 이벤트
        // 1. JSON 데이터를 파싱하여 DTO 객체로 변환
        JSONObject filteredObjects = usersFile.getJsonObject(); // 이미 정의된 JSON 데이터 객체
        ArrayList<UserData> usersDataList = new ArrayList<>();

        for (String key : filteredObjects.keySet()) {
            JSONObject user = filteredObjects.getJSONObject(key);

            // 속성 추출
            String name = user.optString("name", "N/A");
            String userId = user.optString("userId", "N/A");
            String number = user.optString("number", "N/A");
            String major = user.optString("major", "N/A");
            String userType = user.optString("userType", "N/A");
            String studentNumber = key;

            // DTO 객체로 저장
            UserData usersDTO = new UserData(name, userId, number, major, userType, studentNumber);
            usersDataList.add(usersDTO);
        }

        // 2. 검색 버튼에 대한 이벤트 처리
        String searchText = searchFrame.getText().trim().toLowerCase(); // 검색어를 소문자로 변환
        DefaultTableModel model = (DefaultTableModel) userDataListFrame.getModel();
        model.setRowCount(0); // 기존 테이블 데이터를 초기화

        // 3. 필터링된 데이터 추가
        for (UserData user : usersDataList) {
            // 검색 조건: 이름, 아이디, 학번 등에서 검색어 포함 여부 확인
            if (user.getName().toLowerCase().contains(searchText) ||
                    user.getUserId().toLowerCase().contains(searchText) ||
                    user.getStudentNumber().toLowerCase().contains(searchText) ||
                    user.getMajor().toLowerCase().contains(searchText) ||
                    user.getUserType().toLowerCase().contains(searchText)) {

                // 조건에 맞는 데이터를 테이블에 추가
                Object[] rowData = {
                        user.getName(),
                        user.getUserId(),
                        user.getNumber(),
                        user.getMajor(),
                        user.getUserType(),
                        user.getStudentNumber()
                };
                model.addRow(rowData);
            }
        }

        // 4. 검색 결과가 없는 경우 처리
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_searchActionPerformed

    private void userDataListFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userDataListFrameMouseClicked
        int selectedRow = userDataListFrame.getSelectedRow(); // 선택된 행의 인덱스 가져오기
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) userDataListFrame.getModel();

            String name = (String) model.getValueAt(selectedRow, 0);
            String userIdValue = (String) model.getValueAt(selectedRow, 1);
            String number = (String) model.getValueAt(selectedRow, 2);
            String major = (String) model.getValueAt(selectedRow, 3);
            String userTypeValue = (String) model.getValueAt(selectedRow, 4);
            String userNumberPwd = (String) model.getValueAt(selectedRow, 5);

            userName.setText(name);
            userId.setText(userIdValue);
            userMajor.setSelectedItem(major);
            userNumber.setText(number);
            userType.setSelectedItem(userTypeValue);
            userNumberPassword.setText(userNumberPwd);
        }
    }//GEN-LAST:event_userDataListFrameMouseClicked

    private void userMajorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userMajorAncestorAdded
       // 기존 항목 제거
       userMajor.removeAllItems();

        // 콤보박스 항목 추가
        String[] majors = {"","전산학과", "전자공학과", "기계공학과", "화학공학과", "항공우주공학과"};
        for (String major : majors) {
            userMajor.addItem(major);
        }
    }//GEN-LAST:event_userMajorAncestorAdded

    private void userTypeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userTypeAncestorAdded
        // 기존 항목 제거
        userType.removeAllItems();
    
        // 새로운 항목 추가
        String[] majors = {"","학생", "교수", "기계공학과", "학사 당담자", "수업 당담자"};
        for (String major : majors) {
            userType.addItem(major);
        }
    }//GEN-LAST:event_userTypeAncestorAdded

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        
       // 사용자 입력 값 가져오기
        String major = (String) userMajor.getSelectedItem(); // 전공 콤보박스에서 선택한 값
        String type = (String) userType.getSelectedItem();   // 직책 콤보박스에서 선택한 값
        String name = userName.getText().trim();             // 이름 텍스트 필드 값
        String id = userId.getText().trim();                 // 아이디 텍스트 필드 값
        String password = userNumber.getText().trim(); // 비밀번호 텍스트 필드 값

        // 필수 입력 값 확인
        if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "필수 입력 항목이 비어 있습니다. 사용자 목록에서 사용자를 선택해 주세요.", 
                                          "경고", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }

        // 각 항목 수정 여부 플래그
        boolean isPasswordUpdated = false;
        boolean isMajorUpdated = false;
        boolean isTypeUpdated = false;

        // 비밀번호 수정
        if (!usersFile.getUserValueByStandardKey("userId", id, "number").toString().equals(password)) {
            usersFile.addKeyAndValue("userId", id, "number", password);
            isPasswordUpdated = true;
        }

        // 전공 수정
        if (!usersFile.getUserValueByStandardKey("userId", id, "major").toString().equals(major)) {
            usersFile.addKeyAndValue("userId", id, "major", major);
            isMajorUpdated = true;
        }

        // 직책 수정
        if (!usersFile.getUserValueByStandardKey("userId", id, "userType").toString().equals(type)) {
            usersFile.addKeyAndValue("userId", id, "userType", type);
            isTypeUpdated = true;
        }

        // 수정 결과 메시지 생성
        StringBuilder updateMessage = new StringBuilder();
        if (isPasswordUpdated) {
            updateMessage.append("비밀번호");
        }
        if (isMajorUpdated) {
            if (updateMessage.length() > 0) updateMessage.append(", "); // 이전에 수정된 항목이 있다면 구분자 추가
            updateMessage.append("전공");
        }
        if (isTypeUpdated) {
            if (updateMessage.length() > 0) updateMessage.append(", ");
            updateMessage.append("직책");
        }

        // 최종 메시지 출력
        if (updateMessage.length() > 0) {
            JOptionPane.showMessageDialog(null, updateMessage + "이(가) 성공적으로 변경되었습니다.", 
                                          "완료", JOptionPane.INFORMATION_MESSAGE);
            updateJsonFile();
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "변경된 항목이 없습니다.", 
                                          "알림", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
                                                     
        // 아이디 값 가져오기
        String id = userId.getText().trim(); // 아이디 텍스트 필드 값
        System.out.println(id);

        // 유효성 검사: 빈 값이면 경고 메시지 출력
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "삭제할 유저의 아이디를 입력하세요. 사용자 목록에서 사용자를 선택해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 유저 삭제
        String result = usersFile.deleteJsonObject("userId", id);

        // 결과 처리
        if (result == null) {
            // 삭제 대상이 없는 경우
            JOptionPane.showMessageDialog(null, "삭제 대상이 존재하지 않습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // 삭제 성공 시 JSON 파일 및 테이블 업데이트
            JOptionPane.showMessageDialog(null, "유저가 성공적으로 삭제되었습니다.", "완료", JOptionPane.INFORMATION_MESSAGE);
            updateJsonFile(); // JSON 파일 업데이트
        }

        // 테이블 새로고침
        updateTable();

    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserEditData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEditData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEditData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEditData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEditData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchFrame;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTable userDataListFrame;
    private javax.swing.JScrollPane userDataScrollPane;
    private javax.swing.JTextField userId;
    private javax.swing.JComboBox<String> userMajor;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userNumber;
    private javax.swing.JTextField userNumberPassword;
    private javax.swing.JComboBox<String> userType;
    // End of variables declaration//GEN-END:variables
}
