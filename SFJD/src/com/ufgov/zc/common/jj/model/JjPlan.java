package com.ufgov.zc.common.jj.model;import java.io.Serializable;import java.math.BigDecimal;import java.util.ArrayList;import java.util.Date;import java.util.List;import com.ufgov.zc.common.commonbiz.model.WfAware;public class JjPlan implements WfAware, Serializable {  private static final long serialVersionUID = -5839863167896314740L;  private String oid;  private String jjPlanCode;  private String projectCode;  private String projectName;  private BigDecimal auditMoney;  private BigDecimal planMoney;  private BigDecimal orgMoney;  private BigDecimal curMoney;  private Date projectStartDate;  private String coCode;  private String coName;  private String directorCoCode;  private String directorCoName;  private String fundCode;  private int nd;  private int month;  private Date procDate;  private String inputorId;  private String inputorName;  private Long processInstId;  private String auditorId;  private String auditorName;  private String inputGroupId;  private Date adate;  private String astatusCode;  /**   * 0 新增 1 下达 2 审核过程中   */  private String isEffect;  private Date effectDate;  private String isValid;  private String remark;  private int printTimes;  private String isFinished;  private List jjPlanDetailList = new ArrayList();  protected String clearAccCode;  protected String clearAccName;  protected String clearAccNo;  protected String clearBankCode;  protected String clearBankName;  protected String clearBankNo;  private BigDecimal sumEffectMoney = new BigDecimal("0.00");  private BigDecimal sumPayMoney = new BigDecimal("0.00");  private BigDecimal sumBalance = new BigDecimal("0.00");  public String getIsFinished() {    return isFinished;  }  public void setIsFinished(String isFinished) {    this.isFinished = isFinished;  }  public String getProjectCode() {    return projectCode;  }  public void setProjectCode(String projectCode) {    this.projectCode = projectCode;  }  public String getProjectName() {    return projectName;  }  public void setProjectName(String projectName) {    this.projectName = projectName;  }  public BigDecimal getAuditMoney() {    return auditMoney;  }  public void setAuditMoney(BigDecimal auditMoney) {    this.auditMoney = auditMoney;  }  public BigDecimal getPlanMoney() {    return planMoney;  }  public void setPlanMoney(BigDecimal planMoney) {    this.planMoney = planMoney;  }  public BigDecimal getOrgMoney() {    return orgMoney;  }  public void setOrgMoney(BigDecimal orgMoney) {    this.orgMoney = orgMoney;  }  public BigDecimal getCurMoney() {    return curMoney;  }  public void setCurMoney(BigDecimal curMoney) {    this.curMoney = curMoney;  }  public Date getProjectStartDate() {    return projectStartDate;  }  public void setProjectStartDate(Date projectStartDate) {    this.projectStartDate = projectStartDate;  }  public String getDirectorCoCode() {    return directorCoCode;  }  public void setDirectorCoCode(String directorCoCode) {    this.directorCoCode = directorCoCode;  }  public int getNd() {    return nd;  }  public void setNd(int nd) {    this.nd = nd;  }  public int getMonth() {    return month;  }  public void setMonth(int month) {    this.month = month;  }  public String getInputorId() {    return inputorId;  }  public void setInputorId(String inputorId) {    this.inputorId = inputorId;  }  public String getInputorName() {    return inputorName;  }  public void setInputorName(String inputorName) {    this.inputorName = inputorName;  }  public Long getProcessInstId() {    return processInstId;  }  public void setProcessInstId(Long processInstId) {    this.processInstId = processInstId;  }  public String getAuditorId() {    return auditorId;  }  public void setAuditorId(String auditorId) {    this.auditorId = auditorId;  }  public String getAuditorName() {    return auditorName;  }  public void setAuditorName(String auditorName) {    this.auditorName = auditorName;  }  public Date getAdate() {    return adate;  }  public void setAdate(Date adate) {    this.adate = adate;  }  public String getAstatusCode() {    return astatusCode;  }  public void setAstatusCode(String astatusCode) {    this.astatusCode = astatusCode;  }  public String getIsEffect() {    return isEffect;  }  public void setIsEffect(String isEffect) {    this.isEffect = isEffect;  }  public String getIsValid() {    return isValid;  }  public void setIsValid(String isValid) {    this.isValid = isValid;  }  public String getRemark() {    return remark;  }  public void setRemark(String remark) {    this.remark = remark;  }  public int getPrintTimes() {    return printTimes;  }  public void setPrintTimes(int printTimes) {    this.printTimes = printTimes;  }  public String toString() {    return this.projectName;  }  public String getOid() {    return oid;  }  public void setOid(String oid) {    this.oid = oid;  }  public String getJjPlanCode() {    return jjPlanCode;  }  public void setJjPlanCode(String jjPlanCode) {    this.jjPlanCode = jjPlanCode;  }  public Date getProcDate() {    return procDate;  }  public void setProcDate(Date procDate) {    this.procDate = procDate;  }  public Date getEffectDate() {    return effectDate;  }  public void setEffectDate(Date effectDate) {    this.effectDate = effectDate;  }  public List getJjPlanDetailList() {    return jjPlanDetailList;  }  public void setJjPlanDetailList(List jjPlanDetailList) {    this.jjPlanDetailList = jjPlanDetailList;  }  public String getDirectorCoName() {    return directorCoName;  }  public void setDirectorCoName(String directorCoName) {    this.directorCoName = directorCoName;  }  public String getFundCode() {    return fundCode;  }  public void setFundCode(String fundCode) {    this.fundCode = fundCode;  }  public String getClearAccCode() {    return clearAccCode;  }  public void setClearAccCode(String clearAccCode) {    this.clearAccCode = clearAccCode;  }  public String getClearAccName() {    return clearAccName;  }  public void setClearAccName(String clearAccName) {    this.clearAccName = clearAccName;  }  public String getClearAccNo() {    return clearAccNo;  }  public void setClearAccNo(String clearAccNo) {    this.clearAccNo = clearAccNo;  }  public String getClearBankCode() {    return clearBankCode;  }  public void setClearBankCode(String clearBankCode) {    this.clearBankCode = clearBankCode;  }  public String getClearBankName() {    return clearBankName;  }  public void setClearBankName(String clearBankName) {    this.clearBankName = clearBankName;  }  public String getClearBankNo() {    return clearBankNo;  }  public void setClearBankNo(String clearBankNo) {    this.clearBankNo = clearBankNo;  }  public String getTitleField() {    return this.getJjPlanCode();  }  public String getCoCode() {    return coCode;  }  public void setCoCode(String coCode) {    this.coCode = coCode;  }  public String getCoName() {    return coName;  }  public void setCoName(String coName) {    this.coName = coName;  }  public BigDecimal getSumEffectMoney() {    return sumEffectMoney;  }  public void setSumEffectMoney(BigDecimal sumEffectMoney) {    this.sumEffectMoney = sumEffectMoney;  }  public BigDecimal getSumPayMoney() {    return sumPayMoney;  }  public void setSumPayMoney(BigDecimal sumPayMoney) {    this.sumPayMoney = sumPayMoney;  }  public String getInputGroupId() {    return inputGroupId;  }  public void setInputGroupId(String inputGroupId) {    this.inputGroupId = inputGroupId;  }  public BigDecimal getSumBalance() {    return sumBalance;  }  public void setSumBalance(BigDecimal sumBalance) {    this.sumBalance = sumBalance;  }}