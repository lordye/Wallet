package com.hundsun.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_USER", schema = "WALLET")
public class UserEntity {
    private long id;
    private String username;
    private String password;
    private String flag;
    private String createDate;
    private String reserve1;
    private String reserve2;
    private String reserve3;
    private String reserve4;
    private String reserve5;
    private WalletEntity walletEntity;
    private UserInfoEntity userInfoEntity;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name = "user_id", sequenceName = "t_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
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
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    @JoinColumn(name = "WALLET_ID", unique = true)
    public WalletEntity getWalletEntity() {
        return walletEntity;
    }

    public void setWalletEntity(WalletEntity walletEntity) {
        this.walletEntity = walletEntity;
    }

    @Basic
    @Column(name = "FLAG")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @OneToOne
    @JoinColumn(name = "INFO_ID", unique = true)
    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
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
    @Column(name = "RESERVE4")
    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    @Basic
    @Column(name = "RESERVE5")
    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (reserve1 != null ? !reserve1.equals(that.reserve1) : that.reserve1 != null) return false;
        if (reserve2 != null ? !reserve2.equals(that.reserve2) : that.reserve2 != null) return false;
        if (reserve3 != null ? !reserve3.equals(that.reserve3) : that.reserve3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (reserve1 != null ? reserve1.hashCode() : 0);
        result = 31 * result + (reserve2 != null ? reserve2.hashCode() : 0);
        result = 31 * result + (reserve3 != null ? reserve3.hashCode() : 0);
        return result;
    }
}
