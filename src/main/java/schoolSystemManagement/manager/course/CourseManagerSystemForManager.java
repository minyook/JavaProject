/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolSystemManagement.manager.course;

import org.json.JSONObject;
import schoolSystemManagement.dto.CourseData;
import schoolSystemManagement.file.JsonFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import schoolSystemManagement.common.SelfUserEdit;

/**
 *
 * @author admin
 */
public class CourseManagerSystemForManager extends javax.swing.JFrame {


    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");
    
    public void updateCloseCourseList(){
        // coursesFile.getJsonObject()가 빈 값인지 확인하고 필터링된 객체 가져오기
        coursesFile = new JsonFile("course_data.json", "course_data.json");
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "false");

        // filteredObjects가 비어 있지 않으면 처리
        if (filteredObjects != null && !filteredObjects.isEmpty()) {
            ArrayList<CourseData> courseDataList = new ArrayList<>();

            // 반복하여 필터링된 객체의 특정 속성을 출력
            for (String key : filteredObjects.keySet()) {
                JSONObject course = filteredObjects.getJSONObject(key);

                // 원하는 속성 추출
                String name = course.optString("name", "N/A");
                int maxStudents = course.optInt("maxStudents", 0);
                String professor = course.optString("professor", "N/A");
                int unit = course.optInt("unit", 0);
                String userId = course.optString("userId", "N/A");
                String description = course.optString("description", "N/A");

                // 결과를 DTO 객체로 만들어 ArrayList에 저장
                CourseData courseDTO = new CourseData(name, professor, maxStudents, unit, userId, description);
                courseDataList.add(courseDTO);
            }

            // JTable에 데이터를 설정하기 위한 DefaultTableModel 생성
            DefaultTableModel tableModel = new DefaultTableModel();

            // 테이블 컬럼 정의
            tableModel.addColumn("강의명");
            tableModel.addColumn("교수명");
            tableModel.addColumn("교수 ID");
            tableModel.addColumn("최대 학생 수");
            tableModel.addColumn("학점");

            // 필터링된 데이터 추가
            for (CourseData value : courseDataList) {
                tableModel.addRow(new Object[]{
                        value.getName(),
                        value.getProfessor(),
                        value.getUserId(),
                        value.getMaxStudents(),
                        value.getUnit()
                });
            }

            // JTable에 모델 설정
            closeCoursesListFrame.setModel(tableModel);
        } else {
            // 필터링된 객체가 비어 있을 경우 테이블에 아무것도 추가하지 않음
            // 공백 상태로 유지
            DefaultTableModel emptyModel = new DefaultTableModel();
            closeCoursesListFrame.setModel(emptyModel);
        }

    }
    public void updateOpenCourseList(){
        // 필터링된 객체 가져오기
        coursesFile = new JsonFile("course_data.json", "course_data.json");
        JSONObject filteredObjects = coursesFile.getAllObjectsByKeyValue("status", "true");

        if (filteredObjects != null && filteredObjects.length() > 0) {
            ArrayList<CourseData> courseDataList = new ArrayList<>();

            // 반복하여 필터링된 객체의 특정 속성을 출력
            for (String key : filteredObjects.keySet()) {
                JSONObject course = filteredObjects.getJSONObject(key);

                // 원하는 속성 추출
                String name = course.optString("name", "N/A");
                int maxStudents = course.optInt("maxStudents", 0);
                String professor = course.optString("professor", "N/A");
                int unit = course.optInt("unit", 0);
                String userId = course.optString("userId", "N/A");
                String description = course.optString("description", "N/A");

                // 결과를 DTO 객체로 만들어 ArrayList에 저장
                CourseData courseDTO = new CourseData(name, professor, maxStudents, unit, userId, description);
                courseDataList.add(courseDTO);
            }

            // JTable에 데이터를 설정하기 위한 DefaultTableModel 생성
            DefaultTableModel tableModel = new DefaultTableModel();

            // 테이블 컬럼 정의
            tableModel.addColumn("강의명");
            tableModel.addColumn("교수명");
            tableModel.addColumn("교수 ID");
            tableModel.addColumn("최대 학생 수");
            tableModel.addColumn("학점");

            // 필터링된 데이터 추가
            for (CourseData value : courseDataList) {
                tableModel.addRow(new Object[]{
                    value.getName(),
                    value.getProfessor(),
                    value.getUserId(),
                    value.getMaxStudents(),
                    value.getUnit()
                });
            }

            // JTable에 모델 설정
            openCoursesListFrame.setModel(tableModel);
        } else {
            // 필터링된 객체가 비어 있을 경우 테이블에 아무것도 추가하지 않음
            // 공백 상태로 유지
            DefaultTableModel emptyModel = new DefaultTableModel();
            openCoursesListFrame.setModel(emptyModel);
        }

    }

    // addKeyAndValue 중복 코드 제거를 위한 메서드
    private void updateCourseData(JsonFile coursesFile, String courseName, String courseUnit, String courseMaxStudents,
                                  String courseCountStudents, String courseStatus, String courseDescription) {
        coursesFile.addKeyAndValue("name", courseName, "unit", courseUnit);
        coursesFile.addKeyAndValue("name", courseName, "maxStudents", courseMaxStudents);
        coursesFile.addKeyAndValue("name", courseName, "countStudents", courseCountStudents);
        coursesFile.addKeyAndValue("name", courseName, "status", courseStatus);
        coursesFile.addKeyAndValue("name", courseName, "description", courseDescription);
    }

    /**
     * Creates new form CourseManagerSystemForManager
     */
    public CourseManagerSystemForManager() {
        initComponents();
        setTitle("강의 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(860,635);
        // 크기 조정 완전 금지
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_courses = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        openCoursesListFrame = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        closeCoursesListFrame = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        courseStatusFrameLable = new javax.swing.JLabel();
        courseCountStudentsFrame = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        courseMaxStudentsFrame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        courseUnitFrame = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        courseProfessorIdFrame = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        courseProfessorFrame = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        courseNameFrame = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        courseDescriptionFrame = new javax.swing.JTextArea();
        addCourseButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        courseStatusFrame = new javax.swing.JComboBox<>();
        reloadButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_courses.setBackground(new java.awt.Color(255, 255, 255));

        openCoursesListFrame.setBackground(new java.awt.Color(255, 255, 255));
        openCoursesListFrame.setModel(new javax.swing.table.DefaultTableModel(
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
        openCoursesListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                openCoursesListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        openCoursesListFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openCoursesListFrameMouseClicked(evt);
            }
        });
        openCoursesListFrame.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                openCoursesListFramePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(openCoursesListFrame);

        closeCoursesListFrame.setBackground(new java.awt.Color(255, 255, 255));
        closeCoursesListFrame.setModel(new javax.swing.table.DefaultTableModel(
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
        closeCoursesListFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                closeCoursesListFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        closeCoursesListFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeCoursesListFrameMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(closeCoursesListFrame);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("개설 된 강의 리스트");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("개설 되지 않은 강의 리스트");

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setText("수정");
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                updateButtonAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        courseStatusFrameLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseStatusFrameLable.setText("개설 여부");

        courseCountStudentsFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseCountStudentsFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseCountStudentsFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("현재 수강생 수");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("최대 수강생 수");

        courseMaxStudentsFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseMaxStudentsFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseMaxStudentsFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("학점");

        courseUnitFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseUnitFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseUnitFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        courseUnitFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseUnitFrameActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("담당 교수 아이디");

        courseProfessorIdFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseProfessorIdFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseProfessorIdFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("담당 교수");

        courseProfessorFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseProfessorFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseProfessorFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("강의 이름");

        courseNameFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseNameFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseNameFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("강의 설명");

        courseDescriptionFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseDescriptionFrame.setColumns(20);
        courseDescriptionFrame.setRows(5);
        courseDescriptionFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseDescriptionFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(courseDescriptionFrame);

        addCourseButton.setBackground(new java.awt.Color(255, 255, 255));
        addCourseButton.setText("강의 추가");
        addCourseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("HY견고딕", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("강의 관리");
        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        courseStatusFrame.setBackground(new java.awt.Color(255, 255, 255));
        courseStatusFrame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        courseStatusFrame.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseStatusFrameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        reloadButton.setBackground(new java.awt.Color(255, 255, 255));
        reloadButton.setText("새로고침");
        reloadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("삭제");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                deleteButtonAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_coursesLayout = new javax.swing.GroupLayout(panel_courses);
        panel_courses.setLayout(panel_coursesLayout);
        panel_coursesLayout.setHorizontalGroup(
            panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_coursesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_coursesLayout.createSequentialGroup()
                        .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_coursesLayout.createSequentialGroup()
                                .addComponent(reloadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(courseProfessorIdFrame)
                            .addComponent(courseProfessorFrame)
                            .addComponent(courseNameFrame)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_coursesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(courseStatusFrame, 0, 241, Short.MAX_VALUE)
                                        .addComponent(courseCountStudentsFrame)
                                        .addComponent(courseMaxStudentsFrame)
                                        .addComponent(courseUnitFrame)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseStatusFrameLable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_coursesLayout.createSequentialGroup()
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        panel_coursesLayout.setVerticalGroup(
            panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_coursesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_coursesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_coursesLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseNameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseProfessorFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseProfessorIdFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseUnitFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseMaxStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseCountStudentsFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseStatusFrameLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(courseStatusFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_coursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_courses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_courses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openCoursesListFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_openCoursesListFrameAncestorAdded
        updateOpenCourseList();
    }//GEN-LAST:event_openCoursesListFrameAncestorAdded

    private void closeCoursesListFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_closeCoursesListFrameAncestorAdded
        updateCloseCourseList();
    }//GEN-LAST:event_closeCoursesListFrameAncestorAdded

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        updateOpenCourseList();
        updateCloseCourseList();
        JOptionPane.showMessageDialog(this, "정상적으로 데이터가 다시 로드 되었습니다.");
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void closeCoursesListFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeCoursesListFrameMouseClicked
        // 열러있지 않은 강의 마우스 클릭시 
        int selectedRow = closeCoursesListFrame.getSelectedRow(); // 선택된 행의 인덱스 가져오기
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) closeCoursesListFrame.getModel();

            String courseNameValue = model.getValueAt(selectedRow, 0).toString();
            String professorNameValue = model.getValueAt(selectedRow, 1).toString();
            String professorIdValue = model.getValueAt(selectedRow, 2).toString();
            String maxStudents = model.getValueAt(selectedRow, 3).toString();
            String courseUnitValue = model.getValueAt(selectedRow, 4).toString();
            

            courseNameFrame.setText(courseNameValue);
            courseProfessorFrame.setText(professorNameValue);
            courseProfessorIdFrame.setText(professorIdValue);
            courseUnitFrame.setText(courseUnitValue);
            courseMaxStudentsFrame.setText(maxStudents);
            courseCountStudentsFrame.setText(coursesFile.getUserValueByStandardKey("name", courseNameValue, "countStudents").toString());
            courseStatusFrame.setSelectedItem(coursesFile.getUserValueByStandardKey("name", courseNameValue, "status").toString());
            courseDescriptionFrame.setText(coursesFile.getUserValueByStandardKey("name", courseNameValue, "description").toString());
        }
        courseNameFrame.setEnabled(false);
        courseProfessorFrame.setEnabled(false);
        courseProfessorIdFrame.setEnabled(false);
        courseUnitFrame.setEnabled(true);
        courseMaxStudentsFrame.setEnabled(true);
        courseCountStudentsFrame.setEnabled(true);
        courseStatusFrame.setEnabled(true);
        courseDescriptionFrame.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }//GEN-LAST:event_closeCoursesListFrameMouseClicked

    private void courseUnitFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseUnitFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseUnitFrameActionPerformed

    private void courseStatusFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseStatusFrameAncestorAdded
        // 기존 내용 초기화
        courseStatusFrame.removeAllItems();

        // 콤보박스에 true와 false 값 추가
        courseStatusFrame.addItem("true");
        courseStatusFrame.addItem("false");

        // 기본값을 "true"로 설정
        courseStatusFrame.setSelectedItem("false");
        
        
        courseStatusFrame.setEnabled(false);
    }//GEN-LAST:event_courseStatusFrameAncestorAdded

    private void courseNameFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseNameFrameAncestorAdded
        courseNameFrame.setEnabled(false);
    }//GEN-LAST:event_courseNameFrameAncestorAdded

    private void courseProfessorFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseProfessorFrameAncestorAdded
        courseProfessorFrame.setEnabled(false);
    }//GEN-LAST:event_courseProfessorFrameAncestorAdded

    private void courseProfessorIdFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseProfessorIdFrameAncestorAdded
        courseProfessorIdFrame.setEnabled(false);
    }//GEN-LAST:event_courseProfessorIdFrameAncestorAdded

    private void courseUnitFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseUnitFrameAncestorAdded
        courseUnitFrame.setEnabled(false);
    }//GEN-LAST:event_courseUnitFrameAncestorAdded

    private void courseMaxStudentsFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseMaxStudentsFrameAncestorAdded
        courseMaxStudentsFrame.setEnabled(false);
    }//GEN-LAST:event_courseMaxStudentsFrameAncestorAdded

    private void courseCountStudentsFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseCountStudentsFrameAncestorAdded
        courseCountStudentsFrame.setEnabled(false);
    }//GEN-LAST:event_courseCountStudentsFrameAncestorAdded

    private void courseDescriptionFrameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseDescriptionFrameAncestorAdded
        courseDescriptionFrame.setEnabled(false);
    }//GEN-LAST:event_courseDescriptionFrameAncestorAdded

    private void openCoursesListFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCoursesListFrameMouseClicked
        // 열린 강의 마우스 클릭시 
        int selectedRow = openCoursesListFrame.getSelectedRow(); // 선택된 행의 인덱스 가져오기
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) openCoursesListFrame.getModel();

            String courseNameValue = model.getValueAt(selectedRow, 0).toString();
            String professorNameValue = model.getValueAt(selectedRow, 1).toString();
            String professorIdValue = model.getValueAt(selectedRow, 2).toString();
            String maxStudents = model.getValueAt(selectedRow, 3).toString();
            String courseUnitValue = model.getValueAt(selectedRow, 4).toString();
            

            courseNameFrame.setText(courseNameValue);
            courseProfessorFrame.setText(professorNameValue);
            courseProfessorIdFrame.setText(professorIdValue);
            courseUnitFrame.setText(courseUnitValue);
            courseMaxStudentsFrame.setText(maxStudents);
            courseCountStudentsFrame.setText(coursesFile.getUserValueByStandardKey("name", courseNameValue, "countStudents").toString());
            courseStatusFrame.setSelectedItem(coursesFile.getUserValueByStandardKey("name", courseNameValue, "status").toString());
            courseDescriptionFrame.setText(coursesFile.getUserValueByStandardKey("name", courseNameValue, "description").toString());
        }
        courseNameFrame.setEnabled(false);
        courseProfessorFrame.setEnabled(false);
        courseProfessorIdFrame.setEnabled(false);
        courseUnitFrame.setEnabled(false);
        courseMaxStudentsFrame.setEnabled(false);
        courseCountStudentsFrame.setEnabled(false);
        courseStatusFrame.setEnabled(true);
        courseDescriptionFrame.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_openCoursesListFrameMouseClicked

    private void openCoursesListFramePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_openCoursesListFramePropertyChange
        
    }//GEN-LAST:event_openCoursesListFramePropertyChange

    private void updateButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_updateButtonAncestorAdded
        updateButton.setEnabled(false);
    }//GEN-LAST:event_updateButtonAncestorAdded

    private void deleteButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_deleteButtonAncestorAdded
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_deleteButtonAncestorAdded

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // 입력 값 가져오기
        String courseName = courseNameFrame.getText();
        String courseProfessor = courseProfessorFrame.getText();
        String courseProfessorId = courseProfessorIdFrame.getText();
        String courseUnit = courseUnitFrame.getText();
        String courseMaxStudents = courseMaxStudentsFrame.getText();
        String courseCountStudents = courseCountStudentsFrame.getText();
        String courseStatus = courseStatusFrame.getSelectedItem().toString();
        String courseDescription = courseDescriptionFrame.getText();

        // 값이 비어 있는지 확인하고 경고 메시지 출력
        if (courseName.isEmpty() || courseProfessor.isEmpty() || courseProfessorId.isEmpty() ||
                courseUnit.isEmpty() || courseMaxStudents.isEmpty() || courseCountStudents.isEmpty() ||
                courseStatus.isEmpty() || courseDescription.isEmpty()) {
            JOptionPane.showMessageDialog(null, "모든 필드를 채워야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;  // 값이 비어 있으면 종료
        }

        // 추가적인 유효성 검사 (예: 숫자 형식 확인)
        try {
            Integer.parseInt(courseMaxStudents); // 최대 학생 수가 숫자인지 확인
            Integer.parseInt(courseCountStudents); // 등록된 학생 수가 숫자인지 확인
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "학생 수는 숫자여야 합니다.", "유효성 검사 오류", JOptionPane.ERROR_MESSAGE);
            return;  // 유효하지 않으면 종료
        }

        // 데이터 업데이트
        coursesFile = new JsonFile("course_data.json", "course_data.json");

        // addKeyAndValue 호출을 간소화하는 메서드 사용
        updateCourseData(coursesFile, courseName, courseUnit, courseMaxStudents, courseCountStudents, courseStatus, courseDescription);

        // 수정 완료 알림 메시지
        updateOpenCourseList(); // 테이블 갱신
        updateCloseCourseList(); // 테이블 갱신
        JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String courseName = courseNameFrame.getText();

        // 삭제 확인 메시지 표시
        int response = JOptionPane.showConfirmDialog(null, courseName + " 강의를 정말로 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // 데이터 업데이트
            coursesFile = new JsonFile("course_data.json", "course_data.json");

            // 삭제 작업 수행
            String deletedKey = coursesFile.deleteJsonObject("name", courseName);

            // 삭제 성공 여부 확인 후 알림 메시지 표시
            if (deletedKey != null) {
                // 삭제가 성공했을 경우
                JOptionPane.showMessageDialog(null, courseName + " 강의가 삭제되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);

                // 테이블 갱신
                updateOpenCourseList(); // 열린 수업 리스트 갱신
                updateCloseCourseList(); // 닫힌 수업 리스트 갱신
            } else {
                // 삭제 실패 시
                JOptionPane.showMessageDialog(null, "삭제에 실패했습니다. 다시 시도해 주세요.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // 삭제 취소 시
            JOptionPane.showMessageDialog(null, "삭제가 취소되었습니다.", "취소", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        // 내 정보 수정 버튼을 눌렀을 때 이벤트
        addCourseSystem addCourseSystemManagementScreen = new addCourseSystem();

        // 기존 창 기준으로 우측에 위치 설정
        addCourseSystemManagementScreen.setLocation(this.getX() + this.getWidth(), this.getY());

        // 새 창을 표시
        addCourseSystemManagementScreen.setVisible(true);
    }//GEN-LAST:event_addCourseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CourseManagerSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseManagerSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseManagerSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseManagerSystemForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseManagerSystemForManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseButton;
    private javax.swing.JTable closeCoursesListFrame;
    private javax.swing.JTextField courseCountStudentsFrame;
    private javax.swing.JTextArea courseDescriptionFrame;
    private javax.swing.JTextField courseMaxStudentsFrame;
    private javax.swing.JTextField courseNameFrame;
    private javax.swing.JTextField courseProfessorFrame;
    private javax.swing.JTextField courseProfessorIdFrame;
    private javax.swing.JComboBox<String> courseStatusFrame;
    private javax.swing.JLabel courseStatusFrameLable;
    private javax.swing.JTextField courseUnitFrame;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable openCoursesListFrame;
    private javax.swing.JPanel panel_courses;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
