package com.example.reptile.pojo;

public class Lottery {
    private Integer id;
    private String videoName;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName(String alt) {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
