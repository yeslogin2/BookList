package com.example.cy123.booklist.Model;

import java.util.ArrayList;

/**
 * Created by cy123 on 2016/6/29.
 */
public class Book {
    private String image;
    private String publisher;
    private String pubdate;
    private String author_intro;
    private String summary;
    private String catalog;

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSummary() {

        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor_intro() {

        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getPubdate() {

        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getPublisher() {

        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
