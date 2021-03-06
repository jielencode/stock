package com.ufgov.zc.server.sf.service;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfOutInfoType;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;

public interface ISfOutInfoTypeService {

  List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  SfOutInfoType selectByPrimaryKey(String code, RequestMeta requestMeta);

  SfOutInfoType saveFN(SfOutInfoType inData, RequestMeta requestMeta);

  void deleteByPrimaryKeyFN(String code, RequestMeta requestMeta);


}
