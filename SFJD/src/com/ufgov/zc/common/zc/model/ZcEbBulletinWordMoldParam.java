package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.util.Date;public class ZcEbBulletinWordMoldParam implements Serializable {  private static final long serialVersionUID = -4289450435481040445L;  private String tempId;  private String bulletinParamID;  private String bulletinMoldCode;  private String paramName;  private String fieldName;  private String paramDesc;  private String paramValue;  private String paramType;  public String getBulletinParamID() {    return bulletinParamID;  }  public void setBulletinParamID(String bulletinParamID) {    this.bulletinParamID = bulletinParamID;  }  public String getBulletinMoldCode() {    return bulletinMoldCode;  }  public void setBulletinMoldCode(String bulletinMoldCode) {    this.bulletinMoldCode = bulletinMoldCode;  }  public String getParamName() {    return paramName;  }  public void setParamName(String paramName) {    this.paramName = paramName;  }  public String getFieldName() {    return fieldName;  }  public void setFieldName(String fieldName) {    this.fieldName = fieldName;  }  public String getParamDesc() {    return paramDesc;  }  public void setParamDesc(String paramDesc) {    this.paramDesc = paramDesc;  }  public String getParamValue() {    return paramValue;  }  public void setParamValue(String paramValue) {    this.paramValue = paramValue;  }  public String getTempId() {    return tempId;  }  public void setTempId(String tempId) {    this.tempId = tempId;  }  public String getParamType() {    return paramType;  }  public void setParamType(String paramType) {    this.paramType = paramType;  }}