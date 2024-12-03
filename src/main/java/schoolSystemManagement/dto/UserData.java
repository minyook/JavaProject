package schoolSystemManagement.dto;

public class UserData {
    // 사용자의 이름
    private String name;

    //사용자의 아이디
    private String userId;

    // 사용자의 비밀번호
    private String number;

    // 사용자의 학과
    private String major;

    // 사용자의 분류
    private String userType;

    // 사용자의 학번
    private String studentNumber;

    /**
     * 생성자 입니다.
     * @param name 이름
     * @param userId 사용자 ID
     * @param userType 사용자 유형
     */
    public UserData(String name, String userId, String userType) {
        this.name = name;
        this.userId = userId;
        this.userType = userType;
    }

    /**
     * 생성자 입니다.
     * @param name 이름
     * @param userId 사용자 ID
     * @param number 번호
     * @param major 전공
     */
    public UserData(String name, String userId, String number, String major) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
    }

    /**
     * 생성자 입니다.
     * @param name 이름
     * @param userId 사용자 ID
     * @param number 번호
     * @param major 전공
     * @param userType 사용자 유형
     */
    public UserData(String name, String userId, String number, String major, String userType) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
        this.userType = userType;
    }

    /**
     * 생성자 입니다.
     * @param name 이름
     * @param userId 사용자 ID
     * @param number 번호
     * @param major 전공
     * @param userType 사용자 유형
     * @param studentNumber 학생 번호
     */
    public UserData(String name, String userId, String number, String major, String userType, String studentNumber) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
        this.userType = userType;
        this.studentNumber = studentNumber;
    }

    // @gettor
    public String getNumber() {
        return number;
    }
    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public String getMajor(){
        return major;
    }
    public String getUserType(){ return userType; }
    public String getStudentNumber(){ return studentNumber; }

}
