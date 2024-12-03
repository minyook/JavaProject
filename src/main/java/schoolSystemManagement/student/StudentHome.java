/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.student;

import javax.swing.DefaultListModel;
import javax.swing.event.AncestorEvent;

import schoolSystemManagement.common.SelfUserEdit;
import schoolSystemManagement.file.JsonFile;


public class StudentHome extends javax.swing.JFrame {

    // 테스트를 위한 기본 값 설정
    public String studentName = "김영진";
    public String studentId = "S-695";

    // 전체적으로 사용하기 위해 파일을 불러오는 부분입니다.
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    // 수강 신청 한 목록을 업데이트 하기 위한 메서드 입니다.
    public void updateCoursesListFrame(){
        // 수강신청 한 목록
        // 특정 조건에 따라 JSON 배열 값 가져오기
        usersFile = new JsonFile("user_data.json", "user_data.json");
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "course");

        // JList에 데이터를 설정하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Object value : courseValues) {
            System.out.println(value.toString());
            listModel.addElement(value.toString());
        }

        // JList에 모델 설정
        studentCoursesListFrame.setModel(listModel);

        // 읽기 전용
        studentCoursesListFrame.setEnabled(false);
    }
    /**
     * 기본 생성자 입니다.
     */
    public StudentHome() {
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("학생 메뉴");
    }

    /**
     * 부모 프레임으로 부터 이름과 아이디를 전달받아 사용하는 생성자 입니다.
     *
     * @param studentName
     * @param studentId
     */
    public StudentHome(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("학생 메뉴");
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
        studentCourseManagementButton = new javax.swing.JButton();
        studentEditProfile = new javax.swing.JButton();
        studentMajorFrame = new javax.swing.JTextField();
        studentMajorLabel = new javax.swing.JLabel();
        studentIdLabel = new javax.swing.JLabel();
        studentIdFrame = new javax.swing.JTextField();
        studentNameLabel = new javax.swing.JLabel();
        studentNameFrame = new javax.swing.JTextField();
        subCoursesLabel = new javax.swing.JLabel();
        studentCoursesScroolPane = new javax.swing.JScrollPane();
        studentCoursesListFrame = new javax.swing.JList<>();
        titleLabel = new javax.swing.JLabel();
        reloadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        studentCourseManagementButton.setBackground(new java.awt.Color(255, 255, 255));
        studentCourseManagementButton.setText("내 수강 관리");
        studentCourseManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCourseManagementButtonActionPerformed(evt);
            }
        });

        studentEditProfile.setBackground(new java.awt.Color(255, 255, 255));
        studentEditProfile.setText("내 정보 수정");
        studentEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentEditProfileActionPerformed(evt);
            }
        });

        studentMajorFrame.setEditable(false);
        studentMajorFrame.setBackground(new java.awt.Color(255, 255, 255));
        studentMajorFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentMajorFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        studentMajorFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentMajorFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        studentMajorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        studentMajorLabel.setText("학과");

        studentIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        studentIdLabel.setText("아이디");

        studentIdFrame.setEditable(false);
        studentIdFrame.setBackground(new java.awt.Color(255, 255, 255));
        studentIdFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentIdFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        studentIdFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentIdFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        studentNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        studentNameLabel.setText("이름");

        studentNameFrame.setEditable(false);
        studentNameFrame.setBackground(new java.awt.Color(255, 255, 255));
        studentNameFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentNameFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        studentNameFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentNameFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        subCoursesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subCoursesLabel.setText("신청 한 강의");

        studentCoursesListFrame.setBackground(new java.awt.Color(255, 255, 255));
        studentCoursesListFrame.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        studentCoursesListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentCoursesListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        studentCoursesScroolPane.setViewportView(studentCoursesListFrame);

        titleLabel.setFont(new java.awt.Font("HY견고딕", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("학생 메뉴");
        titleLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        reloadButton.setBackground(new java.awt.Color(255, 255, 255));
        reloadButton.setText("새로고침");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subCoursesLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentCoursesScroolPane)
                    .addComponent(studentMajorFrame)
                    .addComponent(studentCourseManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentEditProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(studentMajorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentIdFrame)
                    .addComponent(studentNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentNameFrame)
                    .addComponent(reloadButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reloadButton)
                .addGap(4, 4, 4)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentMajorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentMajorFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subCoursesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(studentCoursesScroolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentCourseManagementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void studentCourseManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentCourseManagementButtonActionPerformed
        // 내 수강 관리 버튼 클릭 시 이벤트
        CourseManagementSystemForStudents studentCourseManagementScreen = new CourseManagementSystemForStudents(studentName, studentId);

        // 기존 창 기준으로 우측에 위치 설정
        studentCourseManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        studentCourseManagementScreen.setVisible(true);
    }//GEN-LAST:event_studentCourseManagementButtonActionPerformed

    private void studentEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentEditProfileActionPerformed
        // 내 정보 수정 버튼을 눌렀을 때 이벤트
        SelfUserEdit selfUserEditManagementScreen = new SelfUserEdit(studentName, studentId);

        // 기존 창 기준으로 우측에 위치 설정
        selfUserEditManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        selfUserEditManagementScreen.setVisible(true);
        
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_studentEditProfileActionPerformed

    private void studentNameFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_studentNameFrameAncestorAdded
      studentNameFrame.setText(studentName);
    }//GEN-LAST:event_studentNameFrameAncestorAdded

    private void studentIdFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_studentIdFrameAncestorAdded
        studentIdFrame.setText(studentId);
    }//GEN-LAST:event_studentIdFrameAncestorAdded

    private void studentMajorFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_studentMajorFrameAncestorAdded
        Object studentMajor = usersFile.getUserValueByStandardKey("userId", studentId, "major");

        studentMajorFrame.setText(studentMajor.toString());
    }//GEN-LAST:event_studentMajorFrameAncestorAdded

    private void studentCoursesListFrameAncestorAdded(AncestorEvent evt) {//GEN-FIRST:event_studentCoursesListFrameAncestorAdded
        // 수강신청 한 목록
        // 특정 조건에 따라 JSON 배열 값 가져오기
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", studentId, "courseList", "course");

        // JList에 데이터를 설정하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Object value : courseValues) {
            System.out.println(value.toString());
            listModel.addElement(value.toString());
        }

        // JList에 모델 설정
        studentCoursesListFrame.setModel(listModel);
        
        // 읽기 전용
        studentCoursesListFrame.setEnabled(false);
    }//GEN-LAST:event_studentCoursesListFrameAncestorAdded

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        updateCoursesListFrame();
    }//GEN-LAST:event_reloadButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHome("김영진", "S-695").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton studentCourseManagementButton;
    private javax.swing.JList<String> studentCoursesListFrame;
    private javax.swing.JScrollPane studentCoursesScroolPane;
    private javax.swing.JButton studentEditProfile;
    private javax.swing.JTextField studentIdFrame;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JTextField studentMajorFrame;
    private javax.swing.JLabel studentMajorLabel;
    private javax.swing.JTextField studentNameFrame;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JLabel subCoursesLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
