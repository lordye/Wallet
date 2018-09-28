package com.hundsun.wallet.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_TRANSFER_INFO", schema = "WALLET")
public class TTransferInfoEntity {
    private long id;
    private String type;
    private long fromId;
    private String fromName;
    private long toId;
    private String toName;
    private long transMoney;
    private String transDate;
    private String flowNo;
    private String remarks;
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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "FROM_ID")
    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "FROM_NAME")
    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @Basic
    @Column(name = "TO_ID")
    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    @Basic
    @Column(name = "TO_NAME")
    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    @Basic
    @Column(name = "TRANS_MONEY")
    public long getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(long transMoney) {
        this.transMoney = transMoney;
    }

    @Basic
    @Column(name = "TRANS_DATE")
    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    @Basic
    @Column(name = "FLOW_NO")
    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    @Basic
    @Column(name = "REMARKS")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

        TTransferInfoEntity that = (TTransferInfoEntity) o;

        if (id != that.id) return false;
        if (fromId != that.fromId) return false;
        if (toId != that.toId) return false;
        if (transMoney != that.transMoney) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (fromName != null ? !fromName.equals(that.fromName) : that.fromName != null) return false;
        if (toName != null ? !toName.equals(that.toName) : that.toName != null) return false;
        if (transDate != null ? !transDate.equals(that.transDate) : that.transDate != null) return false;
        if (flowNo != null ? !flowNo.equals(that.flowNo) : that.flowNo != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
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
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (int) (fromId ^ (fromId >>> 32));
        result = 31 * result + (fromName != null ? fromName.hashCode() : 0);
        result = 31 * result + (int) (toId ^ (toId >>> 32));
        result = 31 * result + (toName != null ? toName.hashCode() : 0);
        result = 31 * result + (int) (transMoney ^ (transMoney >>> 32));
        result = 31 * result + (transDate != null ? transDate.hashCode() : 0);
        result = 31 * result + (flowNo != null ? flowNo.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (reserve1 != null ? reserve1.hashCode() : 0);
        result = 31 * result + (reserve2 != null ? reserve2.hashCode() : 0);
        result = 31 * result + (reserve3 != null ? reserve3.hashCode() : 0);
        result = 31 * result + (reserve4 != null ? reserve4.hashCode() : 0);
        result = 31 * result + (reserve5 != null ? reserve5.hashCode() : 0);
        return result;
    }
}
