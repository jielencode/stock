package com.ufgov.zc.server.sf.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfXysx;

public interface SfXysxMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table SF_XYSX
   *
   * @mbggenerated Thu Feb 05 22:13:33 CST 2015
   */
  int deleteByPrimaryKey(BigDecimal entrustId);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table SF_XYSX
   *
   * @mbggenerated Thu Feb 05 22:13:33 CST 2015
   */
  int insert(SfXysx record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table SF_XYSX
   *
   * @mbggenerated Thu Feb 05 22:13:33 CST 2015
   */
  List selectByPrimaryKey(BigDecimal entrustId);
}