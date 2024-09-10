package com.libraryApp.project.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Books {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_books")
    private int id;
    @Column (name = "title_books")
    private String title;
    @Column (name = "author")
    private String author;
    @Column (name = "page_number")
    private int pageNum;
    @Column (name = "rating")
    private int rating;

    public Books(int id, String title, String author, int pageNum, int rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageNum = pageNum;
        this.rating = rating;
    }

    public Books() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageNum=" + pageNum +
                ", rating=" + rating +
                '}';
    }
}
