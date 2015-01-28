/**    * @(#) project: GK * @(#) file: ZcEbEvalService.java *  * Copyright 2010 UFGOV, Inc. All rights reserved. * UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. *  */package com.ufgov.zc.server.zc.service.impl;import java.math.BigDecimal;import java.util.ArrayList;import java.util.Calendar;import java.util.HashMap;import java.util.List;import java.util.Map;import java.util.regex.Matcher;import java.util.regex.Pattern;import org.apache.log4j.Logger;import com.kingdrive.workflow.context.WorkflowContext;import com.ufgov.zc.common.commonbiz.model.Position;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.NumLimConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.MainSubBill;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.system.exception.BusinessException;import com.ufgov.zc.common.system.model.AsWfDraft;import com.ufgov.zc.common.system.util.ExceptionUtil;import com.ufgov.zc.common.system.util.UUID;import com.ufgov.zc.common.zc.model.ComlianceItemValue;import com.ufgov.zc.common.zc.model.EvalItemType;import com.ufgov.zc.common.zc.model.EvalPackProvider;import com.ufgov.zc.common.zc.model.FormulaRootCode;import com.ufgov.zc.common.zc.model.ZcBaseBill;import com.ufgov.zc.common.zc.model.ZcEbEvalBidTeamMember;import com.ufgov.zc.common.zc.model.ZcEbEvalItemResult;import com.ufgov.zc.common.zc.model.ZcEbEvalPack;import com.ufgov.zc.common.zc.model.ZcEbEvalParam;import com.ufgov.zc.common.zc.model.ZcEbEvalReport;import com.ufgov.zc.common.zc.model.ZcEbExpertChengNuo;import com.ufgov.zc.common.zc.model.ZcEbExpertEvalResult;import com.ufgov.zc.common.zc.model.ZcEbExpertOpinion;import com.ufgov.zc.common.zc.model.ZcEbFormula;import com.ufgov.zc.common.zc.model.ZcEbOpenBid;import com.ufgov.zc.common.zc.model.ZcEbPack;import com.ufgov.zc.common.zc.model.ZcEbPackEvalResult;import com.ufgov.zc.common.zc.model.ZcEbSupplierPack;import com.ufgov.zc.server.system.dao.IWorkflowDao;import com.ufgov.zc.server.system.dao.ibatis.AsOptionDao;import com.ufgov.zc.server.system.print.PrintManager;import com.ufgov.zc.server.system.util.AsOptionUtil;import com.ufgov.zc.server.system.util.NumLimUtil;import com.ufgov.zc.server.system.workflow.WFEngineAdapter;import com.ufgov.zc.server.zc.ZcSUtil;import com.ufgov.zc.server.zc.dao.IBaseDao;import com.ufgov.zc.server.zc.dao.IZcEbEvalDao;import com.ufgov.zc.server.zc.dao.IZcEbOpenBidDao;import com.ufgov.zc.server.zc.service.IZcEbEvalService;import com.ufgov.zc.server.zc.service.impl.calculator.CalculatorParam;import com.ufgov.zc.server.zc.service.impl.calculator.IZcEbPackExpertEvalResSumCalculator;/** *  * @ClassName: ZcEbEvalService *  * @Description: 评标模块业务处理实现类。 *  * @date: 2010-4-21 下午03:54:05 *  * @version: V1.0 *  * @since: 1.0 *  * @author: fanpl *  * @modify: */public class ZcEbEvalService implements IZcEbEvalService {  private static final Logger log = Logger.getLogger(ZcEbEvalService.class);  private WFEngineAdapter wfEngineAdapter;  private IZcEbEvalDao zcEbEvalDao;  private IBaseDao baseDao;  private IWorkflowDao workflowDao;  private AsOptionDao asOptionDao;    private IZcEbOpenBidDao zcEbOpenBidDao;  public IZcEbOpenBidDao getZcEbOpenBidDao() {    return zcEbOpenBidDao;  }  public void setZcEbOpenBidDao(IZcEbOpenBidDao zcEbOpenBidDao) {    this.zcEbOpenBidDao = zcEbOpenBidDao;  }  public IWorkflowDao getWorkflowDao() {    return workflowDao;  }  public void setWorkflowDao(IWorkflowDao workflowDao) {    this.workflowDao = workflowDao;  }  /**   *    * @return the zcEbEvalDao   */  public IZcEbEvalDao getZcEbEvalDao() {    return zcEbEvalDao;  }  /**   *    * @param zcEbEvalDao   *            the zcEbEvalDao to set   */  public void setZcEbEvalDao(IZcEbEvalDao zcEbEvalDao) {    this.zcEbEvalDao = zcEbEvalDao;  }  public IBaseDao getBaseDao() {    return baseDao;  }  public void setBaseDao(IBaseDao baseDao) {    this.baseDao = baseDao;  }  public AsOptionDao getAsOptionDao() {    return asOptionDao;  }  public void setAsOptionDao(AsOptionDao asOptionDao) {    this.asOptionDao = asOptionDao;  }  public WFEngineAdapter getWfEngineAdapter() {    return wfEngineAdapter;  }  public void setWfEngineAdapter(WFEngineAdapter wfEngineAdapter) {    this.wfEngineAdapter = wfEngineAdapter;  }  public List getZcEbEvalPackList(ElementConditionDto dto, RequestMeta meta) {    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getWfcompoId(), NumLimConstants.FWATCH));    return baseDao.query("ZcEbEval.getZcEbPackList", dto);  }  public List getZcEbEvalExpertList(ElementConditionDto dto) {    return baseDao.query("ZcEbEval.getEvalExpertList", dto);  }  public List getZcEbEvalReportList(ElementConditionDto dto, RequestMeta meta) {    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getWfcompoId(), NumLimConstants.FWATCH));    List list = zcEbEvalDao.getZcEbEvalReportList(dto);    for (int i = 0; i < list.size(); i++) {      ZcEbEvalReport zcEbEvalReport = (ZcEbEvalReport) list.get(i);      zcEbEvalReport.setDbDigest(zcEbEvalReport.digest());    }    return list;  }  public List getZcEbEvalItemResultList(Map map) {    List evalResultList = new ArrayList();    evalResultList = zcEbEvalDao.getZcEbEvalItemResultList(map);    // 获得评标的结果 ,如果评标结果为空，表示该专家对供应商还未进行评标。    if (evalResultList == null || evalResultList.size() == 0) {      evalResultList = getZcEbEvalFormulaItemList(map);    }    return evalResultList;  }  public List getZcEbEvalFormulaItemList(Map map) {    List formulaItemList = zcEbEvalDao.getZcEbEvalFormulaItemList(map);    if (map.get("ITEM_TYPE").equals(EvalItemType.COMPLIANICE)) {      ZcEbEvalItemResult compItem = new ZcEbEvalItemResult();      compItem.setItemCode(FormulaRootCode.COMPLIANCE);      compItem.setItemType(EvalItemType.COMPLIANICE);      compItem.setFormulaCode((String) map.get("FORMULA_CODE"));      compItem.setItemName("符合性指标");      formulaItemList.add(compItem);    } else {      ZcEbEvalItemResult scoreItem = new ZcEbEvalItemResult();      // 添加一个汇总结果：      scoreItem.setItemCode(FormulaRootCode.SCORE);      scoreItem.setItemType(EvalItemType.SCORE);      scoreItem.setFormulaCode((String) map.get("FORMULA_CODE"));      scoreItem.setItemName("技术性指标");      formulaItemList.add(scoreItem);    }    // * 专家评标看到初审的结果    // ZcEbProviderPreAudit audit = (ZcEbProviderPreAudit)    // baseDao.read("ZcEbProviderPreAudit.getZcEbProviderPreAuditByProviderCode",    // map);    // if (audit != null) {    // List auditList =    // baseDao.query("ZcEbProviderPreAudit.getZcEbProviderPreAuditItemList",    // audit.getResultCode());    // Map auditMap1 = new HashMap();    // Map auditMap2 = new HashMap();    //    // for (int i = 0; i < auditList.size(); i++) {    // ZcEbProviderPreAuditItem auditItem = (ZcEbProviderPreAuditItem)    // auditList.get(i);    // auditMap1.put(auditItem.getFormulaItemCode(),    // auditItem.getAuditValue());    // auditMap2.put(auditItem.getFormulaItemCode(),    // auditItem.getNoPassReason());    // }    // for (int i = 0; i < formulaItemList.size(); i++) {    // ZcEbEvalItemResult item = (ZcEbEvalItemResult)    // formulaItemList.get(i);    // item.setAuditValue((String) auditMap1.get(item.getItemCode()));    // item.setNoPassReason((String) auditMap2.get(item.getItemCode()));    // }    // }    return formulaItemList;  }  public void saveEvalitemResultList(List list) {    for (int i = 0; i < list.size(); i++) {      ZcEbEvalItemResult bean = (ZcEbEvalItemResult) list.get(i);      // baseDao.delete("ZcEbEval.deleteZcEbEvalItemResult", bean);      if (bean.getResultCode() == null) {        bean.setResultCode(UUID.randomUUID().toString());        baseDao.insert("ZcEbEval.insertZcEbEvalItemResult", bean);      } else {        baseDao.update("ZcEbEval.updateZcEbEvalItemResult", bean);      }    }  }  public void deleteEvalitemResultList(Map map) {    baseDao.delete("ZcEbEval.deleteZcEbEvalItemResult", map);  }  public void insertEvalItemResultList(List list) {    // 执行先删再插入操作    ZcEbEvalItemResult bean = (ZcEbEvalItemResult) list.get(0);    Map map = new HashMap();    map.put("projCode", bean.getProjCode());    map.put("packCode", bean.getPackCode());    map.put("evalExpertCode", bean.getEvalExpertCode());    map.put("providerCode", bean.getProviderCode());    map.put("itemType", bean.getItemType());    baseDao.delete("ZcEbEval.deleteZcEbEvalItemResult", map);    zcEbEvalDao.insertEvalItemResultList(list);  }  private ZcEbEvalItemResult calculatorComplainceRes(List childList, ZcEbEvalItemResult parentRes) {    int unPassCount = 0;    for (int i = 0; i < childList.size(); i++) {      ZcEbEvalItemResult detailRes = (ZcEbEvalItemResult) childList.get(i);      if (ComlianceItemValue.UN_PASS.equals(detailRes.getComplianceEvalValue())) {        unPassCount++;        break;      }    }    if (unPassCount >= 1) {      parentRes.setComplianceEvalValue(ComlianceItemValue.UN_PASS);      parentRes.setComplianceUnpassReason("任何一条不通过总结果即不通过");    } else {      parentRes.setComplianceEvalValue(ComlianceItemValue.PASS);    }    parentRes.setExpertEvalScore(new BigDecimal(0));    return parentRes;  }  public List getListEvalPackProvider(Map map) {    List providerList = zcEbEvalDao.getListEvalPackProvider(map);    for (int i = 0; i < providerList.size(); i++) {      EvalPackProvider provider = (EvalPackProvider) providerList.get(i);      map.put("PROVIDER_CODE", provider.getProviderCode());      // 判断该供应商的评审情况      List evalResultList = getZcEbEvalItemResultList(map);      String itemType = (String) map.get("ITEM_TYPE");      if (itemType.equals(EvalItemType.COMPLIANICE)) {        provider.setComplEvalList(evalResultList);      } else {        provider.setScoreEvalList(evalResultList);      }      provider.setEval(provider.providerIsEval(evalResultList));    }    return providerList;  }  public String getProviderEvalResult(Map map) {    map.put("PROVIDER_CODE", map.get("providerCode"));    map.put("ITEM_CODE", map.get("itemCode"));    map.put("ITEM_TYPE", map.get("itemType"));    map.put("FORMULA_CODE", map.get("formulaCode"));    map.put("PROJ_CODE", map.get("projCode"));    map.put("PACK_CODE", map.get("packCode"));    map.put("EVAL_EXPERT_CODE", map.get("expertCode"));    ZcEbEvalItemResult result = zcEbEvalDao.getZcEbEvalItemResult(map);    if (result == null) {      return "";    }    if (map.get("itemType").toString().equals(EvalItemType.SCORE)) {      return result.getExpertEvalScore().toString();    } else {      if (result.getComplianceEvalValue().equals("1")) {        return "通过";      } else {        return "不通过";      }    }  }  private boolean providerIsEval(List list) {    if (list == null || list.size() == 0) {      return false;    } else {      for (int i = 0; i < list.size(); i++) {        ZcEbEvalItemResult resulstItem = (ZcEbEvalItemResult) list.get(i);        if (resulstItem.getItemType().equals(EvalItemType.COMPLIANICE)) {          if (resulstItem.getComplianceEvalValue() == null) {            return false;          }        } else {          if (resulstItem.getExpertEvalScore() == null) {            return false;          }        }      }    }    return true;  }  public List getProviderList(Map map) {    return zcEbEvalDao.getListEvalPackProvider(map);  }  public List getZcEbEvalPackSumResult(Map map, RequestMeta meta) {    return zcEbEvalDao.getZcEbEvalPackSumResult(map);  }  public List getEvalParamList(Map map) {    return zcEbEvalDao.getEvalParamList(map);  }  public List getEvalParamResultList(Map map) {    List newList = new ArrayList();    List list = zcEbEvalDao.getEvalParamResultList(map);    for (int i = 0; i < list.size(); i++) {      ZcEbEvalParam param = (ZcEbEvalParam) list.get(i);      param.setDbDigest(param.digest());      newList.add(param);    }    return newList;  }  public void insertEvalParamResultList(List list) {    zcEbEvalDao.insertEvalParamResultList(list);  }  private void checkEvalParamResultConsistency(List currBeanList) {    ZcSUtil.checkConsistency(currBeanList, getOldParamResultList(currBeanList), "paramCode");  }  private List getOldParamResultList(List currBeanList) {    ZcEbEvalParam param = (ZcEbEvalParam) currBeanList.get(0);    Map paramMap = new HashMap();    paramMap.put("formulaCode", param.getFormulaCode());    paramMap.put("packCode", param.getPackCode());    paramMap.put("projCode", param.getProjCode());    return zcEbEvalDao.getEvalParamResultList(paramMap);  }  public void updateEvalParamResultList(List list) {    checkEvalParamResultConsistency(list);    zcEbEvalDao.updateEvalParamResultList(list);  }  public List getZcEbExpertEvalResultList(ElementConditionDto dto, RequestMeta meta) {    dto.setNumLimitStr(NumLimUtil.getInstance().getNumLimCondByCoType(dto.getWfcompoId(), NumLimConstants.FWATCH));    return zcEbEvalDao.getZcEbExpertEvalResultList(dto);  }  public List getZcEbPackEvalList(ElementConditionDto dto) {    return zcEbEvalDao.getZcEbPackEvalList(dto);  }  public ZcEbEvalReport insertZcEbEvalReport(ZcEbEvalReport zcEbEvalReport) {    // createWfDraft(zcEbEvalReport);    zcEbEvalDao.insertZcEbEvalReport(zcEbEvalReport);    return zcEbEvalReport;  }  public ZcEbEvalReport updateZcEbEvalReport(ZcEbEvalReport zcEbEvalReport) {    // checkReportConsistency(zcEbEvalReport);    zcEbEvalDao.updateZcEbEvalReport(zcEbEvalReport);    return zcEbEvalReport;  }  private void checkReportConsistency(ZcEbEvalReport zcEbEvalReport) {    ZcSUtil.checkConsistency(zcEbEvalReport, getOriginZcEbEntrust(zcEbEvalReport), "reportCode");  }  private ZcEbEvalReport getOriginZcEbEntrust(ZcEbEvalReport zcEbEvalReport) {    return this.zcEbEvalDao.getZcEbEvalReport(zcEbEvalReport.getReportCode());  }  public int deleteZcEbEvalReport(ZcEbEvalReport zcEbEvalReport) {    StringBuffer errorInfo = new StringBuffer("id为");    StringBuffer stackTraceMessage = new StringBuffer();    boolean fail = false;    int num = 0;    try {//      if (zcEbEvalReport.getReportAttachBlobid() != null && zcEbEvalReport.getReportAttachBlobid().length() > 0) {//        baseDao.delete("AsFile.deleteAsFileById", zcEbEvalReport.getReportAttachBlobid());//      }      num = zcEbEvalDao.deleteZcEbEvalReport(zcEbEvalReport);      Map map = new HashMap();      map.put("PROJ_CODE", zcEbEvalReport.getProjCode());      map.put("PACK_CODE", zcEbEvalReport.getPackCode());      zcEbEvalDao.deleteZcEbPackSumRes(map);      if (num == 0) {        errorInfo.append(": ");        errorInfo.append(zcEbEvalReport.getReportCode());        errorInfo.append("已被删除");        fail = true;      }    } catch (Exception ex) {      errorInfo.append(": ");      errorInfo.append(zcEbEvalReport.getReportCode());      stackTraceMessage.append(ExceptionUtil.getStackTrace(ex));      fail = true;    }    errorInfo.append("的评审报告删除失败！");    if (fail) {      BusinessException be = new BusinessException(errorInfo.toString());      be.setStackTraceMessage(stackTraceMessage.toString());      throw be;    }    return num;  }  public ZcEbEvalReport getZcEbEvalReport(String reportCode) {    ZcEbEvalReport zcEbEvalReport = zcEbEvalDao.getZcEbEvalReport(reportCode);    if (null != zcEbEvalReport) {      zcEbEvalReport.setDbDigest(zcEbEvalReport.digest());    }    return zcEbEvalReport;  }  public ZcEbEvalReport audit(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    //    // String zhuren =    // asOptionDao.getAsOption("AUDIT_CGZX_ZR").getOptVal();//采购中心主任角色    // String fuzhuren =    // asOptionDao.getAsOption("AUDIT_CGZX_FZR").getOptVal();//采购中心副主任角色    // String ysdwfzjs =    // AsOptionUtil.getInstance().getOptionVal("OPT_HT_AUDIT_TO_CGC_ROLE_STRING");//预算单位负责人    // String currentJs = meta.getSvPoCode();    // 如果主任审批，或者是副主任不送主任审批，则送中心经办人审批    // if ((currentJs.equalsIgnoreCase(fuzhuren) &&    // zcEbEvalReport.getIsGoonAudit().intValue() != 1) ||    // (currentJs.equalsIgnoreCase(zhuren))) {    // commitToZxjb(zcEbEvalReport);    // } else    // if (ysdwfzjs != null && ysdwfzjs.equalsIgnoreCase(currentJs))    // {//如果是预算单位负责人，则送中心经办人    // commitToZxjb(zcEbEvalReport);    // } else {    wfEngineAdapter.commit(zcEbEvalReport.getComment(), zcEbEvalReport, meta);    // }    return zcEbEvalReport;  }  private void commitToZxjb(ZcEbEvalReport zcEbEvalReport, RequestMeta requestMeta) {    String zxjbr = getZxjbr(zcEbEvalReport);// 获取采购中心经办人，负责人    WorkflowContext workflowContext = wfEngineAdapter.genCommonWFC(zcEbEvalReport.getComment(), zcEbEvalReport, requestMeta);    List result = new ArrayList();    result.add(zxjbr);    workflowContext.setNextExecutor(result);    wfEngineAdapter.commit(workflowContext);  }  private String getZxjbr(ZcEbEvalReport zcEbEvalReport) {    // TODO Auto-generated method stub    // ZcEbProtocol p = (ZcEbProtocol)    // this.baseDao.read("ZcEbProtocol.getZcEbProtocolByProtCode",    // protCode);    String userId = (String) baseDao.read("ZcEbRequirement.getNodeCgzxUserId", zcEbEvalReport.getProcessInstId());    return userId;  }  /**   *    *    *    * @Description: 送到下级单位继续审批   *    * @return ZcEbEvalReport 返回类型   *    * @since 1.0   */  public ZcEbEvalReport sendNextOrg(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    WorkflowContext contex = wfEngineAdapter.genCommonWFC(zcEbEvalReport.getComment(), zcEbEvalReport, meta);    List nextExecutors = new ArrayList();    HashMap para = new HashMap();    para.put("POSI_CODE", AsOptionUtil.getInstance().getOptionVal("CG_HT_AUDIT_YSDW_JB_ROLE_STRING_for_all"));    para.put("CO_CODE", zcEbEvalReport.getCoCode());    para.put("ND", zcEbEvalReport.getNd());    Position po = (Position) this.baseDao.read("User.getAsEmpPosiByEmpCode", para);    if (po == null)      return null;    nextExecutors.add(po.getEmpCode());    contex.setNextExecutor(nextExecutors);    wfEngineAdapter.commit(contex);    return zcEbEvalReport;  }  public ZcEbEvalReport newCommit(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    wfEngineAdapter.newCommit(zcEbEvalReport.getComment(), zcEbEvalReport, meta);    return zcEbEvalReport;  }  public ZcEbEvalReport unaudit(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    wfEngineAdapter.unAudit(zcEbEvalReport.getComment(), zcEbEvalReport, meta);    return zcEbEvalReport;  }  public ZcEbEvalReport untread(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    wfEngineAdapter.untread(zcEbEvalReport.getComment(), zcEbEvalReport, meta);    return zcEbEvalReport;  }  public ZcEbEvalReport callbackZcEbEvalReport(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    wfEngineAdapter.callback(zcEbEvalReport.getComment(), zcEbEvalReport, meta);    return zcEbEvalReport;  }  public void updateZcEbEvalStatus(List zcEbEvalReportList) {    for (int i = 0; i < zcEbEvalReportList.size(); i++) {      ZcEbEvalReport zcEbEvalReport = (ZcEbEvalReport) zcEbEvalReportList.get(i);      checkReportConsistency(zcEbEvalReport);    }    for (int i = 0; i < zcEbEvalReportList.size(); i++) {      ZcEbEvalReport zcEbEvalReport = (ZcEbEvalReport) zcEbEvalReportList.get(i);      zcEbEvalDao.updateZcEbEvalReport(zcEbEvalReport);    }  }  public ZcEbEvalReport updateZcEbEvalStatus(ZcEbEvalReport zcEbEvalReport) {    checkReportConsistency(zcEbEvalReport);    zcEbEvalDao.updateZcEbEvalReport(zcEbEvalReport);    return zcEbEvalReport;  }  /**   *    * 评审报告创建草稿   */  public void createWfDraft(ZcEbEvalReport zcEbEvalReport, RequestMeta meta) {    Long draftid = workflowDao.createDraftId();    zcEbEvalReport.setProcessInstId(draftid);    AsWfDraft asWfDraft = new AsWfDraft();    asWfDraft.setCompoId(meta.getCompoId());    asWfDraft.setWfDraftName(zcEbEvalReport.getTitleField());    asWfDraft.setUserId(meta.getSvUserID());    asWfDraft.setMasterTabId("ZC_EB_EVAL_REPORT");    asWfDraft.setWfDraftId(BigDecimal.valueOf(draftid.longValue()));    workflowDao.insertAsWfdraft(asWfDraft);  }  public String genExpertSumResult(Map map) {    return zcEbEvalDao.genExpertSumResult(map);  }  /**   *    * 获取某一专家对某一供应商的评审结果。   */  public List getExpertEvalPackResList(Map map) {    List list = zcEbEvalDao.getExpertEvalPackResList(map);    for (int i = 0; i < list.size(); i++) {      ZcEbExpertEvalResult result = (ZcEbExpertEvalResult) list.get(i);      ElementConditionDto dto = new ElementConditionDto();      dto.setZcText1(EvalItemType.COMPLIANICE);      dto.setZcText0(result.getFormulaCode());      dto.setZcText4("N");      dto.setPackCode(result.getPackCode());      dto.setProjCode(result.getProjCode());      dto.setZcText2(result.getExpertCode());      dto.setZcText3(result.getProviderCode());      result.setZcEbEvalComplItemResultList(zcEbEvalDao.getZcEbExpertEvalResultList(dto));      dto.setZcText1(EvalItemType.SCORE);      if (list != null && list.size() > 0) {        result.setZcEbEvalScoreItemResultList(zcEbEvalDao.getZcEbExpertEvalResultList(dto));      }    }    return list;  }  /*   * (non-Javadoc)   *    * <p>Title: genPackFinalSumResult</p>   *    * <p>Description: </p>   *    * @param map   *    * @return   *    * @see   * com.ufgov.gk.server.zc.service.IZcEbEvalService#genFinalSumResult(java   * .util.Map)   */  public List genPackFinalSumResult(Map map, List list) {    // 根据汇总的方式 ,获得计算处理类。    IZcEbPackExpertEvalResSumCalculator calculator = getCalculator(map);    String formulaCode = (String) map.get("FORML_CODE");    map.put("FILTER_BY_COMPLIANCE_RES", "Y");    // 符合性通过比例：暂时没用到    ZcEbFormula f =zcEbEvalDao.getZcEbFormula(formulaCode);    BigDecimal compliancePassRate =f.getComplianceRate();    List sumResList = new ArrayList();    List providerList = zcEbEvalDao.getListEvalPackProvider(map);    for (int i = 0; i < providerList.size(); i++) {      EvalPackProvider provider = (EvalPackProvider) providerList.get(i);      map.put("PROVIDER_CODE", provider.getProviderCode());      // 供应商打分的最总结果      ZcEbPackEvalResult finaResult = new ZcEbPackEvalResult();      finaResult.setProviderCode(provider.getProviderCode());      finaResult.setProviderName(provider.getProviderName());      finaResult.setProjCode(provider.getProjCode());      finaResult.setPackCode(provider.getPackCode());      finaResult.setIsComplianceResult("N");      finaResult.setProviderTotalPrice(provider.getBidSum());      List ExpertSumEvalResultList = new ArrayList();      for (int j = 0; j < list.size(); j++) {        ZcEbExpertEvalResult result = (ZcEbExpertEvalResult) list.get(j);        if (provider.getProviderCode().equals(result.getProviderCode())) {          ExpertSumEvalResultList.add(result);        }      }      finaResult.setZcEbExpertEvalResultList(ExpertSumEvalResultList);      // 获得汇总结果      genProviderPackSumRes(providerList.size(), calculator, finaResult, map, compliancePassRate);      sumResList.add(finaResult);    }    return sumResList;  }  private IZcEbPackExpertEvalResSumCalculator getCalculator(Map map) {    String calWayID = (String) map.get("SUM_WAY_ID");    String calculatorClassName = zcEbEvalDao.getCalculatorWay(calWayID).getCalClass();    Class calculatorClass = null;    try {      calculatorClass = Class.forName(calculatorClassName);      IZcEbPackExpertEvalResSumCalculator calculator = (IZcEbPackExpertEvalResSumCalculator) calculatorClass.newInstance();      return calculator;    } catch (ClassNotFoundException e) {      throw new RuntimeException("没有找到计算方式为" + map.get("SUM_WAY_NAME") + "的计算实现类!");    } catch (InstantiationException e) {      e.printStackTrace();      throw new RuntimeException("初始化计算实现类是发生异常!");    } catch (IllegalAccessException e) {      e.printStackTrace();      throw new RuntimeException("计算时发生异常!");    }  }  /**   *    *    *    * @Description: 根据汇总计算方式及对应供应商代码生成本供应商的最终汇总结果。   *    * @param providerCount   *            供应商数   *    * @param calWayID   *            计算处理方式ID   *    * @param providerCode   *            当前计算的供应商代码   *    * @param map   *            取当前计算供应商专家评审结果的参数。   *    * @return List 返回类型   *    * @since 1.0   */  private void genProviderPackSumRes(int providerCount, IZcEbPackExpertEvalResSumCalculator calculator, ZcEbPackEvalResult finaResult, Map map,  BigDecimal compliancePassRate) {    CalculatorParam param = new CalculatorParam();    param.setCompliancePassRate(compliancePassRate);    param.setExpertEvalPackResList(finaResult.getZcEbExpertEvalResultList());    param.setProviderCount(providerCount);    finaResult.setEvalScore(calculator.genProviderPackSumResult(param).getEvalScore());  }  /*   * (non-Javadoc)   *    * <p>Title: updateZcEbPackEvalFinalSumResult</p>   *    * <p>Description: </p>   *    * @param list   *    * @see com.ufgov.gk.server.zc.service.IZcEbEvalService#   * updateZcEbPackEvalFinalSumResult(java.util.List)   */  public void updateZcEbPackEvalFinalSumResultFN(List list) {    for (int i = 0; i < list.size(); i++) {      ZcEbPackEvalResult result = (ZcEbPackEvalResult) list.get(i);      Map map = new HashMap();      map.put("projCode", result.getProjCode());      map.put("packCode", result.getPackCode());      map.put("providerCode", result.getProviderCode());      map.put("IS_COMPLIANCE_RESULT", result.getIsComplianceResult());      // 先删除原理的汇总结果      zcEbEvalDao.deleteZcEbPackEvalFinalSumResult(map);      result.setResultCode(String.valueOf(UUID.randomUUID()));      zcEbEvalDao.insertParckFinalSumResult(result);    }  }  public void deleteZcEbPackEvalFinalSumResult(Map map) {    zcEbEvalDao.deleteZcEbPackEvalFinalSumResult(map);  }  public static List parseRegExp() {    List paramList = new ArrayList();    String s = "@价格分#=@投标价#*(1-@调整系数#);";    String regex = "\\[(?:[^\\]]+)\\]";    // String regex = "@(?:[^#]+)#";    Pattern pat = Pattern.compile(regex);    Matcher matcher = pat.matcher(s);    while (matcher.find()) {      int start = matcher.start();      int end = matcher.end();      String item = s.substring(start + 1, end - 1);      paramList.add(item);      System.out.println(s.substring(start + 1, end - 1));    }    return paramList;  }  private List getItemResultList(ZcEbEvalItemResult itemResult) {    Map paramMap = new HashMap();    paramMap.put("ITEM_TYPE", itemResult.getItemType());    paramMap.put("FORMULA_CODE", itemResult.getFormulaCode());    paramMap.put("PROVIDER_CODE", itemResult.getProviderCode());    paramMap.put("EVAL_EXPERT_CODE", itemResult.getEvalExpertCode());    paramMap.put("PACK_CODE", itemResult.getPackCode());    paramMap.put("PROJ_CODE", itemResult.getProjCode());    return getZcEbEvalItemResultList(paramMap);  }  public ZcEbEvalReport saveZcEbEvalReport(ZcEbEvalReport zcEbEvalReport) {    String reportCode = zcEbEvalReport.getReportCode();    if (null == reportCode) {      zcEbEvalReport.setReportCode(UUID.randomUUID().toString());      return insertZcEbEvalReport(zcEbEvalReport);    } else {      return updateZcEbEvalReport(zcEbEvalReport);    }  }  public List getZcEbEvalResult(Map map) {    return zcEbEvalDao.getZcEbEvalResult(map);  }  public List getZcEbEvalFormulaItemReportList(Map map) {    return zcEbEvalDao.getZcEbEvalFormulaItemReportList(map);  }  public PrintObject genZcEbEvalReportPrintObject(ZcEbEvalReport zcEbEvalReport) {    MainSubBill mainSubBill = new MainSubBill();    mainSubBill.setMainBill(zcEbEvalReport);    mainSubBill.setSubBillList(zcEbEvalReport.getPackEvalResultList());    return PrintManager.genMainSubPrintObject(mainSubBill);  }  public List getEbExpertOpinionList(Map map) {    return baseDao.query("ZcEbEval.getEbExpertOpinionList", map);  }  public ZcEbExpertOpinion getZcEbExpertOpinion(Map map) {    return (ZcEbExpertOpinion) baseDao.read("ZcEbEval.getEbExpertOpinion", map);  }  public void SaveZcEbExpertOpinion(ZcEbExpertOpinion zcEbExpertOpinion) {    // 执行删插操作    baseDao.delete("ZcEbEval.deleteZcEbExpertOpinion", zcEbExpertOpinion);    baseDao.insert("ZcEbEval.insertZcEbExpertOpinion", zcEbExpertOpinion);  }  public void saveFinalEvalResult(List list) {  }  public ZcEbEvalBidTeamMember getZcEbEvalMember(ZcEbEvalPack evalPack) {    return this.zcEbEvalDao.getZcEbEvalMemer(evalPack);  }  public ZcEbEvalReport sendToProcurementUnit(ZcEbEvalReport zcEbEvalReport, RequestMeta requestMeta) {    sendNextOrg(zcEbEvalReport, requestMeta);    return zcEbEvalReport;  }  public void insertProEvalItemResultList(Map map, List providerList, RequestMeta meta) {    // 采用的是删插操作    baseDao.delete("ZcEbEval.deleteZcEbEvalItemResult", map);    String itemType = (String) map.get("itemType");    for (int i = 0; i < providerList.size(); i++) {      EvalPackProvider provider = (EvalPackProvider) providerList.get(i);      // 采用删插的保存方式。      if (itemType.equals(EvalItemType.COMPLIANICE)) {        zcEbEvalDao.insertEvalItemResultList(provider.getComplEvalList());      } else {        zcEbEvalDao.insertEvalItemResultList(provider.getScoreEvalList());      }    }  }  /*   *    * --------------------------------------------------专家承诺--------------------   * ------------------------------------   */  public void deleteZcExpertChengNuo(ZcEbExpertChengNuo bill, RequestMeta meta) {    baseDao.delete("ZcEbEval.deleteZcEbExpertChengNuo", bill);  }  public void saveZcExpertChengNuo(ZcEbExpertChengNuo bill, RequestMeta meta) {    baseDao.delete("ZcEbEval.deleteZcEbExpertChengNuo", bill);    baseDao.insert("ZcEbEval.insertZcEbExpertChengNuo", bill);  }  public ZcEbExpertChengNuo getZcExpertChengNuo(Map map, RequestMeta meta) {    return (ZcEbExpertChengNuo) baseDao.read("ZcEbEval.getZcEbExpertChengNuo", map);  }  public List getZcEbPackEvalResult(Map map) {    // TODO Auto-generated method stub    return baseDao.query("ZcEbPackResult.getProviderByProj", map);  }     public List queryExportsDatas(ElementConditionDto dto, RequestMeta meta) {    // TODO Auto-generated method stub    List rtn=baseDao.query("ZcEbEval.queryExportsDatas", dto);    //获取工作流信息    if(rtn!=null && rtn.size()>0){      ZcSUtil su=new ZcSUtil();      for(int i=0;i<rtn.size();i++){        su.getWorkFlowInfo((ZcBaseBill)rtn.get(i));      }    }    return rtn;  }    public String importTransDatasFN(ZcEbEvalReport bill, RequestMeta meta) {    // TODO Auto-generated method stub    deleteZcEbEvalReport(bill);    insertZcEbEvalReport(bill);    return "导入成功";  }     public String saveOffLineEvalBidFN(List packLst, RequestMeta requestMeta) {    // TODO Auto-generated method stub    if(packLst==null)return "没有数据需要保存";    for(int i=0;i<packLst.size();i++){      ZcEbSupplierPack sp=(ZcEbSupplierPack)packLst.get(i);      ZcEbOpenBid openBid =new ZcEbOpenBid();      openBid.setSignupId(sp.getSignupID());      openBid.setPackCode(sp.getPackCode());      openBid.setOpenBidStatus(sp.getOpenBidStatus());            openBid.setOpenBidDate(sp.getOpenBidDate()==null?Calendar.getInstance().getTime():sp.getOpenBidDate());      String priceStr="";      if(sp.getProviderTotalPrice()!=null){        priceStr=""+sp.getProviderTotalPrice().doubleValue();      }      openBid.setBidSum(priceStr);      openBid.setEcbjSum(sp.getProviderTotalPrice());      openBid.setPromiseWorkDate("");      zcEbOpenBidDao.updateOpenBid(openBid);    }    return "保存成功";  }}