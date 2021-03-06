package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfJdPerson extends ZcBaseBill{
    /**
   * 
   */
  private static final long serialVersionUID = -7608002169933670970L;
  
  public static final String COL_ACCOUNT="SF_JD_PERSON_ACCOUNT"; // 系统登陆账号
  public static final String COL_BIRTHDAY="SF_JD_PERSON_BIRTHDAY"; // 出生日期
  public static final String COL_CERTIFICATE_NO="SF_JD_PERSON_CERTIFICATE_NO"; // 执业证号
  public static final String COL_JD_PERSON_ID="SF_JD_PERSON_JD_PERSON_ID"; // 鉴定人员ID
  public static final String COL_NAME="SF_JD_PERSON_NAME"; // 姓名
  public static final String COL_PASSWORD="SF_JD_PERSON_PASSWORD"; // 登陆密码
  public static final String COL_REMARK="SF_JD_PERSON_REMARK"; // 备注
  public static final String COL_SEX="SF_JD_PERSON_SEX"; // 性别
  public static final String COL_STATUS="SF_JD_PERSON_STATUS"; // 状态
  public static final String COL_TECH_TITLE="SF_JD_PERSON_TECH_TITLE"; // 技术职称


  /**
   * 司法鉴定人员页签
   */
  public static final String TAB_ID="SfJdPerson_Tab";

  public static final String SF_VS_JD_PERSON_STATUS="SF_VS_JD_PERSON_STATUS";
  
  /**
   * 启用
   */
  public static final String STATUS_ENABLE="enable";
  /**
   * 暂停
   */
  public static final String STATUS_UNABLE="unable";
  

  public static final String SEQ_SF_JD_PERSON_ID="SEQ_SF_JD_PERSON_ID";
  
  private List majorLst=new ArrayList();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.JD_PERSON_ID
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private BigDecimal jdPersonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.NAME
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.SEX
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.BIRTHDAY
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.TECH_TITLE
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String techTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.CERTIFICATE_NO
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String certificateNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.STATUS
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.REMARK
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.ACCOUNT
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_JD_PERSON.PASSWORD
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.JD_PERSON_ID
     *
     * @return the value of SF_JD_PERSON.JD_PERSON_ID
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public BigDecimal getJdPersonId() {
        return jdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.JD_PERSON_ID
     *
     * @param jdPersonId the value for SF_JD_PERSON.JD_PERSON_ID
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setJdPersonId(BigDecimal jdPersonId) {
        this.jdPersonId = jdPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.NAME
     *
     * @return the value of SF_JD_PERSON.NAME
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.NAME
     *
     * @param name the value for SF_JD_PERSON.NAME
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.SEX
     *
     * @return the value of SF_JD_PERSON.SEX
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.SEX
     *
     * @param sex the value for SF_JD_PERSON.SEX
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.BIRTHDAY
     *
     * @return the value of SF_JD_PERSON.BIRTHDAY
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.BIRTHDAY
     *
     * @param birthday the value for SF_JD_PERSON.BIRTHDAY
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.TECH_TITLE
     *
     * @return the value of SF_JD_PERSON.TECH_TITLE
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getTechTitle() {
        return techTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.TECH_TITLE
     *
     * @param techTitle the value for SF_JD_PERSON.TECH_TITLE
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setTechTitle(String techTitle) {
        this.techTitle = techTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.CERTIFICATE_NO
     *
     * @return the value of SF_JD_PERSON.CERTIFICATE_NO
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.CERTIFICATE_NO
     *
     * @param certificateNo the value for SF_JD_PERSON.CERTIFICATE_NO
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.STATUS
     *
     * @return the value of SF_JD_PERSON.STATUS
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.STATUS
     *
     * @param status the value for SF_JD_PERSON.STATUS
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.REMARK
     *
     * @return the value of SF_JD_PERSON.REMARK
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.REMARK
     *
     * @param remark the value for SF_JD_PERSON.REMARK
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.ACCOUNT
     *
     * @return the value of SF_JD_PERSON.ACCOUNT
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.ACCOUNT
     *
     * @param account the value for SF_JD_PERSON.ACCOUNT
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_JD_PERSON.PASSWORD
     *
     * @return the value of SF_JD_PERSON.PASSWORD
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_JD_PERSON.PASSWORD
     *
     * @param password the value for SF_JD_PERSON.PASSWORD
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public List getMajorLst() {
      return majorLst;
    }

    public void setMajorLst(List majorLst) {
      this.majorLst = majorLst;
    }
}