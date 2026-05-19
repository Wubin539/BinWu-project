package com.mycompany.assignment;

public class ClimateNews {
    private int NewsId;
    private String NewsTitle;
    private String Newscontent;

    public ClimateNews() {
    }

    public ClimateNews(int NewsId, String NewsTitle, String Newscontent) {
        this.NewsId = NewsId;
        this.NewsTitle = NewsTitle;
        this.Newscontent = Newscontent;
    }

    public int getNewsId() {
        return NewsId;
    }

    public void setNewsId(int NewsId) {
        this.NewsId = NewsId;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }

    public String getNewscontent() {
        return Newscontent;
    }

    public void setNewscontent(String Newscontent) {
        this.Newscontent = Newscontent;
    }

    @Override
    public String toString() {
        return "No.: " + NewsId + "\n"
                + "Title: " + NewsTitle + "\n"
                + "Detail: " + Newscontent + "\n";
    }
}
