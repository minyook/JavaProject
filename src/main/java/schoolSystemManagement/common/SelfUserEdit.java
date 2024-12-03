/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.common;

import schoolSystemManagement.file.JsonFile;
import schoolSystemManagement.student.StudentHome;

import javax.swing.*;
import javax.swing.event.AncestorEvent;

/**
 * 접속 한 사용자가 개인 정보를 수정하기 위한 Swing 프레임 입니다.
 *
 * @author 지민승
 * @version 1.0
 * @since 2024-12-03
 */
public class SelfUserEdit extends javax.swing.JFrame {

    // 테스트를 위한 초기화 값 입니다.
    public String userName = "김영진";
    public String userId = "S-695";

    // 프로그램 전체적으로 사용하는 부분입니다.
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    /**
     * 기본 생성자 입니다.
     */
    public SelfUserEdit() {
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("내 정보 수정");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * 부모 프레임으로 부터 값을 전달 받아 객체를 생성 합니다.
     *
     * @param userName
     * @param userId
     */
    public SelfUserEdit(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        initComponents();
        // 크기 조정 완전 금지
        setResizable(false);
        setTitle("내 정보 수정");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    /**
     * 이 메소드는 생성자 내에서 호출되어 양식을 초기화합니다.
     * 경고: 이 코드를 수정하지 마십시오. 이 메소드의 내용은 항상
     * 양식 편집기에 의해 재생성됩니다.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        saveEditProfileButton = new javax.swing.JButton();
        roleLable = new javax.swing.JLabel();
        idLable = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameLable = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        titleLable = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        passwordLable = new javax.swing.JLabel();
        majorLable = new javax.swing.JLabel();
        majorComboBox = new javax.swing.JComboBox<>();
        userTypeComboBox = new javax.swing.JComboBox<>();
        explainScrollpane = new javax.swing.JScrollPane();
        explainTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        saveEditProfileButton.setBackground(new java.awt.Color(255, 255, 255));
        saveEditProfileButton.setText("저장하기");
        saveEditProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditProfileButtonActionPerformed(evt);
            }
        });

        roleLable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roleLable.setText("직책");

        idLable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idLable.setText("아이디");

        idTextField.setEditable(false);
        idTextField.setBackground(new java.awt.Color(255, 255, 255));
        idTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        idTextField.setEnabled(false);
        idTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                idTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        nameLable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameLable.setText("이름");

        nameTextField.setEditable(false);
        nameTextField.setBackground(new java.awt.Color(255, 255, 255));
        nameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        nameTextField.setEnabled(false);
        nameTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                nameTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        titleLable.setFont(new java.awt.Font("HY견고딕", 0, 24)); // NOI18N
        titleLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLable.setText("내 정보 수정");

        passwordTextField.setBackground(new java.awt.Color(255, 255, 255));
        passwordTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        passwordTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                passwordTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        passwordLable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passwordLable.setText("비밀번호");

        majorLable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        majorLable.setText("학과");

        majorComboBox.setBackground(new java.awt.Color(255, 255, 255));
        majorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        majorComboBox.setEnabled(false);
        majorComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                majorComboBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        userTypeComboBox.setBackground(new java.awt.Color(255, 255, 255));
        userTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userTypeComboBox.setEnabled(false);
        userTypeComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userTypeComboBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        explainTextArea.setEditable(false);
        explainTextArea.setColumns(20);
        explainTextArea.setRows(5);
        explainTextArea.setText("비밀번호를 변경 할 수 있습니다.\n - 조건: 6자 이상 15자 미만\n추가적인 아이디 변경, 학과, 직책 변경은 관리자를 통해 진행 해 주세요.\n");
        explainTextArea.setEnabled(false);
        explainScrollpane.setViewportView(explainTextArea);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userTypeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveEditProfileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(roleLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idTextField)
                    .addComponent(nameLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameTextField)
                    .addComponent(passwordTextField)
                    .addComponent(passwordLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(majorLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(majorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(explainScrollpane))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(explainScrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(majorLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(majorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(roleLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(saveEditProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void saveEditProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditProfileButtonActionPerformed
        // 저장하기 버튼을 눌렀을 때 실행되는 코드
        // 사용자가 입력한 비밀번호 데이터를 가져오고, 검증 후 데이터 저장 작업을 수행합니다.
        String userPasswordData = passwordTextField.getText(); // 사용자 입력 필드에서 비밀번호 데이터를 가져옴

        // 입력값 검증
        if (userPasswordData == null || userPasswordData.trim().isEmpty()) {
            // 입력값이 null 이거나 공백으로만 구성되어 있는 경우
            // 사용자에게 경고 메시지를 표시하고 메서드 실행을 종료합니다.
            JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
            return; // 이후 코드를 실행하지 않도록 종료
        }

        if (userPasswordData.length() < 6 || userPasswordData.length() > 15) {
            // 비밀번호 길이가 6자 미만이거나 15자를 초과한 경우
            // 사용자에게 경고 메시지를 표시하고 메서드 실행을 종료합니다.
            JOptionPane.showMessageDialog(this, "비밀번호는 6자 이상 15자 이하로 입력해야 합니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
            return; // 이후 코드를 실행하지 않도록 종료
        }

        // 데이터 저장
        try {
            // 유효한 비밀번호가 입력되었을 때, 사용자 데이터를 저장하는 작업을 수행합니다.
            // usersFile 객체의 `setValueByStandardKey` 메서드를 호출하여 데이터를 저장합니다.
            usersFile.setValueByStandardKey("userId", userId, "number", userPasswordData);

            // 데이터 저장이 성공적으로 완료되었음을 사용자에게 알리는 메시지를 표시합니다.
            JOptionPane.showMessageDialog(this, "프로필이 성공적으로 저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            // 데이터 저장 작업 중 예외가 발생했을 경우
            // 사용자에게 오류 메시지를 표시하고 문제를 알립니다.
            JOptionPane.showMessageDialog(this, "프로필 저장 중 오류가 발생했습니다: " + e.getMessage(), "저장 실패", JOptionPane.ERROR_MESSAGE);

            // 디버깅 및 로그 확인을 위해 예외 스택 트레이스를 콘솔에 출력합니다.
            e.printStackTrace();
        }

    }//GEN-LAST:event_saveEditProfileButtonActionPerformed

    private void nameTextFieldAncestorAdded(AncestorEvent evt) {//GEN-FIRST:event_nameTextFieldAncestorAdded
      nameTextField.setText(userName);
    }//GEN-LAST:event_nameTextFieldAncestorAdded

    private void idTextFieldAncestorAdded(AncestorEvent evt) {//GEN-FIRST:event_idTextFieldAncestorAdded
        idTextField.setText(userId);
    }//GEN-LAST:event_idTextFieldAncestorAdded

    private void passwordTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_passwordTextFieldAncestorAdded
        // 사용자 비밀번호 가져오기
        String userPasswordData = usersFile.getUserValueByStandardKey("userId", userId, "number").toString();
        passwordTextField.setText(userPasswordData);
    }//GEN-LAST:event_passwordTextFieldAncestorAdded

    private void majorComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_majorComboBoxAncestorAdded
        // 사용자 전공 데이터를 가져오고 콤보박스 항목을 설정하는 코드

        // 사용자 데이터에서 전공 정보를 가져옵니다.
        // `usersFile.getUserValueByStandardKey` 메서드를 호출하여 특정 사용자 ID와 키("major")에 해당하는 값을 얻습니다.
        // 가져온 값은 `toString()` 메서드를 통해 문자열로 변환됩니다.
        String userMajorData = usersFile.getUserValueByStandardKey("userId", userId, "major").toString();

        // 기존 콤보박스 항목 제거
        // 콤보박스(userMajor)에 기존에 포함된 모든 항목을 삭제합니다.
        // 이를 통해 중복 항목이 추가되지 않도록 방지합니다.
        majorComboBox.removeAllItems();

        // 새로운 콤보박스 항목 추가
        // 전공 목록을 문자열 배열로 정의합니다.
        String[] majors = {"전산학과", "전자공학과", "기계공학과", "화학공학과", "항공우주공학과"};

        // `for-each` 반복문을 사용해 전공 배열의 각 요소를 콤보박스에 추가합니다.
        // 각 전공명은 콤보박스의 선택 가능 항목으로 등록됩니다.
        for (String major : majors) {
            majorComboBox.addItem(major); // 콤보박스에 항목 추가
        }

        // 사용자 데이터로부터 가져온 전공 정보를 기반으로 콤보박스에서 해당 항목을 선택합니다.
        // 사용자가 이전에 저장했던 전공이 콤보박스에서 기본값으로 표시됩니다.
        majorComboBox.setSelectedItem(userMajorData);

    }//GEN-LAST:event_majorComboBoxAncestorAdded

    private void userTypeComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userTypeComboBoxAncestorAdded
        // 사용자 타입 데이터를 가져오고 콤보박스 항목을 설정하는 코드

        // 사용자 데이터에서 사용자 타입 정보를 가져옵니다.
        // `usersFile.getUserValueByStandardKey` 메서드를 호출하여 특정 사용자 ID와 키("userType")에 해당하는 값을 얻습니다.
        // 가져온 값은 `toString()` 메서드를 통해 문자열로 변환됩니다.
        String userMajorData = usersFile.getUserValueByStandardKey("userId", userId, "userType").toString();

        // 기존 콤보박스 항목 제거
        // 콤보박스(userType)에 기존에 포함된 모든 항목을 삭제하여 초기화합니다.
        // 이를 통해 중복 항목 추가를 방지하고 최신 데이터만 표시하도록 설정합니다.
        userTypeComboBox.removeAllItems();

        // 새로운 콤보박스 항목 추가
        // 사용자 타입에 대한 항목을 배열로 정의합니다.
        String[] majors = {"학생", "교수", "기계공학과", "학사담당자", "수업담당자"};

        // `for-each` 반복문을 사용하여 배열의 각 요소를 콤보박스에 추가합니다.
        for (String major : majors) {
            userTypeComboBox.addItem(major); // 콤보박스에 항목 추가
        }

        // 사용자 데이터로부터 가져온 타입 정보를 콤보박스에서 기본 선택 항목으로 설정합니다.
        // 가져온 데이터가 배열에 있는 항목과 일치하면 해당 항목이 기본값으로 표시됩니다.
        userTypeComboBox.setSelectedItem(userMajorData);

    }//GEN-LAST:event_userTypeComboBoxAncestorAdded

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
                new SelfUserEdit("김영진", "S-695").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane explainScrollpane;
    private javax.swing.JTextArea explainTextArea;
    private javax.swing.JLabel idLable;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JComboBox<String> majorComboBox;
    private javax.swing.JLabel majorLable;
    private javax.swing.JLabel nameLable;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel roleLable;
    private javax.swing.JButton saveEditProfileButton;
    private javax.swing.JLabel titleLable;
    private javax.swing.JComboBox<String> userTypeComboBox;
    // End of variables declaration//GEN-END:variables
}
