package ua.zakharov.app.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    private Long id;
    @Pattern(regexp = "[A-Za-z0-9]{6,}",
            message = "The login has to have at least 6 English symbols")
    private String username;
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}",
            message = "The password has to have more 6 symbols, has at least 1 uppercase letter and special character")
    private String password;
    @NotBlank(message = "Your name can't have whitespace")
    @Size(min = 3, message = "Your name has to have more 3 character")
    private String name;

    public User(){}

    public User(Long id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
