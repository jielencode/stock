package com.ufgov.zc.server.console.dao;import java.util.List;import com.ufgov.zc.common.console.model.AsEmp;import com.ufgov.zc.common.system.dto.ElementConditionDto;public interface IAsEmpDao {  public List getOrgAsEmp(ElementConditionDto dto);  public AsEmp getProviderInfoByCA(ElementConditionDto dto);  public AsEmp getProviderInfoByUserId(ElementConditionDto dto);  public AsEmp insert(AsEmp po);  public List getAsEmp(AsEmp emp);}