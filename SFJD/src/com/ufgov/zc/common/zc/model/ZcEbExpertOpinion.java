/**   * @(#) project: ZFCG* @(#) file: ZcEbExpertOpinion.java* * Copyright 2011 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.common.zc.model;import java.io.Serializable;import java.util.Date;/*** @ClassName: ZcEbExpertOpinion* @Description: TODO(这里用一句话描述这个类的作用)* @date: 2011-4-1 下午04:08:00* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public class ZcEbExpertOpinion extends ZcBaseBill implements Serializable {  private String projCode;  private String projName;  private String packCode;  private String packName;  private String expertCode;  private String expertName;  private String opinion;  private Date time;  public String getProjCode() {    return projCode;  }  public void setProjCode(String projCode) {    this.projCode = projCode;  }  public String getProjName() {    return projName;  }  public void setProjName(String projName) {    this.projName = projName;  }  public String getPackCode() {    return packCode;  }  public void setPackCode(String packCode) {    this.packCode = packCode;  }  public String getPackName() {    return packName;  }  public void setPackName(String packName) {    this.packName = packName;  }  public String getExpertCode() {    return expertCode;  }  public void setExpertCode(String expertCode) {    this.expertCode = expertCode;  }  public String getExpertName() {    return expertName;  }  public void setExpertName(String expertName) {    this.expertName = expertName;  }  public String getOpinion() {    return opinion;  }  public void setOpinion(String opinion) {    this.opinion = opinion;  }  public Date getTime() {    return time;  }  public void setTime(Date time) {    this.time = time;  }}