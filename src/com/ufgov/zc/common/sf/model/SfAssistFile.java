package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;

import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfAssistFile extends ZcBaseBill{
    /**
   * 
   */
  private static final long serialVersionUID = -5109000691444095317L;
  
  public static final String SEQ_SF_ASSIST_FILE_ID="SEQ_SF_ASSIST_FILE_ID"; 
  
  public static final String COL_ASSIST_FILE_ID="SF_ASSIST_FILE_ASSIST_FILE_ID"; // 文档ID
  public static final String COL_FILE_DESC="SF_ASSIST_FILE_FILE_DESC"; // 摘要
  public static final String COL_FILE_ID="SF_ASSIST_FILE_FILE_ID"; // 文件Blobid
  public static final String COL_FILE_NAME="SF_ASSIST_FILE_FILE_NAME"; // 名称
  public static final String COL_FILE_TYPE="SF_ASSIST_FILE_FILE_TYPE"; // 文档类别

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_ASSIST_FILE.ASSIST_FILE_ID
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    private BigDecimal assistFileId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_ASSIST_FILE.FILE_NAME
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    private String fileName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_ASSIST_FILE.FILE_DESC
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    private String fileDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_ASSIST_FILE.FILE_ID
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    private String fileId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SF_ASSIST_FILE.FILE_TYPE
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    private String fileType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_ASSIST_FILE.ASSIST_FILE_ID
     *
     * @return the value of SF_ASSIST_FILE.ASSIST_FILE_ID
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public BigDecimal getAssistFileId() {
        return assistFileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_ASSIST_FILE.ASSIST_FILE_ID
     *
     * @param assistFileId the value for SF_ASSIST_FILE.ASSIST_FILE_ID
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public void setAssistFileId(BigDecimal assistFileId) {
        this.assistFileId = assistFileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_ASSIST_FILE.FILE_NAME
     *
     * @return the value of SF_ASSIST_FILE.FILE_NAME
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_ASSIST_FILE.FILE_NAME
     *
     * @param fileName the value for SF_ASSIST_FILE.FILE_NAME
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_ASSIST_FILE.FILE_DESC
     *
     * @return the value of SF_ASSIST_FILE.FILE_DESC
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public String getFileDesc() {
        return fileDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_ASSIST_FILE.FILE_DESC
     *
     * @param fileDesc the value for SF_ASSIST_FILE.FILE_DESC
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_ASSIST_FILE.FILE_ID
     *
     * @return the value of SF_ASSIST_FILE.FILE_ID
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_ASSIST_FILE.FILE_ID
     *
     * @param fileId the value for SF_ASSIST_FILE.FILE_ID
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SF_ASSIST_FILE.FILE_TYPE
     *
     * @return the value of SF_ASSIST_FILE.FILE_TYPE
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SF_ASSIST_FILE.FILE_TYPE
     *
     * @param fileType the value for SF_ASSIST_FILE.FILE_TYPE
     *
     * @mbggenerated Sun Jan 25 11:58:54 CST 2015
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTempId() {
      if(super.getTempId()!=null && super.getTempId().trim().length()>0){
        return super.getTempId();
      }else{
        return  assistFileId==null?super.getTempId():assistFileId.toString();
      }      
    }
}