package data.courses;

public enum CourseData{

    Testing("Тестирование");

    private String name;
    CourseData(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
