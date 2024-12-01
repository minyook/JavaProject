package schoolSystemManagement.course.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame {

    public TestFrame() {
        setTitle("Main Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // 버튼 생성
        JButton managerButton = new JButton("Manager");
        JButton professorButton = new JButton("Professor");
        JButton studentButton = new JButton("Student");

        // 버튼에 액션 리스너 추가
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Manager 프레임을 메인 프레임 옆에 띄우기
                ChargeTuitionFeeSystemForManager managerFrame = new ChargeTuitionFeeSystemForManager("김영진", "S-027");
                positionNextTo(managerFrame);
                managerFrame.setVisible(true);
            }
        });

        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Professor 프레임을 메인 프레임 옆에 띄우기
                CourseManagementSystemForProfessor professorFrame = new CourseManagementSystemForProfessor("이선권", "P-092");
                positionNextTo(professorFrame);
                professorFrame.setVisible(true);
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Student 프레임을 메인 프레임 옆에 띄우기
                CourseManagementSystemForStudents studentFrame = new CourseManagementSystemForStudents("임민욱", "S-027");
                positionNextTo(studentFrame);
                studentFrame.setVisible(true);
            }
        });

        // 프레임에 버튼 추가
        add(managerButton);
        add(professorButton);
        add(studentButton);

        setVisible(true);
    }

    /**
     * 새 창을 메인 프레임의 오른쪽 옆에 위치시킴
     */
    private void positionNextTo(JFrame frame) {
        // 현재 프레임(MainFrame)의 위치와 크기 가져오기
        Point mainFrameLocation = getLocation();
        Dimension mainFrameSize = getSize();

        // 새 창의 위치 계산
        int newX = mainFrameLocation.x + mainFrameSize.width + 10; // 오른쪽 옆으로 10px 띄움
        int newY = mainFrameLocation.y; // Y 좌표는 동일하게 설정

        // 새 창 위치 설정
        frame.setLocation(newX, newY);
    }

    public static void main(String[] args) {
        new TestFrame();
    }
}
