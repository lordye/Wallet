package com.hundsun.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_USER_INFO", schema = "WALLET")
public class UserInfoEntity {
    private long id;
    private String username;
    private String realName;
    private String identityCard;
    private String gender;
    private String phoneNumber;
    private int creditScore;
    private String reserve1;
    private String reserve2;
    private String reserve3;
    private String email;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name = "user_info_id", sequenceName = "t_user_info_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "REAL_NAME")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "IDENTITY_CARD")
    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "CREDIT_SCORE")
    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    @Basic
    @Column(name = "RESERVE1")
    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    @Basic
    @Column(name = "RESERVE2")
    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    @Basic
    @Column(name = "RESERVE3")
    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != that.id) return false;
        if (creditScore != that.creditScore) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (identityCard != null ? !identityCard.equals(that.identityCard) : that.identityCard != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (reserve1 != null ? !reserve1.equals(that.reserve1) : that.reserve1 != null) return false;
        if (reserve2 != null ? !reserve2.equals(that.reserve2) : that.reserve2 != null) return false;
        if (reserve3 != null ? !reserve3.equals(that.reserve3) : that.reserve3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (identityCard != null ? identityCard.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + creditScore;
        result = 31 * result + (reserve1 != null ? reserve1.hashCode() : 0);
        result = 31 * result + (reserve2 != null ? reserve2.hashCode() : 0);
        result = 31 * result + (reserve3 != null ? reserve3.hashCode() : 0);
        return result;
    }

}
