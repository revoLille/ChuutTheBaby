package com.projetastonlille.fr.shuutthebaby.database;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Pierre on 15/06/2016.
 */
public class Child implements Serializable{

    private int id;
    private String first_name_child;
    private Date birthday;
    private int sex;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name_child() {
        return first_name_child;
    }

    public void setFirst_name_child(String first_name_child) {
        this.first_name_child = first_name_child;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", first_name_child='" + first_name_child + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", user_id=" + user_id +
                '}';
    }
}
