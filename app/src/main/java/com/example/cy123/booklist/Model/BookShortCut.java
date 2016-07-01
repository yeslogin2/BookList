package com.example.cy123.booklist.Model;

import java.util.ArrayList;

/**
 * Created by cy123 on 2016/6/29.
 */
public class BookShortCut {
    private String id;
    private String title;
    private String url;
    private ArrayList<String> author;

    public ArrayList<String> getAuthor() {
        return author;
    }

    public String getAuthorString(){
        String author = "";
        for (String str : this.getAuthor()){
            author += (str + " ");
        }
        return author;
    }

    public void setAuthor(ArrayList<String> author) {
        this.author = author;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
