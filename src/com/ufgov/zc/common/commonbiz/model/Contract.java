package com.ufgov.zc.common.commonbiz.model;import java.io.Serializable;public class Contract implements Serializable {  /**   *    */  private static final long serialVersionUID = -1580828026129488070L;  private int nd;  private String contractCode;  private String contractName;  private String projectCode;  private String projectName;  private String contractLimit;  private String totalMoney;  private String payer;  private String payee;  private String payStatus;  private String coName;  private String contractType;  private String contractContent;  private String examCondition;  private String projectNum;  private String contractBalMoney;  public String getContractCode() {    return contractCode;  }  public void setContractCode(String contractCode) {    this.contractCode = contractCode;  }  public String getContractName() {    return contractName;  }  public void setContractName(String contractName) {    this.contractName = contractName;  }  public int hashCode() {    final int prime = 31;    int result = 1;    result = prime * result + ((contractCode == null) ? 0 : contractCode.hashCode());    result = prime * result + ((contractName == null) ? 0 : contractName.hashCode());    result = prime * result + nd;    return result;  }  public boolean equals(Object obj) {    if (this == obj)      return true;    if (obj == null)      return false;    if (getClass() != obj.getClass())      return false;    final Contract other = (Contract) obj;    if (contractCode == null) {      if (other.contractCode != null)        return false;    } else if (!contractCode.equals(other.contractCode))      return false;    if (contractName == null) {      if (other.contractName != null)        return false;    } else if (!contractName.equals(other.contractName))      return false;    if (nd != other.nd)      return false;    return true;  }  public int getNd() {    return nd;  }  public void setNd(int nd) {    this.nd = nd;  }  public String getProjectCode() {    return projectCode;  }  public void setProjectCode(String projectCode) {    this.projectCode = projectCode;  }  public String getProjectName() {    return projectName;  }  public void setProjectName(String projectName) {    this.projectName = projectName;  }  public String getContractLimit() {    return contractLimit;  }  public void setContractLimit(String contractLimit) {    this.contractLimit = contractLimit;  }  public String getTotalMoney() {    return totalMoney;  }  public void setTotalMoney(String totalMoney) {    this.totalMoney = totalMoney;  }  public String getPayer() {    return payer;  }  public void setPayer(String payer) {    this.payer = payer;  }  public String getPayee() {    return payee;  }  public void setPayee(String payee) {    this.payee = payee;  }  public String getPayStatus() {    return payStatus;  }  public void setPayStatus(String payStatus) {    this.payStatus = payStatus;  }  public String getCoName() {    return coName;  }  public void setCoName(String coName) {    this.coName = coName;  }  public String getContractType() {    return contractType;  }  public void setContractType(String contractType) {    this.contractType = contractType;  }  public String getContractContent() {    return contractContent;  }  public void setContractContent(String contractContent) {    this.contractContent = contractContent;  }  public String getExamCondition() {    return examCondition;  }  public void setExamCondition(String examCondition) {    this.examCondition = examCondition;  }  public String getProjectNum() {    return projectNum;  }  public void setProjectNum(String projectNum) {    this.projectNum = projectNum;  }  public String getContractBalMoney() {    return contractBalMoney;  }  public void setContractBalMoney(String contractBalMoney) {    this.contractBalMoney = contractBalMoney;  }}