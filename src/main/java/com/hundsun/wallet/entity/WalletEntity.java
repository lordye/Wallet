package com.hundsun.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_WALLET", schema = "WALLET")
public class WalletEntity {
    private long id;
    private long balance;
    private String flag;
    private long ownerId;
    private String ownerName;
    private String reserve1;
    private String reserve2;
    private String reserve3;
    private String reserve4;
    private String reserve5;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BALANCE")
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
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
    @Column(name = "OWNER_ID")
    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "OWNER_NAME")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

        WalletEntity that = (WalletEntity) o;

        if (id != that.id) return false;
        if (balance != that.balance) return false;
        if (ownerId != that.ownerId) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (reserve1 != null ? !reserve1.equals(that.reserve1) : that.reserve1 != null) return false;
        if (reserve2 != null ? !reserve2.equals(that.reserve2) : that.reserve2 != null) return false;
        if (reserve3 != null ? !reserve3.equals(that.reserve3) : that.reserve3 != null) return false;
        if (reserve4 != null ? !reserve4.equals(that.reserve4) : that.reserve4 != null) return false;
        if (reserve5 != null ? !reserve5.equals(that.reserve5) : that.reserve5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (int) (ownerId ^ (ownerId >>> 32));
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (reserve1 != null ? reserve1.hashCode() : 0);
        result = 31 * result + (reserve2 != null ? reserve2.hashCode() : 0);
        result = 31 * result + (reserve3 != null ? reserve3.hashCode() : 0);
        result = 31 * result + (reserve4 != null ? reserve4.hashCode() : 0);
        result = 31 * result + (reserve5 != null ? reserve5.hashCode() : 0);
        return result;
    }
}
