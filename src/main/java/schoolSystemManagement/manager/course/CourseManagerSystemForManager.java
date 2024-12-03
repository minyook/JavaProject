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

/**
 * 강의 관리를 위한 프레임 입니다.
 *
 * @author 주정현
 * @version 1.0
 * @since 2024-12-03
 */
public class CourseManagerSystemForManager extends javax.swing.JFrame {

    // 전체적으로 사용하기 위해 파일을 불러오는 부분입니다.
    JsonFile usersFile = new JsonFile("user_data.json", "user_data.json");
    JsonFile coursesFile = new JsonFile("course_data.json", "course_data.json");

    // 개설 된 강의 리스트를 업데이트 하기 위한 메서드 입니다.
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
            closeCoursesTable.setModel(tableModel);
        } else {
            // 필터링된 객체가 비어 있을 경우 테이블에 아무것도 추가하지 않음
            // 공백 상태로 유지
            DefaultTableModel emptyModel = new DefaultTableModel();
            closeCoursesTable.setModel(emptyModel);
        }

    }

    // 개설 되지 않은 강의 리스트를 업데이트 하기 위한 메서드 입니다.
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
            openCoursesTable.setModel(tableModel);
        } else {
            // 필터링된 객체가 비어 있을 경우 테이블에 아무것도 추가하지 않음
            // 공백 상태로 유지
            DefaultTableModel emptyModel = new DefaultTableModel();
            openCoursesTable.setModel(emptyModel);
        }

    }

    // addKeyAndValue 중복 코드 제거를 위한 메서드 입니다.
    private void updateCourseData(JsonFile coursesFile, String courseName, String courseUnit, String courseMaxStudents,
                                  String courseCountStudents, String courseStatus, String courseDescription) {
        coursesFile.addKeyAndValue("name", courseName, "unit", courseUnit);
        coursesFile.addKeyAndValue("name", courseName, "maxStudents", courseMaxStudents);
        coursesFile.addKeyAndValue("name", courseName, "countStudents", courseCountStudents);
        coursesFile.addKeyAndValue("name", courseName, "status", courseStatus);
        coursesFile.addKeyAndValue("name", courseName, "description", courseDescription);
    }

    /**
     * 기본 생성자 입니다
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

        mainPanel = new javax.swing.JPanel();
        openCoursesTableScrollPane = new javax.swing.JScrollPane();
        openCoursesTable = new javax.swing.JTable();
        closeCoursesTableScrollPane = new javax.swing.JScrollPane();
        closeCoursesTable = new javax.swing.JTable();
        openCoursesLabel = new javax.swing.JLabel();
        closeCoursesLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        courseStatusLabel = new javax.swing.JLabel();
        courseCountStudentsTextField = new javax.swing.JTextField();
        courseCountStudentsLabel = new javax.swing.JLabel();
        courseMaxStudentsLabel = new javax.swing.JLabel();
        courseMaxStudentsTextField = new javax.swing.JTextField();
        courseUnitLabel = new javax.swing.JLabel();
        courseUnitTextField = new javax.swing.JTextField();
        courseProfessorIdLabel = new javax.swing.JLabel();
        courseProfessorIdTextField = new javax.swing.JTextField();
        courseProfessorLabel = new javax.swing.JLabel();
        courseProfessorTextField = new javax.swing.JTextField();
        courseNameLabel = new javax.swing.JLabel();
        courseNameTextField = new javax.swing.JTextField();
        courseDescriptionLabel = new javax.swing.JLabel();
        courseDescriptionScrollPane = new javax.swing.JScrollPane();
        courseDescriptionTextArea = new javax.swing.JTextArea();
        addCourseButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        courseStatusComboBox = new javax.swing.JComboBox<>();
        reloadButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        openCoursesTable.setBackground(new java.awt.Color(255, 255, 255));
        openCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        openCoursesTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                openCoursesTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        openCoursesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openCoursesTableMouseClicked(evt);
            }
        });
        openCoursesTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                openCoursesTablePropertyChange(evt);
            }
        });
        openCoursesTableScrollPane.setViewportView(openCoursesTable);

        closeCoursesTable.setBackground(new java.awt.Color(255, 255, 255));
        closeCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        closeCoursesTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                closeCoursesTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        closeCoursesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeCoursesTableMouseClicked(evt);
            }
        });
        closeCoursesTableScrollPane.setViewportView(closeCoursesTable);

        openCoursesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openCoursesLabel.setText("개설 된 강의 리스트");

        closeCoursesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeCoursesLabel.setText("개설 되지 않은 강의 리스트");

        saveButton.setBackground(new java.awt.Color(255, 255, 255));
        saveButton.setText("수정");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                saveButtonAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        courseStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseStatusLabel.setText("개설 여부");

        courseCountStudentsTextField.setBackground(new java.awt.Color(255, 255, 255));
        courseCountStudentsTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseCountStudentsTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        courseCountStudentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseCountStudentsLabel.setText("현재 수강생 수");

        courseMaxStudentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseMaxStudentsLabel.setText("최대 수강생 수");

        courseMaxStudentsTextField.setBackground(new java.awt.Color(255, 255, 255));
        courseMaxStudentsTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseMaxStudentsTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        courseUnitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseUnitLabel.setText("학점");

        courseUnitTextField.setBackground(new java.awt.Color(255, 255, 255));
        courseUnitTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseUnitTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        courseUnitTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseUnitTextFieldActionPerformed(evt);
            }
        });

        courseProfessorIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseProfessorIdLabel.setText("담당 교수 아이디");

        courseProfessorIdTextField.setBackground(new java.awt.Color(255, 255, 255));
        courseProfessorIdTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseProfessorIdTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        courseProfessorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseProfessorLabel.setText("담당 교수");

        courseProfessorTextField.setBackground(new java.awt.Color(255, 255, 255));
        courseProfessorTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseProfessorTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        courseNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseNameLabel.setText("강의 이름");

        courseNameTextField.setBackground(new java.awt.Color(255, 255, 255));
        courseNameTextField.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseNameTextFieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        courseDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseDescriptionLabel.setText("강의 설명");

        courseDescriptionTextArea.setBackground(new java.awt.Color(255, 255, 255));
        courseDescriptionTextArea.setColumns(20);
        courseDescriptionTextArea.setRows(5);
        courseDescriptionTextArea.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseDescriptionTextAreaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        courseDescriptionScrollPane.setViewportView(courseDescriptionTextArea);

        addCourseButton.setBackground(new java.awt.Color(255, 255, 255));
        addCourseButton.setText("강의 추가");
        addCourseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("HY견고딕", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("강의 관리");
        titleLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        courseStatusComboBox.setBackground(new java.awt.Color(255, 255, 255));
        courseStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        courseStatusComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                courseStatusComboBoxAncestorAdded(evt);
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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(closeCoursesTableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                            .addComponent(openCoursesTableScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeCoursesLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openCoursesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(reloadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseDescriptionScrollPane)
                            .addComponent(courseProfessorIdTextField)
                            .addComponent(courseProfessorTextField)
                            .addComponent(courseNameTextField)
                            .addComponent(courseNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseProfessorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseProfessorIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(courseStatusComboBox, 0, 241, Short.MAX_VALUE)
                                        .addComponent(courseCountStudentsTextField)
                                        .addComponent(courseMaxStudentsTextField)
                                        .addComponent(courseUnitTextField)
                                        .addComponent(courseMaxStudentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(courseCountStudentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(courseUnitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseStatusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(openCoursesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openCoursesTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeCoursesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeCoursesTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(courseNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseProfessorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseProfessorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseProfessorIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseProfessorIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseUnitLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseUnitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseMaxStudentsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseMaxStudentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseCountStudentsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseCountStudentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseStatusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(courseStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseDescriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseDescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void openCoursesTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_openCoursesTableAncestorAdded
        updateOpenCourseList();
    }//GEN-LAST:event_openCoursesTableAncestorAdded

    private void closeCoursesTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_closeCoursesTableAncestorAdded
        updateCloseCourseList();
    }//GEN-LAST:event_closeCoursesTableAncestorAdded

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        updateOpenCourseList();
        updateCloseCourseList();
        JOptionPane.showMessageDialog(this, "정상적으로 데이터가 다시 로드 되었습니다.");
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void closeCoursesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeCoursesTableMouseClicked
        // 열려있지 않은 강의를 마우스 클릭했을 때 실행되는 이벤트 핸들러

        // 선택된 행의 인덱스를 가져옵니다.
        // 사용자가 클릭한 강의가 위치한 테이블의 행 번호를 반환합니다.
        // -1일 경우, 아무것도 선택되지 않은 상태임을 의미합니다.
        int selectedRow = closeCoursesTable.getSelectedRow();

        if (selectedRow != -1) { // 선택된 행이 있을 경우에만 실행
            // 테이블의 모델을 가져옵니다.
            // 선택된 행에서 데이터를 읽기 위해 DefaultTableModel 객체를 사용합니다.
            DefaultTableModel model = (DefaultTableModel) closeCoursesTable.getModel();

            // 선택된 행의 각 열 데이터를 가져옵니다.
            // 강의 이름, 교수 이름, 교수 ID, 최대 학생 수, 학점 수를 문자열로 추출합니다.
            String courseNameValue = model.getValueAt(selectedRow, 0).toString(); // 강의 이름
            String professorNameValue = model.getValueAt(selectedRow, 1).toString(); // 교수 이름
            String professorIdValue = model.getValueAt(selectedRow, 2).toString(); // 교수 ID
            String maxStudents = model.getValueAt(selectedRow, 3).toString(); // 최대 학생 수
            String courseUnitValue = model.getValueAt(selectedRow, 4).toString(); // 학점

            // 추출한 데이터를 텍스트 필드에 채웁니다.
            courseNameTextField.setText(courseNameValue); // 강의 이름 텍스트 필드
            courseProfessorTextField.setText(professorNameValue); // 교수 이름 텍스트 필드
            courseProfessorIdTextField.setText(professorIdValue); // 교수 ID 텍스트 필드
            courseUnitTextField.setText(courseUnitValue); // 학점 텍스트 필드
            courseMaxStudentsTextField.setText(maxStudents); // 최대 학생 수 텍스트 필드

            // 추가 데이터를 파일에서 가져와 텍스트 필드 또는 콤보박스에 설정
            // 현재 학생 수, 상태, 강의 설명을 각각 설정합니다.
            courseCountStudentsTextField.setText(
                    coursesFile.getUserValueByStandardKey("name", courseNameValue, "countStudents").toString()
            );
            courseStatusComboBox.setSelectedItem(
                    coursesFile.getUserValueByStandardKey("name", courseNameValue, "status").toString()
            );
            courseDescriptionTextArea.setText(
                    coursesFile.getUserValueByStandardKey("name", courseNameValue, "description").toString()
            );
        }

        // 필드와 UI 요소의 활성화 상태 설정
        // 일부 필드들은 편집 불가능하도록 설정하고, 나머지는 활성화합니다.
        courseNameTextField.setEnabled(false); // 강의 이름은 수정 불가
        courseProfessorTextField.setEnabled(false); // 교수 이름은 수정 불가
        courseProfessorIdTextField.setEnabled(false); // 교수 ID는 수정 불가
        courseUnitTextField.setEnabled(true); // 학점은 수정 가능
        courseMaxStudentsTextField.setEnabled(true); // 최대 학생 수는 수정 가능
        courseCountStudentsTextField.setEnabled(true); // 현재 학생 수는 수정 가능
        courseStatusComboBox.setEnabled(true); // 상태 변경 가능
        courseDescriptionTextArea.setEnabled(true); // 강의 설명 변경 가능

        // 저장 및 삭제 버튼 활성화
        saveButton.setEnabled(true); // 저장 버튼 활성화
        deleteButton.setEnabled(true); // 삭제 버튼 활성화

    }//GEN-LAST:event_closeCoursesTableMouseClicked

    private void courseUnitTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseUnitTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseUnitTextFieldActionPerformed

    private void courseStatusComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseStatusComboBoxAncestorAdded
        // 기존 내용 초기화
        courseStatusComboBox.removeAllItems();

        // 콤보박스에 true와 false 값 추가
        courseStatusComboBox.addItem("true");
        courseStatusComboBox.addItem("false");

        // 기본값을 "true"로 설정
        courseStatusComboBox.setSelectedItem("false");
        
        // 상태 변경 불가능
        courseStatusComboBox.setEnabled(false);
    }//GEN-LAST:event_courseStatusComboBoxAncestorAdded

    private void courseNameTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseNameTextFieldAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseNameTextField.setEnabled(false);
    }//GEN-LAST:event_courseNameTextFieldAncestorAdded

    private void courseProfessorTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseProfessorTextFieldAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseProfessorTextField.setEnabled(false);
    }//GEN-LAST:event_courseProfessorTextFieldAncestorAdded

    private void courseProfessorIdTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseProfessorIdTextFieldAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseProfessorIdTextField.setEnabled(false);
    }//GEN-LAST:event_courseProfessorIdTextFieldAncestorAdded

    private void courseUnitTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseUnitTextFieldAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseUnitTextField.setEnabled(false);
    }//GEN-LAST:event_courseUnitTextFieldAncestorAdded

    private void courseMaxStudentsTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseMaxStudentsTextFieldAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseMaxStudentsTextField.setEnabled(false);
    }//GEN-LAST:event_courseMaxStudentsTextFieldAncestorAdded

    private void courseCountStudentsTextFieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseCountStudentsTextFieldAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseCountStudentsTextField.setEnabled(false);
    }//GEN-LAST:event_courseCountStudentsTextFieldAncestorAdded

    private void courseDescriptionTextAreaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_courseDescriptionTextAreaAncestorAdded
        // 기본적으로 상태 변경 불가능
        courseDescriptionTextArea.setEnabled(false);
    }//GEN-LAST:event_courseDescriptionTextAreaAncestorAdded

    private void openCoursesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCoursesTableMouseClicked
        // 열린 강의를 마우스 클릭했을 때 실행되는 이벤트 핸들러

        // 선택된 행의 인덱스를 가져옵니다.
        // 사용자가 클릭한 강의가 위치한 테이블의 행 번호를 반환합니다.
        // -1일 경우, 아무것도 선택되지 않은 상태임을 의미합니다.
        int selectedRow = openCoursesTable.getSelectedRow();

        if (selectedRow != -1) { // 선택된 행이 있을 경우에만 실행
            // 테이블의 모델을 가져옵니다.
            // 선택된 행에서 데이터를 읽기 위해 DefaultTableModel 객체를 사용합니다.
            DefaultTableModel model = (DefaultTableModel) openCoursesTable.getModel();

            // 선택된 행의 각 열 데이터를 가져옵니다.
            // 강의 이름, 교수 이름, 교수 ID, 최대 학생 수, 학점 수를 문자열로 추출합니다.
            String courseNameValue = model.getValueAt(selectedRow, 0).toString(); // 강의 이름
            String professorNameValue = model.getValueAt(selectedRow, 1).toString(); // 교수 이름
            String professorIdValue = model.getValueAt(selectedRow, 2).toString(); // 교수 ID
            String maxStudents = model.getValueAt(selectedRow, 3).toString(); // 최대 학생 수
            String courseUnitValue = model.getValueAt(selectedRow, 4).toString(); // 학점

            // 추출한 데이터를 텍스트 필드에 채웁니다.
            courseNameTextField.setText(courseNameValue); // 강의 이름 텍스트 필드
            courseProfessorTextField.setText(professorNameValue); // 교수 이름 텍스트 필드
            courseProfessorIdTextField.setText(professorIdValue); // 교수 ID 텍스트 필드
            courseUnitTextField.setText(courseUnitValue); // 학점 텍스트 필드
            courseMaxStudentsTextField.setText(maxStudents); // 최대 학생 수 텍스트 필드

            // 추가 데이터를 파일에서 가져와 텍스트 필드 또는 콤보박스에 설정
            // 현재 학생 수, 상태, 강의 설명을 각각 설정합니다.
            courseCountStudentsTextField.setText(
                    coursesFile.getUserValueByStandardKey("name", courseNameValue, "countStudents").toString()
            );
            courseStatusComboBox.setSelectedItem(
                    coursesFile.getUserValueByStandardKey("name", courseNameValue, "status").toString()
            );
            courseDescriptionTextArea.setText(
                    coursesFile.getUserValueByStandardKey("name", courseNameValue, "description").toString()
            );
        }

        // 필드와 UI 요소의 활성화 상태 설정
        // 열린 강의의 경우 대부분 필드가 비활성화되어 편집할 수 없도록 설정합니다.
        courseNameTextField.setEnabled(false); // 강의 이름은 수정 불가
        courseProfessorTextField.setEnabled(false); // 교수 이름은 수정 불가
        courseProfessorIdTextField.setEnabled(false); // 교수 ID는 수정 불가
        courseUnitTextField.setEnabled(false); // 학점은 수정 불가
        courseMaxStudentsTextField.setEnabled(false); // 최대 학생 수는 수정 불가
        courseCountStudentsTextField.setEnabled(false); // 현재 학생 수는 수정 불가
        courseStatusComboBox.setEnabled(true); // 상태 변경 가능
        courseDescriptionTextArea.setEnabled(false); // 강의 설명은 수정 불가

        // 버튼 활성화 상태 설정
        saveButton.setEnabled(true); // 저장 버튼 활성화
        deleteButton.setEnabled(false); // 삭제 버튼 비활성화

    }//GEN-LAST:event_openCoursesTableMouseClicked

    private void openCoursesTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_openCoursesTablePropertyChange
        
    }//GEN-LAST:event_openCoursesTablePropertyChange

    private void saveButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_saveButtonAncestorAdded
        saveButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonAncestorAdded

    private void deleteButtonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_deleteButtonAncestorAdded
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_deleteButtonAncestorAdded

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        // 각 UI 컴포넌트에서 입력된 값을 읽어와 변수에 저장합니다.
        String courseName = courseNameTextField.getText(); // 강의 이름
        String courseProfessor = courseProfessorTextField.getText(); // 교수 이름
        String courseProfessorId = courseProfessorIdTextField.getText(); // 교수 ID
        String courseUnit = courseUnitTextField.getText(); // 학점
        String courseMaxStudents = courseMaxStudentsTextField.getText(); // 최대 학생 수
        String courseCountStudents = courseCountStudentsTextField.getText(); // 등록된 학생 수
        String courseStatus = courseStatusComboBox.getSelectedItem().toString(); // 상태
        String courseDescription = courseDescriptionTextArea.getText(); // 강의 설명

        // 필수 입력값 검증
        // 필드 중 하나라도 비어 있으면 경고 메시지를 표시하고 작업을 중단합니다.
        if (courseName.isEmpty() || courseProfessor.isEmpty() || courseProfessorId.isEmpty() ||
                courseUnit.isEmpty() || courseMaxStudents.isEmpty() || courseCountStudents.isEmpty() ||
                courseStatus.isEmpty() || courseDescription.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "모든 필드를 채워야 합니다.",
                    "경고",
                    JOptionPane.WARNING_MESSAGE
            );
            return; // 값이 비어 있으면 메서드 실행 종료
        }

        // 숫자 유효성 검사
        // 학생 수 관련 필드가 숫자로 입력되었는지 확인합니다.
        try {
            Integer.parseInt(courseMaxStudents); // 최대 학생 수가 숫자인지 확인
            Integer.parseInt(courseCountStudents); // 등록된 학생 수가 숫자인지 확인
        } catch (NumberFormatException e) {
            // 숫자가 아닌 경우 경고 메시지를 표시하고 작업을 중단합니다.
            JOptionPane.showMessageDialog(
                    null,
                    "학생 수는 숫자여야 합니다.",
                    "유효성 검사 오류",
                    JOptionPane.ERROR_MESSAGE
            );
            return; // 유효하지 않으면 메서드 실행 종료
        }

        // 데이터 업데이트
        // JSON 파일을 로드하고 강의 데이터를 업데이트합니다.
        coursesFile = new JsonFile("course_data.json", "course_data.json"); // JSON 파일 경로

        // 강의 데이터를 업데이트하는 별도의 메서드를 호출하여 코드 재사용성을 높임
        updateCourseData(
                coursesFile,
                courseName,
                courseUnit,
                courseMaxStudents,
                courseCountStudents,
                courseStatus,
                courseDescription
        );

        // 수정 완료 후 UI 갱신
        // 열린 강의와 닫힌 강의 테이블을 갱신합니다.
        updateOpenCourseList(); // 열린 강의 목록 테이블 업데이트
        updateCloseCourseList(); // 닫힌 강의 목록 테이블 업데이트

        // 수정 완료 메시지
        JOptionPane.showMessageDialog(
                null,
                "수정이 완료되었습니다.",
                "알림",
                JOptionPane.INFORMATION_MESSAGE
        );

    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // 삭제 버튼 클릭시 이벤트
        String courseName = courseNameTextField.getText();

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
    private javax.swing.JLabel closeCoursesLabel;
    private javax.swing.JTable closeCoursesTable;
    private javax.swing.JScrollPane closeCoursesTableScrollPane;
    private javax.swing.JLabel courseCountStudentsLabel;
    private javax.swing.JTextField courseCountStudentsTextField;
    private javax.swing.JLabel courseDescriptionLabel;
    private javax.swing.JScrollPane courseDescriptionScrollPane;
    private javax.swing.JTextArea courseDescriptionTextArea;
    private javax.swing.JLabel courseMaxStudentsLabel;
    private javax.swing.JTextField courseMaxStudentsTextField;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JTextField courseNameTextField;
    private javax.swing.JLabel courseProfessorIdLabel;
    private javax.swing.JTextField courseProfessorIdTextField;
    private javax.swing.JLabel courseProfessorLabel;
    private javax.swing.JTextField courseProfessorTextField;
    private javax.swing.JComboBox<String> courseStatusComboBox;
    private javax.swing.JLabel courseStatusLabel;
    private javax.swing.JLabel courseUnitLabel;
    private javax.swing.JTextField courseUnitTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel openCoursesLabel;
    private javax.swing.JTable openCoursesTable;
    private javax.swing.JScrollPane openCoursesTableScrollPane;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
