package com.ufgov.zc.server.sf.dao.ibatis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.zc.common.sf.model.SfAppendMaterialNotice;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper;

public class SfAppendMaterialNoticeMapperImp  extends SqlMapClientDaoSupport implements SfAppendMaterialNoticeMapper {

  
  public int deleteByPrimaryKey(BigDecimal agreementId) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().delete("com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper.deleteByPrimaryKey", agreementId);
  }

  
  public int insert(SfAppendMaterialNotice record) {
    // TODO Auto-generated method stub
    getSqlMapClientTemplate().insert("com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper.insert", record);
    return 1;
  }

  
  public int insertSelective(SfAppendMaterialNotice record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public SfAppendMaterialNotice selectByPrimaryKey(BigDecimal agreementId) {
    // TODO Auto-generated method stub
    return (SfAppendMaterialNotice) getSqlMapClientTemplate().queryForObject("com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper.selectByPrimaryKey", agreementId);
  }

  
  public int updateByPrimaryKeySelective(SfAppendMaterialNotice record) {
    // TODO Auto-generated method stub
    return 0;
  }

  
  public int updateByPrimaryKey(SfAppendMaterialNotice record) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().update("com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper.updateByPrimaryKey", record);
  }

  public List getMainDataLst(ElementConditionDto elementConditionDto) {
    // TODO Auto-generated method stub
    return getSqlMapClientTemplate().queryForList("com.ufgov.zc.server.sf.dao.SfAppendMaterialNoticeMapper.selectMainDataLst",elementConditionDto);
  }

}
