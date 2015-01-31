package com.ufgov.zc.server.sf.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfChargeDetail;

public interface SfChargeDetailMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_CHARGE_DETAIL
	 * @mbggenerated  Wed Jan 14 02:04:25 CST 2015
	 */
	int deleteByPrimaryKey(BigDecimal chargeId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_CHARGE_DETAIL
	 * @mbggenerated  Wed Jan 14 02:04:25 CST 2015
	 */
	int insert(SfChargeDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_CHARGE_DETAIL
	 * @mbggenerated  Wed Jan 14 02:04:25 CST 2015
	 */
	List selectByPrimaryKey(BigDecimal chargeId);
}