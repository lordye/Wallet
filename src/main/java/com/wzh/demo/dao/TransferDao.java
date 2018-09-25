package com.wzh.demo.dao;

import java.util.List;
import com.wzh.demo.entity.TransferInfoEntity;

public interface TransferDao {

    /**
     *新增转账流水信息
     * @param transferInfoEntity
     */
    void add(TransferInfoEntity transferInfoEntity);

    /**
     * 通过用户id查询与他相关的流水信息
     * @param id
     * @return
     */
    List<TransferInfoEntity> getById(long id);

}
