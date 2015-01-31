package com.ufgov.zc.server.sf.dao;

import java.util.List;

import com.ufgov.zc.common.sf.model.SfOutInfoReq;
import com.ufgov.zc.common.system.dto.ElementConditionDto;

public interface SfOutInfoReqMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_OUT_INFO_REQ
	 * @mbggenerated  Sat Jan 17 15:25:49 CST 2015
	 */
	int deleteByPrimaryKey(String outInfoReqCode);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_OUT_INFO_REQ
	 * @mbggenerated  Sat Jan 17 15:25:49 CST 2015
	 */
	int insert(SfOutInfoReq record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_OUT_INFO_REQ
	 * @mbggenerated  Sat Jan 17 15:25:49 CST 2015
	 */
	int insertSelective(SfOutInfoReq record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_OUT_INFO_REQ
	 * @mbggenerated  Sat Jan 17 15:25:49 CST 2015
	 */
	SfOutInfoReq selectByPrimaryKey(String outInfoReqCode);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_OUT_INFO_REQ
	 * @mbggenerated  Sat Jan 17 15:25:49 CST 2015
	 */
	int updateByPrimaryKeySelective(SfOutInfoReq record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SF_OUT_INFO_REQ
	 * @mbggenerated  Sat Jan 17 15:25:49 CST 2015
	 */
	int updateByPrimaryKey(SfOutInfoReq record);
  
  List getMainDataLst(ElementConditionDto elementConditionDto);
}