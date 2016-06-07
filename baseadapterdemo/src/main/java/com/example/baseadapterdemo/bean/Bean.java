package com.example.baseadapterdemo.bean;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Bean {

    private String title;
    private String descript;
    private String time;
    private String phone;

    public Bean(String title, String descript, String time, String phone) {
        this.title = title;
        this.descript = descript;
        this.time = time;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
