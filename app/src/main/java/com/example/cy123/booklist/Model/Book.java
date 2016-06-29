package com.example.cy123.booklist.Model;

/**
 * Created by cy123 on 2016/6/29.
 */
public class Book {
    private String id;
    private String title;
    private String url;
    private String image;
    private String author;
    private String translator;
    private String publisher;
    private String pubdate;
    private String tags;
    private String binding;
    private String price;
    private String pages;
    private String author_intro;
    private String summary;
    private String catalog;

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

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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

    public String getPages() {

        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBinding() {

        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getTags() {

        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
