package com.ufgov.zc.common.cp.model.report;import java.math.BigDecimal;public class BiPayQueryCpApply extends PayQueryReport {  private BigDecimal unauditCpApply;  private BigDecimal auditCpApply;  public BigDecimal getUnauditCpApply() {    return unauditCpApply;  }  public void setUnauditCpApply(BigDecimal unauditCpApply) {    this.unauditCpApply = unauditCpApply;  }  public BigDecimal getAuditCpApply() {    return auditCpApply;  }  public void setAuditCpApply(BigDecimal auditCpApply) {    this.auditCpApply = auditCpApply;  }}