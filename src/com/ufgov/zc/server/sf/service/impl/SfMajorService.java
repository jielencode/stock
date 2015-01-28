package com.ufgov.zc.server.sf.service.impl;

import java.util.List;

import com.ufgov.zc.common.sf.model.SfMajor;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.server.sf.dao.SfJdPersonMapper;
import com.ufgov.zc.server.sf.dao.SfMajorMapper;
import com.ufgov.zc.server.sf.service.ISfMajorService;
import com.ufgov.zc.server.system.util.NumUtil;

public class SfMajorService implements ISfMajorService {

  private SfMajorMapper majorMapper;
  
  private SfJdPersonMapper jdPersonMapper;
   
  public SfJdPersonMapper getJdPersonMapper() {
    return jdPersonMapper;
  }

  public void setJdPersonMapper(SfJdPersonMapper jdPersonMapper) {
    this.jdPersonMapper = jdPersonMapper;
  }

  public List getMajorLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return majorMapper.getMajorLst(elementConditionDto);
  }

  public SfMajorMapper getMajorMapper() {
    return majorMapper;
  }

  public void setMajorMapper(SfMajorMapper majorMapper) {
    this.majorMapper = majorMapper;
  }

  
  public SfMajor selectByPrimaryKey(String majorCode, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
     SfMajor rtn=majorMapper.selectByPrimaryKey(majorCode);
     if(rtn==null)return null;
     ElementConditionDto dto=new ElementConditionDto();
     dto.setDattr1(majorCode);
     rtn.setJdPersonLst(jdPersonMapper.getMainDataLst(dto));
     return rtn;
  }

  
  public SfMajor saveFN(SfMajor inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if(inData.getMajorCode()==null){
      String code = NumUtil.getInstance().getNo("SF_MAJOR", "MAJOR_CODE", inData);
      inData.setMajorCode(code);
      majorMapper.insert(inData);
    }else{
     majorMapper.deleteByPrimaryKey(inData.getMajorCode());
     majorMapper.insert(inData);
    }
     return inData;
  }

  
  public void deleteByPrimaryKeyFN(String majorCode, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    majorMapper.deleteByPrimaryKey(majorCode);
  }

   
  public boolean isUsing(String majorCode, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return majorMapper.isUsing(majorCode);
     
  }


}
