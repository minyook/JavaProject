/**
 * JsonFile.java
 * <p>
 * 설명:
 * - JsonFile 클래스는 JSON 파일을 로드, 읽기, 수정, 저장하는 기능을 편하게 사용하기  위해서 만들어진 클래스 입니다.
 * - JSON 데이터를 객체 형태로 관리하며, 중첩된 키에 대한 읽기 및 쓰기 작업을 지원합니다.
 * <p>
 * 작성자 정보:
 * - 작성자: oxxultus
 * - 작성일: 2024-11-26
 * <p>
 * 수정 정보:
 * - 수정자: oxxultus
 * - 수정일: 2024-11-26
 */
package schoolSystemManagement.course.management.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class JsonFile {

    // JSON 파일의 이름 (파일의 식별자 역할을 할 수 있음)
    private final String fileName;

    // JSON 파일의 경로 (실제 파일 위치)
    private final String filePath;

    // JSON 데이터를 담고 있는 JSONObject 인스턴스
    public JSONObject jsonObject;

    // @생성자
    public JsonFile(){
        this.fileName = "";
        this.filePath = "";
        this.jsonObject = null;
    }

    public JsonFile(JSONObject filteredObjects) {
        this.fileName = "";
        this.filePath = "";
        this.jsonObject = filteredObjects;
    }

    /*
      절대경로란?
      파일이나 디렉토리의 위치를 루트 디렉토리로부터 전체 경로로 나타냅니다.
      상대경로란?
      일이나 디렉토리의 위치를 현재 작업 디렉토리(CWD)를 기준으로 나타냅니다.
     */
    /**
     * JsonFile 생성자.
     * 파일 이름과 경로를 기반으로 JSON 데이터를 로드하여 객체에 저장합니다.
     *
     * @param fileName JSON 파일의 이름.
     * @param filePath JSON 파일의 절대 경로 또는 상대 경로.
     */
    public JsonFile(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
        loadJsonData(); // 객체 생성 시 JSON 파일 로드
    }

    // @Getter, @Setter
    /**
     * JSON 파일의 이름을 반환합니다.
     *
     * @return JSON 파일 이름.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * JSONObject 를 반환합니다.
     *
     * @return jsonObject 값.
     */
    public JSONObject getJsonObject() {
        return jsonObject;
    }

    /**
     * 파일의 경로를 반환합니다.
     *
     * @return JSON 파일 경로.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * JSON 파일의 내용을 변경합니다.
     */
    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }


    // @사용자 지정 메서드
    /**
     * JSON 데이터를 파일에서 읽어 JSONObject에 저장합니다.
     * 파일을 찾을 수 없거나 읽기 오류가 발생할 경우 빈 JSON 객체를 초기화합니다.
     */
    private void loadJsonData() {
        try (FileReader reader = new FileReader(filePath)) {
            // JSONTokener를 통해 JSON 파일 내용을 읽어와 JSONObject로 변환
            this.jsonObject = new JSONObject(new JSONTokener(reader));
        } catch (Exception e) {
            // Java에서 예외가 발생했을 때 해당 예외의 스택 추적(Stack Trace)을 콘솔에 출력하는 메서드입니다.
            e.printStackTrace();
            // 오류 발생 시 빈 JSON 객체로 초기화
            this.jsonObject = new JSONObject();
        }
    }

    /**
     * arrayKeyName 매개변수를 받는 메서드 (검색할 리스트가 배열이라면 이름을 지정해 검색 가능하다)
     * <p>
     * {@code public void setValueByStandardKey(String standardKey, String standardKeyValue, String targetKey, Object newValue)}
     * <p>
     * {@code public void setValueByStandardKey(String standardKey, String standardKeyValue, String targetKey, Object newValue, String arrayKeyName)}
     */
    private void updateUserByStandardKey(JSONObject jsonObject, String standardKey, String standardKeyValue, String targetKey, Object newValue, String arrayKeyName) {
        // targetKey를 '.' 기준으로 분리하여 경로를 생성
        String[] keys = targetKey.split("\\.");

        // JSON 객체의 모든 키 탐색 (예: user1, user2 등)
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키가 일치하는 경우 (예: userId가 S-027인 경우)
            if (userObject.getString(standardKey).equals(standardKeyValue)) {
                // 경로 탐색
                JSONObject currentObject = userObject;

                // 경로 탐색 시작
                for (int i = 0; i < keys.length - 1; i++) {
                    String currentKey = keys[i];

                    // "courseList"와 같은 배열을 다룰 때
                    if (currentKey.equals(arrayKeyName)) {
                        JSONArray courseList = currentObject.getJSONArray(currentKey);

                        // 배열 내부 탐색
                        for (int j = 0; j < courseList.length(); j++) {
                            JSONObject courseObject = courseList.getJSONObject(j);

                            // 마지막 키가 일치하면 해당 값 수정
                            if (courseObject.has(keys[i + 1])) {
                                System.out.println("Original " + keys[i + 1] + " in " + arrayKeyName + " for " + standardKey + ": " + courseObject.get(keys[i + 1]));

                                // 수정 로직: 값의 타입에 따라 처리
                                if (newValue instanceof Integer) {
                                    courseObject.put(keys[i + 1], newValue);
                                } else if (newValue instanceof Double) {
                                    courseObject.put(keys[i + 1], newValue);
                                } else if (newValue instanceof String) {
                                    courseObject.put(keys[i + 1], newValue);
                                } else {
                                    System.out.println("Unsupported data type for targetKey in " + arrayKeyName + ": " + keys[i + 1]);
                                }

                                System.out.println("Updated " + keys[i + 1] + " in " + arrayKeyName + " for " + standardKey + ": " + courseObject.get(keys[i + 1]));
                                return; // 수정 후 종료
                            }
                        }

                    } else if (currentObject.has(currentKey)) {
                        currentObject = currentObject.getJSONObject(currentKey);
                    } else {
                        // 경로에 해당하는 키가 없으면 종료
                        System.out.println("No matching " + currentKey + " found for " + standardKey + ": " + standardKeyValue);
                        return;
                    }
                }

                // 마지막 키가 일치하면 수정
                if (currentObject.has(keys[keys.length - 1])) {
                    System.out.println("Original " + keys[keys.length - 1] + " for " + standardKey + ": " + currentObject.get(keys[keys.length - 1]));

                    // 수정 로직: 값의 타입에 따라 처리
                    if (newValue instanceof Integer) {
                        currentObject.put(keys[keys.length - 1], newValue);
                    } else if (newValue instanceof Double) {
                        currentObject.put(keys[keys.length - 1], newValue);
                    } else if (newValue instanceof String) {
                        currentObject.put(keys[keys.length - 1], newValue);
                    } else {
                        System.out.println("Unsupported data type for targetKey: " + keys[keys.length - 1]);
                    }

                    System.out.println("Updated " + keys[keys.length - 1] + " for " + standardKey + ": " + currentObject.get(keys[keys.length - 1]));
                    return;
                }
            }
        }

        // 기준 키에 해당하는 값이 없는 경우
        System.out.println("No user found with " + standardKey + ": " + standardKeyValue);
    }

    /**
     * 기존의 과목 정보에 강의를 추가했을 때 과목에 대한 정보를 추가하기 위한 함수 입니다.
     * <p>
     * {@code public void addValueByCourse(String standardKey, String standardKeyValue, String arrayKeyName, String course, int score, int unit)}
     */
    private void updateValueByCourse(JSONObject jsonObject, String standardKey, String standardKeyValue, String arrayKeyName, String course, int score, int unit) {
        // JSON 객체의 모든 키 탐색 (예: user1, user2 등)
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키가 일치하는 경우 (예: userId가 S-027인 경우)
            if (userObject.getString(standardKey).equals(standardKeyValue)) {
                // arrayKeyName(예: "courseList")이 이미 존재하는지 확인
                if (userObject.has(arrayKeyName)) {
                    // 이미 존재하면 "courseList" 배열을 가져와서 새로운 값 추가
                    JSONArray courseList = userObject.getJSONArray(arrayKeyName);

                    // 새로운 객체 생성하여 배열에 추가
                    JSONObject newCourse = new JSONObject();
                    newCourse.put("course", course);
                    newCourse.put("score", score);
                    newCourse.put("unit", unit);

                    // 배열에 추가
                    courseList.put(newCourse);
                    System.out.println("Added new course to " + arrayKeyName + " for " + standardKey + ": " + newCourse);
                } else {
                    // "courseList"가 없다면 새로운 배열을 만들어서 추가
                    JSONArray courseList = new JSONArray();
                    JSONObject newCourse = new JSONObject();
                    newCourse.put("course", course);
                    newCourse.put("score", score);
                    newCourse.put("unit", unit);

                    // 배열에 추가
                    courseList.put(newCourse);

                    // 새로운 배열을 JSON 객체에 추가
                    userObject.put(arrayKeyName, courseList);
                    System.out.println("Created new " + arrayKeyName + " and added course for " + standardKey + ": " + newCourse);
                }
                return; // 업데이트가 완료되면 종료
            }
        }

        // 기준 키에 해당하는 값이 없으면
        System.out.println("No user found with " + standardKey + ": " + standardKeyValue);
    }

    /**
     * 현재 객체의 JSON 데이터를 원본 파일에 저장합니다.
     * 수정된 내용이 있을 경우 이 메서드를 호출하여 저장할 수 있습니다.
     */

    /**
     * JSON 객체를 업데이트하여 기준 키와 값으로 식별된 객체에 새로운 키-값 쌍을 추가하거나 수정합니다.
     *
     * @param jsonObject        수정할 JSON 객체.
     * @param standardKey       기준이 되는 키 이름 (예: "userId", "name").
     * @param standardKeyValue  기준 키의 값으로, 특정 객체를 식별하는 데 사용됩니다.
     * @param addKey            추가하거나 수정할 키 이름.
     * @param addKeyValue       추가하거나 수정할 키의 값.
     */
    private void updateKeyValueByStandardKey(JSONObject jsonObject, String standardKey, String standardKeyValue, String addKey, String addKeyValue) {
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키와 값이 일치하는 경우
            if (userObject.has(standardKey) && userObject.getString(standardKey).equals(standardKeyValue)) {
                // 키가 이미 존재하면 값을 수정, 존재하지 않으면 추가
                userObject.put(addKey, addKeyValue);
                return; // 작업 완료 후 종료
            }
        }
    }


    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            // JSON 데이터를 예쁘게 포맷팅(들여쓰기 포함)하여 파일에 작성
            writer.write(jsonObject.toString(4));
        } catch (Exception e) {
            // Java에서 예외가 발생했을 때 해당 예외의 스택 추적(Stack Trace)을 콘솔에 출력하는 메서드입니다.
            e.printStackTrace();
        }
    }

    /**
     * 특정 key:value 조건을 만족하는 모든 하위 JSON 객체를 반환합니다.
     *
     * @param key   찾고자 하는 키
     * @param value 키에 해당하는 값
     * @return 조건에 맞는 JSON 객체들이 포함된 JSONObject
     */
    public JSONObject getAllObjectsByKeyValue(String key, Object value) {
        JSONObject result = new JSONObject();

        for (String currentKey : jsonObject.keySet()) {
            Object currentValue = jsonObject.get(currentKey);

            // 하위 객체가 JSONObject일 경우 조건 확인
            if (currentValue instanceof JSONObject childObject) {
                if (childObject.has(key) && childObject.get(key).equals(value)) {
                    result.put(currentKey, childObject); // 조건에 맞는 객체 추가
                }
            }
        }

        return result; // 결과 반환
    }

    /**
     * 특정 기준 키를 기준으로 사용자 정보를 수정합니다.
     * arrayKeyName 기본값으로 "courseList"를 사용하는 메서드 (기본값 설정)
     *
     * @관련함수 updateUserByStandardKey()
     *
     * @param standardKey 기준 키의 이름 (예: "userId", "userKey" 등).
     * @param standardKeyValue 기준이 될 키의 값 (예: "S-027").
     * @param targetKey 수정할 키 (예: "name").
     * @param newValue 수정할 새로운 값 (예: "김영진", 30). int double String 지원.
     *
     * @부가설명 해당하는 파일의 key 값의 value 를 수정하기 위한 메서드 입니다.
     * @사용예시 jsonFile.setValueByStandardKey("userId", "S-027", "name", "홍길동");
     */
    public void setValueByStandardKey(String standardKey, String standardKeyValue, String targetKey, Object newValue) {
        System.out.println("파일 업데이트 전: " + this.jsonObject);  // 수정 전 상태 로그 출력
        updateUserByStandardKey(this.jsonObject, standardKey, standardKeyValue, targetKey, newValue, "courseList");

        // 수정 후 상태 출력 (디버깅 용도)
        System.out.println("파일 업데이트 후: " + this.jsonObject);

        // 수정된 내용을 파일에 저장
        saveToFile();
    }

    /**
     * 특정 기준 키를 기준으로 사용자 정보를 수정합니다.
     * arrayKeyName 을 직접  설정해서 사용하는 메서드
     *
     * @관련함수 updateUserByStandardKey()
     *
     * @param standardKey 기준 키의 이름 (예: "userId", "userKey" 등).
     * @param standardKeyValue 기준이 될 키의 값 (예: "S-027").
     * @param targetKey 수정할 키 (예: "name").
     * @param newValue 수정할 새로운 값 (예: "김영진", 30). int double String 지원.
     * @param arrayKeyName 검색 할 배열 키 이름
     *
     * @부가설명 courseList.score 방식으로 jsonArray 접근 가능합니다.
     * @사용예시 jsonFile.setValueByStandardKey("userId", "S-027", "courseList.score", 300, "courseList");
     * @deprecated
     */
    public void setValueByStandardKey(String standardKey, String standardKeyValue, String targetKey, Object newValue, String arrayKeyName) {
        System.out.println("파일 업데이트 전: " + this.jsonObject);  // 수정 전 상태 로그 출력
        updateUserByStandardKey(this.jsonObject, standardKey, standardKeyValue, targetKey, newValue, arrayKeyName);

        // 수정 후 상태 출력 (디버깅 용도)
        System.out.println("파일 업데이트 후: " + this.jsonObject);

        // 수정된 내용을 파일에 저장
        saveToFile();
    }


    /**
     * 성적의 정보를 수정하기 위해 값을 검색해서 수정할 수 있도록 도와주는 메서드 입니다.
     *
     * @관련함수 setCourseValue()
     *
     * @param standardKey 기준 키의 이름 (예: "userId", "userKey" 등).
     * @param standardKeyValue 기준이 될 키의 값 (예: "S-027").
     * @param targetArrayKey 수정할 JsonArray 키의 이름
     * @param targetKey 원하는 값을 찾기위한 JsonArray내의 키의 이름
     * @param targetValue 원하는 값을 찾기위한 JsonArray내의 키의 이름에 대한 값
     * @param arrayKeyName 해당 JsonArray 배열의 수정하고싶은 키의 이름
     * @param newValue 수정할 값
     *
     * @부가설명 교수가 학생의 성적의 정보를 수정할 때 사용하기 위한 함수 입니다.
     * @사용예시 jsonFile.setJsonArrayValue("userId", "S-027", "courseList", "course", "프로그래밍 실습", "score", 50);
     */
    public void setJsonArrayValue(String standardKey, String standardKeyValue, String targetArrayKey, String targetKey, String targetValue, String arrayKeyName, Object newValue) {
        // JSON 객체의 모든 키 탐색 (예: user1, user2 등)
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키가 일치하는 경우 (예: userId가 S-027인 경우)
            if (userObject.getString(standardKey).equals(standardKeyValue)) {

                // targetArrayKey (예: "courseList") 배열을 찾음
                if (userObject.has(targetArrayKey)) {
                    JSONArray courseList = userObject.getJSONArray(targetArrayKey);

                    // 배열 내에서 targetKey ("course") 값이 targetValue ("프로그래밍 실습")인 항목을 찾음
                    for (int i = 0; i < courseList.length(); i++) {
                        JSONObject courseObject = courseList.getJSONObject(i);

                        // targetKey ("course")의 값이 targetValue ("프로그래밍 실습")과 일치하는 항목 찾기
                        if (courseObject.getString(targetKey).equals(targetValue)) {
                            // 해당 항목의 arrayKeyName ("score") 값을 새로운 값으로 수정
                            courseObject.put(arrayKeyName, newValue);
                            System.out.println("Updated " + arrayKeyName + " for " + targetKey + " course: " + targetValue + " to " + newValue);

                            // 변경된 항목 출력 (디버깅)
                            System.out.println("Updated course: " + courseObject.toString());

                            // 수정된 내용을 파일에 저장
                            saveToFile();

                            return;  // 수정 후 종료
                        }
                    }
                }
            }
        }
        // 만약 기준 키에 해당하는 값이 없거나, 해당하는 targetKey 가 없으면 메시지 출력
        System.out.println("No user found with " + standardKey + ": " + standardKeyValue + " or course not found: " + targetValue);
    }

    /**
     * 특정 기준 키를 기준으로 사용자 정보를 수정합니다.
     * 주어진 기준에 맞는 사용자 객체를 찾아 `arrayKeyName` 배열 내에 새로운 강의 정보를 추가합니다.
     *
     * @관련함수 updateValueByCourse()
     *
     * @param standardKey 기준 키의 이름 (예: "userId", "userKey" 등).
     * @param standardKeyValue 기준이 될 키의 값 (예: "S-027").
     * @param arrayKeyName 배열의 키 이름 (예: "courseList").
     * @param course 추가할 강의의 이름 (예: "Data Structures").
     * @param score 추가할 강의의 점수 (예: 300).
     * @param unit 추가할 강의의 학점 (예: 4).
     *
     * @부가설명 Json 베열 값이 없다면 arrayKeyName 의 새로운 Json배열을 생성해서 추가합니다. 즉 강의 과목을 신청할 때 해당하는 과목을 신청정보에 추가하기 위한 함수입니다.
     * @사용예시 `jsonFile.updateValueByCourse(jsonObject, "userId", "S-027", "courseList", "Data Structures", 300, 4);`
     */
    public void addValueByCourse(String standardKey, String standardKeyValue, String arrayKeyName, String course, int score, int unit) {
        // 파일 업데이트 전 상태 출력 (디버깅용)
        System.out.println("파일 업데이트 전: " + this.jsonObject);

        // 과목 정보 업데이트 수행
        updateValueByCourse(this.jsonObject, standardKey, standardKeyValue, arrayKeyName, course, score, unit);

        // 파일 업데이트 후 상태 출력 (디버깅용)
        System.out.println("파일 업데이트 후: " + this.jsonObject);

        // 수정된 내용을 파일에 저장
        saveToFile();
    }


    /**
     * 기준 키를 기준으로 특정 사용자의 값을 반환합니다.
     *
     * @param standardKey 기준 키의 이름 (예: "userId", "userKey" 등).
     * @param standardKeyValue 기준이 될 키값 (예: "S-027").
     * @param targetKey 사용자 정보에서 가져올 키 (예: "name").
     * @return 해당 키에 해당하는 값.
     */
    public Object getUserValueByStandardKey(String standardKey, String standardKeyValue, String targetKey) {
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키가 일치하는 경우
            if (userObject.getString(standardKey).equals(standardKeyValue)) {
                // 해당 키에 해당하는 값을 반환
                return userObject.opt(targetKey);
            }
        }
        return null; // 해당 userId를 찾을 수 없으면 null 반환
    }

    /**
     * 특정 기준 키와 값에 맞는 JSON 객체에서 배열을 찾아, 해당 배열의 특정 키 값을 모두 반환합니다.
     *
     * @param standardKey 기준 키의 이름 (예: "userId", "userKey" 등).
     * @param standardKeyValue 기준이 될 키값 (예: "S-027").
     * @param targetArrayKey Json 배열의 키 이름 (예: "courseList").
     * @param targetKey Json 배열의 키의 값 (예: "course").
     * @return Object[] targetKey에 해당하는 값을 포함하는 배열 (예: "courseList" 배열 내의 "course" 값들).
     *                  반환되는 배열은 다양한 타입(int, double, String 등)을 처리할 수 있습니다.
     * @부가설명 현재 자신이 신청한 과목, 현재 자신이 신청 한 학점, 현재 자신의 과목 별 성적, 을 처리하기 위해 만들어진 함수 입니다.
     * @사용예시 Object[] courseValues = jsonFile.getAllJsonArrayValue("userId", "S-027", "courseList", "course");
     * @출력 for (Object value : courseValues) {System.out.println(value);}
     */
    public Object[] getAllJsonArrayValue(String standardKey, String standardKeyValue, String targetArrayKey, String targetKey) {
        // 결과를 담을 리스트 (Object 타입으로 선언하여 다양한 타입을 처리)
        List<Object> courseList = new ArrayList<>();

        // JSON 객체의 모든 키 탐색
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키가 일치하는 경우
            if (userObject.optString(standardKey).equals(standardKeyValue)) {

                // targetArrayKey 배열을 찾음
                JSONArray courses = userObject.optJSONArray(targetArrayKey);
                if (courses != null) {

                    // 배열 내에서 targetKey 값을 추출
                    for (int i = 0; i < courses.length(); i++) {
                        JSONObject courseObject = courses.optJSONObject(i);

                        if (courseObject != null && courseObject.has(targetKey)) {
                            // targetKey 값 추가
                            courseList.add(courseObject.get(targetKey));
                        }
                    }
                }
            }
        }

        // 결과가 없으면 빈 배열 반환
        return courseList.toArray(new Object[0]);
    }


    /**
     * JSON 객체에서 특정 기준 키와 값에 맞는 사용자 정보를 찾고, 해당 사용자의 배열 안에서 지정된 값을 반환합니다.
     *
     * @param standardKey 기준 키의 이름 (예: "userId").
     * @param standardKeyValue 기준 키의 값 (예: "P-092").
     * @param targetArrayKey 탐색할 배열의 키 이름 (예: "courseList").
     * @param targetKey 배열 항목의 키 이름 (예: "course").
     * @param targetValue 배열 항목에서 찾아야 할 값 (예: "비주얼프로그래밍").
     * @param arrayKeyName 반환할 값의 키 이름 (예: "unit").
     * @return 해당 값 (예: "unit" 값) 또는 해당 값이 없으면 null.
     *
     * @부가설명 원하는 사용자의 성적 정보에 접근해서 출력할때 사용하기 위한 메서드 입니다.
     * @사용예시 Object unitValue = jsonFile.getJsonArrayValue("userId", "P-092", "courseList", "course", "비주얼프로그래밍", "score");
     * @출력 System.out.println("Unit Value: " + unitValue);
     */
    public Object getJsonArrayValue(String standardKey, String standardKeyValue, String targetArrayKey, String targetKey, String targetValue, String arrayKeyName) {
        // JSON 객체의 모든 키 탐색 (예: user1, user2 등)
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // 기준 키가 일치하는 경우 (예: userId가 P-092인 경우)
            if (userObject.getString(standardKey).equals(standardKeyValue)) {

                // targetArrayKey (예: "courseList") 배열을 찾음
                if (userObject.has(targetArrayKey)) {
                    JSONArray courseList = userObject.getJSONArray(targetArrayKey);

                    // 배열 내에서 targetKey ("course") 값이 targetValue ("비주얼프로그래밍")인 항목을 찾음
                    for (int i = 0; i < courseList.length(); i++) {
                        JSONObject courseObject = courseList.getJSONObject(i);

                        // targetKey ("course")의 값이 targetValue ("비주얼프로그래밍")과 일치하는 항목 찾기
                        if (courseObject.getString(targetKey).equals(targetValue)) {
                            // 해당 항목의 arrayKeyName ("unit") 값을 반환
                            return courseObject.get(arrayKeyName);
                        }
                    }
                }
            }
        }

        // 값이 없으면 null 반환
        return null;
    }

    /**
     * 특정 배열의 내부 요소 조건에 따라 JSON 객체 전체를 반환합니다.
     *
     * @param targetArrayKey JSON 배열의 키 이름 (예: "courseList").
     * @param targetKey 배열 내부 요소의 키 이름 (예: "course").
     * @param targetKeyValue 배열 내부 요소에서 찾을 값 (예: "Math101").
     * @return Object[] 조건을 만족하는 JSON 객체 배열.
     */
    public Object[] getAllJsonObjectWhereTargetKeyValue(String targetArrayKey, String targetKey, String targetKeyValue) {
        // 조건을 만족하는 JSON 객체를 담을 리스트
        List<JSONObject> matchingObjects = new ArrayList<>();

        // JSON 객체의 모든 키 탐색
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // targetArrayKey 배열 탐색
            JSONArray courses = userObject.optJSONArray(targetArrayKey);
            if (courses != null) {
                // 배열의 요소를 탐색
                for (int i = 0; i < courses.length(); i++) {
                    JSONObject courseObject = courses.optJSONObject(i);

                    // 조건을 만족하는 경우
                    if (courseObject != null && targetKeyValue.equals(courseObject.optString(targetKey))) {
                        matchingObjects.add(userObject);
                        break; // 조건을 만족하면 현재 객체를 추가하고 루프 종료
                    }
                }
            }
        }

        // 결과 반환
        return matchingObjects.toArray(new Object[0]);
    }


    /**
     * 특정 배열의 내부 요소 중 targetKey의 값이 하나라도 존재하는 모든 JSON 객체를 반환합니다.
     *
     * @param targetArrayKey JSON 배열의 키 이름 (예: "courseList").
     * @param targetKey 배열 내부 요소의 키 이름 (예: "course").
     * @return Object[] targetKey의 값이 하나라도 존재하는 JSON 객체 배열.
     */
    public Object[] getAllJsonObjectWhereTargetKeyExists(String targetArrayKey, String targetKey) {
        // 조건을 만족하는 JSON 객체를 담을 리스트
        List<JSONObject> matchingObjects = new ArrayList<>();

        // JSON 객체의 모든 키 탐색
        for (String key : jsonObject.keySet()) {
            JSONObject userObject = jsonObject.getJSONObject(key);

            // targetArrayKey 배열 탐색
            JSONArray courses = userObject.optJSONArray(targetArrayKey);
            if (courses != null) {
                // 배열의 요소를 탐색
                for (int i = 0; i < courses.length(); i++) {
                    JSONObject courseObject = courses.optJSONObject(i);

                    // targetKey가 존재하고 값이 null 또는 빈 문자열이 아닌 경우
                    if (courseObject != null && courseObject.has(targetKey) && !courseObject.optString(targetKey).isEmpty()) {
                        matchingObjects.add(userObject);
                        break; // 조건을 만족하면 현재 객체를 추가하고 루프 종료
                    }
                }
            }
        }

        // 결과 반환
        return matchingObjects.toArray(new Object[0]);
    }

    /**
     * JSON 객체에서 기준 키와 값을 사용하여 해당 객체에 새로운 키-값 쌍을 추가하거나 수정합니다.
     *
     * @param standardKey       기준이 되는 키 이름 (예: "userId", "name").
     * @param standardKeyValue  기준 키의 값으로, 특정 객체를 식별하는 데 사용됩니다.
     * @param addKey            추가하거나 수정할 키 이름.
     * @param addKeyValue       추가하거나 수정할 키의 값.
     */
    public void addKeyAndValue(String standardKey, String standardKeyValue, String addKey, String addKeyValue) {
        // 파일 업데이트 전 상태 출력 (디버깅용)
        System.out.println("파일 업데이트 전: " + this.jsonObject);

        // 기준 키와 값을 사용해 키-값 추가 또는 수정
        updateKeyValueByStandardKey(this.jsonObject, standardKey, standardKeyValue, addKey, addKeyValue);

        // 파일 업데이트 후 상태 출력 (디버깅용)
        System.out.println("파일 업데이트 후: " + this.jsonObject);

        // 수정된 내용을 파일에 저장
        saveToFile();
    }


    public void addValueByCourse(String userId, String p092, String courseList, JTextArea courseName, int i, JTextArea courseUnit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/* 사용 예시 */
/*
*
* //JsonFile 객체 생성 (data.json 파일을 로드)
* JsonFile jsonFile = new JsonFile("data.json", "src/data.json");
*
* // 'userId':'S-027'을 가지는 객체 중 'age' 값
* System.out.println("'userId':'S-027'을 가지는 객체 중 'age' 의 값: " + jsonFile.getUserValueByStandardKey("userId", "S-027", "age"));
*
* // 'userId':'S-027'을 가지는 객체 중 'age' 값 30 으로 수정
* jsonFile.setValueByStandardKey("userId", "S-027", "age", 30);
*
* // 수정 후 S-027의 'name' 값을 출력 (age 만 수정되었지만 전체 JSON 객체를 다시 출력)
* System.out.println("Updated name for S-027: " + jsonFile.getUserValueByStandardKey("userId","S-027",  "name"));
*
*/