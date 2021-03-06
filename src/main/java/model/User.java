package model;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String email;
    private String alias;
    private String password;
    private int role;
    private String fullName;
    private int yob;
    private String description;
    private String about;
    private LocalDateTime createdDate;
    private String image;

    public User() {
    }

    public User(int id, String email, String alias, int role, String fullName, int yob, String description, String about, String image) {
        this.id = id;
        this.email = email;
        this.alias = alias;
        this.role = role;
        this.fullName = fullName;
        this.yob = yob;
        this.description = description;
        this.about = about;
        this.image = image;
    }

    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User(int id, String email, String alias, String password, int role, String fullName, int yob, String description, String about, String image) {
        this.id = id;
        this.email = email;
        this.alias = alias;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.yob = yob;
        this.description = description;
        this.about = about;
        this.image = image;
    }

    public User(String email, String alias, String password, int role, String fullName, int yob, String description, String about, String image) {
        this.email = email;
        this.alias = alias;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.yob = yob;
        this.description = description;
        this.about = about;
        this.image = image;
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String email, String alias, String password, int role, String fullName, int yob, String description, String about, LocalDateTime createdDate, String image) {
        this.id = id;
        this.email = email;
        this.alias = alias;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.yob = yob;
        this.description = description;
        this.about = about;
        this.createdDate = createdDate;
        this.image = image;
    }

    public User(String email, String alias, String password, int role, String fullName, int yob, String description, String about, LocalDateTime createdDate, String image) {
        this.email = email;
        this.alias = alias;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.yob = yob;
        this.description = description;
        this.about = about;
        this.createdDate = createdDate;
        this.image = image;
    }

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
