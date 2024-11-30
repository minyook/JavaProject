/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.course.management;

import schoolSystemManagement.course.management.dto.UserData;
import schoolSystemManagement.course.management.json.JsonFile;
import org.json.JSONObject;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author oxxultus
 */
public class CourseManagementSystemForManager extends javax.swing.JFrame {

    public String managerName = "김영진";
    public String managerId = "S-027";
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");
    /**
     * Creates new form CourseManagementSystemForManager
     */
    public CourseManagementSystemForManager() {
        initComponents();
        setTitle("[수업관리자] 수강 관리 시스템");
    }
    public CourseManagementSystemForManager(String managerName, String managerId) {
        this.managerName = managerName;
        this.managerId = managerId;
        initComponents();
        setTitle("[수업관리자] 수강 관리 시스템");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panel_SubCourseStudents = new javax.swing.JPanel();
        subStudentsFrame = new javax.swing.JScrollPane();
        totalCourseSubStudentsListFrame = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentSubListFrame = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        studentNameFrame = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        studentTotalUnitFrame = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        coursesPriceFrame = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        submitPrice = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        studentMajorFrame = new javax.swing.JTextField();
        studentUserIdFrame = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        managerIdFrame = new javax.swing.JTextField();
        managerNameFrame = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        totalCourseSubStudentsListFrame.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        totalCourseSubStudentsListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                totalCourseSubStudentsListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        totalCourseSubStudentsListFrame.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                totalCourseSubStudentsListFrameValueChanged(evt);
            }
        });
        subStudentsFrame.setViewportView(totalCourseSubStudentsListFrame);

        studentSubListFrame.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        studentSubListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentSubListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(studentSubListFrame);

        jLabel1.setText("수강 신청 한 학생 목록");

        jLabel2.setText("학생 이름");

        studentNameFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentNameFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel4.setText("총 수강 신청 학점");

        studentTotalUnitFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentTotalUnitFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel5.setText("신청 한 강의 목록");

        jLabel6.setText("청구 할 금액");

        submitPrice.setText("청구하기");
        submitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPriceActionPerformed(evt);
            }
        });

        jLabel7.setText("학과");

        studentMajorFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentMajorFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        studentUserIdFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                studentUserIdFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel8.setText("사용자 아이디");

        managerIdFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                managerIdFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        managerNameFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                managerNameFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel9.setText("관리자 이름");

        jLabel10.setText("관리자 아이디");

        javax.swing.GroupLayout panel_SubCourseStudentsLayout = new javax.swing.GroupLayout(panel_SubCourseStudents);
        panel_SubCourseStudents.setLayout(panel_SubCourseStudentsLayout);
        panel_SubCourseStudentsLayout.setHorizontalGroup(
                panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(managerNameFrame))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(186, 186, 186))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SubCourseStudentsLayout.createSequentialGroup()
                                                                .addComponent(managerIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())))
                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                                .addComponent(subStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1)
                                                                        .addComponent(studentNameFrame)
                                                                        .addComponent(coursesPriceFrame)
                                                                        .addComponent(submitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(studentMajorFrame)
                                                                        .addComponent(studentTotalUnitFrame)
                                                                        .addComponent(studentUserIdFrame)
                                                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jLabel6)
                                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel4)
                                                                                        .addComponent(jLabel8))
                                                                                .addGap(0, 127, Short.MAX_VALUE)))))
                                                .addContainerGap())))
        );
        panel_SubCourseStudentsLayout.setVerticalGroup(
                panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SubCourseStudentsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SubCourseStudentsLayout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(managerNameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(managerIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SubCourseStudentsLayout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(44, 44, 44)))
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_SubCourseStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel_SubCourseStudentsLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(studentNameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(studentMajorFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(studentUserIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(studentTotalUnitFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(coursesPriceFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(submitPrice))
                                        .addComponent(subStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jMenu1.setText("메뉴");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_SubCourseStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_SubCourseStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void totalCourseSubStudentsListFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        Object[] subStudentsData = usersFile.getAllJsonObjectWhereTargetKeyExists("courseList","course");
        ArrayList<UserData> subStudents = new ArrayList<>();

        // 필터링된 객체가 없는 경우 처리
        if (subStudentsData.length == 0) {
            // JList에 "학생이 존재하지 않습니다." 메시지 추가
            DefaultListModel<String> emptyModel = new DefaultListModel<>();
            emptyModel.addElement("학생이 존재하지 않습니다.");
            totalCourseSubStudentsListFrame.setModel(emptyModel);
            return;  // 더 이상 진행하지 않음
        }

        // 반복하여 필터링된 객체의 특정 속성을 추출하고, DTO 객체로 변환하여 리스트에 저장
        for (Object obj : subStudentsData) {
            JSONObject course = (JSONObject) obj;

            // 원하는 속성 추출
            String name = course.optString("name", "N/A");
            String userId = course.optString("userId", "N/A");
            String major = course.optString("major", "N/A");
            String number = course.optString("number", "N/A");

            // 결과를 DTO 객체로 만들어 ArrayList에 저장
            UserData userDTO = new UserData(name, userId, number, major);
            subStudents.add(userDTO);
        }

        // JList에 데이터를 설정하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // courseDataList에서 강의 이름을 가져와 JList에 추가
        for (UserData value : subStudents) {
            listModel.addElement("이름: " + value.getName() + "    학과: " + value.getMajor() + "    userId: " + value.getUserId());
        }

        // JList에 모델 설정
        totalCourseSubStudentsListFrame.setModel(listModel);
    }

    private void totalCourseSubStudentsListFrameValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // 리스트에서 선택한 부분의 문자열을 가져온다.
        String selectedStudentNameAndNumber = totalCourseSubStudentsListFrame.getSelectedValue();

        // fullString이 null인 경우, 즉 선택된 값이 없을 때 처리
        if (selectedStudentNameAndNumber == null) {
            return;  // 종료
        }

        String fullString = selectedStudentNameAndNumber;

        // 공백을 기준으로 문자열을 나눕니다. (주어진 구분자 "    "을 기준으로 나누기)
        String[] parts = fullString.split("    ");  // 공백 4개를 기준으로 분리

        // 배열의 길이가 4가 아닌 경우, 즉 필요한 데이터가 없다면 종료
        if (parts.length < 3) {
            JOptionPane.showMessageDialog(this, "선택된 학생 데이터가 올바르지 않습니다. 다시 선택해주세요.");
            return;  // 종료
        }

        // 각 항목을 분리하여 변수에 저장
        String name = parts[0].replace("이름: ", "").trim();  // 이름
        String major = parts[1].replace("학과:", "").trim();  // 학과
        String userId = parts[2].replace("userId:", "").trim(); // userId

        // 필수 데이터가 없다면 종료
        if (name.isEmpty() || major.isEmpty() || userId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "학생의 이름, 학과, 또는 userId가 누락되었습니다.");
            return;  // 종료
        }

        studentNameFrame.setText(name);
        studentMajorFrame.setText(major);
        studentUserIdFrame.setText(userId);

        // 내 학점 가져오기
        Object[] updateCourseUnitValues = usersFile.getAllJsonArrayValue("userId", userId, "courseList", "unit");

        // 학점 결과 계산 후 출력
        int unitSum = 0;
        for (Object unitValue : updateCourseUnitValues) {
            // Object를 String으로 변환한 후, Integer로 변환
            unitSum += Integer.parseInt(unitValue.toString());  // toString()을 호출하여 Object를 String으로 변환
        }
        studentTotalUnitFrame.setText(Integer.toString(unitSum));

        // 특정 조건에 따라 신청한 과 배열 값 가져와서 출력하
        Object[] courseValues = usersFile.getAllJsonArrayValue("userId", userId, "courseList", "course");

        // JList에 데이터를 설정하기 위한 DefaultListModel 생성
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Object value : courseValues) {
            System.out.println(value.toString());
            listModel.addElement(value.toString());
        }

        // JList에 모델 설정
        studentSubListFrame.setModel(listModel);

        // 필드 비활성화
        studentNameFrame.setEditable(false);
        studentMajorFrame.setEditable(false);
        studentTotalUnitFrame.setEditable(false);
        studentUserIdFrame.setEditable(false);
    }

    private void studentSubListFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        DefaultListModel<String> emptyModel = new DefaultListModel<>();
        emptyModel.addElement("학생을 선택 해 주세요");
        studentSubListFrame.setModel(emptyModel);
        studentSubListFrame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentSubListFrame.setEnabled(false);
    }

    private void submitPriceActionPerformed(java.awt.event.ActionEvent evt) {
        String tuition = coursesPriceFrame.getText();

        // 필수 데이터가 없다면 종료
        if (tuition == null || tuition.isEmpty()) {
            JOptionPane.showMessageDialog(this, "청구 할 금액을 입력해 주세요.");
            return;  // 종료
        }

        // 값 가져오기
        String studentName = studentNameFrame.getText();
        String studentMajor = studentMajorFrame.getText();
        String studentUserId = studentUserIdFrame.getText();

        // 학생 이름 확인
        if (studentName == null || studentName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "학생의 이름이 누락되었습니다.\n학생을 다시 선택해 주세요.");
            return;  // 종료
        }

        // 학과 확인
        if (studentMajor == null || studentMajor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "학생의 학과가 누락되었습니다.\n학생을 다시 선택해 주세요.");
            return;  // 종료
        }

        // 사용자 ID 확인
        if (studentUserId == null || studentUserId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "학생의 사용자 ID가 누락되었습니다.\n학생을 다시 선택해 주세요.");
            return;  // 종료
        }

        // 저장 확인
        int result = JOptionPane.showConfirmDialog(
                this,
                "학비를 청구 하시겠습니까?",
                "저장 확인",
                JOptionPane.YES_NO_OPTION
        );

        // 사용자가 "예"를 선택한 경우에만 저장 실행
        if (result == JOptionPane.YES_OPTION) {
            // 학비는 문자열로 데이터에 저장됩니다.
            usersFile.addKeyAndValue("userId", studentUserId, "tuition", tuition);

            // 성공적으로 저장되었음을 사용자에게 알림
            JOptionPane.showMessageDialog(this, "청구 금액이 성공적으로 저장되었습니다.");
        } else {
            // 사용자가 "아니요"를 선택했을 때
            JOptionPane.showMessageDialog(this, "저장이 취소되었습니다.");
        }
    }

    private void managerNameFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        managerNameFrame.setText(managerName);

        // 필드 비활성화
        managerNameFrame.setEnabled(false);
    }

    private void managerIdFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        managerIdFrame.setText(managerId);

        // 필드 비활성화
        managerIdFrame.setEnabled(false);
    }

    private void studentNameFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        studentNameFrame.setEnabled(false);
    }

    private void studentMajorFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        studentMajorFrame.setEnabled(false);
    }

    private void studentUserIdFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        studentUserIdFrame.setEnabled(false);
    }

    private void studentTotalUnitFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {
        studentTotalUnitFrame.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(CourseManagementSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseManagementSystemForManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField coursesPriceFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField managerIdFrame;
    private javax.swing.JTextField managerNameFrame;
    private javax.swing.JPanel panel_SubCourseStudents;
    private javax.swing.JTextField studentMajorFrame;
    private javax.swing.JTextField studentNameFrame;
    private javax.swing.JList<String> studentSubListFrame;
    private javax.swing.JTextField studentTotalUnitFrame;
    private javax.swing.JTextField studentUserIdFrame;
    private javax.swing.JScrollPane subStudentsFrame;
    private javax.swing.JButton submitPrice;
    private javax.swing.JList<String> totalCourseSubStudentsListFrame;
    // End of variables declaration
}