package com.southwind.entity;

import java.util.Date;

public class Users {
    private Integer id ;
    private String name ;
    private Integer score ;
    private Date birthday ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", birthday=" + birthday +
                '}';
    }

    public Users() {
    }

    public Users(Integer id, String name, Integer score, Date birthday) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.birthday = birthday;
    }
}
