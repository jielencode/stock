/**   * @(#) project: GK* @(#) file: ZcEbEvalReport.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.math.BigDecimal;import java.util.Date;import java.util.List;/*** @ClassName: ZcEbEvalReport* @Description: 评审报告实体对象。* @date: 2010-4-21 下午08:11:22* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbEvalReport extends ZcBaseBill implements Serializable {  private static final long serialVersionUID = -1793493724571212830L;  private String reportTitle;  private String reportCode;  private String recordCode;  private String projCode;  private String projName;  private String packCode;  private String packName;  private String status;  private String remark;  private String tsqkDescription;  private String evalDescription;  /**   * 评审报告附件ID   */  private String reportAttachBlobid;  private String reportAttach;  /**   * 签名附件ID   */  private String signReportAttachBlobid;  private String signReportAttach;  /**   * 检查公正意见   */  private String superviseOpinion;  /**   * 招标人意见   */  private String callBidOpinion;  /**   * 中标人   */  private String providerName;  private String providerCode;  private BigDecimal bidSum;  private String zcSuLinkMan;  /**   * 评标组意见   */  private String bidEvalOpinion;  private List packEvalResultList;  private String zcCoLinkMan;  private String expertOpinion;  private ZcEbPack zcEbPack;  public String getReportTitle() {    return reportTitle;  }  public void setReportTitle(String reportTitle) {    this.reportTitle = reportTitle;  }  public BigDecimal getBidSum() {    return bidSum;  }  public void setBidSum(BigDecimal bidSum) {    this.bidSum = bidSum;  }  public String getReportAttach() {    return reportAttach;  }  public void setReportAttach(String reportAttach) {    this.reportAttach = reportAttach;  }  public String getSignReportAttach() {    return signReportAttach;  }  public void setSignReportAttach(String signReportAttach) {    this.signReportAttach = signReportAttach;  }  public String getSuperviseOpinion() {    return superviseOpinion;  }  public void setSuperviseOpinion(String superviseOpinion) {    this.superviseOpinion = superviseOpinion;  }  public String getCallBidOpinion() {    return callBidOpinion;  }  public void setCallBidOpinion(String callBidOpinion) {    this.callBidOpinion = callBidOpinion;  }  public String getProviderName() {    return providerName;  }  public void setProviderName(String providerName) {    this.providerName = providerName;  }  public String getBidEvalOpinion() {    return bidEvalOpinion;  }  public void setBidEvalOpinion(String bidEvalOpinion) {    this.bidEvalOpinion = bidEvalOpinion;  }  public Date getBidDate() {    return bidDate;  }  public void setBidDate(Date bidDate) {    this.bidDate = bidDate;  }  private String bidLocation;  private String purType;  private String purTypeVal;  private String proxyProject;  private Date bidDate;  public String getBidLocation() {    return bidLocation;  }  public void setBidLocation(String bidLocation) {    this.bidLocation = bidLocation;  }  public String getPurType() {    return purType;  }  public void setPurType(String purType) {    this.purType = purType;  }  public String getProxyProject() {    return proxyProject;  }  public void setProxyProject(String proxyProject) {    this.proxyProject = proxyProject;  }  /**   * @return the reportCode   */  public String getReportCode() {    return reportCode;  }  /**   * @param reportCode the reportCode to set   */  public void setReportCode(String reportCode) {    this.reportCode = reportCode;  }  /**   * @return the projCode   */  public String getProjCode() {    return projCode;  }  /**   * @param projCode the projCode to set   */  public void setProjCode(String projCode) {    this.projCode = projCode;  }  /**   * @return the projName   */  public String getProjName() {    return projName;  }  /**   * @param projName the projName to set   */  public void setProjName(String projName) {    this.projName = projName;  }  /**   * @return the packCode   */  public String getPackCode() {    return packCode;  }  /**   * @param packCode the packCode to set   */  public void setPackCode(String packCode) {    this.packCode = packCode;  }  /**   * @return the packName   */  public String getPackName() {    return packName;  }  /**   * @param packName the packName to set   */  public void setPackName(String packName) {    this.packName = packName;  }  /**   * @return the recordCode   */  public String getRecordCode() {    return recordCode;  }  /**   * @param recordCode the recordCode to set   */  public void setRecordCode(String recordCode) {    this.recordCode = recordCode;  }  /**   * @return the status   */  public String getStatus() {    return status;  }  /**   * @param status the status to set   */  public void setStatus(String status) {    this.status = status;  }  /**   * @return the remark   */  public String getRemark() {    return remark;  }  /**   * @param remark the remark to set   */  public void setRemark(String remark) {    this.remark = remark;  }  /**   * @return the tsqkDescription   */  public String getTsqkDescription() {    return tsqkDescription;  }  /**   * @param tsqkDescription the tsqkDescription to set   */  public void setTsqkDescription(String tsqkDescription) {    this.tsqkDescription = tsqkDescription;  }  /**   * @return the evalDescription   */  public String getEvalDescription() {    return evalDescription;  }  /**   * @param evalDescription the evalDescription to set   */  public void setEvalDescription(String evalDescription) {    this.evalDescription = evalDescription;  }  /**   * @return the reportAttachBlobid   */  public String getReportAttachBlobid() {    return reportAttachBlobid;  }  /**   * @param reportAttachBlobid the reportAttachBlobid to set   */  public void setReportAttachBlobid(String reportAttachBlobid) {    this.reportAttachBlobid = reportAttachBlobid;  }  /**   * @return the signReportAttachBlobid   */  public String getSignReportAttachBlobid() {    return signReportAttachBlobid;  }  /**   * @param signReportAttachBlobid the signReportAttachBlobid to set   */  public void setSignReportAttachBlobid(String signReportAttachBlobid) {    this.signReportAttachBlobid = signReportAttachBlobid;  }  public String getProviderCode() {    return providerCode;  }  public void setProviderCode(String providerCode) {    this.providerCode = providerCode;  }  public String getZcSuLinkMan() {    return zcSuLinkMan;  }  public void setZcSuLinkMan(String zcSuLinkMan) {    this.zcSuLinkMan = zcSuLinkMan;  }  public List getPackEvalResultList() {    return packEvalResultList;  }  public void setPackEvalResultList(List packEvalResultList) {    this.packEvalResultList = packEvalResultList;  }  public String getPurTypeVal() {    return purTypeVal;  }  public void setPurTypeVal(String purTypeVal) {    this.purTypeVal = purTypeVal;  }  public String getZcCoLinkMan() {    return zcCoLinkMan;  }  public void setZcCoLinkMan(String zcCoLinkMan) {    this.zcCoLinkMan = zcCoLinkMan;  }  /**   * @return the expertOpinion   */  public String getExpertOpinion() {    return expertOpinion;  }  /**   * @param expertOpinion the expertOpinion to set   */  public void setExpertOpinion(String expertOpinion) {    this.expertOpinion = expertOpinion;  }  /**   * @return the zcEbPack   */  public ZcEbPack getZcEbPack() {    return zcEbPack;  }  /**   * @param zcEbPack the zcEbPack to set   */  public void setZcEbPack(ZcEbPack zcEbPack) {    this.zcEbPack = zcEbPack;  }}