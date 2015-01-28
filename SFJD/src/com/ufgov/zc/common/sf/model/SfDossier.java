package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;
import java.util.Date;

import com.ufgov.zc.common.util.EmpMeta;
import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfDossier extends ZcBaseBill{

  public static final String SEQ_SF_DOSSIER_ID="SEQ_SF_DOSSIER_ID";
  /**
   * 回执页签
   */
  public static final String TAB_ID="SfDossier_Tab";
  /**
   * 回执搜索条件
   */
  public static final String SEARCH_ID="SfDossier_search";
  
  /**
   * 卷宗目录类别 :法医检验卷宗目录
   */
  public static final String DOSSIER_TYPE_FA_YI="fayi";
  /**
   * 卷宗目录类别 :物证检验卷宗目录
   */
  public static final String DOSSIER_TYPE_WU_ZHENG="wuzheng";  
  /**
   * 卷宗目录类别 :其他
   */
  public static final String DOSSIER_TYPE_OTHER="other";  

  public static final String SF_VS_DOSSIER_TYPE="SF_VS_DOSSIER_TYPE";  

  public static final String SF_VS_DOSSIER_STATUS="SF_VS_DOSSIER_STATUS";  
  
  public static final String COL_DOSSIER_ID="SF_DOSSIER_DOSSIER_ID"; // 卷宗目录ID
  public static final String COL_DOSSIER_TYPE="SF_DOSSIER_DOSSIER_TYPE"; // 卷宗类别
  public static final String COL_ENTRUST_CODE="SF_DOSSIER_ENTRUST_CODE"; // 委托编号
  public static final String COL_ENTRUST_ID="SF_DOSSIER_ENTRUST_ID"; // 委托ID
  public static final String COL_INPUTOR="SF_DOSSIER_INPUTOR"; // 录入人
  public static final String COL_INPUT_DATE="SF_DOSSIER_INPUT_DATE"; // 录入时间
  public static final String COL_NAME="SF_DOSSIER_NAME"; // 名称
  public static final String COL_ND="SF_DOSSIER_ND"; // 年度
  public static final String COL_PROCESS_INST_ID="SF_DOSSIER_PROCESS_INST_ID"; // 工作流实例号
  public static final String COL_REMARK="SF_DOSSIER_REMARK"; // 备注
  public static final String COL_STATUS="SF_DOSSIER_STATUS"; // 状态
  public static final String COL_FILE_ID="SF_DOSSIER_FILE_ID"; // word文件id

  
  private String fileId;
  
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.DOSSIER_ID
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private BigDecimal dossierId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.INPUTOR
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private String inputor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.INPUT_DATE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private Date inputDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.STATUS
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.ENTRUST_ID
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private BigDecimal entrustId;
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.ENTRUST_CODE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private String entrustCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.NAME
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private String name;
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.DOSSIER_TYPE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private String dossierType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_DOSSIER.REMARK
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.DOSSIER_ID
	 * @return  the value of SF_DOSSIER.DOSSIER_ID
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public BigDecimal getDossierId() {
		return dossierId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.DOSSIER_ID
	 * @param dossierId  the value for SF_DOSSIER.DOSSIER_ID
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setDossierId(BigDecimal dossierId) {
		this.dossierId = dossierId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.INPUTOR
	 * @return  the value of SF_DOSSIER.INPUTOR
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public String getInputor() {
		return inputor;
	}

  public String getInputorName() {
    return EmpMeta.getEmpName(inputor);
  }
	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.INPUTOR
	 * @param inputor  the value for SF_DOSSIER.INPUTOR
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setInputor(String inputor) {
		this.inputor = inputor;
	}

  public void setInputorName(String inputorName) {
  }
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.INPUT_DATE
	 * @return  the value of SF_DOSSIER.INPUT_DATE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.INPUT_DATE
	 * @param inputDate  the value for SF_DOSSIER.INPUT_DATE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.STATUS
	 * @return  the value of SF_DOSSIER.STATUS
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.STATUS
	 * @param status  the value for SF_DOSSIER.STATUS
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.ENTRUST_ID
	 * @return  the value of SF_DOSSIER.ENTRUST_ID
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public BigDecimal getEntrustId() {
		return entrustId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.ENTRUST_ID
	 * @param entrustId  the value for SF_DOSSIER.ENTRUST_ID
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setEntrustId(BigDecimal entrustId) {
		this.entrustId = entrustId;
	}

	
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.ENTRUST_CODE
	 * @return  the value of SF_DOSSIER.ENTRUST_CODE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public String getEntrustCode() {
		return entrustCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.ENTRUST_CODE
	 * @param entrustCode  the value for SF_DOSSIER.ENTRUST_CODE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setEntrustCode(String entrustCode) {
		this.entrustCode = entrustCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.NAME
	 * @return  the value of SF_DOSSIER.NAME
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.NAME
	 * @param name  the value for SF_DOSSIER.NAME
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.DOSSIER_TYPE
	 * @return  the value of SF_DOSSIER.DOSSIER_TYPE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public String getDossierType() {
		return dossierType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.DOSSIER_TYPE
	 * @param dossierType  the value for SF_DOSSIER.DOSSIER_TYPE
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setDossierType(String dossierType) {
		this.dossierType = dossierType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_DOSSIER.REMARK
	 * @return  the value of SF_DOSSIER.REMARK
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_DOSSIER.REMARK
	 * @param remark  the value for SF_DOSSIER.REMARK
	 * @mbggenerated  Fri Jan 23 00:45:31 CST 2015
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  /**
   * 
   */
  private static final long serialVersionUID = -1338073265575074575L;

  }