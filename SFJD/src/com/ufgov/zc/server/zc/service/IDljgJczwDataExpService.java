package com.ufgov.zc.server.zc.service;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;public interface IDljgJczwDataExpService {  public abstract List getZcEbRequirementData(List reqCodes);  public abstract List getZcEbRequirementDetailData(List reqCode);  public abstract List getWorkFlowInforData(List instanceIds);  public abstract List getAsFile(List fileIds);  public abstract List getZcEbBidCondition(List projCodes);  public abstract List getZcEbBulletin(List bulletinIdIds);  public abstract List getZcEbEvalReport(List zcEbEvalReportIds);  public abstract List getZcEbFormula(List projCodes);  public abstract List getZcEbFormulaItem(List formulaCodes);  public abstract List getZcEbFormulaParam(List formulaCodes);  public abstract List getZcEbPack(List projCodes);  public abstract List getZcEbPackReq(List projCodes);  public abstract List getZcEbPlan(List projCodes);  public abstract List getZcEbProj(List projCodes);  public abstract List getZcEbProjZbfile(List projCodes);  public abstract List getZcEbProtocol(List protCodes);  public abstract List getZcEbXunJia(List projCodes);  public abstract List getZcEbEntrustData(List snList);  public abstract List getZcEbEntrustDetailData(List entrustSnList);  public abstract List getZcEbAuditSheetData(List sheetIds);  public abstract List getZcPProMakeData(List zcMakeCodes);  public abstract List getZcPProMitem(List zcMakeCodes);  public abstract List getZcPProMitemBi(List zcMakeCodes);  public abstract List getZcPProMitemMer(List zcMakeCodes);  public List getZcEbPackReqDetail(List detailCodes);  public List getZcEbPackEvalResult(List packCodes);  public List getZcEbSignupPackDetailData(List signupId);  public List getZcEbSignupData(List projCodes, RequestMeta meta);  public Map getZcXmcgHtData(List projCodes);  public List getZcEntrustCancelData(List projCodes, RequestMeta requestMeta);}