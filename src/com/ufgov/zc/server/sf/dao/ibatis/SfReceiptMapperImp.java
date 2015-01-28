package com.ufgov.zc.server.sf.dao.ibatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.sf.model.SfAgreement;
import com.ufgov.zc.common.sf.model.SfReceipt;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.server.sf.dao.SfReceiptMapper;

public class SfReceiptMapperImp extends SqlMapClientDaoSupport implements SfReceiptMapper {

  
  public int deleteByPrimaryKey(BigDecimal receiptId) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.sf.dao.SfReceiptMapper.deleteByPrimaryKey", receiptId);
  }

  
  public int insert(SfReceipt record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.sf.dao.SfReceiptMapper.insert", record);
    return 1;
  }

  
  public int insertSelective(SfReceipt record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public SfReceipt selectByPrimaryKey(BigDecimal receiptId) {
    // TODO Auto-generated method stub
    return (SfReceipt) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.sf.dao.SfReceiptMapper.selectByPrimaryKey", receiptId);
  }

  
  public int updateByPrimaryKeySelective(SfReceipt record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public int updateByPrimaryKey(SfReceipt record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.sf.dao.SfReceiptMapper.updateByPrimaryKey", record);
  }

  
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.sf.dao.SfReceiptMapper.selectMainDataLst",elementConditionDto);
  }

}
