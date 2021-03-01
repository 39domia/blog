package model;

import java.time.LocalDateTime;

public class Post {
    private int idPost;
    private String postTitle;
    private String fullContent;
    private String shortContent;
    private LocalDateTime publishDate;
    private String image;
    Category category;
    Author author;

    public Post(String postTitle, String fullContent, String shortContent, LocalDateTime publishDate, String image, Category category, Author author) {
        this.postTitle = postTitle;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.publishDate = publishDate;
        this.image = image;
        this.category = category;
        this.author = author;
    }

    public Post(int idPost, String postTitle, String fullContent, String shortContent, LocalDateTime publishDate, String image, Category category, Author author) {
        this.idPost = idPost;
        this.postTitle = postTitle;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.publishDate = publishDate;
        this.image = image;
        this.category = category;
        this.author = author;
    }

    public Post(String postTitle, String fullContent, String shortContent, String image, Category category, Author author) {
        this.postTitle = postTitle;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
        this.author = author;
    }

    public Post() {
    }

    public Post(int idPost, String postTitle, String fullContent, String shortContent, String image, Category category, Author author) {
        this.idPost = idPost;
        this.postTitle = postTitle;
        this.fullContent = fullContent;
        this.shortContent = shortContent;
        this.image = image;
        this.category = category;
        this.author = author;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
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

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
