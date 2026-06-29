package model;

public class User {

    private String id;
    private String password;
    private String name;
    private boolean admin;

    public User(String id, String password, String name, boolean admin) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "이름 : " + name +
                "\n아이디 : " + id;
    }
}