package org.example.model;

public class Teacher {
    private String name;
    private String profileUrl;
    private String bio;
    private String email;
    private String research;

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "',profileUrl='" + profileUrl + "'}";
    }
}
