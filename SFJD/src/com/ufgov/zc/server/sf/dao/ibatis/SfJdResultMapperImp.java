package com.ufgov.zc.server.sf.dao.ibatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.sf.model.SfJdResult;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.server.sf.dao.SfJdResultMapper;

public class SfJdResultMapperImp extends SqlMapClientDaoSupport implements SfJdResultMapper {

  
  public int deleteByPrimaryKey(BigDecimal jdResultId) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.sf.dao.SfJdResultMapper.deleteByPrimaryKey", jdResultId);
  }

  
  public int insert(SfJdResult record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.sf.dao.SfJdResultMapper.insert", record);
    return 1;
  }

  
  public int insertSelective(SfJdResult record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public SfJdResult selectByPrimaryKey(BigDecimal jdResultId) {
    // TODO Auto-generated method stub
    return (SfJdResult) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.sf.dao.SfJdResultMapper.selectByPrimaryKey", jdResultId);
    
  }

  
  public int updateByPrimaryKeySelective(SfJdResult record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public int updateByPrimaryKey(SfJdResult record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.sf.dao.SfJdResultMapper.updateByPrimaryKey", record);
  }

  
  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.sf.dao.SfJdResultMapper.selectMainDataLst",elementConditionDto);
    
  }

}
