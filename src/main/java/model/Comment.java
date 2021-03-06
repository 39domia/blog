package model;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private String email;
    private LocalDateTime cratedDate;
    private int idRoot;

    public Comment() {
    }

    public Comment(int id, String content, String email, LocalDateTime cratedDate, int idRoot) {
        this.id = id;
        this.content = content;
        this.email = email;
        this.cratedDate = cratedDate;
        this.idRoot = idRoot;
    }

    public Comment(String content, String email, LocalDateTime cratedDate, int idRoot) {
        this.content = content;
        this.email = email;
        this.cratedDate = cratedDate;
        this.idRoot = idRoot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(LocalDateTime cratedDate) {
        this.cratedDate = cratedDate;
    }

    public int getIdRoot() {
        return idRoot;
    }

    public void setIdRoot(int idRoot) {
        this.idRoot = idRoot;
    }
}
