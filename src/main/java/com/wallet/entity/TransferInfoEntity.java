package com.wzh.demo.entity;

import com.wzh.demo.utils.CommonUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HS_TRANSFER_INFO", schema = "WZH", catalog = "")
public class TransferInfoEntity {
    private long id;
    private long userIn;
    private String userInName;
    private long userOut;
    private String userOutName;
    private Double balance;
    private String createdate;
    private String flowNo;


    public TransferInfoEntity(){}

    public TransferInfoEntity(long in , long out){
        this.balance = 0.0;
        this.createdate = CommonUtils.getTime();
        this.flowNo = CommonUtils.getFlowNumber(in,out);
    }

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name = "transfer_id",sequenceName = "hs_transfer_info_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "transfer_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_IN", nullable = false, precision = 0)
    public long getUserIn() {
        return userIn;
    }

    public void setUserIn(long userIn) {
        this.userIn = userIn;
    }

    @Basic
    @Column(name = "USER_IN_NAME", nullable = false, length = 100)
    public String getUserInName() {
        return userInName;
    }

    public void setUserInName(String userInName) {
        this.userInName = userInName;
    }

    @Basic
    @Column(name = "USER_OUT", nullable = false, precision = 0)
    public long getUserOut() {
        return userOut;
    }

    public void setUserOut(long userOut) {
        this.userOut = userOut;
    }

    @Basic
    @Column(name = "USER_OUT_NAME", nullable = false, length = 100)
    public String getUserOutName() {
        return userOutName;
    }

    public void setUserOutName(String userOutName) {
        this.userOutName = userOutName;
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
    @Column(name = "CREATEDATE", nullable = false, length = 8)
    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    @Basic
    @Column(name = "FLOW_NO", nullable = false, length = 50)
    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferInfoEntity that = (TransferInfoEntity) o;
        return getId() == that.getId() &&
                getUserIn() == that.getUserIn() &&
                getUserOut() == that.getUserOut() &&
                Objects.equals(getUserInName(), that.getUserInName()) &&
                Objects.equals(getUserOutName(), that.getUserOutName()) &&
                Objects.equals(getBalance(), that.getBalance()) &&
                Objects.equals(getCreatedate(), that.getCreatedate()) &&
                Objects.equals(getFlowNo(), that.getFlowNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserIn(), getUserInName(), getUserOut(), getUserOutName(), getBalance(), getCreatedate(), getFlowNo());
    }
}
