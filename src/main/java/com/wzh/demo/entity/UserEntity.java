package com.wzh.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "HS_USER", schema = "WZH", catalog = "")
public class UserEntity {
    private long id;
    private String username;
    private String password;
    private long walletId;
    private String flag;

    public UserEntity(){
        this.flag = "1";
        this.walletId = 0;
    }

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name = "user_id",sequenceName = "hs_user_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "user_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME", nullable = false, length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "WALLET_ID", nullable = false, precision = 0)
    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    @Basic
    @Column(name = "FLAG", nullable = false, length = 1)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (walletId != that.walletId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (walletId ^ (walletId >>> 32));
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
