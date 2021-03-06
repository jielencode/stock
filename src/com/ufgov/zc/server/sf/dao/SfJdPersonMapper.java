package com.ufgov.zc.server.sf.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.zc.common.sf.model.SfJdPerson;
import com.ufgov.zc.common.system.dto.ElementConditionDto;

public interface SfJdPersonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SF_JD_PERSON
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    int deleteByPrimaryKey(BigDecimal jdPersonId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SF_JD_PERSON
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    int insert(SfJdPerson record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SF_JD_PERSON
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    int insertSelective(SfJdPerson record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SF_JD_PERSON
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    SfJdPerson selectByPrimaryKey(BigDecimal jdPersonId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SF_JD_PERSON
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    int updateByPrimaryKeySelective(SfJdPerson record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SF_JD_PERSON
     *
     * @mbggenerated Wed Jan 21 20:03:55 CST 2015
     */
    int updateByPrimaryKey(SfJdPerson record);
    
    List getMainDataLst(ElementConditionDto elementConditionDto);
}