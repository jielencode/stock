package com.ufgov.zc.server.sf.publish.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfMaterialsTransfer;
import com.ufgov.zc.common.sf.publish.ISfMaterialsTransferServiceDelegate;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.server.sf.service.ISfMaterialsTransferService;

public class SfMaterialsTransferServiceDelegate implements ISfMaterialsTransferServiceDelegate {

  private ISfMaterialsTransferService materialsTransferService;
  
  public List getMainDataLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.getMainDataLst(elementConditionDto, requestMeta);
  }

  
  public SfMaterialsTransfer selectByPrimaryKey(BigDecimal id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.selectByPrimaryKey(id, requestMeta);
  }

  
  public SfMaterialsTransfer saveFN(SfMaterialsTransfer inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.saveFN(inData, requestMeta);
  }

  
  public void deleteByPrimaryKeyFN(BigDecimal id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    materialsTransferService.deleteByPrimaryKeyFN(id, requestMeta);
  }

  
  public SfMaterialsTransfer unAuditFN(SfMaterialsTransfer qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.unAuditFN(qx, requestMeta);
  }

  
  public SfMaterialsTransfer untreadFN(SfMaterialsTransfer qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.untreadFN(qx, requestMeta);
  }

  
  public SfMaterialsTransfer auditFN(SfMaterialsTransfer qx, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    return materialsTransferService.auditFN(qx, requestMeta);
  }

  
  public SfMaterialsTransfer newCommitFN(SfMaterialsTransfer qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.newCommitFN(qx, requestMeta);
  }

  
  public SfMaterialsTransfer callbackFN(SfMaterialsTransfer qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return materialsTransferService.callbackFN(qx, requestMeta);
  }


  public ISfMaterialsTransferService getMaterialsTransferService() {
    return materialsTransferService;
  }


  public void setMaterialsTransferService(ISfMaterialsTransferService materialsTransferService) {
    this.materialsTransferService = materialsTransferService;
  }

}
