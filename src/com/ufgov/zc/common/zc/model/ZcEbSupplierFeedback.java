package com.ufgov.zc.common.zc.model;import java.io.Serializable;/** * 供应商履约情况反馈表 * @author mengw 2010-7-13 * */public class ZcEbSupplierFeedback extends ZcBaseBill implements Serializable {  private String objId;//主键   private String supplierCode;//供应商 code  private String projectName;//项目名称  private String cgr;//项目采购人  private String jh;//交货方面评价   private String jg;//价格方面评价  private String zl;//质量方面评价  private String fw;//服务方面评价  private String bz;//备注  public String getObjId() {    return objId;  }  public void setObjId(String objId) {    this.objId = objId;  }  public String getSupplierCode() {    return supplierCode;  }  public void setSupplierCode(String supplierCode) {    this.supplierCode = supplierCode;  }  public String getProjectName() {    return projectName;  }  public void setProjectName(String projectName) {    this.projectName = projectName;  }  public String getCgr() {    return cgr;  }  public void setCgr(String cgr) {    this.cgr = cgr;  }  public String getJh() {    return jh;  }  public void setJh(String jh) {    this.jh = jh;  }  public String getJg() {    return jg;  }  public void setJg(String jg) {    this.jg = jg;  }  public String getZl() {    return zl;  }  public void setZl(String zl) {    this.zl = zl;  }  public String getFw() {    return fw;  }  public void setFw(String fw) {    this.fw = fw;  }  public String getBz() {    return bz;  }  public void setBz(String bz) {    this.bz = bz;  }}