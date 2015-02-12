package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;
import java.util.Date;

import com.ufgov.zc.common.util.EmpMeta;
import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfAgreement extends ZcBaseBill{
  
  public static final String SEQ_SF_AGREEMENT_ID="SEQ_SF_AGREEMENT_ID";
  /**
   * 司法鉴定协议书页签
   */
  public static final String TAB_ID="SfAgreement_Tab";

  /**
   * 司法鉴定委托评审搜索条件
   */
  public static final String SEARCH_ID="SfAgreement_search";
  
  public static final String SF_VS_AGREEMENT_STATUS="SF_VS_AGREEMENT_STATUS";
  
  public static final String COL_AGREEMENT_ID="SF_AGREEMENT_AGREEMENT_ID"; // 工作流实例号
  public static final String COL_ENTRUST_CODE="SF_AGREEMENT_ENTRUST_CODE"; // 工作流实例号
  public static final String COL_ENTRUST_ID="SF_AGREEMENT_ENTRUST_ID"; // 检案摘要
  public static final String COL_FILE_ID="SF_AGREEMENT_FILE_ID"; // 委托编号
  public static final String COL_INPUTOR="SF_AGREEMENT_INPUTOR"; // 委托方ID
  public static final String COL_INPUT_DATE="SF_AGREEMENT_INPUT_DATE"; // 委托ID
  public static final String COL_NAME="SF_AGREEMENT_NAME"; // 录入人
  public static final String COL_ND="SF_AGREEMENT_ND"; // 录入时间
  public static final String COL_PROCESS_INST_ID="SF_AGREEMENT_PROCESS_INST_ID"; // 是否受理
  public static final String COL_REMARK="SF_AGREEMENT_REMARK"; // 是否属于重新鉴定
  public static final String COL_STATUS="SF_AGREEMENT_STATUS"; // 鉴定机构

  private String fileId;
  
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.AGREEMENT_ID
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private BigDecimal agreementId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.ENTRUST_ID
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private BigDecimal entrustId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.INPUTOR
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private String inputor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.INPUT_DATE
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private Date inputDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.STATUS
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.REMARK
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.ENTRUST_CODE
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private String entrustCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_AGREEMENT.NAME
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	private String name;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.AGREEMENT_ID
	 * @return  the value of SF_AGREEMENT.AGREEMENT_ID
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public BigDecimal getAgreementId() {
		return agreementId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.AGREEMENT_ID
	 * @param agreementId  the value for SF_AGREEMENT.AGREEMENT_ID
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setAgreementId(BigDecimal agreementId) {
		this.agreementId = agreementId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.ENTRUST_ID
	 * @return  the value of SF_AGREEMENT.ENTRUST_ID
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public BigDecimal getEntrustId() {
		return entrustId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.ENTRUST_ID
	 * @param entrustId  the value for SF_AGREEMENT.ENTRUST_ID
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setEntrustId(BigDecimal entrustId) {
		this.entrustId = entrustId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.INPUTOR
	 * @return  the value of SF_AGREEMENT.INPUTOR
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public String getInputor() {
		return inputor;
	}

  public String getInputorName() {
    if(inputor!=null){
      return EmpMeta.getEmpName(inputor);
    }
    return inputorName;
  }

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.INPUTOR
	 * @param inputor  the value for SF_AGREEMENT.INPUTOR
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setInputor(String inputor) {
		this.inputor = inputor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.INPUT_DATE
	 * @return  the value of SF_AGREEMENT.INPUT_DATE
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.INPUT_DATE
	 * @param inputDate  the value for SF_AGREEMENT.INPUT_DATE
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.STATUS
	 * @return  the value of SF_AGREEMENT.STATUS
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.STATUS
	 * @param status  the value for SF_AGREEMENT.STATUS
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.REMARK
	 * @return  the value of SF_AGREEMENT.REMARK
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.REMARK
	 * @param remark  the value for SF_AGREEMENT.REMARK
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.ENTRUST_CODE
	 * @return  the value of SF_AGREEMENT.ENTRUST_CODE
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public String getEntrustCode() {
		return entrustCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.ENTRUST_CODE
	 * @param entrustCode  the value for SF_AGREEMENT.ENTRUST_CODE
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setEntrustCode(String entrustCode) {
		this.entrustCode = entrustCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_AGREEMENT.NAME
	 * @return  the value of SF_AGREEMENT.NAME
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_AGREEMENT.NAME
	 * @param name  the value for SF_AGREEMENT.NAME
	 * @mbggenerated  Tue Jan 13 03:11:13 CST 2015
	 */
	public void setName(String name) {
		this.name = name;
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
  private static final long serialVersionUID = 7284321149997894619L;

   
}