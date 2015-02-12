package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;

import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfJdPersonMajor extends ZcBaseBill {
    /**
   * 
   */
  private static final long serialVersionUID = -8892495466877183248L;
  
  public static final String COL_JD_PERSON_ID="SF_JD_PERSON_MAJOR_JD_PERSON_ID"; // 鉴定人员ID
  public static final String COL_MAJOR_CODE="SF_JD_PERSON_MAJOR_MAJOR_CODE"; // 专业编号
  
  private SfMajor major=new SfMajor();


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON_MAJOR.JD_PERSON_ID
     *
     * @mbggenerated Wed Jan 21 20:04:17 CST 2015
     */
    private BigDecimal jdPersonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON_MAJOR.MAJOR_CODE
     *
     * @mbggenerated Wed Jan 21 20:04:17 CST 2015
     */
    private String majorCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON_MAJOR.JD_PERSON_ID
     *
     * @return the value of SF_JD_PERSON_MAJOR.JD_PERSON_ID
     *
     * @mbggenerated Wed Jan 21 20:04:17 CST 2015
     */
    public BigDecimal getJdPersonId() {
        return jdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON_MAJOR.JD_PERSON_ID
     *
     * @param jdPersonId the value for SF_JD_PERSON_MAJOR.JD_PERSON_ID
     *
     * @mbggenerated Wed Jan 21 20:04:17 CST 2015
     */
    public void setJdPersonId(BigDecimal jdPersonId) {
        this.jdPersonId = jdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON_MAJOR.MAJOR_CODE
     *
     * @return the value of SF_JD_PERSON_MAJOR.MAJOR_CODE
     *
     * @mbggenerated Wed Jan 21 20:04:17 CST 2015
     */
    public String getMajorCode() {
        return major.getMajorCode();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON_MAJOR.MAJOR_CODE
     *
     * @param majorCode the value for SF_JD_PERSON_MAJOR.MAJOR_CODE
     *
     * @mbggenerated Wed Jan 21 20:04:17 CST 2015
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public SfMajor getMajor() {
      return major;
    }

    public void setMajor(SfMajor major) {
      this.major = major;
    }
}