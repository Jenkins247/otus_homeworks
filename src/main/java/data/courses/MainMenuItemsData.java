package data.courses;

public enum MainMenuItemsData {
    Courses("Курсы");

    private String name;

    MainMenuItemsData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
