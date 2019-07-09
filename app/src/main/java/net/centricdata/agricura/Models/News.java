package net.centricdata.agricura.Models;

public class News {

    int newsId;
    String newsImageUrl;
    String newsHeadline;
    String newsDetails;
    String newsDatePosted;

    public News() {
    }

    public News(int newsId, String newsImageUrl, String newsHeadline, String newsDetails, String newsDatePosted) {
        this.newsId = newsId;
        this.newsImageUrl = newsImageUrl;
        this.newsHeadline = newsHeadline;
        this.newsDetails = newsDetails;
        this.newsDatePosted = newsDatePosted;
    }


    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsImageUrl() {
        return newsImageUrl;
    }

    public void setNewsImageUrl(String newsImageUrl) {
        this.newsImageUrl = newsImageUrl;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public void setNewsHeadline(String newsHeadline) {
        this.newsHeadline = newsHeadline;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }

    public String getNewsDatePosted() {
        return newsDatePosted;
    }

    public void setNewsDatePosted(String newsDatePosted) {
        this.newsDatePosted = newsDatePosted;
    }
}
