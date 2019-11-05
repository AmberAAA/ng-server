package top.anborong.server.utils;

public enum SystemEnums {
    CURRENT_USER(0, "CURRENT_USER"),
    CURRENT_USER_ID(1, "CURRENT_USER_ID"),
    ACCESS_TOKEN(2, "ACCESS_TOKEN");

    private int id;
    private String name;

    SystemEnums (int id, String name) {
        this.id = id;
        this.name= name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
