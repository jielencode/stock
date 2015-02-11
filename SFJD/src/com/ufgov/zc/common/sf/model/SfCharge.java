package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ufgov.zc.common.util.EmpMeta;
import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfCharge extends ZcBaseBill {
  public static final String SEQ_SF_CHARGE_ID = "SEQ_SF_CHARGE_ID";

  /**
   * 司法鉴定费用页签
   */
  public static final String TAB_ID = "SfCharge_Tab";

  /**
   * 搜索条件
   */
  public static final String SEARCH_ID = "SfCharge_search";

  public static final String SF_VS_CHARGE_STATUS = "SF_VS_CHARGE_STATUS";

  public static final String COL_CASHIER = "SF_CHARGE_CASHIER"; // 收费人

  public static final String COL_CASH_DATE = "SF_CHARGE_CASH_DATE"; // 收费时间

  public static final String COL_CHARGE_ID = "SF_CHARGE_CHARGE_ID"; // 收费ID

  public static final String COL_ENTRUST_CODE = "SF_CHARGE_ENTRUST_CODE"; // 委托编号

  public static final String COL_ENTRUST_ID = "SF_CHARGE_ENTRUST_ID"; // 委托ID

  public static final String COL_INPUTOR = "SF_CHARGE_INPUTOR"; // 录入人

  public static final String COL_INPUT_DATE = "SF_CHARGE_INPUT_DATE"; // 录入时间

  public static final String COL_NAME = "SF_CHARGE_NAME"; // 名称

  public static final String COL_ND = "SF_CHARGE_ND"; // 年度

  public static final String COL_PAYER = "SF_CHARGE_PAYER"; // 缴费人

  public static final String COL_PROCESS_INST_ID = "SF_CHARGE_PROCESS_INST_ID"; // 工作流实例号

  public static final String COL_REMARK = "SF_CHARGE_REMARK"; // 备注

  public static final String COL_TOTAL_PRICE = "SF_CHARGE_TOTAL_PRICE"; // 收费金额合计

  public static final String COL_STATUS = "SF_CHARGE_STATUS"; // 状态

  private SfPayFees fees = new SfPayFees();

  private List chargeDetaillst = new ArrayList();

  private String status;

  /**
  * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.CHARGE_ID
  * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
  */
  private BigDecimal chargeId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.ENTRUST_ID
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private BigDecimal entrustId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.CASHIER
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private String cashier;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.CASH_DATE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private Date cashDate;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.INPUTOR
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private String inputor;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.INPUT_DATE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private Date inputDate;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.PAYER
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private String payer;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.TOTAL_PRICE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private BigDecimal totalPrice;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.REMARK
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private String remark;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.ENTRUST_CODE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private String entrustCode;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column SF_CHARGE.NAME
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  private String name;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.CHARGE_ID
   * @return  the value of SF_CHARGE.CHARGE_ID
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public BigDecimal getChargeId() {
    return chargeId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.CHARGE_ID
   * @param chargeId  the value for SF_CHARGE.CHARGE_ID
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setChargeId(BigDecimal chargeId) {
    this.chargeId = chargeId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.ENTRUST_ID
   * @return  the value of SF_CHARGE.ENTRUST_ID
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public BigDecimal getEntrustId() {
    return entrustId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.ENTRUST_ID
   * @param entrustId  the value for SF_CHARGE.ENTRUST_ID
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setEntrustId(BigDecimal entrustId) {
    this.entrustId = entrustId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.CASHIER
   * @return  the value of SF_CHARGE.CASHIER
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public String getCashier() {
    return cashier;
  }

  public String getCashierName() {
    if (cashier != null) {
      return EmpMeta.getEmpName(cashier);
    }
    return cashier;
  }

  public void setCashierName(String cashierName) {

  }

  public String getInputorName() {
    if (inputor != null) {
      return EmpMeta.getEmpName(inputor);
    }
    return inputorName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.CASHIER
   * @param cashier  the value for SF_CHARGE.CASHIER
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setCashier(String cashier) {
    this.cashier = cashier;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.CASH_DATE
   * @return  the value of SF_CHARGE.CASH_DATE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public Date getCashDate() {
    return cashDate;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.CASH_DATE
   * @param cashDate  the value for SF_CHARGE.CASH_DATE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setCashDate(Date cashDate) {
    this.cashDate = cashDate;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.INPUTOR
   * @return  the value of SF_CHARGE.INPUTOR
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public String getInputor() {
    return inputor;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.INPUTOR
   * @param inputor  the value for SF_CHARGE.INPUTOR
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setInputor(String inputor) {
    this.inputor = inputor;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.INPUT_DATE
   * @return  the value of SF_CHARGE.INPUT_DATE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public Date getInputDate() {
    return inputDate;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.INPUT_DATE
   * @param inputDate  the value for SF_CHARGE.INPUT_DATE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setInputDate(Date inputDate) {
    this.inputDate = inputDate;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.PAYER
   * @return  the value of SF_CHARGE.PAYER
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public String getPayer() {
    return payer;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.PAYER
   * @param payer  the value for SF_CHARGE.PAYER
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setPayer(String payer) {
    this.payer = payer;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.TOTAL_PRICE
   * @return  the value of SF_CHARGE.TOTAL_PRICE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.TOTAL_PRICE
   * @param totalPrice  the value for SF_CHARGE.TOTAL_PRICE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.REMARK
   * @return  the value of SF_CHARGE.REMARK
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public String getRemark() {
    return remark;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.REMARK
   * @param remark  the value for SF_CHARGE.REMARK
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setRemark(String remark) {
    this.remark = remark;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.ENTRUST_CODE
   * @return  the value of SF_CHARGE.ENTRUST_CODE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public String getEntrustCode() {
    return entrustCode;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.ENTRUST_CODE
   * @param entrustCode  the value for SF_CHARGE.ENTRUST_CODE
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setEntrustCode(String entrustCode) {
    this.entrustCode = entrustCode;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database column SF_CHARGE.NAME
   * @return  the value of SF_CHARGE.NAME
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database column SF_CHARGE.NAME
   * @param name  the value for SF_CHARGE.NAME
   * @mbggenerated  Wed Jan 14 01:24:40 CST 2015
   */
  public void setName(String name) {
    this.name = name;
  }

  public List getChargeDetaillst() {
    return chargeDetaillst;
  }

  public void setChargeDetaillst(List chargeDetaillst) {
    this.chargeDetaillst = chargeDetaillst;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SfPayFees getFees() {
    return fees;
  }

  public void setFees(SfPayFees fees) {
    if (fees != null) {
      setEntrustCode(fees.getEntrustCode());
      setEntrustId(fees.getEntrustId());
    }
    this.fees = fees;
  }

  /**
   * 
   */
  private static final long serialVersionUID = 2524185494790544981L;
}