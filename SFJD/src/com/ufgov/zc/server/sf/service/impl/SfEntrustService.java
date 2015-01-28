package com.ufgov.zc.server.sf.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfEntrust;
import com.ufgov.zc.common.sf.model.SfMaterials;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.system.model.AsWfDraft;
import com.ufgov.zc.server.sf.dao.SfEntrustMapper;
import com.ufgov.zc.server.sf.dao.SfMaterialsMapper;
import com.ufgov.zc.server.sf.service.ISfEntrustService;
import com.ufgov.zc.server.system.dao.IWorkflowDao;
import com.ufgov.zc.server.system.util.NumUtil;
import com.ufgov.zc.server.system.workflow.WFEngineAdapter;
import com.ufgov.zc.server.zc.ZcSUtil;

public class SfEntrustService implements ISfEntrustService {

  private SfEntrustMapper entrustMapper;
  
  private SfMaterialsMapper materialsMapper;
  
  private IWorkflowDao workflowDao;
  
  private WFEngineAdapter wfEngineAdapter;
  
  public List getEntrustLst(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return entrustMapper.getEntrustLst(elementConditionDto);
  }

  
  public SfEntrust selectByPrimaryKey(BigDecimal id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    SfEntrust rtn=entrustMapper.selectByPrimaryKey(id);
    List materialLst=materialsMapper.selectByEntrustId(id);
    rtn.setMaterials(materialLst==null?new ArrayList():materialLst);
    rtn.setDbDigest(rtn.digest());
    return rtn;
  }

  
  public SfEntrust saveFN(SfEntrust inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    if ("".equals(ZcSUtil.safeString(inData.getCode())) || inData.getCode().equals("自动编号")) {

      String code = NumUtil.getInstance().getNo("SF_ENTRUST", "CODE", inData);
      inData.setCode(code);
      BigDecimal id=new BigDecimal(ZcSUtil.getNextVal(SfEntrust.SEQ_SF_ENTRUST_ID));
      inData.setEntrustId(id);  

      boolean isDraft = false;
      String userId = requestMeta.getSvUserID();
      String compoId = requestMeta.getCompoId();
      
      if (inData.getProcessInstId() == null || inData.getProcessInstId().longValue() == -1) {
        Long draftid = workflowDao.createDraftId();
        inData.setProcessInstId(draftid);
        isDraft = true;
      }      
      insert(inData,requestMeta);

      if (isDraft) {
        AsWfDraft asWfDraft = new AsWfDraft();
        asWfDraft.setCompoId(compoId);
        asWfDraft.setWfDraftName(inData.getCode());
        asWfDraft.setUserId(userId);
        asWfDraft.setMasterTabId(compoId);
        asWfDraft.setWfDraftId(BigDecimal.valueOf(inData.getProcessInstId().longValue()));
        workflowDao.insertAsWfdraft(asWfDraft);
      }
   }else{
     update(inData,requestMeta);
   }
   return inData;
  }
  private void update(SfEntrust inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    entrustMapper.updateByPrimaryKey(inData);
    materialsMapper.deleteByEntrustId(inData.getEntrustId());

    if(inData.getMaterials()!=null){
      for(int i=0;i<inData.getMaterials().size();i++){
        SfMaterials m=(SfMaterials) inData.getMaterials().get(i);
        setMaterialsId(m);
        m.setEntrustId(inData.getEntrustId());
        materialsMapper.insert(m);
      }
    }
  }


  private void setMaterialsId(SfMaterials m) {
    // TODO Auto-generated method stub
    if(m.getMaterialId()!=null)return;
    BigDecimal id=new BigDecimal(ZcSUtil.getNextVal(SfMaterials.SEQ_SF_MATERIALS_ID));
    m.setMaterialId(id);
  }


  private void insert(SfEntrust inData, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    entrustMapper.insert(inData);
    if(inData.getMaterials()!=null){
      for(int i=0;i<inData.getMaterials().size();i++){
        SfMaterials m=(SfMaterials) inData.getMaterials().get(i);
        setMaterialsId(m);
        m.setEntrustId(inData.getEntrustId());
        materialsMapper.insert(m);
      }
    }
  }

  
  public void deleteByPrimaryKeyFN(BigDecimal id, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    entrustMapper.deleteByPrimaryKey(id);
    materialsMapper.deleteByEntrustId(id);
  }


  public SfEntrustMapper getEntrustMapper() {
    return entrustMapper;
  }


  public void setEntrustMapper(SfEntrustMapper entrustMapper) {
    this.entrustMapper = entrustMapper;
  }


  public SfMaterialsMapper getMaterialsMapper() {
    return materialsMapper;
  }


  public void setMaterialsMapper(SfMaterialsMapper materialsMapper) {
    this.materialsMapper = materialsMapper;
  }


  public IWorkflowDao getWorkflowDao() {
    return workflowDao;
  }


  public void setWorkflowDao(IWorkflowDao workflowDao) {
    this.workflowDao = workflowDao;
  }


  public WFEngineAdapter getWfEngineAdapter() {
    return wfEngineAdapter;
  }


  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {
    this.wfEngineAdapter = wfEngineAdapter;
  }

  
  public SfEntrust unAuditFN(SfEntrust qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.rework(qx.getComment(), qx, requestMeta);
    return qx;
  }

  
  public SfEntrust untreadFN(SfEntrust qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.untread(qx.getComment(), qx, requestMeta);
    return qx;
  }

  
  public SfEntrust auditFN(SfEntrust qx, RequestMeta requestMeta) throws Exception {
    // TODO Auto-generated method stub
    qx=saveFN(qx, requestMeta);
    wfEngineAdapter.commit(qx.getComment(), qx, requestMeta);
    return selectByPrimaryKey(qx.getEntrustId(),requestMeta);
  }

  
  public SfEntrust newCommitFN(SfEntrust qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.newCommit(qx.getComment(), qx, requestMeta);
    return selectByPrimaryKey(qx.getEntrustId(),requestMeta);
  }

  
  public SfEntrust callbackFN(SfEntrust qx, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    wfEngineAdapter.callback(qx.getComment(), qx, requestMeta);
    return qx;
  }
}
