package com.ufgov.zc.server.commonbiz.dao;import java.util.List;import com.ufgov.zc.common.system.dto.ElementConditionDto;public interface IFundDao {  List getFund(ElementConditionDto dto);  List getBiXJFund(ElementConditionDto dto);  void updateBiFund(List updateList);  void insertBiFund(List insertList);  void deleteFund(List idList);}