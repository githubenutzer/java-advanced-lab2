package labs.kpi.models;

import labs.kpi.annotations.*;

/**
 * Represents a user with username, password, and age.
 *
 * @author Oleksii Kyrychenko
 */
public class User {

    @NotNull
    private String username;

    @StringLength(min = 3, max = 20)
    private String password;

    @MinValue(18)
    @MaxValue(99)
    private Integer age;

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}