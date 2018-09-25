package com.wzh.demo.entity;

import com.wzh.demo.dao.WalletDao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HS_WALLET", schema = "WZH", catalog = "")
public class WalletEntity {
    private long id;
    private double balance;
    private String flag;

    public WalletEntity(){
        this.balance = 0;
        this.flag = "1";
    }

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name = "wallet_id",sequenceName = "hs_wallet_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "wallet_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BALANCE", nullable = false, precision = 2)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        WalletEntity that = (WalletEntity) o;
        return getId() == that.getId() &&
                Double.compare(that.getBalance(), getBalance()) == 0 &&
                Objects.equals(getFlag(), that.getFlag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getFlag());
    }
}
