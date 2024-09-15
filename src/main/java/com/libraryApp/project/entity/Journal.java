package com.libraryApp.project.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "journal")
public class Journal {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "id")
        private int id;
        @Column (name = "Title")
        private String title;
        @Column (name = "business_name")
        private String businessName;
        @Column (name = "Category")
        private String category;
        @Column (name = "Rating")
        private double rating;

    public Journal(int id, String title, String businessName, String category, double rating) {
        this.id = id;
        this.title = title;
        this.businessName = businessName;
        this.category = category;
        this.rating = rating;
    }

    public Journal() {
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
