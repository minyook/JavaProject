/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.manager.course;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import org.json.JSONObject;
import schoolSystemManagement.Management;
import schoolSystemManagement.common.SelfUserEdit;
import schoolSystemManagement.dto.CourseData;
import schoolSystemManagement.file.JsonFile;


public class CourseManagerHome extends javax.swing.JFrame {

    // 테스트를 위한 초기화 값 입니다.
    public String courseManagerName = "김영진";
    public String courseManagerId = "S-695";

    // 전체적으로 사용하기 위해 파일을 불러오는 부분입니다.
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    /**
     * 기본 생성자
     */
    public CourseManagerHome() {
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("수업 담당자 메뉴");
    }

    /**
     * 부모 프레임으로부터 이름과 아이디 값을 전달 받아 사용합니다.
     *
     * @param courseManagerName 관리자 이름
     * @param courseManagerId 관리자 아이디
     */
    public CourseManagerHome(String courseManagerName, String courseManagerId) {
        this.courseManagerName = courseManagerName;
        this.courseManagerId = courseManagerId;
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("수업 담당자 메뉴");
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
        courseManagementButton = new javax.swing.JButton();
        editProfileButton = new javax.swing.JButton();
        majorTextField = new javax.swing.JTextField();
        majorLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        openCoursesLabel = new javax.swing.JLabel();
        openCoursesScrollPane = new javax.swing.JScrollPane();
        openCoursesList = new javax.swing.JList<>();
        titleLabel = new javax.swing.JLabel();
        chargeTuitionFeeButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        courseManagementButton.setBackground(new java.awt.Color(255, 255, 255));
        courseManagementButton.setText("강의 관리");
        courseManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseManagementButtonActionPerformed(evt);
            }
        });

        editProfileButton.setBackground(new java.awt.Color(255, 255, 255));
        editProfileButton.setText("내 정보 수정");
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        majorTextField.setEditable(false);
        majorTextField.setBackground(new java.awt.Color(255, 255, 255));
        majorTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        majorTextField.setText("수업 담당자");
        majorTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        majorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        majorLabel.setText("직책");

        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idLabel.setText("아이디");

        idTextField.setEditable(false);
        idTextField.setBackground(new java.awt.Color(255, 255, 255));
        idTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        idTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                idTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameLabel.setText("이름");

        nameTextField.setEditable(false);
        nameTextField.setBackground(new java.awt.Color(255, 255, 255));
        nameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        nameTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                nameTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        openCoursesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        openCoursesLabel.setText("개설 된 모든 강의");

        openCoursesList.setBackground(new java.awt.Color(255, 255, 255));
        openCoursesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        openCoursesList.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                openCoursesListAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        openCoursesScrollPane.setViewportView(openCoursesList);

        titleLabel.setFont(new java.awt.Font("HY견고딕", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("수업 담당자 메뉴");
        titleLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        chargeTuitionFeeButton.setBackground(new java.awt.Color(255, 255, 255));
        chargeTuitionFeeButton.setText("청구 관리");
        chargeTuitionFeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeTuitionFeeButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshButton.setText("새로고침");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("로그아웃");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openCoursesLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openCoursesScrollPane)
                    .addComponent(majorTextField)
                    .addComponent(editProfileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(majorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idTextField)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameTextField)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(chargeTuitionFeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(majorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(majorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openCoursesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(openCoursesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseManagementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chargeTuitionFeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        // 내 정보 수정 버튼을 눌렀을 때 이벤트
        SelfUserEdit selfUserEditManagementScreen = new SelfUserEdit(courseManagerName, courseManagerId);

        // 기존 창 기준으로 우측에 위치 설정
        selfUserEditManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        selfUserEditManagementScreen.setVisible(true);
    }//GEN-LAST:event_editProfileButtonActionPerformed

    private void nameTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_nameTextFieldAncestorAdded
        // 이름 불러오기
        nameTextField.setText(courseManagerName);
    }//GEN-LAST:event_nameTextFieldAncestorAdded

    private void idTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_idTextFieldAncestorAdded
        // 아이디 불러오기
        idTextField.setText(courseManagerId);
    }//GEN-LAST:event_idTextFieldAncestorAdded

    private void openCoursesListAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_openCoursesListAncestorAdded
        // 본인에 대한 개설 된 강의 목록 가져오기
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");

        ArrayList<CourseData> courseDataList = new ArrayList<>();

        // 반복하여 필터링된 객체의 특정 속성을 출력
        for (String key : filteredObjects.keySet()) {
            JSONObject course = filteredObjects.getJSONObject(key);

            // 원하는 속성 출력
            String name = course.optString("name", "N/A");
            int maxStudents = course.optInt("maxStudents", 0);
            String professor = course.optString("professor", "N/A");
            int unit = course.optInt("unit", 0);
            String userId = course.optString("userId", "N/A");

            // 결과를 DTO 객체로 만들어 ArrayList에 저장
            CourseData courseDTO = new CourseData(name, professor, maxStudents, unit, userId);
            courseDataList.add(courseDTO);
        }

        // JList에 데이터를 설정하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (CourseData value : courseDataList) {
            listModel.addElement(value.getName());
        }

        // JList에 모델 설정
        openCoursesList.setModel(listModel);

        // 읽기 전용으로 설정
        openCoursesList.setEnabled(false);  // 입력 불가
    }//GEN-LAST:event_openCoursesListAncestorAdded

    private void chargeTuitionFeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeTuitionFeeButtonActionPerformed
        // 수업료 청구 버튼 이벤트
        ChargeTuitionFeeSystemForManager chargeTuitionFeeManagementScreen = new ChargeTuitionFeeSystemForManager(courseManagerName, courseManagerId);

        // 기존 창 기준으로 우측에 위치 설정
        chargeTuitionFeeManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        chargeTuitionFeeManagementScreen.setVisible(true);
    }//GEN-LAST:event_chargeTuitionFeeButtonActionPerformed

    private void courseManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseManagementButtonActionPerformed
        // 강의 관리 버튼 클릭시
        CourseManagerSystemForManager courseManagerSystemManagementScreen = new CourseManagerSystemForManager();

        // 기존 창 기준으로 우측에 위치 설정
        courseManagerSystemManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        courseManagerSystemManagementScreen.setVisible(true);
    }//GEN-LAST:event_courseManagementButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

        // 본인에 대한 개설 된 강의 목록 가져오기
        coursesFile = new JsonFile("course_data.json", "course_data.json");
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");

        ArrayList<CourseData> courseDataList = new ArrayList<>();

        // 반복하여 필터링된 객체의 특정 속성을 출력
        for (String key : filteredObjects.keySet()) {
            JSONObject course = filteredObjects.getJSONObject(key);

            // 원하는 속성 출력
            String name = course.optString("name", "N/A");
            int maxStudents = course.optInt("maxStudents", 0);
            String professor = course.optString("professor", "N/A");
            int unit = course.optInt("unit", 0);
            String userId = course.optString("userId", "N/A");

            // 결과를 DTO 객체로 만들어 ArrayList에 저장
            CourseData courseDTO = new CourseData(name, professor, maxStudents, unit, userId);
            courseDataList.add(courseDTO);
        }

        // JList에 데이터를 설정하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (CourseData value : courseDataList) {
            listModel.addElement(value.getName());
        }

        // JList에 모델 설정
        openCoursesList.setModel(listModel);

        // 읽기 전용으로 설정
        openCoursesList.setEnabled(false);  // 입력 불가
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // 로그아웃 버튼 클릭 시

        // 로그아웃 확인 메시지 표시
        int response = JOptionPane.showConfirmDialog(null, "정말로 로그아웃 하시겠습니까?", "로그아웃 확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // "예"를 선택했을 경우, 현재 창을 종료
            Window[] windows = Window.getWindows(); // 현재 열린 모든 창을 가져옴
            for (Window window : windows) {
                window.dispose(); // 모든 창을 닫음
            }

            // 새로운 창을 표시
            Management management = new Management(); // Management 객체 생성
            management.setVisible(true); // Management 창을 보이도록 설정
        } else {
            // "아니오"를 선택했을 경우, 로그아웃을 취소하고 아무 작업도 하지 않음
            JOptionPane.showMessageDialog(null, "로그아웃이 취소되었습니다.", "취소", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_logoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CourseManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseManagerHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chargeTuitionFeeButton;
    private javax.swing.JButton courseManagementButton;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JTextField majorTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel openCoursesLabel;
    private javax.swing.JList<String> openCoursesList;
    private javax.swing.JScrollPane openCoursesScrollPane;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
