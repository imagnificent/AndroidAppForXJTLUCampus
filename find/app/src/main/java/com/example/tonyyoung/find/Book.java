package com.example.tonyyoung.find;

public class Book {
    private String title;
    private String link;
    private String marcNo;
    private String authorName;
    private String callNo;
    private String publisherInformation;
    private String imageLink;

    public Book(String title, String link, String marcNo, String authorName, String callNo, String publisherInformation, String imgLink){
        super();
        this.title = title;
        this.link = link;
        this.marcNo = marcNo;
        this.authorName = authorName;
        this.callNo = callNo;
        this.publisherInformation = publisherInformation;
        this.imageLink = imgLink;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMarcNo() {
        return marcNo;
    }

    public void setMarcNo(String marcNo) {
        this.marcNo = marcNo;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getPublisherInformation() {
        return publisherInformation;
    }

    public void setPublisherInformation(String publisherInformation) {
        this.publisherInformation = publisherInformation;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
