/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.professor;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.json.JSONObject;
import schoolSystemManagement.common.SelfUserEdit;
import schoolSystemManagement.dto.CourseData;
import schoolSystemManagement.file.JsonFile;

/**
 *
 * @author admin
 */
public class ProfessorHome extends javax.swing.JFrame {
    
    public String professorName = "이선권";
    public String professorId = "P-908";
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    /**
     * 기본 생성자 입니다.
     */
    public ProfessorHome() {
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("교수 메뉴");
    }

    /**
     * 부모 프레임으로부터 이름과 아이디 값을 전달 받아 사용합니다.
     *
     * @param professorName
     * @param professorId
     */
    public ProfessorHome(String professorName, String professorId) {
        this.professorName =professorName;
        this.professorId = professorId;
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("교수 메뉴");
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
        professorCourseManagementButton = new javax.swing.JButton();
        professorEditProfil = new javax.swing.JButton();
        professorMajorFrame = new javax.swing.JTextField();
        majorLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        professorIdFrame = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        professorNameFrame = new javax.swing.JTextField();
        openCoursesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        professorOpenCoursesListFrame = new javax.swing.JList<>();
        titleLabel = new javax.swing.JLabel();
        reData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        professorCourseManagementButton.setBackground(new java.awt.Color(255, 255, 255));
        professorCourseManagementButton.setText("내 강의 관리");
        professorCourseManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professorCourseManagementButtonActionPerformed(evt);
            }
        });

        professorEditProfil.setBackground(new java.awt.Color(255, 255, 255));
        professorEditProfil.setText("내 정보 수정");
        professorEditProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professorEditProfilActionPerformed(evt);
            }
        });

        professorMajorFrame.setEditable(false);
        professorMajorFrame.setBackground(new java.awt.Color(255, 255, 255));
        professorMajorFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        professorMajorFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        professorMajorFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                professorMajorFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        majorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        majorLabel.setText("학과");

        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idLabel.setText("아이디");

        professorIdFrame.setEditable(false);
        professorIdFrame.setBackground(new java.awt.Color(255, 255, 255));
        professorIdFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        professorIdFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        professorIdFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                professorIdFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameLabel.setText("이름");

        professorNameFrame.setEditable(false);
        professorNameFrame.setBackground(new java.awt.Color(255, 255, 255));
        professorNameFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        professorNameFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        professorNameFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                professorNameFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        openCoursesLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        openCoursesLabel.setText("개설 된 강의");

        professorOpenCoursesListFrame.setBackground(new java.awt.Color(255, 255, 255));
        professorOpenCoursesListFrame.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        professorOpenCoursesListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                professorOpenCoursesListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(professorOpenCoursesListFrame);

        titleLabel.setFont(new java.awt.Font("HY견고딕", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("교수 메뉴");
        titleLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        reData.setBackground(new java.awt.Color(255, 255, 255));
        reData.setText("새로고침");
        reData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reDataActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addComponent(professorMajorFrame)
                    .addComponent(professorCourseManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(professorEditProfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(majorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(professorIdFrame)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(professorNameFrame)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorNameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(majorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(professorMajorFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openCoursesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(professorCourseManagementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(professorEditProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void professorCourseManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professorCourseManagementButtonActionPerformed
        // 내 강의 버튼 이벤트
        // 내 수강 관리 버튼 클릭 시 이벤트
        CourseManagementSystemForProfessor professorCourseManagementScreen = new CourseManagementSystemForProfessor(professorName, professorId);

        // 기존 창 기준으로 우측에 위치 설정
        professorCourseManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        professorCourseManagementScreen.setVisible(true);
    }//GEN-LAST:event_professorCourseManagementButtonActionPerformed

    private void professorEditProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professorEditProfilActionPerformed
        // 내 정보 수정 버튼을 눌렀을 때 이벤트
        SelfUserEdit selfUserEditManagementScreen = new SelfUserEdit(professorName, professorId);

        // 기존 창 기준으로 우측에 위치 설정
        selfUserEditManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        selfUserEditManagementScreen.setVisible(true);
    }//GEN-LAST:event_professorEditProfilActionPerformed

    private void professorNameFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_professorNameFrameAncestorAdded
        // 이름 불러오기
        professorNameFrame.setText(professorName);
    }//GEN-LAST:event_professorNameFrameAncestorAdded

    private void professorIdFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_professorIdFrameAncestorAdded
        // 아이디 불러오기
        professorIdFrame.setText(professorId);
    }//GEN-LAST:event_professorIdFrameAncestorAdded

    private void professorMajorFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_professorMajorFrameAncestorAdded
        // 학과 불러오기
        Object professorMajor = usersFile.getUserValueByStandardKey("userId", professorId, "major");

        professorMajorFrame.setText(professorMajor.toString());
    }//GEN-LAST:event_professorMajorFrameAncestorAdded

    private void professorOpenCoursesListFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_professorOpenCoursesListFrameAncestorAdded
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
            if (value.getUserId().equals(professorId)){
                listModel.addElement(value.getName());
            }
        }

        // JList에 모델 설정
        professorOpenCoursesListFrame.setModel(listModel);

        // 읽기 전용으로 설정
        professorOpenCoursesListFrame.setEnabled(false);  // 입력 불가
    }//GEN-LAST:event_professorOpenCoursesListFrameAncestorAdded

    private void reDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reDataActionPerformed
        // 본인에 대한 개설 된 강의 목록 가져오기 및 업데이트
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
            if (value.getUserId().equals(professorId)){
                listModel.addElement(value.getName());
            }
        }

        // JList에 모델 설정
        professorOpenCoursesListFrame.setModel(listModel);

        // 읽기 전용으로 설정
        professorOpenCoursesListFrame.setEnabled(false);  // 입력 불가
    }//GEN-LAST:event_reDataActionPerformed

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
            java.util.logging.Logger.getLogger(ProfessorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorHome("이선권","P-908").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel openCoursesLabel;
    private javax.swing.JButton professorCourseManagementButton;
    private javax.swing.JButton professorEditProfil;
    private javax.swing.JTextField professorIdFrame;
    private javax.swing.JTextField professorMajorFrame;
    private javax.swing.JTextField professorNameFrame;
    private javax.swing.JList<String> professorOpenCoursesListFrame;
    private javax.swing.JButton reData;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
