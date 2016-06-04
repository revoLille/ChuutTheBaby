package com.example.Pierre.myapplication.servlet;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pierre on 04/06/2016.
 */
public class BeanChild implements Serializable {

    private String first_name;
    private Date birthday;
    private int user_id = -1;

    public enum sex {
        M(1),
        F(2);

        private final int unSexeCode;

        sex(int unSexeCode) {
            this.unSexeCode = unSexeCode;
        }

        public int getSexe() {
            return this.unSexeCode;
        }

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
