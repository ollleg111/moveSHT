package movesht.com.movesht.model;

import java.io.Serializable;

/**
 * Created by PC on 10-Mar-17.
 */

public class User implements Serializable {

    private boolean InfoAboutAddToDataBase;

    public boolean isInfoAboutAddToDataBase() {
        return InfoAboutAddToDataBase;
    }

    public void setInfoAboutAddToDataBase(boolean infoAboutAddToDataBase) {
        InfoAboutAddToDataBase = infoAboutAddToDataBase;
    }

    private String user_mail;
    private MyShipment[] Bidding;
    private MyShipment[] activity;
    private String clint_type;
    private MyShipment[] compilate;
    private String firstname;
    private String lastname;
    private Boolean tel_validation;
    private String textPhone;
    private String url_logo;

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setBidding(MyShipment[] bidding) {
        Bidding = bidding;
    }

    public void setActivity(MyShipment[] activity) {
        this.activity = activity;
    }

    public void setClint_type(String clint_type) {
        this.clint_type = clint_type;
    }

    public void setCompilate(MyShipment[] compilate) {
        this.compilate = compilate;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTel_validation(Boolean tel_validation) {
        this.tel_validation = tel_validation;
    }

    public void setTextPhone(String textPhone) {
        this.textPhone = textPhone;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public MyShipment[] getBidding() {
        return Bidding;
    }

    public MyShipment[] getActivity() {
        return activity;
    }

    public String getClint_type() {
        return clint_type;
    }

    public MyShipment[] getCompilate() {
        return compilate;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Boolean getTel_validation() {
        return tel_validation;
    }

    public String getTextPhone() {
        return textPhone;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User() {
    }

}
