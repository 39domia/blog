package model;

public class Author {
    private int idAuthor;
    private String authorName;
    private String authorDes;

    public Author() {
    }

    public Author(int idAuthor, String authorName, String authorDes) {
        this.idAuthor = idAuthor;
        this.authorName = authorName;
        this.authorDes = authorDes;
    }

    public Author(String authorName, String authorDes) {
        this.authorName = authorName;
        this.authorDes = authorDes;
    }

    public Author(int idAuthor, String authorName) {
        this.idAuthor = idAuthor;
        this.authorName = authorName;
    }

    public Author(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDes() {
        return authorDes;
    }

    public void setAuthorDes(String authorDes) {
        this.authorDes = authorDes;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", authorName='" + authorName + '\'' +
                ", authorDes='" + authorDes + '\'' +
                '}';
    }
}
