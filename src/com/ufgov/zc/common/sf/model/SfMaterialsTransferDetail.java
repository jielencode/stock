package com.ufgov.zc.common.sf.model;

import java.math.BigDecimal;
import java.util.Date;

import com.ufgov.zc.common.zc.model.ZcBaseBill;

public class SfMaterialsTransferDetail extends ZcBaseBill{

  /**
   * 鉴定材料处置方法
   */
  public static final String SF_VS_SF_MATERIALS_HANDLE_STATUS="SF_VS_SF_MATERIALS_HANDLE_STATUS";
  
  /**
   * 用尽
   */
  public static final String HANDLE_STATUS_YONG_JIN="1";
  /**
   * 退回
   */
  public static final String HANDLE_STATUS_TUI_HUI="2";
  /**
   * 存档
   */
  public static final String HANDLE_STATUS_CUN_DANG="3";
  /**
   * 内部流转
   */
  public static final String HANDLE_STATUS_NEI_BU_LIU_ZHUAN="4";
  /**
   * 销毁(保管超期)
   */
  public static final String HANDLE_STATUS_XIAO_HUI_chaoqi="5";
  /**
   * 销毁(委托方请求)
   */
  public static final String HANDLE_STATUS_XIAO_HUI_qingqiu="6";
  
  public static final String COL_MATERIAL_ID="SF_MATERIALS_TRANSFER_DETAIL_MATERIAL_ID"; // 材料ID
  public static final String COL_OUT_INFO_DETAIL_ID="SF_MATERIALS_TRANSFER_DETAIL_OUT_INFO_DETAIL_ID"; // 外部信息ID
  public static final String COL_PROCESSING="SF_MATERIALS_TRANSFER_DETAIL_PROCESSING"; // 检验材料处理情况
  public static final String COL_PROCESSING_DATE="SF_MATERIALS_TRANSFER_DETAIL_PROCESSING_DATE"; // 处理时间
  public static final String COL_PROCESSING_MAN="SF_MATERIALS_TRANSFER_DETAIL_PROCESSING_MAN"; // 处理人
  public static final String COL_QUANTITY="SF_MATERIALS_TRANSFER_DETAIL_QUANTITY"; // 数量
  public static final String COL_REMARK="SF_MATERIALS_TRANSFER_DETAIL_REMARK"; // 备注
  public static final String COL_TRANSFER_ID="SF_MATERIALS_TRANSFER_DETAIL_TRANSFER_ID"; // 材料流转_ID
  public static final String COL_UNIT="SF_MATERIALS_TRANSFER_DETAIL_UNIT"; // 单位


  /**
   * 外部信息
   */
  private SfOutInfoDetail outInfoDetail=new SfOutInfoDetail();
  /**
   * 鉴定材料
   */
  private SfMaterials material=new SfMaterials();
  
    public SfOutInfoDetail getOutInfoDetail() {
    return outInfoDetail;
  }

  public void setOutInfoDetail(SfOutInfoDetail outInfoDetail) {
    this.outInfoDetail = outInfoDetail;
  }

  public SfMaterials getMaterial() {
    return material;
  }

  public void setMaterial(SfMaterials material) {
    this.material = material;
  }

    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.TRANSFER_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private BigDecimal transferId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.MATERIAL_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private BigDecimal materialId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.QUANTITY
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private BigDecimal quantity;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.UNIT
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private String unit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private String processing;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_MAN
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private String processingMan;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_DATE
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private Date processingDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.REMARK
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SF_MATERIALS_TRANSFER_DETAIL.OUT_INFO_DETAIL_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	private BigDecimal outInfoDetailId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.TRANSFER_ID
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.TRANSFER_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public BigDecimal getTransferId() {
		return transferId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.TRANSFER_ID
	 * @param transferId  the value for SF_MATERIALS_TRANSFER_DETAIL.TRANSFER_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setTransferId(BigDecimal transferId) {
		this.transferId = transferId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.MATERIAL_ID
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.MATERIAL_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public BigDecimal getMaterialId() {
	  if(material!=null)return material.getMaterialId();
		return null;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.MATERIAL_ID
	 * @param materialId  the value for SF_MATERIALS_TRANSFER_DETAIL.MATERIAL_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setMaterialId(BigDecimal materialId) {
		this.materialId = materialId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.QUANTITY
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.QUANTITY
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.QUANTITY
	 * @param quantity  the value for SF_MATERIALS_TRANSFER_DETAIL.QUANTITY
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.UNIT
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.UNIT
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.UNIT
	 * @param unit  the value for SF_MATERIALS_TRANSFER_DETAIL.UNIT
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.PROCESSING
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public String getProcessing() {
		return processing;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING
	 * @param processing  the value for SF_MATERIALS_TRANSFER_DETAIL.PROCESSING
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setProcessing(String processing) {
		this.processing = processing;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_MAN
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_MAN
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public String getProcessingMan() {
		return processingMan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_MAN
	 * @param processingMan  the value for SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_MAN
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setProcessingMan(String processingMan) {
		this.processingMan = processingMan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_DATE
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_DATE
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public Date getProcessingDate() {
		return processingDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_DATE
	 * @param processingDate  the value for SF_MATERIALS_TRANSFER_DETAIL.PROCESSING_DATE
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.REMARK
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.REMARK
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.REMARK
	 * @param remark  the value for SF_MATERIALS_TRANSFER_DETAIL.REMARK
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SF_MATERIALS_TRANSFER_DETAIL.OUT_INFO_DETAIL_ID
	 * @return  the value of SF_MATERIALS_TRANSFER_DETAIL.OUT_INFO_DETAIL_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public BigDecimal getOutInfoDetailId() {
	  if(outInfoDetail!=null)return outInfoDetail.getOutInfoDetailId();
		return null;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SF_MATERIALS_TRANSFER_DETAIL.OUT_INFO_DETAIL_ID
	 * @param outInfoDetailId  the value for SF_MATERIALS_TRANSFER_DETAIL.OUT_INFO_DETAIL_ID
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	public void setOutInfoDetailId(BigDecimal outInfoDetailId) {
		this.outInfoDetailId = outInfoDetailId;
	}

	/**
   * 
   */
  private static final long serialVersionUID = 670696024582403668L;
}