package model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private String fullContent;
    private String shortContent;
    private LocalDateTime createdDate;
    private String image;
    private LocalDateTime lastEditTime;
    Category category;
    User user;

    public Post() {
    }

    public Post(int id) {
        this.id = id;
    }

    public Post(int id, String title, String fullContent, String shortContent, LocalDateTime createdDate, String image, LocalDateTime lastEditTime, Category category, User user) {
        this.id = id;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.createdDate = createdDate;
        this.image = image;
        this.lastEditTime = lastEditTime;
        this.category = category;
        this.user = user;
    }

    public Post(String title, String fullContent, String shortContent, LocalDateTime createdDate, String image, LocalDateTime lastEditTime, Category category, User user) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.createdDate = createdDate;
        this.image = image;
        this.lastEditTime = lastEditTime;
        this.category = category;
        this.user = user;
    }

    public Post(String title, String fullContent, String shortContent, String image, Category category, User user) {
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
        this.user = user;
    }

    public Post(int id, String title, String fullContent, String shortContent, String image, Category category, User user) {
        this.id = id;
        this.title = title;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
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

    public LocalDateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
