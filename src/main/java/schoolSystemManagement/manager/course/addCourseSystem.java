/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.manager.course;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import schoolSystemManagement.dto.CourseData;
import schoolSystemManagement.dto.UserData;
import schoolSystemManagement.file.JsonFile;

/**
 *
 * @author admin
 */
public class addCourseSystem extends javax.swing.JFrame {
    
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    /**
     * Creates new form addCourseSystem
     */
    public addCourseSystem() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(630,635);
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("강의 추가");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseDiscriptionFrame = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        courseMaxStudentsFrame = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        courseCountStudentsFrame = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        courseStatusFrame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        courseProfessorIdFrame = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        courseUnitFrame = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        courseNameFrame = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        courseProfessorFrame = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        courseDiscriptionFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseDiscriptionFrame.setColumns(20);
        courseDiscriptionFrame.setRows(5);
        courseDiscriptionFrame.setText("강의에 대한 설명을 작성해 주세요.");
        jScrollPane1.setViewportView(courseDiscriptionFrame);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("추가");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("강의 설명");

        courseMaxStudentsFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseMaxStudentsFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        courseMaxStudentsFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseMaxStudentsFrameActionPerformed(evt);
            }
        });

        jLabel2.setText("최대 수강생 수");

        courseCountStudentsFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseCountStudentsFrame.setText("0");
        courseCountStudentsFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        courseCountStudentsFrame.setEnabled(false);

        jLabel6.setText("현재 수강생 수");

        courseStatusFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseStatusFrame.setText("false");
        courseStatusFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        courseStatusFrame.setEnabled(false);
        courseStatusFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseStatusFrameActionPerformed(evt);
            }
        });

        jLabel7.setText("개설 여부");

        courseProfessorIdFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseProfessorIdFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        courseProfessorIdFrame.setEnabled(false);
        courseProfessorIdFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseProfessorIdFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel8.setText("담당 교수 아이디");

        jLabel9.setText("담당 교수");

        courseUnitFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseUnitFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        courseUnitFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseUnitFrameActionPerformed(evt);
            }
        });

        jLabel10.setText("학점");

        courseNameFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseNameFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setText("강의 이름");

        jLabel3.setFont(new java.awt.Font("HY견고딕", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("강의 추가");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        courseProfessorFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseProfessorFrame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        courseProfessorFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseProfessorFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        courseProfessorFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseProfessorFrameActionPerformed(evt);
            }
        });
        courseProfessorFrame.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                courseProfessorFramePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseNameFrame)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(175, 175, 175))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(courseCountStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseMaxStudentsFrame))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(courseProfessorIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseStatusFrame))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(courseProfessorFrame, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(courseUnitFrame))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseNameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(courseUnitFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(courseProfessorFrame))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseProfessorIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseStatusFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(courseCountStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(courseMaxStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void courseMaxStudentsFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseMaxStudentsFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseMaxStudentsFrameActionPerformed

    private void courseStatusFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseStatusFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseStatusFrameActionPerformed

    private void courseUnitFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseUnitFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseUnitFrameActionPerformed

    private void courseProfessorFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseProfessorFrameAncestorAdded
        // 사용자 리스트에서 교수 목록을 가져온다.
        JSONObject filteredObjects = usersFile.getAllObjectsByKeyValue("userType", "교수");

        // filteredObjects가 비어 있지 않으면 처리
        if (filteredObjects != null && !filteredObjects.isEmpty()) {
            ArrayList<UserData> userDataList = new ArrayList<>();

            // 반복하여 필터링된 객체의 특정 속성을 출력
            for (String key : filteredObjects.keySet()) {
                JSONObject user = filteredObjects.getJSONObject(key);

                // 원하는 속성 추출
                String name = user.optString("name", "N/A");
                String userId = user.optString("userId", "N/A");
                String userType = user.optString("userType", "N/A");

                // 결과를 DTO 객체로 만들어 ArrayList에 저장
                UserData userDTO = new UserData(name, userId, userType);
                userDataList.add(userDTO);
            }

            // JComboBox에 데이터를 설정하기 위한 DefaultComboBoxModel 생성
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

            // 필터링된 데이터 추가
            for (UserData value : userDataList) {
                // "이름 - 사용자 ID" 형식으로 데이터를 추가
                comboBoxModel.addElement(value.getName() + " (" + value.getUserId()+ ")");
            }

            // JComboBox에 모델 설정
            courseProfessorFrame.setModel(comboBoxModel);
        } else {
            // 필터링된 객체가 비어 있을 경우 JComboBox에 아무것도 추가하지 않음
            // 공백 상태로 유지
            DefaultComboBoxModel<String> emptyModel = new DefaultComboBoxModel<>();
            courseProfessorFrame.setModel(emptyModel);
        }
    }//GEN-LAST:event_courseProfessorFrameAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // 추가 버튼을 누르면 파일이 추가된다.
        // 파일 갱신
        coursesFile = new JsonFile("course_data.json", "course_data.json");
        
        String courseName = courseNameFrame.getText();
        System.out.println(courseName);
        
        // 강의명이 비어있는지 확인
        if (courseName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "강의명을 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }

        // 사용자 리스트에서 개설된 강의 목록을 가져온다.
        JSONObject filteredTrueObjects = coursesFile.getAllObjectsByKeyValue("status", "true");
        JSONObject filteredFalseObjects = coursesFile.getAllObjectsByKeyValue("status", "false");

        // 비어있으면 빈 리스트로 초기화
        if (filteredTrueObjects == null || filteredTrueObjects.isEmpty()) {
            System.out.println("리스트 초기화1");
            filteredTrueObjects = new JSONObject(); // 빈 JSONObject로 초기화
        }

        if (filteredFalseObjects == null || filteredFalseObjects.isEmpty()) {
            System.out.println("리스트 초기화2");
            filteredFalseObjects = new JSONObject(); // 빈 JSONObject로 초기화
        }

        ArrayList<CourseData> courseDataList = new ArrayList<>();

        // 개설된 강의 목록에서 name 속성 추출하여 CourseData 객체로 추가
        for (String key : filteredTrueObjects.keySet()) {
            JSONObject user = filteredTrueObjects.getJSONObject(key);

            // 원하는 속성 추출
            String name = user.optString("name", "N/A");
            
            System.out.println(name);

            // CourseData 객체로 만들어 ArrayList에 저장
            CourseData courseDTO = new CourseData(name);
            courseDataList.add(courseDTO);
        }

        // 개설되지 않은 강의 목록에서 name 속성 추출하여 CourseData 객체로 추가
        for (String key : filteredFalseObjects.keySet()) {
            JSONObject user = filteredFalseObjects.getJSONObject(key);

            // 원하는 속성 추출
            String name = user.optString("name", "N/A");

            // CourseData 객체로 만들어 ArrayList에 저장
            CourseData courseDTO = new CourseData(name);
            courseDataList.add(courseDTO);
        }

        // 필터링된 객체가 비어있지 않다면 강의명 중복 체크
        if (!courseDataList.isEmpty()) {
            
            for (CourseData value : courseDataList) {
                if (value.getName().equals(courseName)) {
                    JOptionPane.showMessageDialog(null, "이미 존재하는 강의명입니다.", "알림", JOptionPane.WARNING_MESSAGE);
                    return; // 작업 취소
                }
            }
        }

        // 교수 이름과 ID를 분리해서 이름만 저장
        String courseProfessor = courseProfessorFrame.getSelectedItem().toString();
        if (courseProfessor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "교수명을 선택해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }

        if (courseProfessor.contains(" (") && courseProfessor.contains(")")) {
            // "이름 (사용자ID)" 형식에서 이름과 사용자ID로 분리
            String[] parts = courseProfessor.split(" \\(");
            if (parts.length == 2) {
                courseProfessor = parts[0].trim(); // 이름만 저장
            }
        } else {
            // 형식이 잘못된 경우 처리
            JOptionPane.showMessageDialog(null, "잘못된 교수명 형식입니다.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }

        String courseProfessorId = courseProfessorIdFrame.getText();
        if (courseProfessorId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "담당 교수를 선택해 주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }

        String courseStatus = courseStatusFrame.getText();

        String courseUnitStr = courseUnitFrame.getText();
        if (courseUnitStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "학점을 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }
        int courseUnit = 0;
        try {
            courseUnit = Integer.parseInt(courseUnitStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "학점은 숫자로 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }

        String courseCountStudentsStr = courseCountStudentsFrame.getText();
        

        String courseMaxStudentsStr = courseMaxStudentsFrame.getText();
        if (courseMaxStudentsStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "최대 학생 수를 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }
        int courseMaxStudents = 0;
        try {
            courseMaxStudents = Integer.parseInt(courseMaxStudentsStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "최대 학생 수는 숫자로 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }
        
        String courseDiscription = courseDiscriptionFrame.getText();
        if (courseDiscription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "강의에 대한 설명을 작성해 주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            return; // 작업 취소
        }
        
        // 확인 대화 상자 띄우기
        int confirm = JOptionPane.showConfirmDialog(
            null, 
            "정말로 강의를 추가하시겠습니까?",  // 메시지
            "확인",  // 제목
            JOptionPane.YES_NO_OPTION,  // 옵션 (확인 / 취소)
            JOptionPane.QUESTION_MESSAGE  // 아이콘 (질문 아이콘)
        );

        // "확인"을 눌렀을 때
        if (confirm == JOptionPane.YES_OPTION) {
            // 강의 추가 메서드 호출
            coursesFile.updateCourse(courseName, courseProfessor, courseProfessorId, courseUnitStr, courseStatus, courseCountStudentsStr, courseMaxStudentsStr, courseDiscription);
            JOptionPane.showMessageDialog(null, "강의가 성공적으로 추가되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
            
            // 현재 창 닫기
            dispose();
        }
        // "취소"를 눌렀을 때
        else if (confirm == JOptionPane.NO_OPTION) {
            // 취소된 경우 아무런 처리 없음
            JOptionPane.showMessageDialog(null, "강의 추가가 취소되었습니다.", "취소", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void courseProfessorFramePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_courseProfessorFramePropertyChange
        
    }//GEN-LAST:event_courseProfessorFramePropertyChange

    private void courseProfessorIdFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseProfessorIdFrameAncestorAdded
        
    }//GEN-LAST:event_courseProfessorIdFrameAncestorAdded

    private void courseProfessorFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseProfessorFrameActionPerformed
        // JComboBox에서 선택된 항목 가져오기
        String selectedItem = courseProfessorFrame.getSelectedItem().toString();

        // 선택된 항목이 예상된 형식인지 확인
        if (selectedItem.contains(" (") && selectedItem.contains(")")) {
            // 선택된 항목을 "이름 (사용자ID)" 형식에서 이름과 사용자ID로 분리
            String[] parts = selectedItem.split(" \\(");  // "( "으로 분리

            if (parts.length == 2) {
                String userName = parts[0].trim();  // 이름
                String userId = parts[1].replace(")", "").trim();  // 사용자ID (뒤의 ")" 제거)

                // 결과 출력
                System.out.println("이름: " + userName + ", 사용자 ID: " + userId);
                courseProfessorIdFrame.setText(userId);
            } else {
                // 형식이 예상과 다를 경우 오류 처리
                System.out.println("잘못된 형식의 항목이 선택되었습니다.");
            }
        } else {
            // 예상된 형식이 아닌 경우 오류 처리
            System.out.println("선택된 항목이 잘못된 형식입니다.");
        }
    }//GEN-LAST:event_courseProfessorFrameActionPerformed

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
            java.util.logging.Logger.getLogger(addCourseSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCourseSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCourseSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCourseSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCourseSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField courseCountStudentsFrame;
    private javax.swing.JTextArea courseDiscriptionFrame;
    private javax.swing.JTextField courseMaxStudentsFrame;
    private javax.swing.JTextField courseNameFrame;
    private javax.swing.JComboBox<String> courseProfessorFrame;
    private javax.swing.JTextField courseProfessorIdFrame;
    private javax.swing.JTextField courseStatusFrame;
    private javax.swing.JTextField courseUnitFrame;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}