package schoolSystemManagement.dto;

public class UserData {

    private String name;
    private String userId;
    private String number;
    private String major;
    private String userType;
    private String studentNumber;

    public UserData(String name, String userId, String number, String major) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
    }
    public UserData(String name, String userId, String number, String major, String userType) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
        this.userType = userType;
    }
    public UserData(String name, String userId, String number, String major, String userType, String studentNumber) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
        this.userType = userType;
        this.studentNumber = studentNumber;
    }

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
