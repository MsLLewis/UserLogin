package com.lewis.userlogin.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "user-updownload")
public class UserUpDownLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userProfilePic;
    private Long size;
    private byte [] content;

    public UserUpDownLoad(){}

    public UserUpDownLoad(String userProfilePic, Long size, byte[] content) {
        this.userProfilePic = userProfilePic;
        this.size = size;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UserUpDownLoad{" +
                "id=" + id +
                ", userProfilePic='" + userProfilePic + '\'' +
                ", size=" + size +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
