package schoolSystemManagement.course.management.dto;

public class UserData {

    private String name;
    private String userId;
    private String number;
    private String major;

    public UserData(String name, String userId, String number, String major) {
        this.name = name;
        this.userId = userId;
        this.number = number;
        this.major = major;
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

}
