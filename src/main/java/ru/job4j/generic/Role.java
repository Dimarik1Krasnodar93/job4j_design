package ru.job4j.generic;

public class Role extends Base {
    private final String roleMame;

    public Role(String id, String name) {
        super(id);
        this.roleMame = name;
    }

    public String getUsername() {
        return roleMame;
    }
}
