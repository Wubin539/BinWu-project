package com.mycompany.assignment;

public class Ceducation {
    private int educationID;
    private String educationTitle;
    private String educationContent;

    public Ceducation() {
    }

    public Ceducation(int educationID, String educationTitle, String educationContent) {
        this.educationID = educationID;
        this.educationTitle = educationTitle;
        this.educationContent = educationContent;
    }

    public int getEducationID() {
        return educationID;
    }

    public void setEducationID(int educationID) {
        this.educationID = educationID;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public String getEducationContent() {
        return educationContent;
    }

    public void setEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    @Override
    public String toString() {
        return "No.: " + educationID + "\n"
                + "Title: " + educationTitle + "\n"
                + "Content: " + educationContent + "\n";
    }
}
