package com.psoft.myapplication;

public class Banners {

    private String url;
    private String title;
    private String message;
    private String image;


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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Banners(String url, String title, String message, String image) {

        this.url = url;
        this.title = title;
        this.message = message;
        this.image = image;
    }
}
