package com.ufgov.zc.server.sf.dao.ibatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.sf.model.SfJdDocAudit;
import com.ufgov.zc.common.sf.model.SfOutInfo;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.server.sf.dao.SfJdDocAuditMapper;

public class SfJdDocAuditMapperImp extends SqlMapClientDaoSupport implements SfJdDocAuditMapper {

  
  public int deleteByPrimaryKey(BigDecimal jdDocAuditId) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.sf.dao.SfJdDocAuditMapper.deleteByPrimaryKey", jdDocAuditId);
    
  }

  
  public int insert(SfJdDocAudit record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.sf.dao.SfJdDocAuditMapper.insert", record);
    return 1;
  }

  
  public int insertSelective(SfJdDocAudit record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public SfJdDocAudit selectByPrimaryKey(BigDecimal jdDocAuditId) {
    // TODO Auto-generated method stub
    return (SfJdDocAudit) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.sf.dao.SfJdDocAuditMapper.selectByPrimaryKey", jdDocAuditId);
  }

  
  public int updateByPrimaryKeySelective(SfJdDocAudit record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public int updateByPrimaryKey(SfJdDocAudit record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.sf.dao.SfJdDocAuditMapper.updateByPrimaryKey", record);
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.sf.dao.SfJdDocAuditMapper.selectMainDataLst",elementConditionDto);
  }
}
