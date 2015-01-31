package com.ufgov.zc.server.sf.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfMaterialsTransferDetail;

public interface SfMaterialsTransferDetailMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_MATERIALS_TRANSFER_DETAIL
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	int deleteByPrimaryKey(BigDecimal transferId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_MATERIALS_TRANSFER_DETAIL
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	int insert(SfMaterialsTransferDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_MATERIALS_TRANSFER_DETAIL
	 * @mbggenerated  Sun Jan 18 15:56:24 CST 2015
	 */
	List selectByPrimaryKey(BigDecimal transferId);
	
}